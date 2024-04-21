package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.VoluntarioHabilidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface VoluntarioHabilidadRepository extends JpaRepository<VoluntarioHabilidadEntity, Long> {
    // findById
    @Query("SELECT vh FROM VoluntarioHabilidadEntity vh WHERE vh.idVoluntarioHabilidad = :id")
    VoluntarioHabilidadEntity findVoluntarioHabilidadById(@Param("id") Long id);

    // findAll
    @Query("SELECT vh FROM VoluntarioHabilidadEntity vh")
    List<VoluntarioHabilidadEntity> findAllVoluntarioHabilidades();

    // save
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO VoluntarioHabilidadEntity (idVoluntario, idHabilidad) VALUES (:idVoluntario, :idHabilidad)")
    void saveVoluntarioHabilidad(@Param("idVoluntario") Long idVoluntario,
            @Param("idHabilidad") Long idHabilidad);
}