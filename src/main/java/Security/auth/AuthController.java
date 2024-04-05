package Security.auth;

import Converter.UsuarioMapper;
import DTO.UsuarioDTO;
import Model.Token;
import Model.Usuario;
import Repository.UsuarioRepository;
import Security.service.JwtService;
import Security.service.TokenService;
import Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioMapper usuarioMapper;


    @PostMapping("/login")
    public AuthenticationResponseDTO login(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = (Usuario) usuarioService.loadUserByUsername(usuarioDTO.getUsername());
        String apiKey = null;

        if (usuario == null) {
            return AuthenticationResponseDTO
                    .builder()
                    .message("Usuario no encontrado")
                    .build();
        }

        if (usuarioService.validarPassword(usuario, usuarioDTO.getPassword())) {

            if (usuario.getToken().getFechaExpiracion().isBefore(LocalDateTime.now())) {
                Token token = usuario.getToken();
                apiKey = jwtService.generateToken(usuario);
                token.setToken(apiKey);
                token.setFechaExpiracion(LocalDateTime.now().plusDays(1));
                tokenService.save(token);

                //Usuario con token válido
            } else {
                apiKey = usuario.getToken().getToken();
            }

        } else {
            return AuthenticationResponseDTO
                    .builder()
                    .message("Contraseña incorrecta")
                    .build();
        }

//        if(usuario.getTipo().equals(TipoUsuario.ORGANIZACION)){
//            Organizacion organizacion = organizacionRepository.findByUsuario(usuario);
//
//            return AuthenticationResponseDTO
//                    .builder()
//                    .token(apiKey)
//                    .tipoUsuario(usuario.getTipo())
//                    .id(organizacion.getId())
//                    .message("Usuario logueado correctamente")
//                    .build();
//        }else if (usuario.getTipo().equals(TipoUsuario.VOLUNTARIO)){
//            Voluntario voluntario = voluntarioRepository.findByUsuario(usuario);
//
//            return AuthenticationResponseDTO
//                    .builder()
//                    .token(apiKey)
//                    .tipoUsuario(usuario.getTipo())
//                    .id(voluntario.getId())
//                    .message("Usuario logueado correctamente")
//                    .build();
//        }

        return AuthenticationResponseDTO
                .builder()
                .token(apiKey)
                .tipoUsuario(usuario.getTipo())
                .message("Usuario logueado correctamente")
                .build();
    }
}
