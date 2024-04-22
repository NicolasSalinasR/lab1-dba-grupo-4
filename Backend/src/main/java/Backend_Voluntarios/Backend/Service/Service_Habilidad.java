package Backend_Voluntarios.Backend.Service;


import Backend_Voluntarios.Backend.Entity.Entity_Habilidad;
import Backend_Voluntarios.Backend.Repository.interface_Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Service_Habilidad {
    @Autowired
    private interface_Habilidad interfaceHabilidad;

    public List<Entity_Habilidad> lista_habilidades(String palabraClave) {
        return interfaceHabilidad.findAll(palabraClave);
    }

    public Entity_Habilidad findbyid(Long id_habilidad){
        return interfaceHabilidad.findbyid(id_habilidad);
    }

    public String find_nombre_habilidad (Long id_habilidad){
        return interfaceHabilidad.find_nombre_habilidad(id_habilidad);
    }

}