package Backend_Voluntarios.Backend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "voluntario_Habilidad")
public class Entity_Voluntario_Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Voluntario_Habilidad;

    private Long Id_voluntario;

    private Long Id_habilidad;

    public Entity_Voluntario_Habilidad(Long Id_voluntario, Long Id_habilidad) {
        super();
        this.Id_voluntario = Id_voluntario;
        this.Id_habilidad = Id_habilidad;
    }

    public Entity_Voluntario_Habilidad() {
        super();
    }

    public Long getId_Voluntario_Habilidad() {
        return Id_Voluntario_Habilidad;
    }

    public void setId_Voluntario_Habilidad(Long id_Voluntario_Habilidad) {
        Id_Voluntario_Habilidad = id_Voluntario_Habilidad;
    }

    public Long getId_voluntario() {
        return Id_voluntario;
    }

    public void setId_voluntario(Long id_voluntario) {
        Id_voluntario = id_voluntario;
    }

    public Long getId_habilidad() {
        return Id_habilidad;
    }

    public void setId_habilidad(Long id_habilidad) {
        Id_habilidad = id_habilidad;
    }
}
