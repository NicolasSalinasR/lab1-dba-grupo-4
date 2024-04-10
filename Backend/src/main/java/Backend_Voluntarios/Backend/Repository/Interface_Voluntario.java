package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.Entity_Ranking;
import Backend_Voluntarios.Backend.Entity.Entity_Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Interface_Voluntario extends JpaRepository<Entity_Voluntario, Long> {
    @Query("SELECT palabra FROM Entity_Voluntario palabra WHERE"
            + " CONCAT(palabra.Id_voluntario, palabra.condicion_voluntario, palabra.disponibilidad_voluntario, palabra.equipamiento_voluntario, palabra.zona_vivienda_voluntario)"
            + " LIKE %?1%")
    public List<Entity_Voluntario> findAll(String palabraClave);
}
