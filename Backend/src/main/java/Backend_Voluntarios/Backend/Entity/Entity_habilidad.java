package Backend_Voluntarios.Backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Habilidad")
public class Entity_habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id_habilidad;

    private String nombre_habilidad;

    public Entity_habilidad(Long id_habilidad, String nombre_habilidad){
        this.Id_habilidad = id_habilidad;
        this.nombre_habilidad = nombre_habilidad;
    }
}
