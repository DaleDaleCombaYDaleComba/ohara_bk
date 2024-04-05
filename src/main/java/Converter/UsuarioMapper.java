package Converter;

import DTO.UsuarioDTO;
import Model.Usuario;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    /**
     * Clase que mapea los datos de la database
     * Convierte de Enitity a DTO y viceversa
     */
    Usuario toEntity(UsuarioDTO dto);

    UsuarioDTO toDTO(Usuario entity);

    List<Usuario> toEntity(List<UsuarioDTO> dto);

    List<UsuarioDTO> toDTO(List<Usuario> entity);
}
