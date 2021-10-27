package com.nttdata.cadastrodeusuario.mappers;

import com.nttdata.cadastrodeusuario.dtos.response.UsuarioResponse;
import com.nttdata.cadastrodeusuario.entities.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioToUsuarioResponseMapper {
    public UsuarioResponse toDto(Usuario usuario);
}
