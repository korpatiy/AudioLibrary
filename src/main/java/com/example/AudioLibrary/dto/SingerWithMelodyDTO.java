package com.example.AudioLibrary.dto;

import com.example.AudioLibrary.entity.Composer;
import com.example.AudioLibrary.entity.Melody;
import com.example.AudioLibrary.entity.Singer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * DTO для {@link Singer} c оберткой листа мелодий
 */
@Getter
@Setter
public class SingerWithMelodyDTO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("melodies")
    private Set<MelodyDTO> melodies;

    public static SingerWithMelodyDTO fromModel(Singer singer) {
        SingerWithMelodyDTO dto = new SingerWithMelodyDTO();
        dto.setId(singer.getId());
        dto.setFirstName(singer.getFirstName());
        dto.setLastName(singer.getLastName());
        Set<MelodyDTO> melodyDTOS = new HashSet<>();
        for (Melody melody : singer.getMelodies()) {
            melodyDTOS.add(MelodyDTO.fromModel(melody));
        }
        dto.setMelodies(melodyDTOS);
        return dto;
    }
}
