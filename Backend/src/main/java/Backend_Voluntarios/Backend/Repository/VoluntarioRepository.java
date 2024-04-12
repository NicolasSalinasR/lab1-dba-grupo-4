package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.VoluntarioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoluntarioRepository {
    @Query("SELECT palabra FROM VoluntarioEntity palabra WHERE"
            + " CONCAT(palabra.Id_voluntario, palabra.condicion_voluntario, palabra.disponibilidad_voluntario, palabra.equipamiento_voluntario, palabra.zona_vivienda_voluntario)"
            + " LIKE %?1%")
    public List<VoluntarioEntity> findAll(@Param("palabra") String palabraClave);

    @Query("SELECT v FROM VoluntarioEntity v")
    public List<VoluntarioEntity> ListAll();

    @Query("SELECT v FROM VoluntarioEntity v WHERE v.Id_voluntario = ?1")
    public List<VoluntarioEntity> BuscarId_voluntario(@Param("v") Long Id_voluntario);

    @Query("INSERT INTO Entity_Voluntario (Id_voluntario, condicion_voluntario, disponibilidad_voluntario, equipamiento_voluntario, zona_vivienda_voluntario) " +
            "VALUES (:Id, :condicion, :disponibilidad, :equipamiento, :zona)")
    VoluntarioEntity Crear_voluntario(@Param("Id") Long Id_voluntario,
                                      @Param("condicion") String condicion_voluntario,
                                      @Param("disponibilidad") Boolean disponibilidad_voluntario,
                                      @Param("equipamiento") String equipamiento_voluntario,
                                      @Param("zona") String zona_vivienda_voluntario);

    @Query("DELETE FROM VoluntarioEntity WHERE Id_voluntario = :id")
    VoluntarioEntity Borrar_voluntario(@Param("id") Long Id_voluntario);

    @Query("SELECT v FROM VoluntarioEntity v WHERE v.Id_voluntario = ?1")
    VoluntarioEntity Id_voluntario(@Param("v") Long Id_voluntario);
}
