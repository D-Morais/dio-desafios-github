package br.com.digitalinnovationone.apivisitante.service;

import br.com.digitalinnovationone.apivisitante.dto.VisitanteRequestDto;
import br.com.digitalinnovationone.apivisitante.entitly.Visitante;
import br.com.digitalinnovationone.apivisitante.repository.VisitanteRepository;
import br.com.digitalinnovationone.apivisitante.validation.VisitanteValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VisitanteService {

    private final VisitanteRepository repository;


    public Visitante criar(VisitanteRequestDto dto){
        VisitanteValidation.validarCriacaoDoVisitante(dto);

        var id = UUID.randomUUID().toString();
        var visitante = new Visitante(id, dto.getCpf(), dto.getNome());
        return repository.save(visitante);
    }

}
