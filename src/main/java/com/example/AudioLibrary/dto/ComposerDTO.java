package com.example.AudioLibrary.dto;

import com.example.AudioLibrary.entity.Composer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComposerDTO {

    @JsonProperty("lid")
    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;

    public static ComposerDTO fromModel(Composer composer) {
        ComposerDTO dto = new ComposerDTO();
        dto.setFirstName(composer.getFirstName());
        dto.setLastName(composer.getLastName());
        dto.setId(composer.getId());
        return dto;
    }
}
