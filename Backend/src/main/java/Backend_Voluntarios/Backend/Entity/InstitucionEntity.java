package Backend_Voluntarios.Backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "institucion")
public class InstitucionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idInstitucion;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idEmergencia;

    private String nombreInstitucion;


    // Constructor all
    public InstitucionEntity( Long idEmergencia, String nombreInstitucion){
        super();
        this.idEmergencia = idEmergencia;
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
        return idEmergencia;
    }

    public String getNombreInstitucion(){
        return nombreInstitucion;
    }

    //Setters
    public void setIdEmergencia(Long idEmergencia){
        this.idEmergencia= idEmergencia;
    }
    public void setNombreInstitucion(String nombreInstitucion){
        this.nombreInstitucion= nombreInstitucion;
    }

    }



    

