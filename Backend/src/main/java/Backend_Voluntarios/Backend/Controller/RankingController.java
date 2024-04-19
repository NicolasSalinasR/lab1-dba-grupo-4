package Backend_Voluntarios.Backend.Controller;

import Backend_Voluntarios.Backend.Entity.RankingEntity;
import Backend_Voluntarios.Backend.Service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController {
    @Autowired
    private RankingService serviceRanking;

    @GetMapping()
    public String conectado(){
        return "CONECTADO";
    }

    @GetMapping("/all")
    public List<RankingEntity> tabla(){
        return serviceRanking.tablaCompleta();
    }

    @GetMapping("/{palabraClave}")
    public ResponseEntity<List<RankingEntity>> Buscar_rankings(@PathVariable String palabraClave){
        List<RankingEntity> rankingsEncontrados =  serviceRanking.listaFiltro(palabraClave);
        if (rankingsEncontrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rankingsEncontrados);
    }

    @GetMapping("/{idRanking}")
    public ResponseEntity<List<RankingEntity>> buscarId(@PathVariable Long idRanking) {
        if (idRanking == null) {
            return ResponseEntity.badRequest().build();
        }
        List<RankingEntity> idRankingsEncontrados = serviceRanking.tablaId(idRanking);
        if (idRankingsEncontrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(idRankingsEncontrados);
    }

    @PostMapping("/guardar")
    public ResponseEntity<RankingEntity> crearVoluntario(@PathVariable RankingEntity rankingEntity) {
        if (rankingEntity.getIdRanking() != null) {
            return ResponseEntity.badRequest().build();
        }
        serviceRanking.nuevoRanking(rankingEntity);
        return ResponseEntity.ok(rankingEntity);
    }

    @DeleteMapping("/delete/{idRanking}")
    public void eliminar(@PathVariable Long idRanking){
        RankingEntity rankingEntity = serviceRanking.buscarId(idRanking);
        serviceRanking.borrarRanking(rankingEntity);
    }
}
