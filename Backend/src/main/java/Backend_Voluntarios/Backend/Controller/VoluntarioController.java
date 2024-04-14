package Backend_Voluntarios.Backend.Controller;

import Backend_Voluntarios.Backend.Entity.VoluntarioEntity;
import Backend_Voluntarios.Backend.Service.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voluntario")
public class VoluntarioController {
    @Autowired
    private VoluntarioService serviceVoluntario;

    @GetMapping()
    public String conectado(){
        return "CONECTADO";
    }

    @GetMapping("/all")
    public List<VoluntarioEntity> tabla(){
        return serviceVoluntario.tablaCompleta();
    }

    @GetMapping("/{palabraClave}")
    public ResponseEntity<List<VoluntarioEntity>> buscarVoluntarios(@PathVariable String palabraClave){
        List<VoluntarioEntity> voluntariosEncontrados =  serviceVoluntario.listaFiltro(palabraClave);
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
        List<VoluntarioEntity> idVoluntariosEncontrados = serviceVoluntario.tablaId(idVoluntario);
        if (idVoluntariosEncontrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(idVoluntariosEncontrados);
    }

    @PostMapping("/guardar")
    public ResponseEntity<VoluntarioEntity> crearVoluntario(@PathVariable VoluntarioEntity voluntarioEntity) {
        if (voluntarioEntity.getIdVoluntario() != null) {
            return ResponseEntity.badRequest().build();
        }
        serviceVoluntario.nuevoVoluntario(voluntarioEntity);
        return ResponseEntity.ok(voluntarioEntity);
    }

    @DeleteMapping("/delete/{idVoluntario}")
    public void eliminar(@PathVariable Long idVoluntario){
        VoluntarioEntity voluntarioBorrado = serviceVoluntario.buscarId(idVoluntario);
        serviceVoluntario.borrarVoluntario(voluntarioBorrado);
    }
}
