package com.nttdata.cadastrodeusuario.entities;

import lombok.Data;
import javax.persistence.OneToMany;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    @JoinColumn(name = "telefone_id")
    List<Telefone> telefones;

    private String nome;

    @Column(name="email", unique=true, nullable = false)
    private String email;

    @Column(name="senha", unique=true, nullable = false)
    private String senha;

    private String dataCriacao;
    private String dataAtualizacao;
    private String ultimoLogin;

}