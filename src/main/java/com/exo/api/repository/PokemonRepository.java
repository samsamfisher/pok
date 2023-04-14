package com.exo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exo.api.entity.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{
    Pokemon findByName(String name);
}
