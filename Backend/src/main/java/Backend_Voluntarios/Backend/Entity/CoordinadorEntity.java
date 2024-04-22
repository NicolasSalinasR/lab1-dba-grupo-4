package Backend_Voluntarios.Backend.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "coordinador")
public class CoordinadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCoordinador;

    private String correoCoordinador;

    private String contrasenaCoordinador;

    private String nombre;

    public CoordinadorEntity(String nombre, String contrasenaCoordinador, String correoCoordinador) {
        this.nombre = nombre;
        this.contrasenaCoordinador = contrasenaCoordinador;
        this.correoCoordinador = correoCoordinador;
    }

    public String getCorreoCoordinador() {
        return correoCoordinador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenaCoodinador() {
        return contrasenaCoordinador;
    }

    public void setContrasenaCoodinador(String contrasenaCoordinador) {
        this.contrasenaCoordinador = contrasenaCoordinador;
    }

    public void setCorreoCoordinador(String correoCoordinador) {
        this.correoCoordinador = correoCoordinador;
    }

    public void setIdCoordinador(Long idCoordinador) {
        this.idCoordinador = idCoordinador;
    }

    public CoordinadorEntity(){super();}

    public Long getIdCoordinador(){
        return idCoordinador;
    }
}