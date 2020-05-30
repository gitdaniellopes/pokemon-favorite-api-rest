package br.com.daniellopes.pokemonfavoriteapi.controller;

import br.com.daniellopes.pokemonfavoriteapi.model.Results;
import br.com.daniellopes.pokemonfavoriteapi.model.dto.ResultsDto;
import br.com.daniellopes.pokemonfavoriteapi.model.form.ResultsForm;
import br.com.daniellopes.pokemonfavoriteapi.repository.ResultsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultsController {

    private final ResultsRepository resultsRepository;

    public ResultsController(ResultsRepository resultsRepository) {
        this.resultsRepository = resultsRepository;
    }


    @GetMapping
    public List<ResultsDto> list() {
        List<Results> results = resultsRepository.findAll();
        return ResultsDto.convert(results);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ResultsDto> save(@RequestBody @Valid
                                                   ResultsForm form, UriComponentsBuilder uriBuilder) {
        Results results = form.convert();
        resultsRepository.save(results);

        URI uri = uriBuilder.path("pokemon/{id}").buildAndExpand(results.getId()).toUri();
        return ResponseEntity.created(uri).body(new ResultsDto(results));
    }
}
