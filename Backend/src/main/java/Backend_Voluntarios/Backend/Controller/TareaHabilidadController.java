package Backend_Voluntarios.Backend.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Backend_Voluntarios.Backend.Service.TareaHabilidadService;
import Backend_Voluntarios.Backend.Entity.TareaHabilidadEntity;

@RestController
@RequestMapping("/tareaHabilidad")
@CrossOrigin(origins = "*")
public class TareaHabilidadController {


    private TareaHabilidadService tareaHabilidadService;

    @GetMapping("/{id}")
    public TareaHabilidadEntity getTareaHabilidadById(@PathVariable Long id) {
        return tareaHabilidadService.getTareaHabilidadById(id);
    }

    @GetMapping("/all")
    public List<TareaHabilidadEntity> getAllTareaHabilidad() {
        return tareaHabilidadService.getAllTareaHabilidades();
    }

    @PostMapping("/add")
    public TareaHabilidadEntity addTareaHabilidad(@RequestBody Map<String, String> body) {
        Long idTarea = Long.parseLong(body.get("idTarea"));
        Long idHabilidad = Long.parseLong(body.get("idHabilidad"));
        List <String> habilidadRequerida = Collections.singletonList(body.get("habilidadRequerida"));

        TareaHabilidadEntity tareaHabilidad = new TareaHabilidadEntity(idTarea, idHabilidad, habilidadRequerida);

        tareaHabilidadService.addTareaHabilidad(tareaHabilidad);

        return tareaHabilidad;
    }
}