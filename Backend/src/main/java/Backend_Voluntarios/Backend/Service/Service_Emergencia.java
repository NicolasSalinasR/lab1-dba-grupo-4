package Backend_Voluntarios.Backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Backend_Voluntarios.Backend.Repository.Repository_Emergencia;
import Backend_Voluntarios.Backend.Entity.Entity_Emergencia;

@Service
public class Service_Emergencia {
    @Autowired
    private Repository_Emergencia repository_emergencia;

    public void getEmergenciaById(Long id) {
        repository_emergencia.findEmergenciaById(id);
    }

    public void getAllEmergencias() {
        repository_emergencia.findAllEmergencias();
    }

    public void addEmergencia(Entity_Emergencia emergencia) {
        repository_emergencia.saveEmergencia(emergencia.getTipo_emergencia(),
                emergencia.getZona_emergencia(),
                emergencia.getCondicion_fisica(),
                emergencia.getCantidad_voluntarios_minimo(),
                emergencia.getCantidad_voluntarios_maximo());
    }

}
