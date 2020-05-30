package br.com.daniellopes.pokemonfavoriteapi.controller;

import br.com.daniellopes.pokemonfavoriteapi.model.Results;
import br.com.daniellopes.pokemonfavoriteapi.model.dto.ResultsDto;
import br.com.daniellopes.pokemonfavoriteapi.repository.ResultsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
