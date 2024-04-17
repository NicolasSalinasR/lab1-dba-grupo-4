package Backend_Voluntarios.Backend.Entity;

import jakarta.persistence.*;


@Entity
@Table(name="habilidad")
public class habilidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idHabilidad;

    private String nombreHabilidad;

    public habilidadEntity(Long idHabilidad, String nombreHabilidad) {
        this.idHabilidad = idHabilidad;
        this.nombreHabilidad = nombreHabilidad;
    }
    // constructor vacio
    public habilidadEntity(){
        super();
    }
    // geters
    public Long getIdHabilidad() {
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
