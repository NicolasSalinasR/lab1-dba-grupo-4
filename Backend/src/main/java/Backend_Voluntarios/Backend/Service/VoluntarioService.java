package Backend_Voluntarios.Backend.Service;

import Backend_Voluntarios.Backend.Entity.VoluntarioEntity;
import Backend_Voluntarios.Backend.Repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntarioService {
    @Autowired
    private VoluntarioRepository repositoryVoluntario;

    public List<VoluntarioEntity> listaFiltro(String palabraClave){
        return repositoryVoluntario.findAll(palabraClave);
    }

    public List<VoluntarioEntity> tablaCompleta(){
        return repositoryVoluntario.listAll();
    }

    public List<VoluntarioEntity> tablaId(Long idVoluntario){
        return repositoryVoluntario.buscarIdVoluntario(idVoluntario);
    }

    public VoluntarioEntity nuevoVoluntario(VoluntarioEntity voluntarioEntity){
        return repositoryVoluntario.crearVoluntario(voluntarioEntity.getIdVoluntario(),
                voluntarioEntity.getNombreVoluntario(),
                voluntarioEntity.getCorreoVoluntario(),
                voluntarioEntity.getNumeroDocumentoVoluntario(),
                voluntarioEntity.getEquipamientoVoluntario(),
                voluntarioEntity.getZonaViviendaVoluntario());
    }

    public VoluntarioEntity borrarVoluntario(VoluntarioEntity voluntarioEntity){
        return repositoryVoluntario.borrarVoluntario(voluntarioEntity.getIdVoluntario());
    }

    public VoluntarioEntity buscarId(Long idVoluntario){
        return repositoryVoluntario.idVoluntario(idVoluntario);
    }
}
