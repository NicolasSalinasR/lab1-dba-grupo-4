package Backend_Voluntarios.Backend.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backend_Voluntarios.Backend.Entity.VoluntarioHabilidadEntity;
import Backend_Voluntarios.Backend.Service.VoluntarioHabilidadService;

@RestController
@RequestMapping("/voluntarioHabilidad")
public class VoluntarioHabilidadController {

    private VoluntarioHabilidadService voluntarioHabilidadService;

    @GetMapping("{id}")
    public VoluntarioHabilidadEntity getVoluntarioHabilidadById(Long id) {
        return voluntarioHabilidadService.getVoluntarioHabilidadById(id);
    }

    @GetMapping("/todos")
    public List<VoluntarioHabilidadEntity> getAllVoluntarioHabilidades() {
        return voluntarioHabilidadService.getAllVoluntarioHabilidades();
    }

    @PostMapping("/agregar")
    public VoluntarioHabilidadEntity addVoluntarioHabilidad(@RequestBody Map<String, String> body) {
        Long id_voluntario = Long.parseLong(body.get("idVoluntario"));
        Long id_habilidad = Long.parseLong(body.get("idHabilidad"));

        VoluntarioHabilidadEntity voluntario_habilidad = new VoluntarioHabilidadEntity(id_voluntario, id_habilidad);
        voluntarioHabilidadService.addVoluntarioHabilidad(voluntario_habilidad);
        return voluntario_habilidad;
    }
}
