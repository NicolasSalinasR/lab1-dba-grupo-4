package Backend_Voluntarios.Backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "eme_habilidad")
public class EmeHabilidadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idEmergenciaHabilidad;

    @ManyToOne
    @JoinColumn(name = "idEmergencia")
    private EmergenciaEntity emergencia ;


    @ManyToOne
    @JoinColumn(name = "idHabilidad")
    private HabilidadEntity habilidad ;




    // Constructor all

    public EmeHabilidadEntity( EmergenciaEntity idEmergencia, HabilidadEntity idHabilidad){
        super();
        this.emergencia = idEmergencia;
        this.habilidad = idHabilidad;

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
        return habilidad.getIdhabilidad();
    }

    public Long getIdEmergencia(){
        return emergencia.getIdEmergencia();
    }

    //Setters

    public void setIdHabilidad(HabilidadEntity idHabilidad){
        this.habilidad = idHabilidad;
    }

    public void setIdEmergencia(EmergenciaEntity idEmergencia){
        this.emergencia= idEmergencia;
    }

}
