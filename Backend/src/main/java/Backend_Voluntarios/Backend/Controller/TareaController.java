package Backend_Voluntarios.Backend.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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


    private TareaService tareaService;

    @GetMapping("/{id}")
    public TareaEntity getTareaById(@PathVariable Long id) {
        return tareaService.getTareaById(id);
    }

    @GetMapping("/all")
    public List<TareaEntity> getAllTareas() {
        return tareaService.getAllTareas();
    }

    @GetMapping("/{nombreTarea}")
    public List<TareaEntity> getRankingTarea(@PathVariable String nombreTarea){
        return tareaService.getRankingTarea(nombreTarea);
    }

    @PostMapping("/add")
    public TareaEntity addTarea(@RequestBody Map<String, String> body) {
        Long idEstadoTarea = Long.parseLong(body.get("idEstadoTarea"));
        String nombreTarea = body.get("nombreTarea");
        String descripcionTarea = body.get("descripcionTarea");
        String tipoTarea = body.get("tipoTarea");

        TareaEntity tarea = new TareaEntity(idEstadoTarea, nombreTarea, descripcionTarea, tipoTarea);

        tareaService.addTarea(tarea);

        return tarea;
    }
}
