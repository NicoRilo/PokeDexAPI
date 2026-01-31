package com.nico.pokedex.controller;

import com.nico.pokedex.model.PokemonDTO;
import com.nico.pokedex.service.PokemonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/list")
    public String listPokemon(Model model) {
        model.addAttribute("pokemons", pokemonService.getPokemonList(20).getResults());
        return "list";
    }

    @GetMapping("/pokemon")
    public String getPokemon(@RequestParam String search, Model model) {
        try {
            PokemonDTO pokemon = pokemonService.findPokemon(search);

            Map<String, String> abilitiesMap = pokemonService.getAbilitiesWithEffect(pokemon);

            model.addAttribute("pokemon", pokemon);
            model.addAttribute("abilitiesMap", abilitiesMap);

            return "detail";
        } catch (Exception e) {
            model.addAttribute("error", "Pokémon no encontrado");
            return "index";
        }
    }

}

