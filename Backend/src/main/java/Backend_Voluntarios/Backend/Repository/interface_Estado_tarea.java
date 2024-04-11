package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.Entity_Estado_tarea;
import Backend_Voluntarios.Backend.Entity.Entity_Habilidad;
import Backend_Voluntarios.Backend.Entity.Entity_Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface interface_Estado_tarea extends JpaRepository<Entity_Estado_tarea, Long> {

    @Query("SELECT palabra FROM Entity_Habilidad palabra WHERE"
            + " CONCAT(palabra.Id_Estado_tarea, palabra.Id_tarea, palabra.estado_tarea)"
            + " LIKE %?1%")
    public List<Entity_Estado_tarea> findAll(String palabraClave);

    @Query(value = "SELECT * FROM Entity_Estado_tarea  WHERE Estado_tarea.Id_Estado_tarea = :Id_Estado_tarea", nativeQuery = true)
    Entity_Estado_tarea findbyid(@Param("Id_Estado_tarea") Long Id_Estado_tarea);

    @Query(value = "SELECT * FROM Entity_Estado_tarea  WHERE Estado_tarea.Id_tarea = :Id_tarea", nativeQuery = true)
    Entity_Estado_tarea findbyid_tarea(@Param("Id_tarea") Long Id_tarea);


    @Query(value = "SELECT Id_Estado_tarea FROM Estado_tarea  WHERE Entity_Estado_tarea.estado_tarea = FALSE", nativeQuery = true)
    Long findTareas_sin_terminar();

    @Query(value = "SELECT Id_Estado_tarea FROM Estado_tarea  WHERE Entity_Estado_tarea.estado_tarea = TRUE", nativeQuery = true)
    Long findTareas_terminadas();
}
