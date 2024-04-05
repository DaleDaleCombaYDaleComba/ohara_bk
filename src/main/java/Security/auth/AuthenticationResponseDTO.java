package Security.auth;

import Model.Enum.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponseDTO {

    private String token;
    private String message;
    private TipoUsuario tipoUsuario;
    private Integer id;
}
