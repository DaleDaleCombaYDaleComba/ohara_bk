package Repository;

import Model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository {

    @Query("SELECT u from Usuario u WHERE u.username = :username")
    Usuario findByUsername(String username);

    Optional<Usuario> findTopByUsername(String username);
}
