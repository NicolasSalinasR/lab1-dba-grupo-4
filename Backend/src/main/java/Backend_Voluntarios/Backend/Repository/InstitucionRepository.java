package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.InstitucionEntity;
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
    InstitucionEntity saveInstitucion (@Param("idInstitucion") Long idInstitucion,
                          @Param("idEmergencia") Long idEmergencia,
                          @Param("nombreInstitucion") String nombreInstitucion);

    //delete
    @Query("DELETE FROM InstitucionEntity WHERE InstitucionEntity.idInstitucion= :id")
    InstitucionEntity deleteInstitucion(@Param("id") Long id);


    //search
    @Query("SELECT palabra FROM InstitucionEntity palabra WHERE"
            + " CONCAT(palabra.idInstitucion, palabra.idEmergencia, palabra.nombreInstitucion)"
            + " LIKE %?1%")
    public List<InstitucionEntity> findAll(String palabraClave);
}
