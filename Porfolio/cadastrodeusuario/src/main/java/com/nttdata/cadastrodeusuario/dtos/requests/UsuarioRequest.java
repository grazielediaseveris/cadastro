package com.nttdata.cadastrodeusuario.dtos.requests;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class UsuarioRequest {

    private String login;

    @NotBlank(message = "O cadastro do nome é requerido")
    private String nome;
    @Email(message = "Email inválido")
    @NotBlank(message = "O campo não pode estar em branco")
    private String email;
    @NotBlank(message = "O campo não pode estar em branco")
    private String senha;

    private List<TelefoneRequest> telefones;
}
