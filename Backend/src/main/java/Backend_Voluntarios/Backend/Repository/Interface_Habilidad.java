package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.Entity_Habilidad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Interface_Habilidad {
    @Query("SELECT palabra FROM Entity_Habilidad palabra WHERE"
            + " CONCAT(palabra.Id_habilidad, palabra.nombre_habilidad)"
            + " LIKE %?1%")
    public List<Entity_Habilidad> findAll(String palabraClave);

    @Query(value = "SELECT * FROM Habilidad  WHERE Entity_Habilidad.Id_habilidad = :Id_habilidad", nativeQuery = true)
    Entity_Habilidad findById(@Param("Id_habilidad") Long Id_habilidad);

    @Query(value = "SELECT nombre_habilidad FROM Entity_Habilidad WHERE Habilidad.Id_habilidad = :Id_habilidad", nativeQuery = true)
    String findNombreHabilidad(@Param("Id_habilidad") Long id_habilidad);


    @Query("INSERT INTO Entity_Habilidad (id_habilidad, nombre_habilidad) VALUES (:id_habilidad, :nombre_habilidad)")
    void saveHabilidad(@Param("id_habilidad") Long id,
                       @Param("nombre_habilidad") String nombre_habilidad);


    @Query("DELETE FROM Entity_Habilidad  WHERE Entity_Habilidad.id_habilidad = :id")
    void deleteHabilidad(@Param("id") Long id);

    @Query("SELECT h FROM Entity_Habilidad h")
    List<Entity_Habilidad> listAll();
}

