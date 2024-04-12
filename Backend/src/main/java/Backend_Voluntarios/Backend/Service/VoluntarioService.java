package Backend_Voluntarios.Backend.Service;

import Backend_Voluntarios.Backend.Entity.VoluntarioEntity;
import Backend_Voluntarios.Backend.Repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntarioService {
    @Autowired
    private VoluntarioRepository repositoryVoluntario;

    public List<VoluntarioEntity> Lista_filtro(String PalabraClave){
        return repositoryVoluntario.findAll(PalabraClave);
    }

    public List<VoluntarioEntity> Tabla_completa(){
        return repositoryVoluntario.ListAll();
    }

    public List<VoluntarioEntity> Tabla_Id(Long Id_voluntario){
        return repositoryVoluntario.BuscarId_voluntario(Id_voluntario);
    }

    public VoluntarioEntity Nuevo_voluntario(VoluntarioEntity entity_voluntario){
        return repositoryVoluntario.Crear_voluntario(entity_voluntario.getId_voluntario(), entity_voluntario.getCondicion_voluntario(), entity_voluntario.isDisponibilidad_voluntario(), entity_voluntario.getEquipamiento_voluntario(), entity_voluntario.getZona_vivienda_voluntario());
    }

    public VoluntarioEntity Borrar_voluntario(VoluntarioEntity entity_voluntario){
        return repositoryVoluntario.Borrar_voluntario(entity_voluntario.getId_voluntario());
    }

    public VoluntarioEntity Buscar_Id(Long Id_voluntario){
        return repositoryVoluntario.Id_voluntario(Id_voluntario);
    }
}
