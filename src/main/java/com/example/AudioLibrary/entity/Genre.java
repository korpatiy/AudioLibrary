package com.example.AudioLibrary.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "genre")
public class Genre {

    @Id
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;
}
