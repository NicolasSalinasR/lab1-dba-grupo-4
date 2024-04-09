package Backend_Voluntarios.Backend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emergencia")
public class Entity_Emergencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Emergencia;

    private String tipo_emergencia;
    private String zona_emergencia;
    private String condicion_fisica;
    private String cantidad_voluntarios_minimo;
    private String cantidad_voluntarios_maximo;

    // Constructor all
    public Entity_Emergencia(Long Id_Emergencia, String tipo_emergencia, String zona_emergencia,
            String condicion_fisica, String cantidad_voluntarios_minimo, String cantidad_voluntarios_maximo) {
        super();
        this.Id_Emergencia = Id_Emergencia;
        this.tipo_emergencia = tipo_emergencia;
        this.zona_emergencia = zona_emergencia;
        this.condicion_fisica = condicion_fisica;
        this.cantidad_voluntarios_minimo = cantidad_voluntarios_minimo;
        this.cantidad_voluntarios_maximo = cantidad_voluntarios_maximo;
    }

    // Constructor empty
    public Entity_Emergencia() {
        super();
    }

    // Getters and Setters

    public Long getId_Emergencia() {
        return Id_Emergencia;
    }

    public void setId_Emergencia(Long id_Emergencia) {
        Id_Emergencia = id_Emergencia;
    }

    public String getTipo_emergencia() {
        return tipo_emergencia;
    }

    public void setTipo_emergencia(String tipo_emergencia) {
        this.tipo_emergencia = tipo_emergencia;
    }

    public String getZona_emergencia() {
        return zona_emergencia;
    }

    public void setZona_emergencia(String zona_emergencia) {
        this.zona_emergencia = zona_emergencia;
    }

    public String getCondicion_fisica() {
        return condicion_fisica;
    }

    public void setCondicion_fisica(String condicion_fisica) {
        this.condicion_fisica = condicion_fisica;
    }

    public String getCantidad_voluntarios_minimo() {
        return cantidad_voluntarios_minimo;
    }

    public void setCantidad_voluntarios_minimo(String cantidad_voluntarios_minimo) {
        this.cantidad_voluntarios_minimo = cantidad_voluntarios_minimo;
    }

    public String getCantidad_voluntarios_maximo() {
        return cantidad_voluntarios_maximo;
    }

    public void setCantidad_voluntarios_maximo(String cantidad_voluntarios_maximo) {
        this.cantidad_voluntarios_maximo = cantidad_voluntarios_maximo;
    }

}
