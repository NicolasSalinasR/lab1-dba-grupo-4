package Backend_Voluntarios.Backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Backend_Voluntarios.Backend.Repository.EmergenciaRepository;
import Backend_Voluntarios.Backend.Entity.EmergenciaEntity;

@Service
public class EmergenciaService {
    @Autowired
    private EmergenciaRepository repositoryEmergencia;

    public EmergenciaEntity getEmergenciaById(Long id) {
        return repositoryEmergencia.findEmergenciaById(id);
    }

    public List<EmergenciaEntity> getAllEmergencias() {
        return repositoryEmergencia.findAllEmergencias();
    }

    public EmergenciaEntity addEmergencia(EmergenciaEntity emergencia) {
        return repositoryEmergencia.saveEmergencia(emergencia.getIdEmergencia(),
                emergencia.getTipoEmergencia(),
                emergencia.getZonaEmergencia(),
                emergencia.getCondicionFisica(),
                emergencia.getCantidadVoluntariosMinimo(),
                emergencia.getCantidadVoluntariosMaximo());
    }

}
