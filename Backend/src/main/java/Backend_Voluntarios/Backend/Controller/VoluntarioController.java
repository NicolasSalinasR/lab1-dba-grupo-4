package Backend_Voluntarios.Backend.Controller;

import Backend_Voluntarios.Backend.Entity.VoluntarioEntity;
import Backend_Voluntarios.Backend.Service.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voluntario")
public class VoluntarioController {
    @Autowired
    private VoluntarioService serviceVoluntario;

    @GetMapping()
    public String Conectado(){
        return "CONECTADO";
    }

    @GetMapping("/All")
    public List<VoluntarioEntity> Tabla(){
        return serviceVoluntario.Tabla_completa();
    }

    @GetMapping("/{PalabraClave}")
    public ResponseEntity<List<VoluntarioEntity>> Buscar_Voluntarios(@PathVariable String PalabraClave){
        List<VoluntarioEntity> voluntarios_encontrados =  serviceVoluntario.Lista_filtro(PalabraClave);
        if (voluntarios_encontrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(voluntarios_encontrados);
    }

    @GetMapping("/{Id_voluntario}")
    public ResponseEntity<List<VoluntarioEntity>> Buscar_Id(@PathVariable Long Id_voluntario) {
        if (Id_voluntario == null) {
            return ResponseEntity.badRequest().build();
        }
        List<VoluntarioEntity> Id_voluntarios_encontrados = serviceVoluntario.Tabla_Id(Id_voluntario);
        if (Id_voluntarios_encontrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(Id_voluntarios_encontrados);
    }

    @PostMapping("/Guardar")
    public ResponseEntity<VoluntarioEntity> Crear_voluntario(@PathVariable VoluntarioEntity voluntario) {
        if (voluntario.getId_voluntario() != null) {
            return ResponseEntity.badRequest().build();
        }
        serviceVoluntario.Nuevo_voluntario(voluntario);
        return ResponseEntity.ok(voluntario);
    }

    @DeleteMapping("/Delete/{Id_voluntario}")
    public void Eliminar(@PathVariable Long Id_voluntario){
        VoluntarioEntity Voluntario_Borrado = serviceVoluntario.Buscar_Id(Id_voluntario);
        serviceVoluntario.Borrar_voluntario(Voluntario_Borrado);
    }
}
