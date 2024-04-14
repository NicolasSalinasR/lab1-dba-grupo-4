package Backend_Voluntarios.Backend.Service;

import Backend_Voluntarios.Backend.Entity.Entity_Habilidad;
import Backend_Voluntarios.Backend.Repository.Interface_Habilidad;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Service_Habilidad {
    @Autowired
    private Interface_Habilidad interfaceHabilidad;

    public List<Entity_Habilidad> listaHabilidades(String palabraClave) {
        if(palabraClave != null) {
            return interfaceHabilidad.findAll(palabraClave);
        }
        return interfaceHabilidad.listAll();
    }

    public List <Entity_Habilidad> listarTodo(){
        return interfaceHabilidad.listAll();
    }
    public Entity_Habilidad findById(Long id_habilidad){
        return interfaceHabilidad.findById(id_habilidad);
    }

    public String find_nombre_habilidad (Long id_habilidad){
        return interfaceHabilidad.findNombreHabilidad(id_habilidad);
    }

    public void eliminarHabilidad (Long idHabilidad){
         interfaceHabilidad.deleteHabilidad(idHabilidad);
    }

    public void guardarHabilidad (Long idHabilidad, String nombreHabilidad){
        interfaceHabilidad.saveHabilidad(idHabilidad, nombreHabilidad);
    }
}
