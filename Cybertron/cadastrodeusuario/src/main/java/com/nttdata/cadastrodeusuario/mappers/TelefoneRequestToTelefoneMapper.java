package com.nttdata.cadastrodeusuario.mappers;

import com.nttdata.cadastrodeusuario.dtos.requests.TelefoneRequest;
import com.nttdata.cadastrodeusuario.entities.Telefone;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TelefoneRequestToTelefoneMapper {
    public Telefone toEntity(TelefoneRequest telefoneRequest);
    public Telefone update(TelefoneRequest telefoneRequest, @MappingTarget Telefone telefone);

}
