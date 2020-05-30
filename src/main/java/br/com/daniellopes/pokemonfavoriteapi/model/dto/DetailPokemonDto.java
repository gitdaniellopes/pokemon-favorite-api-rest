package br.com.daniellopes.pokemonfavoriteapi.model.dto;

import br.com.daniellopes.pokemonfavoriteapi.model.Pokemon;

public class DetailPokemonDto {

    private final Long id;
    private final String name;
    private final String description;
    private final String type;
    private final String numberSerial;
    private final String curlUrl;
    private final String nameResults;


    public DetailPokemonDto(Pokemon pokemon) {
        this.id = pokemon.getId();
        this.name = pokemon.getName();
        this.description = pokemon.getDescription();
        this.type = pokemon.getType();
        this.numberSerial = pokemon.getNumberSerial();
        this.curlUrl = pokemon.getCurlUrl();
        this.nameResults = pokemon.getResults().getName();
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

    public String getNumberSerial() {
        return numberSerial;
    }

    public String getCurlUrl() {
        return curlUrl;
    }

    public String getNameResults() {
        return nameResults;
    }
}
