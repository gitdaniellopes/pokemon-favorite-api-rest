package br.com.daniellopes.pokemonfavoriteapi.controller;

import br.com.daniellopes.pokemonfavoriteapi.model.Pokemon;
import br.com.daniellopes.pokemonfavoriteapi.model.dto.DetailPokemonDto;
import br.com.daniellopes.pokemonfavoriteapi.model.dto.PokemonDto;
import br.com.daniellopes.pokemonfavoriteapi.model.form.PokemonForm;
import br.com.daniellopes.pokemonfavoriteapi.model.form.UpdatePokemonForm;
import br.com.daniellopes.pokemonfavoriteapi.repository.PokemonRepository;
import br.com.daniellopes.pokemonfavoriteapi.repository.ResultsRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pokemon")
@Api(value = "API REST Pokemon")
@CrossOrigin(origins = "*")
public class PokemonController {

    private final PokemonRepository pokemonRepository;
    private final ResultsRepository resultsRepository;

    public PokemonController(PokemonRepository repository, ResultsRepository resultsRepository) {
        this.pokemonRepository = repository;
        this.resultsRepository = resultsRepository;
    }

    @GetMapping
    @ApiOperation(value = "Retorna uma lista de pokemons")
    @Cacheable(value = "listOfPokemon")
    public List<PokemonDto> list() {
        List<Pokemon> pokemons = pokemonRepository.findAll();
        return PokemonDto.convert(pokemons);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna um pokemon unico por id")
    public ResponseEntity<DetailPokemonDto> detail(@PathVariable Long id) {
        Optional<Pokemon> pokemon = pokemonRepository.findById(id);
        return pokemon.map(value ->
                ResponseEntity.ok(new DetailPokemonDto(value))).orElseGet(()
                -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Transactional
    @ApiOperation(value = "Registra um pokemon")
    public ResponseEntity<PokemonDto> save(@RequestBody @Valid
                                                   PokemonForm form, UriComponentsBuilder uriBuilder) {
        Pokemon pokemon = form.convert(resultsRepository);
        pokemonRepository.save(pokemon);

        URI uri = uriBuilder.path("pokemon/{id}").buildAndExpand(pokemon.getId()).toUri();
        return ResponseEntity.created(uri).body(new PokemonDto(pokemon));
    }

    @PutMapping("/{id}")
    @Transactional
    @ApiOperation(value = "Atualiza um pokemon")
    public ResponseEntity<PokemonDto> update(@PathVariable Long id,
                                             @RequestBody @Valid UpdatePokemonForm form) {
        Optional<Pokemon> optional = pokemonRepository.findById(id);
        if (optional.isPresent()) {
            Pokemon pokemon = form.updateUp(id, pokemonRepository, resultsRepository);
            return ResponseEntity.ok(new PokemonDto(pokemon));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ApiOperation(value = "remove um pokemon")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Pokemon> optional = pokemonRepository.findById(id);
        if (optional.isPresent()) {
            pokemonRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}
