package com.nttdata.cadastrodeusuario.controllers;

import com.nttdata.cadastrodeusuario.dtos.requests.UsuarioRequest;
import com.nttdata.cadastrodeusuario.dtos.response.UsuarioResponse;
import com.nttdata.cadastrodeusuario.entities.Usuario;
import com.nttdata.cadastrodeusuario.repositories.UsuarioRepository;
import com.nttdata.cadastrodeusuario.services.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Api(value = "API REST Usuarios")
@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    //CadastrarUsuario - POST - /usuario
    @ApiOperation(value="Realiza o Cadastro do Usuario")
    @PostMapping(produces = "application/json")
    public UsuarioResponse salvar(@RequestBody UsuarioRequest usuarioRequest){
        UsuarioResponse usuarioResponse = usuarioService.criar(usuarioRequest);

        return usuarioResponse;
    }

    //AtualizarUsuario- PATCH - /usuario/{id}
    @ApiOperation(value="Atualiza os dados do Usuario")
    @PatchMapping("/{id}")
    public UsuarioResponse atualizar(@PathVariable("id") Long idUsuario, @RequestBody UsuarioRequest usuarioRequest) {
        UsuarioResponse usuarioResponse = usuarioService.atualizar(idUsuario, usuarioRequest);

        return usuarioResponse;
    }
    //ObterUmUsuario - GET/usuario/{id}
    @ApiOperation(value="Apresenta os dados do Usuario pesquisado pelo codigo")
    @GetMapping("/{id}")
    public UsuarioResponse obter(@PathVariable("id") Long idUsuario){
        UsuarioResponse usuarioResponse = usuarioService.obter(idUsuario);

        return usuarioResponse;

    }
    //ListarTodosUsuarios - GET - /usuario
    @ApiOperation(value="Retorna uma Lista de Usuarios")
    @GetMapping(produces = "application/json")
    public List<UsuarioResponse> Listar(){
        List<UsuarioResponse> listaUsuariosResponse = usuarioService.listar();

        return listaUsuariosResponse;
    }
    //ExcluirUsuario - DELETE - /usuario/{id}
    @ApiOperation(value="Realiza a exclusão do Usuario pelo código")
    @DeleteMapping("/{id}")
    public UsuarioResponse excluir(@PathVariable("id") Long idUsuario) {
        UsuarioResponse usuarioResponse = usuarioService.excluir(idUsuario);

        return usuarioResponse;

    }

}
