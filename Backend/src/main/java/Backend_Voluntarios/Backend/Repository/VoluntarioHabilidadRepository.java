package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.VoluntarioHabilidadEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VoluntarioHabilidadRepository {
    // findById
    @Query("SELECT vh FROM VoluntarioHabilidadEntity vh WHERE vh.idVoluntarioHabilidad = :id")
    VoluntarioHabilidadEntity findVoluntarioHabilidadById(@Param("id") Long id);

    // findAll
    @Query("SELECT vh FROM VoluntarioHabilidadEntity vh")
    List<VoluntarioHabilidadEntity> findAllVoluntarioHabilidades();

    // save
    @Query("INSERT INTO VoluntarioHabilidadEntity (idVoluntarioHabilidad, idVoluntario, idHabilidad) VALUES (:idVoluntarioHabilidad, :idVoluntario, :idHabilidad)")
    VoluntarioHabilidadEntity saveVoluntarioHabilidad(@Param("idVoluntarioHabilidad") Long idVoluntarioHabilidad,
            @Param("idVoluntario") Long idVoluntario,
            @Param("idHabilidad") Long idHabilidad);
}