package com.example.AudioLibrary.dto;

import com.example.AudioLibrary.entity.Composer;
import com.example.AudioLibrary.entity.Genre;
import com.example.AudioLibrary.entity.Melody;
import com.example.AudioLibrary.entity.Singer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Getter
@Setter
public class MelodyDTO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("year")
    private String year;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("genres")
    private Collection<Genre> genres;

    public static MelodyDTO fromModel(Melody melody) {
        MelodyDTO dto = new MelodyDTO();
        Melody newMelody = Optional.ofNullable(melody).orElse(new Melody());
        dto.setId(newMelody.getId());
        dto.setDuration(newMelody.getDuration());
        dto.setName(newMelody.getName());
        dto.setYear(newMelody.getYear());
        dto.setGenres(newMelody.getGenres());
        return dto;
    }
}
