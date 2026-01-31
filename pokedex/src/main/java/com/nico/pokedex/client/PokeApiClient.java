package com.nico.pokedex.client;

import com.nico.pokedex.model.AbilityDTO;
import com.nico.pokedex.model.PokemonDTO;
import com.nico.pokedex.model.PokemonListDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PokeApiClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon/";

    public PokemonDTO getPokemonByNameOrId(String value) {
        return restTemplate.getForObject(BASE_URL + value, PokemonDTO.class);
    }

    public PokemonListDTO getPokemonList(int limit) {
        return restTemplate.getForObject(BASE_URL + "?limit=" + limit, PokemonListDTO.class);
    }

    public AbilityDTO getAbility(String name) {
        return restTemplate.getForObject("https://pokeapi.co/api/v2/ability/" + name, AbilityDTO.class);
    }
}
