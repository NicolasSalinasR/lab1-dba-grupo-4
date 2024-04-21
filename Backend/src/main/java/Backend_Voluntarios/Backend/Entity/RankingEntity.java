package Backend_Voluntarios.Backend.Entity;


import jakarta.persistence.*;

@Entity
@Table(name="ranking")
public class RankingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idRanking;


    @ManyToOne
    @JoinColumn(name = "idTarea")
    private TareaEntity tarea;
   // private Long idTarea;

    @Id
    @ManyToOne
    @JoinColumn(name = "idVoluntario")
    private VoluntarioEntity voluntario;

    @Column(nullable = false)
    private Integer nivelRanking;

    @Column(nullable = false, length = 100)
    private String tareaRanking;

    public RankingEntity(TareaEntity idTarea, VoluntarioEntity idVoluntario, Integer nivelRanking, String tareaRanking){
        this.tarea = idTarea;
        this.voluntario = idVoluntario;
        this.nivelRanking = nivelRanking;
        this.tareaRanking = tareaRanking;
    }

    public RankingEntity(){
        super();
    }

    public Long getIdRanking() {
        return idRanking;
    }

    public String getTareaRanking() {
        return tareaRanking;
    }

    public void setTareaRanking(String tarea_ranking) {
        this.tareaRanking = tarea_ranking;
    }

    public Integer getNivelRanking() {
        return nivelRanking;
    }

    public void setNivelRanking(Integer nivel_ranking) {
        this.nivelRanking = nivel_ranking;
    }

    public Long getIdVoluntario() {
        return voluntario.getIdVoluntario();
    }

    public void setIdVoluntario(VoluntarioEntity Voluntario) {
        this.voluntario = Voluntario;
    }

    public Long getIdTarea() {
        return tarea.getIdTarea();
    }

    public void setIdTarea(TareaEntity tarea) {
        this.tarea = tarea;
    }

    public void setIdRanking(Long idRanking) {
        this.idRanking = idRanking;
    }
}
