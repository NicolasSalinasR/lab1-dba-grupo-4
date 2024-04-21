package Backend_Voluntarios.Backend.Controller;

import Backend_Voluntarios.Backend.Entity.VoluntarioEntity;
import Backend_Voluntarios.Backend.Entity.VoluntarioEntity;
import Backend_Voluntarios.Backend.Service.AuditoriaService;
import Backend_Voluntarios.Backend.Service.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/voluntario")
public class VoluntarioController {
    @Autowired
    private VoluntarioService voluntarioService;

    @Autowired
    private AuditoriaService auditoriaService;

    @GetMapping()
    public String conectado(){
        return "CONECTADO";
    }

    @GetMapping("/all")
    public List<VoluntarioEntity> tabla(){
        return voluntarioService.tablaCompleta();
    }

    @GetMapping("/{palabraClave}")
    public ResponseEntity<List<VoluntarioEntity>> buscarVoluntarios(@PathVariable String palabraClave){
        List<VoluntarioEntity> voluntariosEncontrados =  voluntarioService.listaFiltro(palabraClave);
        if (voluntariosEncontrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(voluntariosEncontrados);
    }

    @GetMapping("/{idVoluntario}")
    public ResponseEntity<List<VoluntarioEntity>> buscarId(@PathVariable Long idVoluntario) {
        if (idVoluntario == null) {
            return ResponseEntity.badRequest().build();
        }
        List<VoluntarioEntity> idVoluntariosEncontrados = voluntarioService.tablaId(idVoluntario);
        if (idVoluntariosEncontrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(idVoluntariosEncontrados);
    }

    @PostMapping("/guardar")
    public VoluntarioEntity crearVoluntario(@RequestBody Map<String, String> body) {
        String nombreVoluntario = body.get("nombreVoluntario");
        String correoVoluntario = body.get("correoVoluntario");
        String numeroDocumentoVoluntario = body.get("numeroDocumentoVoluntario");
        String equipamientoVoluntario = body.get("equipamientoVoluntario");
        String zonaViviendaVoluntario = body.get("zonaViviendaVoluntario");

        VoluntarioEntity voluntario = new VoluntarioEntity(nombreVoluntario, correoVoluntario, numeroDocumentoVoluntario, Collections.singletonList(equipamientoVoluntario), zonaViviendaVoluntario);
        voluntarioService.nuevoVoluntario(voluntario);

        // Long idUsuario = //metodo para obtener id de usuario ya listo, esperar a pablo
        //         auditoriaService.registrarCambio(idUsuario, "Add", "añadio un voluntario");

        return voluntario; // ! Se debe cambiar al terminar el front por seguridad de que no devuelva
        // ! datos, solo debe devolver una respuesta de que se guardo correctamente
    }

    @DeleteMapping("/delete/{idVoluntario}")
    public void eliminar(@PathVariable Long idVoluntario){
        VoluntarioEntity voluntarioBorrado = voluntarioService.buscarId(idVoluntario);
        voluntarioService.borrarVoluntario(voluntarioBorrado);

        // Long idUsuario = //metodo para obtener id de usuario ya listo, esperar a pablo
        //         auditoriaService.registrarCambio(idUsuario, "Delete", "elimino un voluntario");
    }
}
