package Backend_Voluntarios.Backend.Controller;


import Backend_Voluntarios.Backend.Entity.Entity_Emergencia;
import Backend_Voluntarios.Backend.Entity.Entity_Estado_Tarea;
import Backend_Voluntarios.Backend.Entity.Entity_Habilidad;
import Backend_Voluntarios.Backend.Service.Service_Estado_Tarea;
import Backend_Voluntarios.Backend.Service.Service_Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Estado_Tarea")
@CrossOrigin("*")
public class Controller_Estado_Tarea {
    @Autowired
    Service_Estado_Tarea serviceEstadoTarea;

    public List<Entity_Estado_Tarea> Tabla() {return serviceEstadoTarea.listarTodo();}

    @GetMapping("/{palabraClave}")
    public ResponseEntity< List<Entity_Estado_Tarea>> buscarEstadoTarea(@PathVariable String palabraClave){
        List<Entity_Estado_Tarea> estadosEncontrados = serviceEstadoTarea.listAll(palabraClave);
        if(estadosEncontrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estadosEncontrados);
    }

    @GetMapping("/{idEstadoTarea}")
    public ResponseEntity<Entity_Estado_Tarea> buscarIdEstadoTarea(@PathVariable Long idEstadoTarea) {
        if (idEstadoTarea == null) {
            return ResponseEntity.badRequest().build();
        }
        Entity_Estado_Tarea estadosEncontrados = serviceEstadoTarea.findbyid(idEstadoTarea);
        if (estadosEncontrados != null) {
            return ResponseEntity.notFound().build();
        }
       return ResponseEntity.ok(estadosEncontrados);
    }

    @GetMapping("/{idTarea}")
    public ResponseEntity<Entity_Estado_Tarea> buscarIdTarea(@PathVariable Long idTarea) {
        if (idTarea == null) {
            return ResponseEntity.badRequest().build();
        }
        Entity_Estado_Tarea estadosEncontrados = serviceEstadoTarea.findbyid_tarea(idTarea);
        if (estadosEncontrados != null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estadosEncontrados);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Entity_Estado_Tarea> crearEstadoTarea(@PathVariable Entity_Estado_Tarea estadoTarea){
        if(estadoTarea.getId_Estado_Tarea() != null){
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
