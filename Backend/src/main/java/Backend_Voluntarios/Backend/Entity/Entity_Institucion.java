package Backend_Voluntarios.Backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "institucion")
public class Entity_Institucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id_Institucion;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id_Emergencia;

    private String nombre_institucion;


    // Constructor all
    public Entity_Institucion(Long Id_Institucion, Long Id_Emergencia,String nombre_institucion){
        super();
        this.Id_Institucion = Id_Institucion;
        this.Id_Emergencia = Id_Emergencia;
        this.nombre_institucion = nombre_institucion;
    }

    // Constructor empty
    public Entity_Institucion() {
        super();
    }

    // Getters
    public Long getId_Institucion(){
        return Id_Institucion;
    }

    public Long getId_Emergencia() {
        return Id_Emergencia;
    }

    public String getNombre_institucion(){
        return nombre_institucion;
    }

    //Setters

    public void setId_Institucion(Long id_Institucion){
        Id_Institucion= id_Institucion;
    }

    public void setId_Emergencia(Long id_Emergencia){
        Id_Emergencia= id_Emergencia;
    }

    public void setNombre_institucion(String nombreInstitucion){
        this.nombre_institucion= nombreInstitucion;
    }

    }



    

