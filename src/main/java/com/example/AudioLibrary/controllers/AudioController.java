package com.example.AudioLibrary.controllers;

import com.example.AudioLibrary.entity.Melody;
import com.example.AudioLibrary.services.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/melody")
public class AudioController {

    private final AudioService service;

    @Autowired
    public AudioController(AudioService service) {
        this.service = service;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Melody> getAllMelody() {
        return service.getAll();
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Melody addMelody(@RequestBody Melody melody) {
        return service.save(melody);
    }

    @PutMapping
    @ResponseBody
    public void updateMelody() {

    }
}
