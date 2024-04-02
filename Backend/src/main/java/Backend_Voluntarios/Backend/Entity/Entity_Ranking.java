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
}
