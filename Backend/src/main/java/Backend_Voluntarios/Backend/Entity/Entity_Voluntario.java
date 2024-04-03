package Backend_Voluntarios.Backend.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "voluntario")
public class Entity_Voluntario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id_Voluntario;

    private String condicion_voluntario;

    private boolean disponibilidad_voluntario;

    private String zona_vivienda;

    private String equipamiento_voluntario;


    public Entity_Voluntario(Long Id_voluntario, String condicion_voluntario, boolean disponibilidad_voluntario, String zona_vivienda, String equipamiento_voluntario){
        super();
        this.Id_Voluntario = Id_voluntario;
        this.condicion_voluntario = condicion_voluntario;
        this.disponibilidad_voluntario = disponibilidad_voluntario;
        this.equipamiento_voluntario = equipamiento_voluntario;
        this.zona_vivienda = zona_vivienda;
    }
    public Entity_Voluntario(){
        super();
    }

}
