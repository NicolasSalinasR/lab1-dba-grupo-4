package Backend_Voluntarios.Backend.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backend_Voluntarios.Backend.Entity.Entity_Voluntario_Habilidad;
import Backend_Voluntarios.Backend.Service.Service_Voluntario_Habilidad;

@RestController
@RequestMapping("/voluntario_habilidad")
public class Controller_Voluntario_Habilidad {
    @Autowired
    private Service_Voluntario_Habilidad service_voluntario_habilidad;

    @GetMapping("{id}")
    public Entity_Voluntario_Habilidad getVoluntarioHabilidadById(Long id) {
        return service_voluntario_habilidad.getVoluntarioHabilidadById(id);
    }

    @GetMapping("/all")
    public List<Entity_Voluntario_Habilidad> getAllVoluntarioHabilidades() {
        return service_voluntario_habilidad.getAllVoluntarioHabilidades();
    }

    @PostMapping("/add")
    public Entity_Voluntario_Habilidad addVoluntarioHabilidad(@RequestBody Map<String, String> body) {
        Long id_voluntario = Long.parseLong(body.get("id_voluntario"));
        Long id_habilidad = Long.parseLong(body.get("id_habilidad"));

        Entity_Voluntario_Habilidad voluntario_habilidad = new Entity_Voluntario_Habilidad(id_voluntario, id_habilidad);
        service_voluntario_habilidad.addVoluntarioHabilidad(voluntario_habilidad);
        return voluntario_habilidad;
    }
}
