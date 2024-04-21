package Backend_Voluntarios.Backend.Service;

import Backend_Voluntarios.Backend.Entity.HabilidadEntity;
import Backend_Voluntarios.Backend.Repository.HabilidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadService {

    private HabilidadRepository interfaceHabilidad;

    public List<HabilidadEntity> listaHabilidades(String palabraClave) {
        return interfaceHabilidad.findAll(palabraClave);
    }

    public HabilidadEntity findById(Long idHabilidad) {
        return interfaceHabilidad.encontrarPorId(idHabilidad);
    }

    public String findNombreHabilidad(Long idHabilidad) {
        return interfaceHabilidad.findNombreHabilidad(idHabilidad);
    }

    public HabilidadEntity crearHabilidad(HabilidadEntity habilidadEntity) {
        return interfaceHabilidad.crearHabilidad(habilidadEntity.getIdhabilidad(),
                habilidadEntity.getNombreHabilidad());
    }

    public HabilidadEntity borrarHabilidad(HabilidadEntity habilidadEntity) {
        return interfaceHabilidad.borrarHabilidad(habilidadEntity.getIdhabilidad());
    }

    public List<HabilidadEntity> getAllHabilidades() {
        return interfaceHabilidad.findAll();
    }

}
