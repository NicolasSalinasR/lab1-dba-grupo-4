package Backend_Voluntarios.Backend.Controller;

import Backend_Voluntarios.Backend.Entity.CoordinadorEntity;
import Backend_Voluntarios.Backend.Service.CoordinadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/coordinador")
public class CoordinadorController {

    private CoordinadorService coordinadorService;

    @GetMapping()
    public String conectado() {
        return "CONECTADO";
    }

    @GetMapping("/all")
    public List<CoordinadorEntity> tabla() {
        return coordinadorService.tablaCompleta();
    }

    @GetMapping("/{palabraClave}")
    public ResponseEntity<List<CoordinadorEntity>> buscarCoordinador(@PathVariable String palabraClave) {
        List<CoordinadorEntity> coordinadoresEncontrados = coordinadorService.listaFiltro(palabraClave);
        if (coordinadoresEncontrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(coordinadoresEncontrados);
    }

    @GetMapping("/{idCoordinador}")
    public ResponseEntity<List<CoordinadorEntity>> buscarId(@PathVariable Long idCoordinador) {
        if (idCoordinador == null) {
            return ResponseEntity.badRequest().build();
        }
        List<CoordinadorEntity> idCoordinadoresEncontrados = coordinadorService.tablaId(idCoordinador);
        if (idCoordinadoresEncontrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(idCoordinadoresEncontrados);
    }

    @PostMapping("/guardar")
    public CoordinadorEntity crearCoordinador(@RequestBody Map<String, String> body) {
        String correoCoordinador = body.get("correoCoordinador");
        String contrasenaCoordinador = body.get("contrasenaCoordinador");
        String nombre = body.get("nombre");
        CoordinadorEntity coordinador = new CoordinadorEntity(correoCoordinador, contrasenaCoordinador, nombre);
        coordinadorService.nuevoCoordinador(coordinador);
        return coordinador; // ! Se debe cambiar al terminar el front por seguridad de que no devuelva
        // ! datos, solo debe devolver una respuesta de que se guardo correctamente
    }

    @DeleteMapping("/delete/{idCoordinador}")
    public void eliminar(@PathVariable Long idCoordinador) {
        CoordinadorEntity voluntarioBorrado = coordinadorService.buscarId(idCoordinador);
        coordinadorService.borrarCoordinador(voluntarioBorrado);
    }
}
