package com.example.AudioLibrary.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "composer")
public class Composer {

    @Id
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    /**
     * Т.к у композитор может быть много мелодий, а в свою очередь у мелодии только один композитор,
     * исключим создание новой таблицы и реализуем DTO для выдачи без зацикливаний.
     */
    @OneToMany
    @JoinColumn(name = "composer_id")
    //@JsonBackReference
    private Collection<Melody> melodies;
}
