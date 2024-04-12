package Backend_Voluntarios.Backend.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Backend_Voluntarios.Backend.Repository.TareaHabilidadRepository;
import Backend_Voluntarios.Backend.Entity.TareaHabilidadEntity;

@Service
public class TareaHabilidadService {

    @Autowired
    private TareaHabilidadRepository tareaHabilidadRepository;

    public TareaHabilidadEntity getTareaHabilidadById(Long id) {
        return TareaHabilidadRepository.findTareaHabilidadById(id);
    }

    public List<TareaHabilidadEntity> getAllTareaHabilidades() {
        return TareaHabilidadRepository.findAllTareaHabilidad();
    }

    public TareaHabilidadEntity addTareaHabilidad(TareaHabilidadEntity tareaHabilidad) {
        return TareaHabilidadRepository.saveTareaHabilidad(tareaHabilidad.getIdTareaHabilidad(),
                tareaHabilidad.getIdTarea(),
                tareaHabilidad.getIdHabilidad(),
                tareaHabilidad.getHabilidadRequerida());
    }
}
