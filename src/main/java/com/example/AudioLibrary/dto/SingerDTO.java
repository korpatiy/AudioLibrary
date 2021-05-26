package com.example.AudioLibrary.dto;

import com.example.AudioLibrary.entity.Composer;
import com.example.AudioLibrary.entity.Singer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

/**
 * DTO для {@link Singer}
 */
@Getter
@Setter
public class SingerDTO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;

    public static SingerDTO fromModel(Singer singer) {
        SingerDTO dto = new SingerDTO();
        Singer newSinger = Optional.ofNullable(singer).orElse(new Singer());
        dto.setId(newSinger.getId());
        dto.setFirstName(newSinger.getFirstName());
        dto.setLastName(newSinger.getLastName());
        return dto;
    }
}
