package Backend_Voluntarios.Backend.Entity;


import jakarta.persistence.*;

@Entity
@Table(name="ranking")
public class RankingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idRanking;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idTarea;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idVoluntario;

    @Column(nullable = false)
    private Integer nivelRanking;

    @Column(nullable = false, length = 100)
    private String tareaRanking;

    public RankingEntity(Long idRanking, Long idTarea, Long idVoluntario, Integer nivelRanking, String tareaRanking){
        super();
        this.idRanking = idRanking;
        this.idTarea = idTarea;
        this.idVoluntario = idVoluntario;
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
        return idVoluntario;
    }

    public void setIdVoluntario(Long idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public Long getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Long idTarea) {
        this.idTarea = idTarea;
    }

    public void setIdRanking(Long idRanking) {
        this.idRanking = idRanking;
    }
}
