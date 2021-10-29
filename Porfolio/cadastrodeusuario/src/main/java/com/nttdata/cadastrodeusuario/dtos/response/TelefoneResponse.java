package com.nttdata.cadastrodeusuario.dtos.response;

import lombok.Data;

@Data
public class TelefoneResponse {
    private Long id;
    private String numero;
    private String ddd;
    private String status;

}
