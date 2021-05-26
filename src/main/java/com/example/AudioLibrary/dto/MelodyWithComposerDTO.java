package com.example.AudioLibrary.dto;

import com.example.AudioLibrary.entity.Composer;
import com.example.AudioLibrary.entity.Genre;
import com.example.AudioLibrary.entity.Melody;
import com.example.AudioLibrary.entity.Singer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * DTO для {@link Melody} c оберткой певцов и композитора
 */
@Getter
@Setter
public class MelodyWithComposerDTO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("year")
    private String year;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("composer")
    private ComposerDTO composer;
    @JsonProperty("genres")
    private Collection<Genre> genres;
    @JsonProperty("singers")
    private Set<SingerDTO> singers;

    public static MelodyWithComposerDTO fromModel(Melody melody) {
        MelodyWithComposerDTO dto = new MelodyWithComposerDTO();
        dto.setId(melody.getId());
        dto.setDuration(melody.getDuration());
        dto.setName(melody.getName());
        dto.setYear(melody.getYear());
        dto.setGenres(melody.getGenres());
        dto.setComposer(ComposerDTO.fromModel(melody.getComposer()));
        Set<SingerDTO> singerDTOS = new HashSet<>();
        for (Singer singer : melody.getSingers()) {
            singerDTOS.add(SingerDTO.fromModel(singer));
        }
        dto.setSingers(singerDTOS);
        return dto;
    }
}
