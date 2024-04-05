package Model;

import Model.Enum.TipoUsuario;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario", schema = "ohara")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"personal", "empresa", "token"})
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "tipo")
    @Enumerated(EnumType.ORDINAL)
    private TipoUsuario tipo;

//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.LAZY)
//    private Voluntario voluntario;
//
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.LAZY)
//    private Organizacion organizacion;
//
    @OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY)
    private Token token;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(getTipo().name()));
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

}
