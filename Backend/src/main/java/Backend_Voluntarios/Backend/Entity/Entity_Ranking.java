package Backend_Voluntarios.Backend.Entity;


import jakarta.persistence.*;

@Entity
@Table(name="ranking")
public class Entity_Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id_ranking;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id_tarea;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id_voluntario;

    @Column(nullable = false)
    private Integer nivel_ranking;

    @Column(nullable = false, length = 100)
    private String tarea_ranking;

    public Entity_Ranking(Long Id_ranking, Long Id_tarea, Long Id_voluntario, Integer nivel_ranking, String tarea_ranking){
        super();
        this.Id_ranking = Id_ranking;
        this.Id_tarea = Id_tarea;
        this.Id_voluntario = Id_voluntario;
        this.nivel_ranking = nivel_ranking;
        this.tarea_ranking = tarea_ranking;
    }

    public Entity_Ranking(){
        super();
    }

    public Long getId_ranking() {
        return Id_ranking;
    }

    public String getTarea_ranking() {
        return tarea_ranking;
    }

    public void setTarea_ranking(String tarea_ranking) {
        this.tarea_ranking = tarea_ranking;
    }

    public Integer getNivel_ranking() {
        return nivel_ranking;
    }

    public void setNivel_ranking(Integer nivel_ranking) {
        this.nivel_ranking = nivel_ranking;
    }

    public Long getId_voluntario() {
        return Id_voluntario;
    }

    public void setId_voluntario(Long id_voluntario) {
        Id_voluntario = id_voluntario;
    }

    public Long getId_tarea() {
        return Id_tarea;
    }

    public void setId_tarea(Long id_tarea) {
        Id_tarea = id_tarea;
    }

    public void setId_ranking(Long id_ranking) {
        Id_ranking = id_ranking;
    }
}
