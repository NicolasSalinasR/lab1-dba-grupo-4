package Backend_Voluntarios.Backend.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "Estado_Tarea")
public class Entity_Estado_Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id_Estado_Tarea;

    private Long Id_tarea;
    // el estado de la tarea deberia ser un String o un booleano?
    private boolean estado_tarea;

    public Entity_Estado_Tarea(Long Id_estado_tarea, Long Id_tarea, boolean estado_tarea){
        this.Id_Estado_Tarea = Id_estado_tarea;
        this.Id_tarea = Id_tarea;
        this.estado_tarea = estado_tarea;
    }
    // getters

    public Long getId_Estado_Tarea() {
        return Id_Estado_Tarea;
    }

    public Long getId_tarea() {
        return Id_tarea;
    }

    public boolean isEstado_tarea() {
        return estado_tarea;
    }

    //seters

    public void setEstado_tarea(boolean estado_tarea) {
        this.estado_tarea = estado_tarea;
    }

    public void setId_Estado_tarea(Long id_Estado_tarea) {
        Id_Estado_Tarea = id_Estado_tarea;
    }

    public void setId_tarea(Long id_tarea) {
        Id_tarea = id_tarea;
    }
}
