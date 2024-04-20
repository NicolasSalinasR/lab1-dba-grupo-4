package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.CoordinadorEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CoordinadorRepository {
    @Query("SELECT palabra FROM CoordinadorEntity palabra WHERE"
            + " CONCAT(palabra.idCoordinador, palabra.correoCoordinador, palabra.contrasenaCoodinador, " +
            "palabra.contrasenaCoodinador, palabra.nombre)"
            + " LIKE %?1%")
    public List<CoordinadorEntity> listaPalabraClave(@Param("palabra") String palabraClave);

    @Query("SELECT v FROM CoordinadorEntity v")
    public List<CoordinadorEntity> listTodo();

    @Query("SELECT v FROM CoordinadorEntity v WHERE v.idCoordinador = ?1")
    public List<CoordinadorEntity> buscarIdCoordinador(@Param("v") Long idCoordinador);

    @Query("INSERT INTO CoordinadorEntity (idCoordinador, CorreoCoordinador, " +
            "contrasenaCoordinador, nombre) " +
            "VALUES (:id, :correo, :contrasena, : nombre)")
    CoordinadorEntity crearCoordinador(@Param("id") Long idVoluntario,
                                     @Param("correo") String nombreVoluntario,
                                     @Param("contrasena") String contrasenaVoluntario,
                                     @Param("nombre") String correoVoluntario);

    @Query("DELETE FROM CoordinadorEntity WHERE idCoordinador = :id")
    CoordinadorEntity borrarCoordinador(@Param("id") Long idCoordinador);

    @Query("SELECT v FROM CoordinadorEntity v WHERE v.idCoordinador = ?1")
    CoordinadorEntity idCoordinador(@Param("v") Long idCoordinador);
}
