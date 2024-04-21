package Backend_Voluntarios.Backend.Controller;

import java.util.List;
import java.util.Map;

import Backend_Voluntarios.Backend.Service.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Backend_Voluntarios.Backend.Service.TareaService;
import Backend_Voluntarios.Backend.Entity.TareaEntity;

@RestController
@RequestMapping("/tarea")
@CrossOrigin(origins = "*")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @Autowired
    private AuditoriaService auditoriaService;

    @GetMapping("/{id}")
    public TareaEntity getTareaById(@PathVariable Long id) {
        return tareaService.getTareaById(id);
    }

    @GetMapping("/all")
    public List<TareaEntity> getAllTareas() {
        return tareaService.getAllTareas();
    }

    @PostMapping("/add")
    public TareaEntity addTarea(@RequestBody Map<String, String> body) {
        Long idEstadoTarea = Long.parseLong(body.get("idEstadoTarea"));
        Long idEmergencia = Long.parseLong(body.get("idEmergencia"));
        String nombreTarea = body.get("nombreTarea");
        String descripcionTarea = body.get("descripcionTarea");
        String tipoTarea = body.get("tipoTarea");

        TareaEntity tarea = new TareaEntity(idEstadoTarea, idEmergencia, nombreTarea, descripcionTarea, tipoTarea);

        tareaService.addTarea(tarea);

        // Long idUsuario = //metodo para obtener id de usuario ya listo, esperar a pablo
        //         auditoriaService.registrarCambio(idUsuario, "Add", "añadio una tarea");
        return tarea;
    }
}