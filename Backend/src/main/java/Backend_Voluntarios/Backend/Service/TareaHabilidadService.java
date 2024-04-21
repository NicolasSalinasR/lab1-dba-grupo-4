package Backend_Voluntarios.Backend.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import Backend_Voluntarios.Backend.Repository.TareaHabilidadRepository;
import Backend_Voluntarios.Backend.Entity.TareaHabilidadEntity;

@Service
public class TareaHabilidadService {
    private TareaHabilidadRepository tareaHabilidadRepository;

    public TareaHabilidadEntity getTareaHabilidadById(Long id) {
        return tareaHabilidadRepository.findTareaHabilidadById(id);
    }

    public List<TareaHabilidadEntity> getAllTareaHabilidades() {
        return tareaHabilidadRepository.findAllTareaHabilidad();
    }

    public TareaHabilidadEntity addTareaHabilidad(TareaHabilidadEntity tareaHabilidad) {
        return tareaHabilidadRepository.saveTareaHabilidad(tareaHabilidad.getIdTareaHabilidad(),
                tareaHabilidad.getIdTarea(),
                tareaHabilidad.getIdEmeHabilidad(),
                tareaHabilidad.getHabilidadRequerida());
    }
}
