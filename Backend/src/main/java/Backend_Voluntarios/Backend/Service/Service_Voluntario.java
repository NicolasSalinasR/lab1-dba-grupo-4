package Backend_Voluntarios.Backend.Service;

import Backend_Voluntarios.Backend.Entity.Entity_Voluntario;
import Backend_Voluntarios.Backend.Repository.Repository_Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Service_Voluntario {
    @Autowired
    private Repository_Voluntario repositoryVoluntario;

    public List<Entity_Voluntario> Lista_filtro(String palabraClave){
        return repositoryVoluntario.findAll(palabraClave);
    }

    public  List<Entity_Voluntario> Tabla_completa(){
        return repositoryVoluntario.ListAll();
    }
}
