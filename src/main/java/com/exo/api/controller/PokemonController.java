package com.exo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.exo.api.entity.Pokemon;
import com.exo.api.repository.PokemonRepository;
import java.util.List;
import org.springframework.web.bind.annotation.*;


@RestController
public class PokemonController {
    
    @Autowired
    private PokemonRepository pokemonRepository;

    @PostMapping("/pokemon")
    public Pokemon createPokemon(@RequestBody Pokemon pokemon){
        // @RequestBody sert a récuperer les information du pokemon
        return pokemonRepository.save(pokemon);
    }

    @GetMapping("/pokemons") 
    public List<Pokemon> findAllPokemon(){

        return pokemonRepository.findAll();
    }

    @GetMapping("/pokemons/{name}") 
    public Pokemon findPokemon(@PathVariable String name){

        return pokemonRepository.findByName(name);
    }

    @PutMapping("/pokemons/{id}/profil")
    public Pokemon UpdatePokemon(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        Pokemon pokemonToUpdate = pokemonRepository.findById(id).get();
        pokemonToUpdate.setName(pokemon.getName());
        pokemonToUpdate.setType(pokemon.getType());
        return pokemonRepository.save(pokemonToUpdate);
    }  

    @DeleteMapping("/pokemons/{id}") //api/users/:usersId DELETE supprime un utilisateur
        public boolean deletePokemon(@PathVariable Long id){
        pokemonRepository.deleteById(id);
        return true;
    }

}
