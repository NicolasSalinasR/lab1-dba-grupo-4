package Backend_Voluntarios.Backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Backend_Voluntarios.Backend.Repository.Repository_Emergencia;
import Backend_Voluntarios.Backend.Entity.Entity_Emergencia;

@Service
public class Service_Emergencia {
    @Autowired
    private Repository_Emergencia repository_emergencia;

    public Entity_Emergencia getEmergenciaById(Long id) {
        return repository_emergencia.findEmergenciaById(id);
    }

    public List<Entity_Emergencia> getAllEmergencias() {
        return repository_emergencia.findAllEmergencias();
    }

    public Entity_Emergencia addEmergencia(Entity_Emergencia emergencia) {
        return repository_emergencia.saveEmergencia(emergencia.getId_Emergencia(),
                emergencia.getTipo_emergencia(),
                emergencia.getZona_emergencia(),
                emergencia.getCondicion_fisica(),
                emergencia.getCantidad_voluntarios_minimo(),
                emergencia.getCantidad_voluntarios_maximo());
    }

}
