package Backend_Voluntarios.Backend.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "habilidad")
public class HabilidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idHabilidad;

    private String nombreHabilidad;

    public HabilidadEntity(Long idHabilidad, String nombreHabilidad) {
        this.idHabilidad = idHabilidad;
        this.nombreHabilidad = nombreHabilidad;
    }
    // constructor vacio
    public HabilidadEntity(){
        super();
    }
    // geters
    public Long getIdhabilidad() {
        return idHabilidad;
    }
    public String getNombreHabilidad() {
        return nombreHabilidad;
    }
    // seter
    public void setNombreHabilidad(String nombreHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
    }
}



