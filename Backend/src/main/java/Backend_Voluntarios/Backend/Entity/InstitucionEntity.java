package Backend_Voluntarios.Backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "institucion")
public class InstitucionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idInstitucion;

    @ManyToOne
    @JoinColumn(name = "idEmergencia")
    private EmergenciaEntity emergencia;


    private String nombreInstitucion;


    // Constructor all
    public InstitucionEntity( EmergenciaEntity idEmergencia, String nombreInstitucion){
        super();
        this.emergencia = idEmergencia;
        this.nombreInstitucion = nombreInstitucion;
    }

    // Constructor empty
    public InstitucionEntity() {
        super();
    }

    // Getters
    public Long getIdInstitucion(){
        return idInstitucion;
    }

    public Long getIdEmergencia() {
        return emergencia.getIdEmergencia();
    }

    public String getNombreInstitucion(){
        return nombreInstitucion;
    }

    //Setters
    public void setIdEmergencia(EmergenciaEntity idEmergencia){
        this.emergencia= idEmergencia;
    }
    public void setNombreInstitucion(String nombreInstitucion){
        this.nombreInstitucion= nombreInstitucion;
    }

    }



    

