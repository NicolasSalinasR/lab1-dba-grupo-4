package Backend_Voluntarios.Backend.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "estadoTarea")
public class estadoTareaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idEstadoTarea;

    private Long idTarea;
    // el estado de la tarea deberia ser un String o un booleano?
    private boolean estadoTarea;

    public estadoTareaEntity(Long idEstadoTarea, Long idTarea, boolean estadoTarea){
        this.idEstadoTarea = idEstadoTarea;
        this.idTarea = idTarea;
        this.estadoTarea = estadoTarea;
    }
    // getters

    public Long getIdEstadoTarea() {
        return idEstadoTarea;
    }

    public Long getIdTarea() {
        return idTarea;
    }

    public boolean getEstadoTarea() {
        return estadoTarea;
    }

    //seters

    public void setEstado_tarea(boolean estado_tarea) {
        this.estadoTarea = estado_tarea;
    }

    public void setIdEstadoTarea(Long idEstadoTarea) {
       this.idEstadoTarea = idEstadoTarea;
    }

    public void setIdTarea(Long idTarea) {
        this.idTarea = idTarea;
    }
}


