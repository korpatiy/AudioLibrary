package com.example.AudioLibrary.dto;

import com.example.AudioLibrary.entity.Composer;
import com.example.AudioLibrary.entity.Genre;
import com.example.AudioLibrary.entity.Singer;
import lombok.Data;

import java.util.Collection;
import java.util.Set;

@Data
public class SearchRequest {

    private String name;
    private Composer composer;
    private Collection<Genre> genres;
    private Set<Singer> singers;
}