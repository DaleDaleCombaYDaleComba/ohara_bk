package Security.service;

import Model.Token;
import Model.Usuario;
import Security.repository.ITokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final ITokenRepository tokenRepository;


    public Token getByUsuario(Usuario usuario){
        return tokenRepository.findTopByUsuario(usuario);
    }

    public Token save(Token token){
        return tokenRepository.save(token);
    }

}
