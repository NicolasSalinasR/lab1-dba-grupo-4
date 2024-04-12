package Backend_Voluntarios.Backend.Controller;

import Backend_Voluntarios.Backend.Entity.RankingEntity;
import Backend_Voluntarios.Backend.Service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController {
    @Autowired
    private RankingService serviceRanking;

    @GetMapping()
    public String Conectado(){
        return "CONECTADO";
    }

    @GetMapping("/All")
    public List<RankingEntity> Tabla(){
        return serviceRanking.Tabla_completa();
    }

    @GetMapping("/{PalabraClave}")
    public ResponseEntity<List<RankingEntity>> Buscar_rankings(@PathVariable String PalabraClave){
        List<RankingEntity> rankings_encontrados =  serviceRanking.Lista_filtro(PalabraClave);
        if (rankings_encontrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rankings_encontrados);
    }

    @GetMapping("/{Id_ranking}")
    public ResponseEntity<List<RankingEntity>> Buscar_Id(@PathVariable Long Id_ranking) {
        if (Id_ranking == null) {
            return ResponseEntity.badRequest().build();
        }
        List<RankingEntity> Id_rankings_encontrados = serviceRanking.Tabla_Id(Id_ranking);
        if (Id_rankings_encontrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(Id_rankings_encontrados);
    }

    @PostMapping("/Guardar")
    public ResponseEntity<RankingEntity> Crear_voluntario(@PathVariable RankingEntity ranking) {
        if (ranking.getId_ranking() != null) {
            return ResponseEntity.badRequest().build();
        }
        serviceRanking.Nuevo_ranking(ranking);
        return ResponseEntity.ok(ranking);
    }

    @DeleteMapping("/Delete/{Id_ranking}")
    public void Eliminar(@PathVariable Long Id_ranking){
        RankingEntity ranking_Borrado = serviceRanking.Buscar_Id(Id_ranking);
        serviceRanking.Borrar_ranking(ranking_Borrado);
    }
}
