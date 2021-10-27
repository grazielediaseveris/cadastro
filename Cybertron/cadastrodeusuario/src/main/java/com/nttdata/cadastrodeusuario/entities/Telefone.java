package com.nttdata.cadastrodeusuario.entities;


import lombok.Data;
import javax.persistence.ManyToOne;
import javax.persistence.*;

@Entity
@Data
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String numero;
    private String ddd;
}
