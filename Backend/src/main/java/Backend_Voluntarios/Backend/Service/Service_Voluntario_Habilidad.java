package Backend_Voluntarios.Backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Backend_Voluntarios.Backend.Repository.Repository_Voluntario_Habilidad;
import Backend_Voluntarios.Backend.Entity.Entity_Voluntario_Habilidad;
import java.util.List;

@Service
public class Service_Voluntario_Habilidad {
    @Autowired
    private Repository_Voluntario_Habilidad repository_voluntario_habilidad;

    public Entity_Voluntario_Habilidad getVoluntarioHabilidadById(Long id) {
        return repository_voluntario_habilidad.findVoluntarioHabilidadById(id);
    }

    public List<Entity_Voluntario_Habilidad> getAllVoluntarioHabilidades() {
        return repository_voluntario_habilidad.findAllVoluntarioHabilidades();
    }

    public Entity_Voluntario_Habilidad addVoluntarioHabilidad(Entity_Voluntario_Habilidad voluntario_habilidad) {
        return repository_voluntario_habilidad.saveVoluntarioHabilidad(voluntario_habilidad.getId_voluntario(),
                voluntario_habilidad.getId_habilidad());
    }
}
