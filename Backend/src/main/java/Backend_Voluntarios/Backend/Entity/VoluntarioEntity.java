package Backend_Voluntarios.Backend.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "voluntario")
public class VoluntarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idVoluntario;

    @Column(nullable = false, length = 100)
    private String condicionVoluntario;

    @Column(nullable = false)
    private boolean disponibilidadVoluntario;

    @Column(nullable = false, length = 100)
    private String zonaViviendaVoluntario;

    @Column(nullable = false, length = 100)
    private String equipamientoVoluntario;


    public VoluntarioEntity(Long idVoluntario, String condicionVoluntario, boolean disponibilidadVoluntario, String zonaViviendaVoluntario, String equipamientoVoluntario){
        super();
        this.idVoluntario = idVoluntario;
        this.condicionVoluntario = condicionVoluntario;
        this.disponibilidadVoluntario = disponibilidadVoluntario;
        this.equipamientoVoluntario = equipamientoVoluntario;
        this.zonaViviendaVoluntario = zonaViviendaVoluntario;
    }
    public VoluntarioEntity(){
        super();
    }

    public Long getIdVoluntario() {
        return idVoluntario;
    }

    public void setCondicionVoluntario(String condicion_voluntario) {
        this.condicionVoluntario = condicion_voluntario;
    }

    public boolean isDisponibilidadVoluntario() {
        return disponibilidadVoluntario;
    }

    public void setDisponibilidadVoluntario(boolean disponibilidad_voluntario) {
        this.disponibilidadVoluntario = disponibilidad_voluntario;
    }

    public String getZonaViviendaVoluntario() {
        return zonaViviendaVoluntario;
    }

    public void setZonaViviendaVoluntario(String zona_vivienda_voluntario) {
        this.zonaViviendaVoluntario = zona_vivienda_voluntario;
    }

    public String getEquipamientoVoluntario() {
        return equipamientoVoluntario;
    }

    public void setEquipamientoVoluntario(String equipamiento_voluntario) {
        this.equipamientoVoluntario = equipamiento_voluntario;
    }

    public void setIdVoluntario(Long idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public String getCondicionVoluntario() {
        return condicionVoluntario;
    }
}
