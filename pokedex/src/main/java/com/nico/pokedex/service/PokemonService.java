package com.nico.pokedex.service;

import com.nico.pokedex.client.PokeApiClient;
import com.nico.pokedex.model.AbilityDTO;
import com.nico.pokedex.model.PokemonDTO;
import com.nico.pokedex.model.PokemonListDTO;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class PokemonService {

    private final PokeApiClient pokeApiClient;

    public PokemonService(PokeApiClient pokeApiClient) {
        this.pokeApiClient = pokeApiClient;
    }

    public PokemonDTO findPokemon(String value) {
        return pokeApiClient.getPokemonByNameOrId(value);
    }

    public PokemonListDTO getPokemonList(int limit) {
        return pokeApiClient.getPokemonList(limit);
    }

    public Map<String, String> getAbilitiesWithEffect(PokemonDTO pokemon) {
        Map<String, String> abilitiesMap = new LinkedHashMap<>();
        for (PokemonDTO.AbilitySlot a : pokemon.getAbilities()) {
            AbilityDTO ability = pokeApiClient.getAbility(a.getAbility().getName());
            abilitiesMap.put(a.getAbility().getName(), ability.getEffectInEnglish());
        }
        return abilitiesMap;
    }
}

