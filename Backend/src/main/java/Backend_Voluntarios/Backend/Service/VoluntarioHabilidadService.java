package Backend_Voluntarios.Backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Backend_Voluntarios.Backend.Repository.VoluntarioHabilidadRepository;
import Backend_Voluntarios.Backend.Entity.VoluntarioHabilidadEntity;
import java.util.List;

@Service
public class VoluntarioHabilidadService {
    @Autowired
    private VoluntarioHabilidadRepository voluntarioHabilidadRepository;

    public VoluntarioHabilidadEntity getVoluntarioHabilidadById(Long id) {
        return voluntarioHabilidadRepository.findVoluntarioHabilidadById(id);
    }

    public List<VoluntarioHabilidadEntity> getAllVoluntarioHabilidades() {
        return voluntarioHabilidadRepository.findAllVoluntarioHabilidades();
    }

    public VoluntarioHabilidadEntity addVoluntarioHabilidad(VoluntarioHabilidadEntity voluntarioHabilidad) {
        return voluntarioHabilidadRepository.saveVoluntarioHabilidad(voluntarioHabilidad.getIdVoluntarioHabilidad(),
                voluntarioHabilidad.getIdVoluntario(),
                voluntarioHabilidad.getIdHabilidad());
    }
}