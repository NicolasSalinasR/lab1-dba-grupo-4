package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.EstadoTareaEntity;
import Backend_Voluntarios.Backend.Entity.HabilidadEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstadoTareaRepository {
    @Query("SELECT palabra FROM EstadoTareaEntity palabra WHERE"
            + " CONCAT(palabra.idEstadoTarea, palabra.idTarea, palabra.estadoTarea)"
            + " LIKE %?1%")
    public List<EstadoTareaEntity> listAll(String palabraClave);

    @Query(value = "SELECT * FROM estadoTarea  WHERE estadoTarea.idEstadoTarea = :idEstadoTarea", nativeQuery = true)
    EstadoTareaEntity findById(@Param("idEstadoTarea") Long idEstadoTarea);

    @Query(value = "SELECT * FROM Ent  WHERE Estado_tarea.Id_tarea = :Id_tarea", nativeQuery = true)
    EstadoTareaEntity findByIdTarea(@Param("idTarea") Long idTarea);


    @Query(value = "SELECT idEstadoTarea FROM EstadoTareaEntity  WHERE EstadoTareaEntity.estadoTarea = FALSE", nativeQuery = true)
    List<Long>  findTareasSinTerminar();

    @Query(value = "SELECT idEstadoTarea FROM EstadoTareaEntity  WHERE EstadoTareaEntity.estadoTarea = TRUE", nativeQuery = true)
    List<Long> findTareasTerminadas();

    @Query(value = "DELETE FROM EstadoTareaEntity WHERE EstadoTareaEntity.idEstadoTarea = :idEstadoTarea", nativeQuery = true)
    EstadoTareaEntity borrarEstadoTarea(@Param("idEstadoTarea") Long idEstadoTarea);

    @Query(value = "INSERT INTO EstadoTareaEntity (idEstadoTarea, idTarea, estadoTarea) " +
            "VALUES (:idEstadoTarea, :idTarea, :estadoTarea)", nativeQuery = true)
    EstadoTareaEntity guardarEstadoTarea(@Param("idEstadoTarea") Long idEstadoTarea,
                                         @Param("idTarea") Long idTarea,
                                         @Param("estadoTarea") Boolean estadoTarea);

    @Query(value = "SELECT * FROM EstadoTareaEntity", nativeQuery = true)
    List<EstadoTareaEntity> findAll();
}
