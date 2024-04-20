package Backend_Voluntarios.Backend.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "coordinador")
public class CoordinadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCoordinador;

    private String correoCoordinador;

    private String contrasenaCoodinador;

    private String nombre;

    public CoordinadorEntity(String correoCoordinador, String contrasenaCoodinador, String nombre) {
        this.correoCoordinador = correoCoordinador;
        this.contrasenaCoodinador = contrasenaCoodinador;
        this.nombre = nombre;
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
        return contrasenaCoodinador;
    }

    public void setContrasenaCoodinador(String contrasenaCoodinador) {
        this.contrasenaCoodinador = contrasenaCoodinador;
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