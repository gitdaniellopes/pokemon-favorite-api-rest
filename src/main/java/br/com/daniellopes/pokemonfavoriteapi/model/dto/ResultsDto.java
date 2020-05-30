package br.com.daniellopes.pokemonfavoriteapi.model.dto;

import br.com.daniellopes.pokemonfavoriteapi.model.Results;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultsDto {

    private final String name;
    private final List<PokemonDto> pokemons;

    public ResultsDto(Results results) {
        this.name = results.getName();
        this.pokemons = new ArrayList<>();
        this.pokemons.addAll(results.getPokemons().stream().map(PokemonDto::new)
                .collect(Collectors.toList()));
    }

    public static List<ResultsDto> convert(List<Results> results) {
        return results.stream().map(ResultsDto::new).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public List<PokemonDto> getPokemons() {
        return pokemons;
    }
}
