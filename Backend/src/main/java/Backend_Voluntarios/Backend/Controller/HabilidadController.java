package Backend_Voluntarios.Backend.Controller;


import Backend_Voluntarios.Backend.Entity.HabilidadEntity;
import Backend_Voluntarios.Backend.Entity.InstitucionEntity;
import Backend_Voluntarios.Backend.Entity.RankingEntity;
import Backend_Voluntarios.Backend.Service.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Habilidad")
@CrossOrigin(origins = "*")
public class HabilidadController {
    @Autowired
    private HabilidadService habilidadService;

    @GetMapping("/{id}")
    public HabilidadEntity getHabilidadById(@PathVariable Long id){
        return habilidadService.findById(id);
    }

   @GetMapping("/{All}")
    public List<HabilidadEntity>getAllHabilidad() {return habilidadService.getAllHabilidades();}

    @GetMapping("/{PalabraClave}")
    public ResponseEntity<List<HabilidadEntity>> BuscarHabilidades(@PathVariable String PalabraClave){
        List<HabilidadEntity> habilidadEncontradas =  habilidadService.listaHabilidades(PalabraClave);
        if (habilidadEncontradas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(habilidadEncontradas);
    }


    @PostMapping("/add")
    public HabilidadEntity addHabilidad(@RequestBody Map<String, String> body){
        String nombreHabilidad = body.get("nombreHabilidad");

        HabilidadEntity habilidad = new HabilidadEntity(nombreHabilidad);
        habilidadService.crearHabilidad(habilidad);
        return habilidad;
    }
    @DeleteMapping("/delete/{id}")
    public void Eliminar(@PathVariable Long id){
        HabilidadEntity habilidadEliminada = habilidadService.findById(id);
        habilidadService.borrarHabilidad(habilidadEliminada);
    }

}
