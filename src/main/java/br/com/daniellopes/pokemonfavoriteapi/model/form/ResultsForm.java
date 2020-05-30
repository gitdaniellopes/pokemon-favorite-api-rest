package br.com.daniellopes.pokemonfavoriteapi.model.form;

import br.com.daniellopes.pokemonfavoriteapi.model.Results;

public class ResultsForm {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Results convert() {
        return new Results(name);
    }
}
