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
    private Long idHabilidad;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idEmergencia;


    // Constructor all

    public EmeHabilidadEntity(Long idEmergencia_Habilidad, Long idHabilidad, Long idEmergencia){
        super();
        this.idEmergenciaHabilidad = idEmergenciaHabilidad;
        this.idHabilidad = idHabilidad;
        this.idEmergencia = idEmergencia;
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

}
