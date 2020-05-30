package br.com.daniellopes.pokemonfavoriteapi.model;

import javax.persistence.*;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String type;

    @Column(name = "serial_number")
    private String numberSerial;

    @Column(name = "curl_url")
    private String curlUrl;

    @ManyToOne
    private Results results;

    public Pokemon() {
    }

    public Pokemon(String name, String description, String type, String numberSerial,
                   String curlUrl, Results results) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.numberSerial = numberSerial;
        this.curlUrl = curlUrl;
        this.results = results;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pokemon other = (Pokemon) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
