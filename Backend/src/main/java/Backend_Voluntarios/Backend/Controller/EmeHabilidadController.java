package Backend_Voluntarios.Backend.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Backend_Voluntarios.Backend.Entity.EmeHabilidadEntity;
import Backend_Voluntarios.Backend.Service.EmeHabilidadService;

@RestController
@RequestMapping("/emergenciaHabilidad")
@CrossOrigin(origins = "*")

public class EmeHabilidadController {


    private EmeHabilidadService emeHabilidadService;

    @GetMapping("/{id}")
    public EmeHabilidadEntity getEmeHabilidadById(@PathVariable Long id){
        return emeHabilidadService.getEmeHabilidadById(id);
    }

    @GetMapping("/All")
    public List<EmeHabilidadEntity> getAllEmeHabilidades(){
        return emeHabilidadService.getAllEmeHabilidades();
    }

    @GetMapping("/{PalabraClave}")
    public ResponseEntity<List<EmeHabilidadEntity>> Buscar_rankings(@PathVariable String PalabraClave){
        List<EmeHabilidadEntity> rankings_encontrados =  emeHabilidadService.listaFiltro(PalabraClave);
        if (rankings_encontrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rankings_encontrados);
    }

    @PostMapping("/add")
    public EmeHabilidadEntity addEmeHabilidad(@RequestBody Map<String, String> body){
        Long idEmergencia = Long.parseLong(body.get("idEmergencia"));
        Long idHabilidad = Long.parseLong(body.get("idHabilidad"));

        EmeHabilidadEntity emeHabilidad = new EmeHabilidadEntity(idEmergencia,idHabilidad);
        emeHabilidadService.addEmeHabilidad(emeHabilidad);
        return emeHabilidad;
    }

    @DeleteMapping("delete/{id}")
    public void Eliminar(@PathVariable Long id){
        EmeHabilidadEntity emeHabilidadEliminada = emeHabilidadService.getEmeHabilidadById(id);
        emeHabilidadService.deleteEmeHabilidad(emeHabilidadEliminada);
    }




}
