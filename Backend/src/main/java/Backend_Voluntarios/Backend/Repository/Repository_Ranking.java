package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.Entity_Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Repository_Ranking extends JpaRepository <Entity_Ranking, Long> {
    @Query("SELECT palabra FROM Entity_Ranking palabra WHERE"
            + " CONCAT(palabra.Id_ranking, palabra.Id_tarea, palabra.Id_voluntario, palabra.nivel_ranking, palabra.tarea_ranking)"
            + " LIKE %?1%")
    public List<Entity_Ranking> findAll(String palabraClave);
}
