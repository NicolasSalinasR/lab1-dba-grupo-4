package Backend_Voluntarios.Backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "eme_habilidad")
public class EmeHabilidadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idEmergenciaHabilidad;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idEmergencia;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idHabilidad;




    // Constructor all

    public EmeHabilidadEntity(  Long idEmergencia, Long idHabilidad){
        super();
        this.idEmergencia = idEmergencia;
        this.idHabilidad = idHabilidad;

    }

    // Constructor empty
    public EmeHabilidadEntity() {
        super();
    }


    // Getters
    public Long getIdEmergenciaHabilidad(){
        return idEmergenciaHabilidad;
    }

    public Long getIdHabilidad() {
        return idHabilidad;
    }

    public Long getIdEmergencia(){
        return idEmergencia;
    }

    //Setters

    public void setIdHabilidad(Long idHabilidad){
        this.idHabilidad = idHabilidad;
    }

    public void setIdEmergencia(Long idEmergencia){
        this.idEmergencia= idEmergencia;
    }

}
