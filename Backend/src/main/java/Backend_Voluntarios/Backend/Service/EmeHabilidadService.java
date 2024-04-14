package Backend_Voluntarios.Backend.Service;

import java.util.List;

import Backend_Voluntarios.Backend.Entity.InstitucionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Backend_Voluntarios.Backend.Repository.EmeHabilidadRepository;
import Backend_Voluntarios.Backend.Entity.EmeHabilidadEntity;

@Service
public class EmeHabilidadService {

    @Autowired
    private EmeHabilidadRepository emeHabilidadRepository;

    public EmeHabilidadEntity getEmeHabilidadById(Long id){
        return emeHabilidadRepository.findEmeHabilidadById(id);
    }

    public List<EmeHabilidadEntity> getAllEmeHabilidades(){
        return emeHabilidadRepository.findAllEmeHabilidades();
    }

    public EmeHabilidadEntity addEmeHabilidad( EmeHabilidadEntity emeHabilidad){
        return emeHabilidadRepository.saveEmeHabilidad(
                emeHabilidad.getIdEmergenciaHabilidad(),
                emeHabilidad.getIdHabilidad(),
                emeHabilidad.getIdEmergencia());
    }

    public List<EmeHabilidadEntity> listaFiltro(String palabraClave){
        return emeHabilidadRepository.findAll(palabraClave);
    }


}
