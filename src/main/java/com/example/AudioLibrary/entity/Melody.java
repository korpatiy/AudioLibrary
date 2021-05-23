package com.example.AudioLibrary.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "melody")
public class Melody {

    @Id
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String year;
    @Column
    private String duration;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Composer composer;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Genre> genres;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Singer> singers;
}



