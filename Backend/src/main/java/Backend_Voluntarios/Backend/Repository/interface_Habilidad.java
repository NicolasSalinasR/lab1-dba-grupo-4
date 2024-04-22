package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.Entity_Habilidad;
import Backend_Voluntarios.Backend.Entity.Entity_Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface interface_Habilidad extends JpaRepository<Entity_Ranking, Long> {
    @Query("SELECT palabra FROM Entity_Habilidad palabra WHERE"
            + " CONCAT(palabra.Id_habilidad, palabra.nombre_habilidad)"
            + " LIKE %?1%")
    public List<Entity_Habilidad> findAll(String palabraClave);

    @Query(value = "SELECT * FROM Habilidad  WHERE Habilidad.Id_habilidad = :Id_habilidad", nativeQuery = true)
    Entity_Habilidad findbyid(@Param("Id_habilidad") Long Id_habilidad);

    @Query(value = "SELECT nombre_habilidad FROM Habilidad WHERE Habilidad.Id_habilidad = :Id_habilidad", nativeQuery = true)
    String find_nombre_habilidad(@Param("Id_habilidad") Long id_habilidad);
}
