package br.com.daniellopes.pokemonfavoriteapi.model.form;

import br.com.daniellopes.pokemonfavoriteapi.model.Pokemon;
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
    private int number;
    @NotNull
    @NotEmpty
    private String curl_url;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCurl_url(String curl_url) {
        this.curl_url = curl_url;
    }

    public Pokemon convert() {
        return new Pokemon(name, description, type, number, curl_url);
    }
}
