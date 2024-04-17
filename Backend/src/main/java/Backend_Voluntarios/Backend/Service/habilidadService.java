package Backend_Voluntarios.Backend.Service;

import Backend_Voluntarios.Backend.Entity.habilidadEntity;
import Backend_Voluntarios.Backend.Repository.habilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class habilidadService {
    @Autowired
    private habilidadRepository interfaceHabilidad;

    public List<habilidadEntity> listaHabilidades(String palabraClave) {
        if(palabraClave != null) {
            return interfaceHabilidad.findAll(palabraClave);
        }
        return interfaceHabilidad.listAll();
    }

    public List <habilidadEntity> listarTodo(){
        return interfaceHabilidad.listAll();
    }
    public habilidadEntity findById(Long idHabilidad){
        return interfaceHabilidad.findById(idHabilidad);
    }

    public String find_nombre_habilidad (Long idHabilidad){
        return interfaceHabilidad.findNombreHabilidad(idHabilidad);
    }

    public void eliminarHabilidad (Long idHabilidad){
         interfaceHabilidad.deleteHabilidad(idHabilidad);
    }

    public void guardarHabilidad (habilidadEntity habilidad){
        interfaceHabilidad.saveHabilidad(habilidad.getIdHabilidad(), habilidad.getNombreHabilidad());
    }
}
