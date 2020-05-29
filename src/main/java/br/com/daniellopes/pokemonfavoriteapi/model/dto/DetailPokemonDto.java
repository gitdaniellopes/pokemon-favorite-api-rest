package br.com.daniellopes.pokemonfavoriteapi.model.dto;

import br.com.daniellopes.pokemonfavoriteapi.model.Pokemon;

public class DetailPokemonDto {

    private final Long id;
    private final String name;
    private final String description;
    private final String type;
    private final int number;
    private final String curl_url;

    public DetailPokemonDto(Pokemon pokemon) {
        this.id = pokemon.getId();
        this.name = pokemon.getName();
        this.description = pokemon.getDescription();
        this.type = pokemon.getType();
        this.number = pokemon.getNumber();
        this.curl_url = pokemon.getCurl_url();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public String getCurl_url() {
        return curl_url;
    }
}
