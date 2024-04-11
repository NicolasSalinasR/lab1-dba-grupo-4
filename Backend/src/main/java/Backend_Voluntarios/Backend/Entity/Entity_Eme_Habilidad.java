package Backend_Voluntarios.Backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "eme_habilidad")
public class Entity_Eme_Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id_Emergencia_Habilidad;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id_Habilidad;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id_Emergencia;


    // Constructor all

    public Entity_Eme_Habilidad(Long Id_Emergencia_Habilidad, Long Id_Habilidad,Long Id_Emergencia){
        super();
        this.Id_Emergencia_Habilidad = Id_Emergencia_Habilidad;
        this.Id_Habilidad = Id_Habilidad;
        this.Id_Emergencia = Id_Emergencia;
    }

    // Constructor empty
    public Entity_Eme_Habilidad() {
        super();
    }

    // Getters
    public Long getId_Emergencia_Habilidad(){
        return Id_Emergencia_Habilidad;
    }

    public Long getId_Habilidad() {
        return Id_Habilidad;
    }

    public Long getId_Emergencia(){
        return Id_Emergencia;
    }

    //Setters

    public void setId_Emergencia_Habilidad(Long id_Emergencia_Habilidad){
        Id_Emergencia_Habilidad= id_Emergencia_Habilidad;
    }

    public void setId_Habilidad(Long id_Habilidad){
        Id_Habilidad= id_Habilidad;
    }

    public void setId_Emergencia(Long id_Emergencia){
        Id_Emergencia= id_Emergencia;
    }
}
