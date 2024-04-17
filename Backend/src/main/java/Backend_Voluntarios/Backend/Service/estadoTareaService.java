package Backend_Voluntarios.Backend.Service;


import Backend_Voluntarios.Backend.Entity.estadoTareaEntity;
import Backend_Voluntarios.Backend.Repository.estadoTareaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class estadoTareaService {
    @Autowired
    private estadoTareaRepository estado_tareaRepository;

    public List<estadoTareaEntity> listAll(String palabraClave){
        if(palabraClave != null) {
            return estado_tareaRepository.findAll(palabraClave);
        }
        return estado_tareaRepository.listAll();
    }

    public List <estadoTareaEntity> listarTodo(){
        return estado_tareaRepository.listAll();
    }

    public estadoTareaEntity findbyid_tarea(Long id_tarea){
        return estado_tareaRepository.findByIdTarea(id_tarea);
    }

    public estadoTareaEntity findbyid(Long id_tarea){
        return estado_tareaRepository.findbyid(id_tarea);
    }

    public Long getTareasSinTerminar(){
        return estado_tareaRepository.findTareas_sin_terminar();
    }

    public Long getTareasTerminadas(){
        return estado_tareaRepository.findTareas_terminadas();
    }

    public void eliminarEstadoTarea(Long idEstadoTarea){
        estado_tareaRepository.deleteEstadoTarea(idEstadoTarea);
    }

    public void guardarEstadoTarea (estadoTareaEntity estadoTarea){
        estado_tareaRepository.saveEstadoTarea(estadoTarea.getIdEstadoTarea(), estadoTarea.getIdTarea(), estadoTarea.getEstadoTarea());
    }
}
