package com.nttdata.cadastrodeusuario.services;

import com.nttdata.cadastrodeusuario.dtos.requests.TelefoneRequest;
import com.nttdata.cadastrodeusuario.dtos.response.TelefoneResponse;
import com.nttdata.cadastrodeusuario.entities.Telefone;
import com.nttdata.cadastrodeusuario.mappers.TelefoneRequestToTelefoneMapper;
import com.nttdata.cadastrodeusuario.mappers.TelefoneToTelefoneResponseMapper;
import com.nttdata.cadastrodeusuario.repositories.TelefoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TelefoneService {

    //Mappers
    private final TelefoneRequestToTelefoneMapper telefoneRequestToTelefoneMapper;
    private final TelefoneToTelefoneResponseMapper telefoneToTelefoneResponseMapper;

    //Repositories
    private final TelefoneRepository telefoneRepository;

    //CadatrarTelefone
    public TelefoneResponse criar(TelefoneRequest telefoneRequest) {
        //Mapeamento
        Telefone telefone = telefoneRequestToTelefoneMapper.toEntity(telefoneRequest);

        TelefoneResponse telefoneResponse = new TelefoneResponse();

        try {
            telefoneRepository.save(telefone);

            telefoneResponse = telefoneToTelefoneResponseMapper.toDto(telefone);

            telefoneResponse.setStatus("Cadastrado com sucesso!");
        } catch (Exception e) {
            telefoneResponse.setStatus("Erro ao cadastrar Telefone!");
        }

        return telefoneResponse;

    }
    //AtualizarTelefone
    public TelefoneResponse atualizar(Long idTelefone, TelefoneRequest telefoneRequest) {
        Telefone telefone = telefoneRepository.findById(idTelefone).get();

        TelefoneResponse telefoneResponse = new TelefoneResponse();

        if (Objects.isNull(telefone)) {
            telefoneResponse.setStatus("Telefone com esse código não foi encontrado.");

            return telefoneResponse;
        }

        telefoneRequestToTelefoneMapper.update(telefoneRequest, telefone);

        try {
            telefoneRepository.save(telefone);

            telefoneResponse = telefoneToTelefoneResponseMapper.toDto(telefone);

            telefoneResponse.setStatus("Atualizado com sucesso!");
        } catch (Exception e) {
            telefoneResponse.setStatus("Erro ao cadastrar Telefone");
        }

        return telefoneResponse;
    }
    //ObterUmTelefone
    public TelefoneResponse obter(Long idTelefone) {
        Telefone telefone = telefoneRepository.findById(idTelefone).get();

        TelefoneResponse telefoneResponse =  new TelefoneResponse();

        if (Objects.isNull(telefone)) {
            telefoneResponse.setStatus("Telefone com esse código não foi encontrado.");

            return telefoneResponse;

        }

        telefoneResponse = telefoneToTelefoneResponseMapper.toDto(telefone);
        telefoneResponse.setStatus("Telefone obtido com sucesso do Banco de Dados");

        return telefoneResponse;

    }
    //ListarTodosTelefones
    public List<TelefoneResponse> listar() {
        List<Telefone> telefones = telefoneRepository.findAll();

        List<TelefoneResponse> listaTelefonesResponse = new ArrayList<>();
        telefones
                .forEach(telefone ->  {
                   TelefoneResponse telefoneResponse = telefoneToTelefoneResponseMapper.toDto(telefone);
                    listaTelefonesResponse.add(telefoneResponse);

                });

        return listaTelefonesResponse;
    }
    //ExcluirTelefone
    public TelefoneResponse excluir(Long idTelefone) {
        telefoneRepository.deleteById(idTelefone);

        TelefoneResponse telefoneResponse = new TelefoneResponse();
        telefoneResponse.setStatus("Telefone excluído com sucesso.");

        return telefoneResponse;
    }
}
