package com.nttdata.cadastrodeusuario.dtos.response;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class UsuarioResponse {

    private Long id;
    private String status;

    @Email(message = "Email inválido")
    @NotBlank(message = "O campo não pode estar em branco")
    private String email;
    @NotBlank(message = "O campo não pode estar em branco")
    private String senha;

    private List<TelefoneResponse> telefones;

}
