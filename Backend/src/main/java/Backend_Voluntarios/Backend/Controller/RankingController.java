package Backend_Voluntarios.Backend.Controller;

import Backend_Voluntarios.Backend.Entity.RankingEntity;
import Backend_Voluntarios.Backend.Entity.TareaEntity;
import Backend_Voluntarios.Backend.Entity.TareaHabilidadEntity;
import Backend_Voluntarios.Backend.Entity.VoluntarioEntity;
import Backend_Voluntarios.Backend.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ranking")
public class RankingController {
    @Autowired
    private RankingService rankingService;
    private VoluntarioService voluntarioService;
    private TareaService tareaService;
    private TareaHabilidadService tareaHabilidadService;

    @Autowired
    private AuditoriaService auditoriaService;

    @GetMapping()
    public String conectado(){
        return "CONECTADO";
    }

    @GetMapping("/all")
    public List<RankingEntity> tabla(){
        return rankingService.tablaCompleta();
    }

    @GetMapping("/{palabraClave}")
    public ResponseEntity<List<RankingEntity>> buscarRankings(@PathVariable String palabraClave){
        List<RankingEntity> rankingsEncontrados =  rankingService.listaFiltro(palabraClave);
        if (rankingsEncontrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rankingsEncontrados);
    }

    @GetMapping("/listaRanking")
    public List<RankingEntity> listaRanking(){
        return rankingService.listaRanking();
    }

    @GetMapping("/{idRanking}")
    public ResponseEntity<List<RankingEntity>> buscarId(@PathVariable Long idRanking) {
        if (idRanking == null) {
            return ResponseEntity.badRequest().build();
        }
        List<RankingEntity> idRankingsEncontrados = rankingService.tablaId(idRanking);
        if (idRankingsEncontrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(idRankingsEncontrados);
    }

    @PostMapping("/guardar/{idVoluntario}/{idEmergencia}")
    public void crearRanking(@PathVariable Long idVoluntario,
                                      @PathVariable Long idEmergencia) {
        List<TareaEntity> tareas = tareaService.tablaIds(idEmergencia);
        for (TareaEntity tarea : tareas) {
            Long idTarea = tarea.getIdTarea();
            TareaEntity nombreTarea = tareaService.getTareaById(idTarea);
            String tareaRanking = nombreTarea.getNombreTarea();
            VoluntarioEntity buscarZona = voluntarioService.buscarId(idVoluntario);
            String zona = buscarZona.getZonaViviendaVoluntario();
            List<String> equipamiento = buscarZona.getEquipamientoVoluntario();
            int nivelRanking = rankingService.puntajeRanking(zona, equipamiento);


            RankingEntity ranking = new RankingEntity(nombreTarea, buscarZona, nivelRanking, tareaRanking);
            rankingService.nuevoRanking(ranking);
            // Long idUsuario = //metodo para obtener id de usuario ya listo, esperar a pablo
            //         auditoriaService.registrarCambio(idUsuario, "Add", "añadio un ranking");
        }
    }

    @DeleteMapping("/delete/{idRanking}")
    public void eliminar(@PathVariable Long idRanking){
        RankingEntity rankingEntity = rankingService.buscarId(idRanking);
        rankingService.borrarRanking(rankingEntity);

        // Long idUsuario = //metodo para obtener id de usuario ya listo, esperar a pablo
        //         auditoriaService.registrarCambio(idUsuario, "Delete", "elimino un ranking");
    }

    @PutMapping("editar}/{idVoluntario}")
    public void actualizar(@PathVariable Long idVoluntario){
        VoluntarioEntity update = voluntarioService.buscarId(idVoluntario);
        List<String> equipo = update.getEquipamientoVoluntario();
        String zona = update.getZonaViviendaVoluntario();
        RankingEntity updateUser = rankingService.buscarId(idVoluntario);
        updateUser.setNivelRanking(rankingService.puntajeRanking(zona, equipo));
        rankingService.nuevoRanking(updateUser);

        // Long idUsuario = //metodo para obtener id de usuario ya listo, esperar a pablo
        //         auditoriaService.registrarCambio(idUsuario, "update", "modifico un Ranking");
    }
}
