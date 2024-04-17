package Backend_Voluntarios.Backend.Controller;



import Backend_Voluntarios.Backend.Entity.estadoTareaEntity;
import Backend_Voluntarios.Backend.Service.estadoTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Estado_Tarea")
@CrossOrigin("*")
public class estadoTareaController {
    @Autowired
    estadoTareaService serviceEstadoTarea;

    public List<estadoTareaEntity> Tabla() {return serviceEstadoTarea.listarTodo();}

    @GetMapping("/{palabraClave}")
    public ResponseEntity< List<estadoTareaEntity>> buscarEstadoTarea(@PathVariable String palabraClave){
        List<estadoTareaEntity> estadosEncontrados = serviceEstadoTarea.listAll(palabraClave);
        if(estadosEncontrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estadosEncontrados);
    }

    @GetMapping("/{idEstadoTarea}")
    public ResponseEntity<estadoTareaEntity> buscarIdEstadoTarea(@PathVariable Long idEstadoTarea) {
        if (idEstadoTarea == null) {
            return ResponseEntity.badRequest().build();
        }
        estadoTareaEntity estadosEncontrados = serviceEstadoTarea.findbyid(idEstadoTarea);
        if (estadosEncontrados != null) {
            return ResponseEntity.notFound().build();
        }
       return ResponseEntity.ok(estadosEncontrados);
    }

    @GetMapping("/{idTarea}")
    public ResponseEntity<estadoTareaEntity> buscarIdTarea(@PathVariable Long idTarea) {
        if (idTarea == null) {
            return ResponseEntity.badRequest().build();
        }
        estadoTareaEntity estadosEncontrados = serviceEstadoTarea.findbyid_tarea(idTarea);
        if (estadosEncontrados != null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estadosEncontrados);
    }

    @PostMapping("/guardar")
    public ResponseEntity<estadoTareaEntity> crearEstadoTarea(@PathVariable estadoTareaEntity estadoTarea){
        if(estadoTarea.getIdEstadoTarea() != null){
            return ResponseEntity.badRequest().build();
        }
        serviceEstadoTarea.guardarEstadoTarea(estadoTarea);
        return ResponseEntity.ok(estadoTarea);
    }

    @DeleteMapping("/Delete/{idEstadoTares}")
    public void eliminar(@PathVariable Long idEstadoTarea){
        serviceEstadoTarea.eliminarEstadoTarea(idEstadoTarea);
    }



}
