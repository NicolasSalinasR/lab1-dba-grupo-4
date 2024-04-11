package Backend_Voluntarios.Backend.Controller;

import Backend_Voluntarios.Backend.Entity.Entity_Ranking;
import Backend_Voluntarios.Backend.Entity.Entity_Voluntario;
import Backend_Voluntarios.Backend.Repository.Repository_Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class Controller_Ranking {
    @Autowired
    private Repository_Ranking repositoryRanking;

    @GetMapping()
    public String conectado(){
        return "CONECTADO";
    }

    @GetMapping("/")
    public List<Entity_Ranking> getUsuarios(){
        return repositoryRanking.findAll();
    }

    @GetMapping("/{palabraClave}")
    public ResponseEntity<List<Entity_Ranking>> buscar_rankings(@PathVariable String palabraClave){
        List<Entity_Ranking> rankings_encontrados =  repositoryRanking.findAll(palabraClave);
        if (rankings_encontrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rankings_encontrados);
    }

}
