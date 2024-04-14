package Backend_Voluntarios.Backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Backend_Voluntarios.Backend.Repository.InstitucionRepository;
import Backend_Voluntarios.Backend.Entity.InstitucionEntity;

@Service
public class InstitucionService {
    @Autowired
    private InstitucionRepository institucionRepository;

    public InstitucionEntity getInstitucionById(Long id){
        return institucionRepository.findInstitucionById(id);
    }

    public List<InstitucionEntity> getAllInstituciones(){
        return institucionRepository.findAllInstituciones();
    }

    public InstitucionEntity addInstitucion(InstitucionEntity institucion){
        return institucionRepository.saveInstitucion(
                institucion.getIdInstitucion(),
                institucion.getIdEmergencia(),
                institucion.getNombreInstitucion());
    }

    public List<InstitucionEntity> listaFiltro(String palabraClave){
        return institucionRepository.findAll(palabraClave);
    }
}
