package com.example.AudioLibrary.dto;

import com.example.AudioLibrary.entity.Composer;
import com.example.AudioLibrary.entity.Melody;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO для {@link Composer} c оберткой листа мелодий
 */
@Getter
@Setter
public class ComposerWithMelodyDTO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("melodies")
    private List<MelodyDTO> melodies;

    public static ComposerWithMelodyDTO fromModel(Composer composer) {
        ComposerWithMelodyDTO dto = new ComposerWithMelodyDTO();
        dto.setFirstName(composer.getFirstName());
        dto.setLastName(composer.getLastName());
        dto.setId(composer.getId());
        List<MelodyDTO> melodyDTOS = new ArrayList<>();
        for (Melody melody : composer.getMelodies()) {
            melodyDTOS.add(MelodyDTO.fromModel(melody));
        }
        dto.setMelodies(melodyDTOS);
        return dto;
    }
}

