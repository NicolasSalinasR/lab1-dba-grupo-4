package Backend_Voluntarios.Backend.Controller;


import Backend_Voluntarios.Backend.Entity.Entity_Habilidad;
import Backend_Voluntarios.Backend.Service.Service_Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/habilidad")
@CrossOrigin("*")
public class Controller_Habilidad {
    @Autowired
    Service_Habilidad serviceHabilidad;

@GetMapping("/All")
    public List<Entity_Habilidad> Tabla() {return serviceHabilidad.listarTodo();}

    @GetMapping("/{palabraClave}")
    public ResponseEntity< List<Entity_Habilidad>> buscarHabilidad(@PathVariable String palabraClave){
    List<Entity_Habilidad> habilidadesEncontradas = serviceHabilidad.listaHabilidades(palabraClave);
    if(habilidadesEncontradas.isEmpty()) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(habilidadesEncontradas);
    }
    @GetMapping("/{idHabilidad}")
    public ResponseEntity<Entity_Habilidad> buscarId(@PathVariable Long idHabilidad) {
        if (idHabilidad == null) {
            return ResponseEntity.badRequest().build();
        }
        Entity_Habilidad HabilidadesEncontradas = serviceHabilidad.findById(idHabilidad);
        if (HabilidadesEncontradas != null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(HabilidadesEncontradas);
    }



    @GetMapping("/{idHabilidad}")
    public ResponseEntity<String> buscarNombre(@PathVariable Long idHabilidad) {
        if (idHabilidad == null) {
            return ResponseEntity.badRequest().build();
        }
        String NombreHabilidad = serviceHabilidad.find_nombre_habilidad(idHabilidad);
        if (NombreHabilidad != null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(NombreHabilidad);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Entity_Habilidad> crearHabilidad(@PathVariable Entity_Habilidad habilidad){
    if(habilidad.getId_habilidad() != null){
        return ResponseEntity.badRequest().build();
    }
    serviceHabilidad.guardarHabilidad(habilidad);
    return ResponseEntity.ok(habilidad);
    }

    @DeleteMapping("/Delete/{idHabilidad}")
    public void eliminar(@PathVariable Long idHabilidad){
    serviceHabilidad.eliminarHabilidad(idHabilidad);
    }

}

