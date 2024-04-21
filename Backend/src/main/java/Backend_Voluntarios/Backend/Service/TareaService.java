package Backend_Voluntarios.Backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Backend_Voluntarios.Backend.Repository.TareaRepository;
import Backend_Voluntarios.Backend.Entity.TareaEntity;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;

    public TareaEntity getTareaById(Long id) {
        return tareaRepository.findTareaById(id);
    }

    public List<TareaEntity> getAllTareas() {
        return tareaRepository.findAllTareas();
    }

    public List<TareaEntity> tablaIds(Long idEmergencia) {
        return tareaRepository.buscarIdEmergencia(idEmergencia);
    }

    public List<TareaEntity> getRankingTarea(String nombreTarea) {
        return tareaRepository.listRankingTarea(nombreTarea);
    }

    public void addTarea(TareaEntity tarea) {
         tareaRepository.saveTarea(tarea.getNombreTarea(),
                tarea.getDescripcionTarea(),
                tarea.getTipoTarea());
    }
}