package Backend_Voluntarios.Backend.Service;

import Backend_Voluntarios.Backend.Entity.CoordinadorEntity;
import Backend_Voluntarios.Backend.Repository.CoordinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoordinadorService {
    @Autowired
    private CoordinadorRepository coordinadorRepository;

    public List<CoordinadorEntity> listaFiltro(String palabraClave) {
        return coordinadorRepository.listaPalabraClave(palabraClave);
    }

    public List<CoordinadorEntity> tablaCompleta() {
        return coordinadorRepository.listTodo();
    }

    public List<CoordinadorEntity> tablaId(Long idCoordinador) {
        return coordinadorRepository.buscarIdCoordinador(idCoordinador);
    }

    public void nuevoCoordinador(CoordinadorEntity coordinadorEntity) {
        coordinadorRepository.crearCoordinador(coordinadorEntity.getNombre(),
                coordinadorEntity.getContrasenaCoodinador(),
                coordinadorEntity.getCorreoCoordinador());
    }

    public CoordinadorEntity borrarCoordinador(CoordinadorEntity coordinadorEntity) {
        return coordinadorRepository.borrarCoordinador(coordinadorEntity.getIdCoordinador());
    }

    public CoordinadorEntity buscarId(Long idCoordinador) {
        return coordinadorRepository.idCoordinador(idCoordinador);
    }
}
