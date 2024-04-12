package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.Entity_Estado_Tarea;
import Backend_Voluntarios.Backend.Entity.Entity_Habilidad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Interface_Estado_Tarea {
    @Query("SELECT palabra FROM Entity_Habilidad palabra WHERE"
            + " CONCAT(palabra.Id_Estado_tarea, palabra.Id_tarea, palabra.estado_tarea)"
            + " LIKE %?1%")
    public List<Entity_Estado_Tarea> findAll(String palabraClave);

    @Query(value = "SELECT * FROM Entity_Estado_tarea  WHERE Estado_tarea.Id_Estado_tarea = :Id_Estado_tarea", nativeQuery = true)
    Entity_Estado_Tarea findbyid(@Param("Id_Estado_tarea") Long Id_Estado_tarea);

    @Query(value = "SELECT * FROM Entity_Estado_tarea  WHERE Estado_tarea.Id_tarea = :Id_tarea", nativeQuery = true)
    Entity_Estado_Tarea findbyid_tarea(@Param("Id_tarea") Long Id_tarea);


    @Query(value = "SELECT Id_Estado_tarea FROM Estado_tarea  WHERE Entity_Estado_tarea.estado_tarea = FALSE", nativeQuery = true)
    Long findTareas_sin_terminar();

    @Query(value = "SELECT Id_Estado_tarea FROM Estado_tarea  WHERE Entity_Estado_tarea.estado_tarea = TRUE", nativeQuery = true)
    Long findTareas_terminadas();


    @Query("INSERT INTO Entity_Estado_Tarea (id_estado_tarea, id_tarea, estado_tarea) VALUES (:id_estado_tarea, :id_tarea, :estado_tarea)")
    void saveEstadoTarea(@Param("id_emergencia") Long id,
                                    @Param("tipo_emergencia") Long id_tarea,
                                    @Param("zona_emergencia") boolean estado_tarea);

    @Query("DELETE FROM Entity_Estado_Tarea  WHERE Entity_Estado_Tarea.id_habilidad = :id")
    void deleteEstadoTarea(@Param("id") Long id);

    @Query("SELECT e FROM Entity_Estado_Tarea e")
    List<Entity_Estado_Tarea> listAll();

}
