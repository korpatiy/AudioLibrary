package com.example.AudioLibrary.dto;

import com.example.AudioLibrary.entity.Melody;
import com.example.AudioLibrary.entity.Singer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class SingerDTO {

    @JsonProperty("lid")
    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;

    public static SingerDTO fromModel(Singer singer) {
        SingerDTO dto = new SingerDTO();
        dto.setId(singer.getId());
        dto.setFirstName(singer.getFirstName());
        dto.setLastName(singer.getLastName());
        return dto;
    }
}
