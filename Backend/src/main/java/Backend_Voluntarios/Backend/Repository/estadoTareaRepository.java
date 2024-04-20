package Backend_Voluntarios.Backend.Repository;


import Backend_Voluntarios.Backend.Entity.estadoTareaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface estadoTareaRepository {
    @Query("SELECT palabra FROM estadoTareaEntity palabra WHERE"
            + " CONCAT(palabra.idEstadoTarea, palabra.idTarea, palabra.estadoTarea)"
            + " LIKE %?1%")
    public List<estadoTareaEntity> findAll(String palabraClave);

    @Query(value = "SELECT * FROM estadoTareaEntity  WHERE estadoTarea.idEstadoTarea = :idEstadoTarea", nativeQuery = true)
    estadoTareaEntity findbyid(@Param("idEstadoTarea") Long idEstadoTarea);

    @Query(value = "SELECT * FROM estadoTareaEntity  WHERE estadoTarea.idEstadoTarea = :idTarea", nativeQuery = true)
    estadoTareaEntity findByIdTarea(@Param("idTarea") Long idTarea);


    @Query(value = "SELECT estadoTareaEntity  FROM estadoTarea  WHERE estadoTareaEntity.estadoTarea = FALSE", nativeQuery = true)
    Long findTareas_sin_terminar();

    @Query(value = "SELECT idEstadoTarea FROM estadoTarea  WHERE estadoTareaEntity.estadoTarea = TRUE", nativeQuery = true)
    Long findTareas_terminadas();


    @Query("INSERT INTO estadoTareaEntity  (idEstadoTarea, idTarea, estadoTarea) VALUES (:idEstadoTarea, :idTarea, :estadoTarea)")
    void saveEstadoTarea(@Param("idEmergencia") Long idEstadoTarea,
                                    @Param("tipoEmergencia") Long idTarea,
                                    @Param("zonaEmergencia") boolean estadoTarea);

    @Query("DELETE FROM estadoTareaEntity   WHERE estadoTareaEntity.idEstadoTarea = :id")
    void deleteEstadoTarea(@Param("id") Long id);

    @Query("SELECT e FROM estadoTareaEntity  e")
    List<estadoTareaEntity > listAll();

}
