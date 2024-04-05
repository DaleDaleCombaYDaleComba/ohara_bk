package Security.repository;

import Model.Token;
import Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITokenRepository extends JpaRepository<Token, Integer> {

    Token findTopByUsuario(Usuario usuario);

    Optional<Usuario> findTopByUsername(String username);
}
