package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.Entity_Emergencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Repository_Emergencia extends JpaRepository<Entity_Emergencia, Long> {
    // findById
    @Query("SELECT e FROM Entity_Emergencia e WHERE e.Id_Emergencia = :id")
    Entity_Emergencia findEmergenciaById(@Param("id") Long id);

    // findAll
    @Query("SELECT e FROM Entity_Emergencia e")
    List<Entity_Emergencia> findAllEmergencias();

    // save
    @Query("INSERT INTO Entity_Emergencia ( Id_Emergencia, tipo_emergencia, zona_emergencia, condicion_fisica, cantidad_voluntarios_minimo, cantidad_voluntarios_maximo) VALUES (:id, :tipo_emergencia, :zona_emergencia, :condicion_fisica, :cantidad_voluntarios_minimo, :cantidad_voluntarios_maximo)")
    Entity_Emergencia saveEmergencia(@Param("id") Long id_emergencia,
            @Param("tipo_emergencia") String tipo_emergencia,
            @Param("zona_emergencia") String zona_emergencia,
            @Param("condicion_fisica") String condicion_fisica,
            @Param("cantidad_voluntarios_minimo") String cantidad_voluntarios_minimo,
            @Param("cantidad_voluntarios_maximo") String cantidad_voluntarios_maximo);
}
