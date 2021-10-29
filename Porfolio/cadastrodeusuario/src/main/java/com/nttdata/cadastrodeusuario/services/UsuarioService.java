package com.nttdata.cadastrodeusuario.services;

import com.nttdata.cadastrodeusuario.dtos.requests.UsuarioRequest;
import com.nttdata.cadastrodeusuario.dtos.response.UsuarioResponse;
import com.nttdata.cadastrodeusuario.entities.Usuario;
import com.nttdata.cadastrodeusuario.exceptions.EmailNãoEncontradoException;
import com.nttdata.cadastrodeusuario.exceptions.SenhaNãoEncontradaException;
import com.nttdata.cadastrodeusuario.mappers.UsuarioRequestToUsuarioMapper;
import com.nttdata.cadastrodeusuario.mappers.UsuarioToUsuarioResponseMapper;
import com.nttdata.cadastrodeusuario.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    //Mappers
    private final UsuarioRequestToUsuarioMapper usuarioRequestToUsuarioMapper;
    private final UsuarioToUsuarioResponseMapper usuarioToUsuarioResponseMapper;

    //Repositories
    private final UsuarioRepository usuarioRepository;

    //CadatrarUsuario
    public UsuarioResponse criar(UsuarioRequest usuarioRequest) {
        //Mapeamento
        Usuario usuario = usuarioRequestToUsuarioMapper.toEntity(usuarioRequest);

        UsuarioResponse usuarioResponse = new UsuarioResponse();

        if (Objects.isNull(usuario.getEmail())) {
            throw new EmailNãoEncontradoException("Obrigatório ter um email para realizar o cadastro");

        }
        usuarioRequestToUsuarioMapper.update(usuarioRequest, usuario);

        if (Objects.isNull(usuario.getSenha())) {
            throw new SenhaNãoEncontradaException("Obrigatório ter uma senha para realizar o cadastro");

        }
        usuarioRequestToUsuarioMapper.update(usuarioRequest, usuario);
        try {
            usuarioRepository.save(usuario);

            usuarioResponse = usuarioToUsuarioResponseMapper.toDto(usuario);

            usuarioResponse.setStatus("Cadastrado com sucesso!");
        } catch (Exception e) {
            usuarioResponse.setStatus("Erro ao cadastrar Usuário!");

        }

        return usuarioResponse;

    }
    //AtualizarUsuário
    public UsuarioResponse atualizar(Long idUsuario, UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioRepository.findById(idUsuario).get();

        UsuarioResponse usuarioResponse =  new UsuarioResponse();

        if (Objects.isNull(usuario)) {
            usuarioResponse.setStatus("Usuário com esse código não foi encontrado.");

            return usuarioResponse;
        }

        usuarioRequestToUsuarioMapper.update(usuarioRequest, usuario);

        try {
            usuarioRepository.save(usuario);

            usuarioResponse = usuarioToUsuarioResponseMapper.toDto(usuario);

            usuarioResponse.setStatus("Atualizado com sucesso!");
        } catch (Exception e) {
            usuarioResponse.setStatus("Erro ao cadastrar Usuário");
        }

        return usuarioResponse;
    }
    //ObterUmUsuário
    public UsuarioResponse obter(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).get();

        UsuarioResponse usuarioResponse =  new UsuarioResponse();

        if (Objects.isNull(usuario)) {
            usuarioResponse.setStatus("Usuário com esse código não foi encontrado.");

            return usuarioResponse;

        }

        usuarioResponse = usuarioToUsuarioResponseMapper.toDto(usuario);
        usuarioResponse.setStatus("Usuário obtido com sucesso do Banco de Dados");

        return usuarioResponse;

    }
    //ListarTodosUsuários
    public List<UsuarioResponse> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        List<UsuarioResponse> listaUsuariosResponse = new ArrayList<>();
        usuarios
                .forEach(usuario ->  {
                    UsuarioResponse usuarioResponse = usuarioToUsuarioResponseMapper.toDto(usuario);
                    listaUsuariosResponse.add(usuarioResponse);

                });

        return listaUsuariosResponse;
    }
    //ExcluirUsuário
    public UsuarioResponse excluir(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);

        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setStatus("Usuário excluído com sucesso.");

        return usuarioResponse;
    }
}
