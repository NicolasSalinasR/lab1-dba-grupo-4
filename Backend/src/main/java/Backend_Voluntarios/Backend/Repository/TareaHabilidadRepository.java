package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.EmeHabilidadEntity;
import Backend_Voluntarios.Backend.Entity.TareaEntity;
import Backend_Voluntarios.Backend.Entity.TareaHabilidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TareaHabilidadRepository extends JpaRepository<TareaHabilidadEntity, Long> {

    // Encontrar tarea_hablidades por Id
    @Query("SELECT th FROM TareaHabilidadEntity th WHERE th.idTareaHabilidad = :id")
    TareaHabilidadEntity findTareaHabilidadById(@Param("id") Long id);

    // Encontrar todas las tarea_habilidades
    @Query("SELECT th FROM TareaHabilidadEntity th")
    List<TareaHabilidadEntity> findAllTareaHabilidad();

    // Guardar
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO TareaHabilidadEntity (tarea, emeHabilidad, habilidadRequerida) VALUES (:tarea, :emeHabilidad, :habilidadRequerida)")
    void saveTareaHabilidad(@Param("tarea") TareaEntity tarea, @Param("emeHabilidad") EmeHabilidadEntity emeHabilidad,
            @Param("habilidadRequerida") String habilidadRequerida);
}