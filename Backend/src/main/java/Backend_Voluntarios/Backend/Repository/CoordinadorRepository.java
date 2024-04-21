package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.CoordinadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CoordinadorRepository extends JpaRepository<CoordinadorEntity, Long> {
        @Query("SELECT palabra FROM CoordinadorEntity palabra WHERE"
                        + " CONCAT(palabra.idCoordinador, palabra.correoCoordinador, palabra.contrasenaCoordinador, " +
                        "palabra.contrasenaCoordinador, palabra.nombre)"
                        + " LIKE %?1%")
        public List<CoordinadorEntity> listaPalabraClave(@Param("palabra") String palabraClave);

        @Query("SELECT v FROM CoordinadorEntity v")
        public List<CoordinadorEntity> listTodo();

        @Query("SELECT v FROM CoordinadorEntity v WHERE v.idCoordinador = ?1")
        public List<CoordinadorEntity> buscarIdCoordinador(@Param("v") Long idCoordinador);

        @Transactional
        @Modifying
        @Query(value = "INSERT INTO CoordinadorEntity (nombre, " +
                        "contrasenaCoordinador, correoCoordinador) " +
                        "VALUES (:nombre, :contrasena, :correo)")
        public void crearCoordinador(@Param("nombre") String nombre,
                        @Param("contrasena") String contrasenaCoordinador,
                        @Param("correo") String correoCoordinador);

        @Query("DELETE FROM CoordinadorEntity WHERE idCoordinador = :id")
        CoordinadorEntity borrarCoordinador(@Param("id") Long idCoordinador);

        @Query("SELECT v FROM CoordinadorEntity v WHERE v.idCoordinador = ?1")
        CoordinadorEntity idCoordinador(@Param("v") Long idCoordinador);
}
