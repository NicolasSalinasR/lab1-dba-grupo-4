package Backend_Voluntarios.Backend.Service;

import Backend_Voluntarios.Backend.Entity.Entity_Voluntario;
import Backend_Voluntarios.Backend.Repository.Interface_Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Service_Voluntario {
    @Autowired
    private Interface_Voluntario interfaceVoluntario;

    public List<Entity_Voluntario> ListALL(String palabraClave){
        if(palabraClave != null){
            return  interfaceVoluntario.findAll(palabraClave);
        }
        return  interfaceVoluntario.findAll();
    }
}
