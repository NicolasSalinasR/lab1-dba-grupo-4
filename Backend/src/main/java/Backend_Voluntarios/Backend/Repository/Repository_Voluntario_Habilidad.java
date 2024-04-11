package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.Entity_Voluntario_Habilidad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Repository_Voluntario_Habilidad {
    // findById
    @Query("SELECT vh FROM Entity_Voluntario_Habilidad vh WHERE vh.Id_Voluntario_Habilidad = :id")
    Entity_Voluntario_Habilidad findVoluntarioHabilidadById(@Param("id") Long id);

    // findAll
    @Query("SELECT vh FROM Entity_Voluntario_Habilidad vh")
    List<Entity_Voluntario_Habilidad> findAllVoluntarioHabilidades();

    // save
    @Query("INSERT INTO Entity_Voluntario_Habilidad (Id_voluntario, Id_habilidad) VALUES (:Id_voluntario, :Id_habilidad)")
    Entity_Voluntario_Habilidad saveVoluntarioHabilidad(@Param("Id_voluntario") Long Id_voluntario,
            @Param("Id_habilidad") Long Id_habilidad);
}