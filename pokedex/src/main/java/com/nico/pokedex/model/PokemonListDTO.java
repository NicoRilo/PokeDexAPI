package com.nico.pokedex.model;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class PokemonListDTO {
    private List<PokemonResult> results;

    @Data
    public static class PokemonResult {
        private String name;
        private String url;
    }
}

