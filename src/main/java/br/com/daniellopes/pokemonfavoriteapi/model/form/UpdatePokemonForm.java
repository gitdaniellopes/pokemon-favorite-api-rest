package br.com.daniellopes.pokemonfavoriteapi.model.form;

import br.com.daniellopes.pokemonfavoriteapi.model.Pokemon;
import br.com.daniellopes.pokemonfavoriteapi.model.Results;
import br.com.daniellopes.pokemonfavoriteapi.repository.PokemonRepository;
import br.com.daniellopes.pokemonfavoriteapi.repository.ResultsRepository;

public class UpdatePokemonForm {

    private String name;
    private String description;
    private String type;
    private String numberSerial;
    private String curlUrl;
    private String nameResults;


    public Pokemon updateUp(Long id, PokemonRepository pokemonRepository,
                            ResultsRepository resultsRepository) {
        Pokemon pokemon = pokemonRepository.getOne(id);
        Results byName = resultsRepository.findByName(nameResults);
        pokemon.setName(this.name);
        pokemon.setDescription(this.description);
        pokemon.setType(this.type);
        pokemon.setNumberSerial(this.numberSerial);
        pokemon.setCurlUrl(this.curlUrl);
        pokemon.setResults(byName);

        return pokemon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumberSerial() {
        return numberSerial;
    }

    public void setNumberSerial(String numberSerial) {
        this.numberSerial = numberSerial;
    }

    public String getCurlUrl() {
        return curlUrl;
    }

    public void setCurlUrl(String curlUrl) {
        this.curlUrl = curlUrl;
    }

    public String getNameResults() {
        return nameResults;
    }

    public void setNameResults(String nameResults) {
        this.nameResults = nameResults;
    }
}
