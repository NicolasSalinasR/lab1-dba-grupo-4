package Backend_Voluntarios.Backend.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Backend_Voluntarios.Backend.Service.InstitucionService;
import Backend_Voluntarios.Backend.Entity.InstitucionEntity;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/institucion")
@CrossOrigin(origins = "*")

public class InstitucionController {

    private InstitucionService institucionService;

    @GetMapping("/{id}")
    public InstitucionEntity getInstitucionById(@PathVariable Long id){
        return institucionService.getInstitucionById(id);
    }

    @GetMapping("/All")
    public List<InstitucionEntity> getAllInstituciones(){
        return institucionService.getAllInstituciones();
    }

    @GetMapping("/{PalabraClave}")
    public ResponseEntity<List<InstitucionEntity>> Buscar_rankings(@PathVariable String PalabraClave){
        List<InstitucionEntity> rankings_encontrados =  institucionService.listaFiltro(PalabraClave);
        if (rankings_encontrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rankings_encontrados);
    }



    @PostMapping("/add")
    public InstitucionEntity addInstitucion(@RequestBody Map<String, String> body){
        Long idEmergencia = Long.parseLong(body.get("idEmergencia"));
        String nombreInstitucion = body.get("nombreInstitucion");

        InstitucionEntity institucion = new InstitucionEntity(idEmergencia, nombreInstitucion);
        institucionService.addInstitucion(institucion);
        return institucion;
    }

    @DeleteMapping("/delete/{id}")
    public void Eliminar(@PathVariable Long id){
        InstitucionEntity institucionEliminada = institucionService.getInstitucionById(id);
        institucionService.deleteInstitucion(institucionEliminada);
    }



}
