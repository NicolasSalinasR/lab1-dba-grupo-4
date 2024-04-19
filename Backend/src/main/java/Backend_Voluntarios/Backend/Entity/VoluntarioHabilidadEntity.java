package Backend_Voluntarios.Backend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "voluntario_Habilidad")
public class VoluntarioHabilidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVoluntarioHabilidad;

    private Long idVoluntario;

    private Long idHabilidad;

    public VoluntarioHabilidadEntity(Long idVoluntario, Long idHabilidad) {
        super();
        this.idVoluntario = idVoluntario;
        this.idHabilidad = idHabilidad;
    }

    public VoluntarioHabilidadEntity() {
        super();
    }

    public Long getIdVoluntarioHabilidad() {
        return idVoluntarioHabilidad;
    }

    public Long getIdVoluntario() {
        return idVoluntario;
    }

    public Long getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdVoluntario(Long idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public void setIdHabilidad(Long idHabilidad) {
        this.idHabilidad = idHabilidad;
    }
}