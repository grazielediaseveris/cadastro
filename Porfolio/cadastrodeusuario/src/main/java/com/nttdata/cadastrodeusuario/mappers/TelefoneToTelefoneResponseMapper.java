package com.nttdata.cadastrodeusuario.mappers;

import com.nttdata.cadastrodeusuario.dtos.response.TelefoneResponse;
import com.nttdata.cadastrodeusuario.entities.Telefone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TelefoneToTelefoneResponseMapper {
    public TelefoneResponse toDto(Telefone telefone);
}
