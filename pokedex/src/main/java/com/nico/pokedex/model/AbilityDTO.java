package com.nico.pokedex.model;

import lombok.Data;
import java.util.List;

@Data
public class AbilityDTO {

    private List<EffectEntry> effect_entries;

    @Data
    public static class EffectEntry {
        private String effect;
        private Language language;
    }

    @Data
    public static class Language {
        private String name;
    }

    public String getEffectInEnglish() {
        return effect_entries.stream()
                .filter(e -> "en".equals(e.getLanguage().getName()))
                .map(EffectEntry::getEffect)
                .findFirst()
                .orElse("No description available");
    }
}
