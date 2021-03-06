package br.com.daniellopes.pokemonfavoriteapi.model.form;

import br.com.daniellopes.pokemonfavoriteapi.model.Pokemon;
import br.com.daniellopes.pokemonfavoriteapi.model.Results;
import br.com.daniellopes.pokemonfavoriteapi.repository.ResultsRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PokemonForm {

    @NotNull
    @NotEmpty
    @Length(min = 2, max = 60)
    private String name;
    @NotNull
    @NotEmpty
    @Length(min = 2, max = 250)
    private String description;
    @NotNull
    @NotEmpty
    @Length(min = 3, max = 60)
    private String type;
    private String numberSerial;
    @NotNull
    @NotEmpty
    private String curlUrl;

    private String nameResults;

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

    public Pokemon convert(ResultsRepository resultsRepository) {
        Results results = resultsRepository.findByName(nameResults);
        return new Pokemon(name, description, type, numberSerial, curlUrl, results);

    }

}
