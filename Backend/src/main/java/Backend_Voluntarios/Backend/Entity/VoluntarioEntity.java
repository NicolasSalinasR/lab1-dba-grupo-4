package Backend_Voluntarios.Backend.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "voluntario")
public class VoluntarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id_voluntario;

    @Column(nullable = false, length = 100)
    private String condicion_voluntario;

    @Column(nullable = false)
    private boolean disponibilidad_voluntario;

    @Column(nullable = false, length = 100)
    private String zona_vivienda_voluntario;

    @Column(nullable = false, length = 100)
    private String equipamiento_voluntario;


    public VoluntarioEntity(Long Id_voluntario, String condicion_voluntario, boolean disponibilidad_voluntario, String zona_vivienda_voluntario, String equipamiento_voluntario){
        super();
        this.Id_voluntario = Id_voluntario;
        this.condicion_voluntario = condicion_voluntario;
        this.disponibilidad_voluntario = disponibilidad_voluntario;
        this.equipamiento_voluntario = equipamiento_voluntario;
        this.zona_vivienda_voluntario = zona_vivienda_voluntario;
    }
    public VoluntarioEntity(){
        super();
    }

    public Long getId_voluntario() {
        return Id_voluntario;
    }

    public void setCondicion_voluntario(String condicion_voluntario) {
        this.condicion_voluntario = condicion_voluntario;
    }

    public boolean isDisponibilidad_voluntario() {
        return disponibilidad_voluntario;
    }

    public void setDisponibilidad_voluntario(boolean disponibilidad_voluntario) {
        this.disponibilidad_voluntario = disponibilidad_voluntario;
    }

    public String getZona_vivienda_voluntario() {
        return zona_vivienda_voluntario;
    }

    public void setZona_vivienda_voluntario(String zona_vivienda_voluntario) {
        this.zona_vivienda_voluntario = zona_vivienda_voluntario;
    }

    public String getEquipamiento_voluntario() {
        return equipamiento_voluntario;
    }

    public void setEquipamiento_voluntario(String equipamiento_voluntario) {
        this.equipamiento_voluntario = equipamiento_voluntario;
    }

    public void setId_voluntario(Long id_voluntario) {
        Id_voluntario = id_voluntario;
    }

    public String getCondicion_voluntario() {
        return condicion_voluntario;
    }
}
