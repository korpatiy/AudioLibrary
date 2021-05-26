package com.example.AudioLibrary.dto;

import com.example.AudioLibrary.entity.Composer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

/**
 * DTO для {@link Composer}
 */
@Getter
@Setter
public class ComposerDTO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;

    public static ComposerDTO fromModel(Composer composer) {
        ComposerDTO dto = new ComposerDTO();
        Composer newComposer = Optional.ofNullable(composer).orElse(new Composer());
        dto.setFirstName(newComposer.getFirstName());
        dto.setLastName(newComposer.getLastName());
        dto.setId(newComposer.getId());
        return dto;
    }
}
