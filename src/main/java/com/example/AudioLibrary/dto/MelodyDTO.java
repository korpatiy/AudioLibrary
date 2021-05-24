package com.example.AudioLibrary.dto;

import com.example.AudioLibrary.entity.Genre;
import com.example.AudioLibrary.entity.Melody;
import com.example.AudioLibrary.entity.Singer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

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
    @JsonProperty("singers")
    private List<Singer> singers;

    /*public static MelodyDTO fromModel(Melody melody)
    {

    }*/
}
