package Backend_Voluntarios.Backend.Controller;


import Backend_Voluntarios.Backend.Entity.EstadoTareaEntity;
import Backend_Voluntarios.Backend.Entity.HabilidadEntity;
import Backend_Voluntarios.Backend.Service.EstadoTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/EstadoTarea")
@CrossOrigin(origins = "*")
public class EstadoTareaController {

    @Autowired
    private EstadoTareaService estadoTareaService;

    @GetMapping("/{id}")
    public EstadoTareaEntity getEstadoTareaById(@PathVariable Long id){
       return estadoTareaService.findById(id);
    }

    @GetMapping("/{All}")
    public List<EstadoTareaEntity> getAllEstadoTarea() {return estadoTareaService.getAllEstadoHabilidad();}

    @GetMapping("/Tarea/{id}")
    public EstadoTareaEntity getEstadoTareaIdTarea(@PathVariable Long id){
        return estadoTareaService.findByIdTarea(id);
    }

    @GetMapping("/{PalabraClave}")
    public ResponseEntity<List<EstadoTareaEntity>> BuscarEstadoTarea(@PathVariable String PalabraClave){
        List<EstadoTareaEntity> estadoTareaEncontradas =  estadoTareaService.listAll(PalabraClave);
        if (estadoTareaEncontradas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estadoTareaEncontradas);
    }

    @PostMapping("/add")
    public EstadoTareaEntity addEstadoTarea(@RequestBody Map<String, String> body){
        Long idEstadoTarea = Long.parseLong(body.get("idEstadoTarea"));
        Long idTarea = Long.parseLong(body.get("idTarea"));
        Boolean estadoTarea = Boolean.parseBoolean(body.get("estadoTarea")); // Cambio realizado aquí

        EstadoTareaEntity estadoTareaNew = new EstadoTareaEntity(idEstadoTarea, idTarea, estadoTarea);
        estadoTareaService.guardarEstadoTarea(estadoTareaNew);
        return estadoTareaNew;
    }

    @DeleteMapping("/delete/{id}")
    public void Eliminar(@PathVariable Long id){
        estadoTareaService.eliminarEstadoTarea(id);
    }

}
