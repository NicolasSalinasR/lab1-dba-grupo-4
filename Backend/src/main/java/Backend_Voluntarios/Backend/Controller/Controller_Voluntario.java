package Backend_Voluntarios.Backend.Controller;

import Backend_Voluntarios.Backend.Entity.Entity_Ranking;
import Backend_Voluntarios.Backend.Entity.Entity_Voluntario;
import Backend_Voluntarios.Backend.Repository.Interface_Ranking;
import Backend_Voluntarios.Backend.Repository.Interface_Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/voluntario")
public class Controller_Voluntario {
    @Autowired
    private Interface_Voluntario interfaceVoluntario;

    @GetMapping("/{palabraClave}")
    public ResponseEntity<List<Entity_Voluntario>> buscar_voluntarios(@PathVariable String palabraClave){
        List<Entity_Voluntario> voluntarios_encontrados =  interfaceVoluntario.findAll(palabraClave);
        if (voluntarios_encontrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(voluntarios_encontrados);
    }
}
