package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.VoluntarioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoluntarioRepository {
        @Query("SELECT palabra FROM VoluntarioEntity palabra WHERE"
                        + " CONCAT(palabra.idVoluntario, palabra.nombreVoluntario, palabra.correoVoluntario, " +
                        "palabra.numeroDocumentoVoluntario, palabra.equipamientoVoluntario, " +
                        "palabra.zonaViviendaVoluntario)"
                        + " LIKE %?1%")
        public List<VoluntarioEntity> findAll(@Param("palabra") String palabraClave);

        @Query("SELECT v FROM VoluntarioEntity v")
        public List<VoluntarioEntity> listAll();

        @Query("SELECT v FROM VoluntarioEntity v WHERE v.idVoluntario = ?1")
        public List<VoluntarioEntity> buscarIdVoluntario(@Param("v") Long idVoluntario);

        @Query("INSERT INTO Entity_Voluntario (idVoluntario, nombreVoluntario, " +
                        "correoVoluntario, numeroDocumentoVoluntario, equipamientoVoluntario, zonaViviendaVoluntario) "
                        +
                        "VALUES (:id, :condicion, :disponibilidad, :equipamiento, :zona)")
        VoluntarioEntity crearVoluntario(@Param("id") Long idVoluntario,
                        @Param("nombre") String nombreVoluntario,
                        @Param("correoVoluntario") String correoVoluntario,
                        @Param("numero") String numeroDocumentoVoluntario,
                        @Param("equipamiento") List<String> equipamientoVoluntario,
                        @Param("zona") String zonaViviendaVoluntario);

        @Query("DELETE FROM VoluntarioEntity WHERE idVoluntario = :id")
        VoluntarioEntity borrarVoluntario(@Param("id") Long idVoluntario);

        @Query("SELECT v FROM VoluntarioEntity v WHERE v.idVoluntario = ?1")
        VoluntarioEntity idVoluntario(@Param("v") Long idVoluntario);

        @Query("SELECT v FROM VoluntarioEntity v WHERE v.correoVoluntario = ?1")
        VoluntarioEntity findByCorreo(@Param("correo") String correoVoluntario);
}
