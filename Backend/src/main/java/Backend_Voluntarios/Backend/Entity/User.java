package Backend_Voluntarios.Backend.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.security.Key;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class User implements UserDetails {
    private String correo;
    private String nombre;
    private String contrasena;
    private String numeroDocumento;
    private String ROL = "VOLUNTARIO";

    public User(String correo, String nombre, String contrasena, String numeroDocumento) {
        this.correo = correo;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.numeroDocumento = numeroDocumento;
    }

    public User() {
    }

    @Override
    public String getUsername() {
        return correo;
    }

    public void setUsername(String correo) {
        this.correo = correo;
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    public void setPassword(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(ROL));
    }

    public void setAuthorities(String ROL) {
        this.ROL = ROL;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static User voluntarioToUser(VoluntarioEntity voluntario) {
        return new User(voluntario.getCorreoVoluntario(), voluntario.getNombreVoluntario(),
                voluntario.getContrasenaVoluntario(), voluntario.getNumeroDocumentoVoluntario());
    }

    public Map<String, Object> generateExtraClaims() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("nombreVoluntario", this.nombre);
        claims.put("numeroDocumentoVoluntario", this.numeroDocumento);
        return claims;
    }

}
