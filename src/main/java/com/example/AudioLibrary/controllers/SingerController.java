package com.example.AudioLibrary.controllers;

import com.example.AudioLibrary.dto.SingerWithMelodyDTO;
import com.example.AudioLibrary.entity.Singer;
import com.example.AudioLibrary.services.SingerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * Контроллер API для работы с исполнителями
 */
@RestController
@RequestMapping("/singers")
public class SingerController {

    private final SingerService service;

    public SingerController(SingerService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<SingerWithMelodyDTO> getAllMelodies() {
        List<SingerWithMelodyDTO> melodies = new ArrayList<>();
        for (Singer singer : service.getAll()) {
            melodies.add(SingerWithMelodyDTO.fromModel(singer));
        }
        int x = 5;
        return melodies;
    }
}
