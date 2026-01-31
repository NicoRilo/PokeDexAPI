package com.nico.pokedex.model;

import lombok.Data;

import java.util.List;

@Data
public class PokemonDTO {

    private int id;
    private String name;
    private int height;
    private int weight;
    private Sprites sprites;
    private List<TypeSlot> types;
    private List<StatSlot> stats;
    private List<AbilitySlot> abilities;

    @Data
    public static class Sprites {
        private String front_default;
    }

    @Data
    public static class TypeSlot {
        private Type type;
    }

    @Data
    public static class Type {
        private String name;
    }

    @Data
    public static class StatSlot {
        private int base_stat;
        private Stat stat;
    }

    @Data
    public static class Stat {
        private String name;
    }

    @Data
    public static class AbilitySlot {
        private Ability ability;
    }

    @Data
    public static class Ability {
        private String name;
    }
}


