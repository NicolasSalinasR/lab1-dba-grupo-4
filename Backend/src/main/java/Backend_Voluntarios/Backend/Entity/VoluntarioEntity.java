package Backend_Voluntarios.Backend.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "voluntario")
public class VoluntarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idVoluntario;

    @Column(nullable = false, length = 100)
    private String nombreVoluntario;

    @Column(nullable = false, length = 100)
    private String correoVoluntario;

    @Column(unique = true, nullable = false, length = 100)
    private String numeroDocumentoVoluntario;

    @Column(nullable = false)
    private String zonaViviendaVoluntario;

    // agregar token pero no como atributo de la tabla
    @Transient
    private String token;

    @ElementCollection
    private List<String> equipamientoVoluntario;

    public VoluntarioEntity(String nombreVoluntario, String correoVoluntario, String numeroDocumentoVoluntario,
            List<String> equipamientoVoluntario, String zonaViviendaVoluntario) {
        this.nombreVoluntario = nombreVoluntario;
        this.correoVoluntario = correoVoluntario;
        this.numeroDocumentoVoluntario = numeroDocumentoVoluntario;
        this.equipamientoVoluntario = equipamientoVoluntario;
        this.zonaViviendaVoluntario = zonaViviendaVoluntario;
    }

    public VoluntarioEntity() {
        super();
    }

    public Long getIdVoluntario() {
        return idVoluntario;
    }

    public String getNombreVoluntario() {
        return nombreVoluntario;
    }

    public void setNombreVoluntario(String nombreVoluntario) {
        this.nombreVoluntario = nombreVoluntario;
    }

    public String getCorreoVoluntario() {
        return correoVoluntario;
    }

    public String getNumeroDocumentoVoluntario() {
        return numeroDocumentoVoluntario;
    }

    public void setNumeroDocumentoVoluntario(String numeroDocumentoVoluntario) {
        this.numeroDocumentoVoluntario = numeroDocumentoVoluntario;
    }

    public void setCorreoVoluntario(String correoVoluntario) {
        this.correoVoluntario = correoVoluntario;
    }

    public String getZonaViviendaVoluntario() {
        return zonaViviendaVoluntario;
    }

    public void setZonaViviendaVoluntario(String zona_vivienda_voluntario) {
        this.zonaViviendaVoluntario = zona_vivienda_voluntario;
    }

    public List<String> getEquipamientoVoluntario() {
        return equipamientoVoluntario;
    }

    public void setEquipamientoVoluntario(List<String> equipamiento_voluntario) {
        this.equipamientoVoluntario = equipamiento_voluntario;
    }

    public void setIdVoluntario(Long idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
