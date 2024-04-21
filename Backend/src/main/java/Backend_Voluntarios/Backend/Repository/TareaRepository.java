package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.TareaEntity;
import Backend_Voluntarios.Backend.Entity.VoluntarioEntity;
import Backend_Voluntarios.Backend.Entity.RankingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TareaRepository {

    // Encontrar tareas por Id
    @Query("SELECT t FROM TareaEntity t WHERE t.idTarea = :id")
    TareaEntity findTareaById(@Param("id") Long id);

    // Encontrar todas las tareas
    @Query("SELECT t FROM TareaEntity t")
    List<TareaEntity> findAllTareas();

    @Query("SELECT v FROM TareaEntity v WHERE v.idEmergencia = ?1")
    public List<TareaEntity> buscarIdEmergencia(@Param("v") Long idEmergencia);

    // Guardar
    @Query("INSERT INTO TareaEntity (idTarea, idEstadoTarea, nombreTarea, descripcionTarea, tipoTarea) VALUES (:idTarea, :idEstadoTarea, :descripcionTarea, :tipoTarea)")
    TareaEntity saveTarea(@Param("idTarea") Long idTarea,
                          @Param("idEstadoTarea") Long idEstadoTarea,
                          @Param("nombreTarea") String nombreTarea,
                          @Param("descripcionTarea") String descripcionTarea,
                          @Param("tipoTarea") String tipoTarea);

    // Crear en pantalla un listado de voluntarios por ranking para una tarea específica

    @Query("SELECT t.nombreTarea, v.nombreVoluntario, r.nivelRanking " +
            "FROM VoluntarioEntity v, TareaEntity t, RankingEntity r " +
            "WHERE t.nombreTarea = :nombreTarea AND v.idVoluntario = r.idVoluntario AND t.idTarea = r.idTarea " +
            "GROUP BY t.nombreTarea, v.nombreVoluntario, r.nivelRanking " +
            "ORDER BY r.nivelRanking DESC")
    List<TareaEntity> listRankingTarea(@Param("nombreTarea") String nombreTarea);
}
