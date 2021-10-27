package com.nttdata.cadastrodeusuario.mappers;

import com.nttdata.cadastrodeusuario.dtos.requests.UsuarioRequest;
import com.nttdata.cadastrodeusuario.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UsuarioRequestToUsuarioMapper {
    public Usuario toEntity(UsuarioRequest usuarioRequest);
    public Usuario update(UsuarioRequest usuarioRequest, @MappingTarget Usuario usuario);
}
