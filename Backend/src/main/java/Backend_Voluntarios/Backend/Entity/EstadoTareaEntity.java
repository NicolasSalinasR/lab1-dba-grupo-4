package Backend_Voluntarios.Backend.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "estadoTarea")
public class EstadoTareaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idEstadoTarea;

    private Long idTarea;
    // el estado de la tarea deberia ser un String o un booleano?
    private boolean estadoTarea;

    public EstadoTareaEntity(Long idEstadoTarea, Long idTarea, boolean estadoTarea){
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

    public boolean isEstadoTarea() {
        return estadoTarea;
    }

    //seters

    public void setEstadoTarea(boolean estadoTarea) {
        this.estadoTarea = estadoTarea;
    }

    public void setIdEstadoTarea(Long idEstadoTarea) {
        idEstadoTarea = idEstadoTarea;
    }

    public void setId_tarea(Long idTarea) {
        idTarea = idTarea;
    }
}
