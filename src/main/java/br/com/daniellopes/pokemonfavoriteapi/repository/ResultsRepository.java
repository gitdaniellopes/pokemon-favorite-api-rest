package br.com.daniellopes.pokemonfavoriteapi.repository;

import br.com.daniellopes.pokemonfavoriteapi.model.Results;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultsRepository extends JpaRepository<Results, Long> {

    Results findByName(String name);
}
