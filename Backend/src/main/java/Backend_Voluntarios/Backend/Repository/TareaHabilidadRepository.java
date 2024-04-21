package Backend_Voluntarios.Backend.Repository;


import Backend_Voluntarios.Backend.Entity.TareaHabilidadEntity;
import Backend_Voluntarios.Backend.Entity.TareaHabilidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TareaHabilidadRepository {

    // Encontrar tarea_hablidades por Id
    @Query("SELECT th FROM TareaHabilidadEntity th WHERE th.idTareaHabilidad = :id")
    TareaHabilidadEntity findTareaHabilidadById(@Param("id") Long id);

    // Encontrar todas las tarea_habilidades
    @Query("SELECT th FROM TareaHabilidadEntity th")
    List<TareaHabilidadEntity> findAllTareaHabilidad();

    // Guardar
    @Query("INSERT INTO TareaHabilidadEntity (idTareaHabilidad, idTarea, idHabilidad, habilidadRequerida) VALUES (:idTareaHabilidad , :idTarea, :idEstadoTarea, :habilidadRequerida)")
    TareaHabilidadEntity saveTareaHabilidad(@Param("idTareaHabilidad") Long idTareaHabilidad,
                          @Param("idTarea") Long idTarea,
                          @Param("idHabilidad") Long idHabilidad,
                          @Param("habilidadRequerida") List<String> habilidadRequerida);
}