package br.com.daniellopes.pokemonfavoriteapi.repository;

import br.com.daniellopes.pokemonfavoriteapi.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}
