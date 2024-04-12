package Backend_Voluntarios.Backend.Entity;

import jakarta.persistence.*;


@Entity
@Table(name="Habilidad")
public class Entity_Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id_habilidad;

    private String nombre_habilidad;

    public Entity_Habilidad(Long id_habilidad, String nombre_habilidad) {
        this.Id_habilidad = id_habilidad;
        this.nombre_habilidad = nombre_habilidad;
    }
    // constructor vacio
    public Entity_Habilidad(){
        super();
    }
    // geters
    public Long getId_habilidad() {
        return Id_habilidad;
    }
    public String getNombre_habilidad() {
        return nombre_habilidad;
    }
    // seter
    public void setNombre_habilidad(String nombre_habilidad) {
        this.nombre_habilidad = nombre_habilidad;
    }
}

