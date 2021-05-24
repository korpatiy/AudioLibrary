package com.example.AudioLibrary.controllers;

import antlr.StringUtils;
import com.example.AudioLibrary.dto.SimpleResp;
import com.example.AudioLibrary.entity.Melody;
import com.example.AudioLibrary.services.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public List<Melody>getAllMelodies() {
        List<Melody> all = service.getAll();
        return service.getAll();
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
