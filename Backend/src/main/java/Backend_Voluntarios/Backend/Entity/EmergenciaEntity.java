package Backend_Voluntarios.Backend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emergencia")
public class EmergenciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmergencia;

    private String tipoEmergencia;
    private String zonaEmergencia;
    private String condicionFisica;
    private String cantidadVoluntariosMinimo;
    private String cantidadVoluntariosMaximo;

    // Constructor all
    public EmergenciaEntity(String tipoEmergencia, String zonaEmergencia, String condicionFisica,
            String cantidadVoluntariosMinimo, String cantidadVoluntariosMaximo) {
        this.tipoEmergencia = tipoEmergencia;
        this.zonaEmergencia = zonaEmergencia;
        this.condicionFisica = condicionFisica;
        this.cantidadVoluntariosMinimo = cantidadVoluntariosMinimo;
        this.cantidadVoluntariosMaximo = cantidadVoluntariosMaximo;
    }

    // Constructor empty
    public EmergenciaEntity() {
        super();
    }

    // Getters and Setters
    public Long getIdEmergencia() {
        return idEmergencia;
    }

    public String getTipoEmergencia() {
        return tipoEmergencia;
    }

    public void setTipoEmergencia(String tipoEmergencia) {
        this.tipoEmergencia = tipoEmergencia;
    }

    public String getZonaEmergencia() {
        return zonaEmergencia;
    }

    public void setZonaEmergencia(String zonaEmergencia) {
        this.zonaEmergencia = zonaEmergencia;
    }

    public String getCondicionFisica() {
        return condicionFisica;
    }

    public void setCondicionFisica(String condicionFisica) {
        this.condicionFisica = condicionFisica;
    }

    public String getCantidadVoluntariosMinimo() {
        return cantidadVoluntariosMinimo;
    }

    public void setCantidadVoluntariosMinimo(String cantidadVoluntariosMinimo) {
        this.cantidadVoluntariosMinimo = cantidadVoluntariosMinimo;
    }

    public String getCantidadVoluntariosMaximo() {
        return cantidadVoluntariosMaximo;
    }

    public void setCantidadVoluntariosMaximo(String cantidadVoluntariosMaximo) {
        this.cantidadVoluntariosMaximo = cantidadVoluntariosMaximo;
    }
}
