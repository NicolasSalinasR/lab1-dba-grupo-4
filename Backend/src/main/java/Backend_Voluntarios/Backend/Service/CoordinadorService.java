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
    public List<CoordinadorEntity> listaFiltro(String palabraClave){
        return coordinadorRepository.listaPalabraClave(palabraClave);
    }

    public List<CoordinadorEntity> tablaCompleta(){
        return coordinadorRepository.listTodo();
    }

    public List<CoordinadorEntity> tablaId(Long idCoordinador){
        return coordinadorRepository.buscarIdCoordinador(idCoordinador);
    }

    public CoordinadorEntity nuevoCoordinador(CoordinadorEntity coordinadorEntity){
        return coordinadorRepository.crearCoordinador(coordinadorEntity.getIdCoordinador(),
                coordinadorEntity.getCorreoCoordinador(),
                coordinadorEntity.getContrasenaCoodinador(),
                coordinadorEntity.getNombre());
    }

    public CoordinadorEntity borrarCoordinador(CoordinadorEntity voluntarioEntity){
        return coordinadorRepository.borrarCoordinador(voluntarioEntity.getIdCoordinador());
    }

    public CoordinadorEntity buscarId(Long idCoordinador){
        return coordinadorRepository.idCoordinador(idCoordinador);
    }
}

