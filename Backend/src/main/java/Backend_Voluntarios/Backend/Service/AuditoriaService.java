package Backend_Voluntarios.Backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AuditoriaService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void registrarCambio(Long idUsuario, String tipoOperacion, String descripcion) {
        //Llamar al trigger con los parámetros adicionales
        String sql = "INSERT INTO auditoria (id_usuario, tipo_operacion, descripcion) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, idUsuario, tipoOperacion, descripcion);
        String sql_auditoria = "SELECT auditar_operacion(?, ?, ?, current_date, current_time)";
        jdbcTemplate.update(sql_auditoria, idUsuario, tipoOperacion, descripcion);
    }
}

