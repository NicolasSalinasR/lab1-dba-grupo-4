package Backend_Voluntarios.Backend.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private Long idVoluntario;

    private String correoVoluntario;

    private String contraseñaVoluntario;

    private String rol;

    public UsuarioEntity(Long idUsuario, Long idVoluntario, String correoVoluntario, String contraseñaVoluntario, String rol){
        this.idUsuario = idUsuario;
        this.idVoluntario = idVoluntario;
        this.contraseñaVoluntario = contraseñaVoluntario;
        this.correoVoluntario = correoVoluntario;
        this.rol = rol;
    }

    public UsuarioEntity() {super();}

    public Long getIdUsuario() {
        return idUsuario;
    }

    public Long getIdVoluntario() {
        return idVoluntario;
    }
}
