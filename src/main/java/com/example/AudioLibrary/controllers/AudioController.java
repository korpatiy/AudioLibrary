package com.example.AudioLibrary.controllers;

import antlr.StringUtils;
import com.example.AudioLibrary.dto.ComposerWithMelodyDTO;
import com.example.AudioLibrary.dto.MelodyWithComposerDTO;
import com.example.AudioLibrary.dto.SimpleResp;
import com.example.AudioLibrary.entity.Composer;
import com.example.AudioLibrary.entity.Melody;
import com.example.AudioLibrary.services.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/melodies")
public class AudioController {

    private final AudioService service;

    @Autowired
    public AudioController(AudioService service) {
        this.service = service;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<MelodyWithComposerDTO> getAllMelodies() {
        List<MelodyWithComposerDTO> melodies = new ArrayList<>();
        for (Melody melody : service.getAll()) {
            melodies.add(MelodyWithComposerDTO.fromModel(melody));
        }
        return melodies;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Melody addMelody(@RequestBody Melody melody) {
        return service.save(melody);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Melody updateMelody(@RequestBody Melody melody) {
        return service.update(melody);
    }
}
