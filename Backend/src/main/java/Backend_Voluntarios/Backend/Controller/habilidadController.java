package Backend_Voluntarios.Backend.Controller;


import Backend_Voluntarios.Backend.Entity.habilidadEntity;
import Backend_Voluntarios.Backend.Service.habilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/habilidad")
@CrossOrigin("*")
public class habilidadController {
    @Autowired
    habilidadService serviceHabilidad;

@GetMapping("/All")
    public List<habilidadEntity> Tabla() {return serviceHabilidad.listarTodo();}

    @GetMapping("/{palabraClave}")
    public ResponseEntity< List<habilidadEntity>> buscarHabilidad(@PathVariable String palabraClave){
    List<habilidadEntity> habilidadesEncontradas = serviceHabilidad.listaHabilidades(palabraClave);
    if(habilidadesEncontradas.isEmpty()) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(habilidadesEncontradas);
    }
    @GetMapping("/{idHabilidad}")
    public ResponseEntity<habilidadEntity> buscarId(@PathVariable Long idHabilidad) {
        if (idHabilidad == null) {
            return ResponseEntity.badRequest().build();
        }
        habilidadEntity HabilidadesEncontradas = serviceHabilidad.findById(idHabilidad);
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
    public ResponseEntity<habilidadEntity> crearHabilidad(@PathVariable habilidadEntity habilidad){
    if(habilidad.getIdHabilidad() != null){
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

