package DTO;

import Model.Enum.TipoUsuario;
import lombok.Data;

@Data
public class UsuarioDTO {

    private Integer id;

    private String username;

    private String password;

    private String email;

    private TipoUsuario tipo;

}
