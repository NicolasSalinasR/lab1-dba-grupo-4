package Backend_Voluntarios.Backend.Service;

import Backend_Voluntarios.Backend.Entity.Entity_Estado_Tarea;
import Backend_Voluntarios.Backend.Entity.Entity_Habilidad;
import Backend_Voluntarios.Backend.Repository.Interface_Estado_Tarea;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Service_Estado_Tarea {
    @Autowired
    private Interface_Estado_Tarea interface_estado_tarea;

    public List<Entity_Estado_Tarea> listAll(String palabraClave){
        if(palabraClave != null) {
            return interface_estado_tarea.findAll(palabraClave);
        }
        return interface_estado_tarea.listAll();
    }

    public List <Entity_Estado_Tarea> listarTodo(){
        return interface_estado_tarea.listAll();
    }

    public Entity_Estado_Tarea findbyid_tarea(Long id_tarea){
        return interface_estado_tarea.findbyid_tarea(id_tarea);
    }

    public Entity_Estado_Tarea findbyid(Long id_tarea){
        return interface_estado_tarea.findbyid(id_tarea);
    }

    public Long getTareasSinTerminar(){
        return interface_estado_tarea.findTareas_sin_terminar();
    }

    public Long getTareasTerminadas(){
        return interface_estado_tarea.findTareas_terminadas();
    }

    public void eliminarEstadoTarea(Long idEstadoTarea){
        interface_estado_tarea.deleteEstadoTarea(idEstadoTarea);
    }

    public void guardarEstadoTarea (Long idEstadoTarea, Long idTarea, Boolean estadoTarea){
        interface_estado_tarea.saveEstadoTarea(idEstadoTarea, idTarea, estadoTarea);
    }
}
