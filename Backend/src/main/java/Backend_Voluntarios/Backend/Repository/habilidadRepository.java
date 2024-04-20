package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.habilidadEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface habilidadRepository {
    @Query("SELECT palabra FROM habilidadEntity palabra WHERE"
            + " CONCAT(palabra.idHabilidad, palabra.nombreHabilidad)"
            + " LIKE %?1%")
    public List<habilidadEntity> findAll(String palabraClave);

    @Query(value = "SELECT * FROM habilidad  WHERE habilidadEntity.idHabilidad = :idHabilidad", nativeQuery = true)
    habilidadEntity findById(@Param("idHabilidad") Long Id_habilidad);

    @Query(value = "SELECT nombreHabilidad FROM habilidadEntity WHERE Habilidad.idhabilidad = :idHabilidad", nativeQuery = true)
    String findNombreHabilidad(@Param("idHabilidad") Long idHabilidad);


    @Query("INSERT INTO habilidadEntity (idHabilidad, nombreHabilidad) VALUES (:idHabilidad, :nombreHabilidad)")
    void saveHabilidad(@Param("idHabilidad") Long idHabilidad,
                       @Param("nombreHabilidad") String nombreHabilidad);


    @Query("DELETE FROM habilidadEntity  WHERE habilidadEntity.idHabilidad = :id")
    void deleteHabilidad(@Param("id") Long id);

    @Query("SELECT h FROM habilidadEntity h")
    List<habilidadEntity> listAll();
}

