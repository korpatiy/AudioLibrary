package com.example.AudioLibrary.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "singer")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Singer {

    @Id
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(mappedBy = "singers")
    private Set<Melody> melodies;
}
