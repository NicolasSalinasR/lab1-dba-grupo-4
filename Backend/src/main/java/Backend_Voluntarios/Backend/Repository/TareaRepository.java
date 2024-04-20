package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.TareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<TareaEntity, Long> {

    // Encontrar tareas por Id
    @Query("SELECT t FROM TareaEntity t WHERE t.idTarea = :id")
    TareaEntity findTareaById(@Param("id") Long id);

    // Encontrar todas las tareas
    @Query("SELECT t FROM TareaEntity t")
    List<TareaEntity> findAllTareas();

    // Guardar
    @Query("INSERT INTO TareaEntity (idTarea, idEstadoTarea, idEmergencia,nombreTarea, descripcionTarea, tipoTarea) VALUES (:idTarea, :idEstadoTarea, :idEmergencia, :descripcionTarea, :tipoTarea)")
    TareaEntity saveTarea(@Param("idTarea") Long idTarea,
                          @Param("idEstadoTarea") Long idEstadoTarea,
                          @Param("idEmergencia") Long idEmergencia,
                          @Param("nombreTarea") String nombreTarea,
                          @Param("descripcionTarea") String descripcionTarea,
                          @Param("tipoTarea") String tipoTarea);
}