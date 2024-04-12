package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.InstitucionEntity;
import Backend_Voluntarios.Backend.Entity.Entity_Ranking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InstitucionRepository {

    //findById
    @Query("SELECT e FROM InstitucionEntity e WHERE e.idInstitucion = :id")
    InstitucionEntity findInstitucionById(@Param("id")Long id);


    //findAll
    @Query("SELECT e FROM InstitucionEntity e")
    List<InstitucionEntity>findAllInstituciones();

    //save
    @Query("INSERT INTO InstitucionEntity(idInstitucion,idEmergencia,nombreInstitucion)")
    void saveInstitucion (@Param("idInstitucion") Long idInstitucion,
                          @Param("idEmergencia") Long idEmergencia,
                          @Param("nombreInstitucion") Long nombreInstitucion);

    //delete


    //create

    //search
    @Query("SELECT palabra FROM InstitucionEntity palabra WHERE"
            + " CONCAT(palabra.idInstitucion, palabra.idEmergencia, palabra.nombreInstitucion)"
            + " LIKE %?1%")
    public List<InstitucionEntity> findAll(String palabraClave);
}
