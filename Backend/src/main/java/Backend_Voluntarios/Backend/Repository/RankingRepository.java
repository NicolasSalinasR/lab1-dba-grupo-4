package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.EmergenciaEntity;
import Backend_Voluntarios.Backend.Entity.RankingEntity;
import Backend_Voluntarios.Backend.Entity.TareaEntity;
import Backend_Voluntarios.Backend.Entity.VoluntarioEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RankingRepository extends JpaRepository<RankingEntity, Long> {
        @Query("SELECT palabra FROM RankingEntity palabra WHERE"
                        + " CONCAT(palabra.idRanking, palabra.nivelRanking, palabra.tareaRanking)"
                        + " LIKE %?1%")
        public List<RankingEntity> findAll(String palabraClave);

        @Query("SELECT r.idRanking, r.nivelRanking " +
                        "FROM RankingEntity r " +
                        "ORDER BY r.nivelRanking DESC")
        public List<RankingEntity> listRanking();

        @Query("SELECT v FROM RankingEntity v")
        public List<RankingEntity> listAll();

        @Query("SELECT v FROM RankingEntity v WHERE v.idRanking = ?1")
        public List<RankingEntity> buscarIdRanking(@Param("v") Long idRanking);

        @Transactional
        @Modifying
        @Query(value = "INSERT INTO ranking (id_tarea, id_voluntario, nombre_voluntario, numero_documento_voluntario, nivel_ranking, tarea_ranking) "
                        +
                        "VALUES (:id_tarea, :id_voluntario, :nombre_voluntario, :numero_documento_voluntario, :nivel_ranking, :tarea_ranking)", nativeQuery = true)
        void crearRanking(@Param("id_tarea") Long tarea,
                        @Param("id_voluntario") Long voluntario,
                        @Param("nombre_voluntario") String nombreVoluntario,
                        @Param("numero_documento_voluntario") String numeroDocumentoVoluntario,
                        @Param("nivel_ranking") Integer nivelRanking,
                        @Param("tarea_ranking") String tareaRanking);

        @Transactional
        @Modifying
        @Query("DELETE FROM RankingEntity v WHERE v.idRanking = :id")
        void borrarRanking(@Param("id") Long id);

        @Query("SELECT v FROM RankingEntity v WHERE v.idRanking = ?1")
        RankingEntity idRanking(@Param("v") Long idRanking);

        @Query("SELECT v.zonaEmergencia FROM EmergenciaEntity v WHERE v.zonaEmergencia =:zona")
        public List<EmergenciaEntity> matchZona(String zona);

        @Query("SELECT COUNT(DISTINCT v.equipamientoVoluntario) FROM VoluntarioEntity v INNER JOIN TareaHabilidadEntity t ON v.equipamientoVoluntario = t.habilidadRequerida WHERE v.idVoluntario = :idVoluntario AND t.tarea.idTarea = :idTarea")
        public int matchEquipo(@Param("idVoluntario") Long idVoluntario, @Param("idTarea") Long idTarea);

        @Query("SELECT COUNT(v) FROM VoluntarioHabilidadEntity v WHERE v.voluntario.idVoluntario=:id")
        public int matchHabilidad(
                        @Param("id") Long idVoluntario);
}