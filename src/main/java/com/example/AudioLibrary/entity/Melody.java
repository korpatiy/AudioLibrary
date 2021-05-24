package com.example.AudioLibrary.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "melody")
public class Melody {

    @Id
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String year;
    @Column
    private String duration;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "composer_id", referencedColumnName = "id")
    private Composer composer;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Genre> genres;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Singer> singers;
}



