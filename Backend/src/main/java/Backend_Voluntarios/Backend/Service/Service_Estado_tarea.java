package Backend_Voluntarios.Backend.Service;


import Backend_Voluntarios.Backend.Entity.Entity_Estado_tarea;
import Backend_Voluntarios.Backend.Repository.interface_Estado_tarea;
import Backend_Voluntarios.Backend.Repository.interface_Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Service_Estado_tarea {
    @Autowired
    private interface_Estado_tarea interface_estado_tarea;

    public List<Entity_Estado_tarea> listAll(String palabraClave){
        return interface_estado_tarea.findAll(palabraClave);
    }

    public Entity_Estado_tarea findbyid_tarea(Long id_tarea){
        return interface_estado_tarea.findbyid_tarea(id_tarea);
    }

    public Entity_Estado_tarea findbyid(Long id_tarea){
        return interface_estado_tarea.findbyid(id_tarea);
    }

    public Long get_tareas_sin_terminar(){
        return interface_estado_tarea.findTareas_sin_terminar();
    }

    public Long get_tareas_terminadas(){
        return interface_estado_tarea.findTareas_terminadas();
    }

}
