package br.com.daniellopes.pokemonfavoriteapi.controller;

import br.com.daniellopes.pokemonfavoriteapi.model.Pokemon;
import br.com.daniellopes.pokemonfavoriteapi.model.dto.DetailPokemonDto;
import br.com.daniellopes.pokemonfavoriteapi.model.dto.PokemonDto;
import br.com.daniellopes.pokemonfavoriteapi.model.form.PokemonForm;
import br.com.daniellopes.pokemonfavoriteapi.repository.PokemonRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    private final PokemonRepository repository;

    public PokemonController(PokemonRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @ApiOperation(value = "Retorna uma lista de pokemns")
    public List<PokemonDto> list() {
        List<Pokemon> pokemons = repository.findAll();
        return PokemonDto.convert(pokemons);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna um pokemon unico por id")
    public ResponseEntity<DetailPokemonDto> detail(@PathVariable Long id) {
        Optional<Pokemon> pokemon = repository.findById(id);
        return pokemon.map(value ->
                ResponseEntity.ok(new DetailPokemonDto(value))).orElseGet(()
                -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Transactional
    @ApiOperation(value = "Registra um pokemon")
    public ResponseEntity<PokemonDto> save(@RequestBody @Valid
                                                   PokemonForm form, UriComponentsBuilder uriBuilder) {
        Pokemon pokemon = form.convert();
        repository.save(pokemon);

        URI uri = uriBuilder.path("pokemon/{id}").buildAndExpand(pokemon.getId()).toUri();
        return ResponseEntity.created(uri).body(new PokemonDto(pokemon));
    }

}
