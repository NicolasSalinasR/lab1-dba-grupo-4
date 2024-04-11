package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.EmeHabilidadEntity;
import Backend_Voluntarios.Backend.Entity.InstitucionEntity;
import Backend_Voluntarios.Backend.Entity.Entity_Ranking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmeHabilidadRepository {

    //findById
    @Query("SELECT e FROM EmeHabilidadEntity e WHERE e.idEmergenciaHabilidad = :id")
    InstitucionEntity findEmeHabilidadById(@Param("id")Long id);

    //findAll
    @Query("SELECT e FROM EmeHabilidadEntity e")
    List<EmeHabilidadEntity>findAllEmeHabilidades();

    //save

    @Query("INSERT INTO EmeHabilidadEntity(idEmergenciaHabilidad,idHabilidad,idEmergencia)")
    void saveEmeHabilidad(@Param("idEmergenciaHabilidad") Long idEmergenciaHabilidad,
                          @Param("idHabilidad") Long idHabilidad,
                          @Param("idEmergencia")Long idEmergencia);

    //delete


    //create

    //search
    @Query("SELECT palabra FROM EmeHabilidadEntity palabra WHERE"
            + " CONCAT(palabra.idEmergenciaHabilidad, palabra.idHabilidad, palabra.idEmergencia)"
            + " LIKE %?1%")
    public List<EmeHabilidadEntity> findAll(String palabraClave);






}
