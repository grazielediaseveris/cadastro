package com.nttdata.cadastrodeusuario.controllers;

import com.nttdata.cadastrodeusuario.dtos.requests.TelefoneRequest;
import com.nttdata.cadastrodeusuario.dtos.response.TelefoneResponse;
import com.nttdata.cadastrodeusuario.services.TelefoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "API REST Telefones")
@RestController
@RequestMapping("/telefone")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TelefoneController {

    private final TelefoneService telefoneService;

    //CadatrarTelefone - POST - /telefone
    @ApiOperation(value="Realiza o Cadastro de Telefone")
    @PostMapping(produces = "application/json")
    public TelefoneResponse salvar(@RequestBody TelefoneRequest telefoneRequest) {
        TelefoneResponse telefoneResponse = telefoneService.criar(telefoneRequest);

        return  telefoneResponse;
    }
    //AtualizarTelefone - PATCH - /telefone/{id}
    @ApiOperation(value="Atualiza os dados de Telefone")
    @PatchMapping("/{id}")
    public TelefoneResponse atualizar(@PathVariable("id") Long idTelefone, @RequestBody TelefoneRequest telefoneRequest) {
        TelefoneResponse telefoneResponse = telefoneService.atualizar(idTelefone, telefoneRequest);

        return telefoneResponse;
    }
    //ObterUmTelefone - GET/telefone/{id}
    @ApiOperation(value="Apresenta os dados do Telefone pesquisado pelo codigo")
    @GetMapping("/{id}")
    public TelefoneResponse obter(@PathVariable("id") Long idTelefone){
        TelefoneResponse telefoneResponse = telefoneService.obter(idTelefone);

        return telefoneResponse;

    }
    //ListarTodosTelefones - GET - /telefone
    @ApiOperation(value="Retorna uma Lista de Telefones")
    @GetMapping(produces = "application/json")
    public List<TelefoneResponse> Listar(){
        List<TelefoneResponse> listaTelefonesResponse = telefoneService.listar();

        return listaTelefonesResponse;
    }
    //ExcluirTelefone- DELETE - /telefone/{id}
    @ApiOperation(value="Realiza a exclusão do Telefone pelo código")
    @DeleteMapping("/{id}")
    public TelefoneResponse excluir(@PathVariable("id") Long idTelefone) {
        TelefoneResponse telefoneResponse = telefoneService.excluir(idTelefone);

        return telefoneResponse;

    }

}
