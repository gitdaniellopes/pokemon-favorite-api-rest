package br.com.daniellopes.pokemonfavoriteapi.model.dto;

import br.com.daniellopes.pokemonfavoriteapi.model.Pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class PokemonDto {

    private final Long id;
    private final String name;
    private final String curl_url;

    public PokemonDto(Pokemon pokemon) {
        this.id = pokemon.getId();
        this.name = pokemon.getName();
        this.curl_url = pokemon.getCurl_url();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCurl_url() {
        return curl_url;
    }

    public static List<PokemonDto> convert(List<Pokemon> pokemons) {
        return pokemons.stream().map(PokemonDto::new).collect(Collectors.toList());
    }
}
