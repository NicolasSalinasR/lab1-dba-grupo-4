package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.RankingEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankingRepository {
    @Query("SELECT palabra FROM RankingEntity palabra WHERE"
        + " CONCAT(palabra.idRanking, palabra.idTarea, palabra.idVoluntario, palabra.nivelRanking, palabra.tareaRanking)"
        + " LIKE %?1%")
public List<RankingEntity> findAll(String palabraClave);

    @Query("SELECT v FROM RankingEntity v")
    public List<RankingEntity> listAll();

    @Query("SELECT v FROM RankingEntity v WHERE v.idRanking = ?1")
    public List<RankingEntity> buscarIdRanking(@Param("v") Long idRanking);

    @Query("INSERT INTO Entity_Voluntario (Long idRanking, Long idTarea, Long idVoluntario, Integer nivelRanking, String tareaRanking) " +
            "VALUES (:id, :idTarea, :idVoluntario, :nivel, :tarea)")
    RankingEntity crearRanking(@Param("id") Long idRanking,
                               @Param("idTarea") Long idTarea,
                               @Param("idVoluntario") Long idVoluntario,
                               @Param("nivel") Integer nivelRanking,
                               @Param("tarea") String tareaRanking);

    @Query("DELETE FROM RankingEntity WHERE idRanking = :id")
    RankingEntity borrarRanking(@Param("id") Long idRanking);

    @Query("SELECT v FROM RankingEntity v WHERE v.idRanking = ?1")
    RankingEntity idRanking(@Param("v") Long idRanking);
}