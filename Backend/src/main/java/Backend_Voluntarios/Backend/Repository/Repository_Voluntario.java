package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.Entity_Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repository_Voluntario  {
    @Query("SELECT palabra FROM Entity_Voluntario palabra WHERE"
            + " CONCAT(palabra.Id_voluntario, palabra.condicion_voluntario, palabra.disponibilidad_voluntario, palabra.equipamiento_voluntario, palabra.zona_vivienda_voluntario)"
            + " LIKE %?1%")
    public List<Entity_Voluntario> findAll(@Param("palabra") String palabraClave);

    @Query("SELECT v FROM Entity_Voluntario v")
    public List<Entity_Voluntario> ListAll();
}
