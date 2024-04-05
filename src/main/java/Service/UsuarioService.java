package Service;

import Converter.UsuarioMapper;
import Model.Usuario;
import Repository.UsuarioRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Data
public class UsuarioService implements UserDetailsService{

    @Autowired
    private final UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioMapper usuarioMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public Usuario buscarPorUsername(String username){
        return usuarioRepository.findTopByUsername(username).orElse(null);
    }

    public Boolean existByCredentials(String username, String password){
        Usuario usuario = usuarioRepository.findTopByUsername(username).orElse(null);
        return usuario != null  && passwordEncoder.matches(password,usuario.getPassword());
    }

    public boolean validarPassword(Usuario usuario, String passwordSinEncriptar){
        return passwordEncoder.matches(passwordSinEncriptar, usuario.getPassword());
    }
}
