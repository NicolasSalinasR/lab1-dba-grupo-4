package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.HabilidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabilidadRepository extends JpaRepository<HabilidadEntity, Long> {

    @Query("SELECT palabra FROM HabilidadEntity palabra WHERE"
            + " CONCAT(palabra.idHabilidad, palabra.nombreHabilidad)"
            + " LIKE %?1%")
    public List<HabilidadEntity> findAll(String palabraClave);

    @Query(value = "SELECT * FROM HabilidadEntity  WHERE HabilidadEntity.idHabilidad = :idHabilidad", nativeQuery = true)
    HabilidadEntity encontrarPorId(@Param("idHabilidad") Long idHabilidad);

    @Query(value = "SELECT nombreHabilidad FROM HabilidadEntity WHERE HabilidadEntity.idHabilidad = :idHabilidad", nativeQuery = true)
    String findNombreHabilidad(@Param("idHabilidad") Long idHabilidad);

    @Query(value = "INSERT INTO HabilidadEntity (idHabilidad, nombreHabilidad) " +
            "VALUES (:idHabilidad, :nombreHabilidad)", nativeQuery = true)
    HabilidadEntity crearHabilidad(@Param("idHabilidad") Long idHabilidad,
                                   @Param("nombreHabilidad") String nombreHabilidad);

    @Query(value = "DELETE FROM HabilidadEntity WHERE HabilidadEntity.idHabilidad = :idHabilidad", nativeQuery = true)
    HabilidadEntity borrarHabilidad(@Param("idHabilidad") Long idHabilidad);

    @Query(value = "SELECT * FROM HabilidadEntity", nativeQuery = true)
    List<HabilidadEntity> findAll();


}
