package Backend_Voluntarios.Backend.Controller;

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
import Backend_Voluntarios.Backend.Service.Service_Emergencia;
import Backend_Voluntarios.Backend.Entity.Entity_Emergencia;

@RestController
@RequestMapping("/emergencia")
@CrossOrigin(origins = "*")
public class Controller_Emergencia {
    @Autowired
    private Service_Emergencia service_emergencia;

    @GetMapping("/{id}")
    public Entity_Emergencia getEmergenciaById(@PathVariable Long id) {
        return service_emergencia.getEmergenciaById(id);

    }

    @GetMapping("/all")
    public List<Entity_Emergencia> getAllEmergencias() {
        return service_emergencia.getAllEmergencias();
    }

    @PostMapping("/add")
    public Entity_Emergencia addEmergencia(@RequestBody Map<String, String> body) {
        String tipo_emergencia = body.get("tipo_emergencia");
        String zona_emergencia = body.get("zona_emergencia");
        String condicion_fisica = body.get("condicion_fisica");
        String cantidad_voluntarios_minimo = body.get("cantidad_voluntarios_minimo");
        String cantidad_voluntarios_maximo = body.get("cantidad_voluntarios_maximo");

        Entity_Emergencia emergencia = new Entity_Emergencia(tipo_emergencia, zona_emergencia, condicion_fisica,
                cantidad_voluntarios_minimo, cantidad_voluntarios_maximo);
        service_emergencia.addEmergencia(emergencia);
        return emergencia; // ! Se debe cambiar al terminar el front por seguridad de que no devuelva
                           // ! datos, solo debe devolver una respuesta de que se guardo correctamente
    }
}
