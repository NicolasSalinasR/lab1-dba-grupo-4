package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.RankingEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankingRepository {
    @Query("SELECT palabra FROM RankingEntity palabra WHERE"
        + " CONCAT(palabra.Id_ranking, palabra.Id_tarea, palabra.Id_voluntario, palabra.nivel_ranking, palabra.tarea_ranking)"
        + " LIKE %?1%")
public List<RankingEntity> findAll(String palabraClave);

    @Query("SELECT v FROM RankingEntity v")
    public List<RankingEntity> ListAll();

    @Query("SELECT v FROM RankingEntity v WHERE v.Id_ranking = ?1")
    public List<RankingEntity> BuscarId_ranking(@Param("v") Long Id_ranking);

    @Query("INSERT INTO Entity_Voluntario (Long Id_ranking, Long Id_tarea, Long Id_voluntario, Integer nivel_ranking, String tarea_ranking) " +
            "VALUES (:Id, :Id_tarea, :Id_voluntario, :nivel, :tarea)")
    RankingEntity Crear_ranking(@Param("Id") Long Id_ranking,
                                @Param("Id_tarea") Long Id_tarea,
                                @Param("Id_voluntario") Long Id_voluntario,
                                @Param("nivel") Integer nivel_ranking,
                                @Param("tarea") String tarea_ranking);

    @Query("DELETE FROM RankingEntity WHERE Id_ranking = :id")
    RankingEntity Borrar_ranking(@Param("id") Long Id_ranking);

    @Query("SELECT v FROM RankingEntity v WHERE v.Id_ranking = ?1")
    RankingEntity Id_ranking(@Param("v") Long Id_ranking);
}