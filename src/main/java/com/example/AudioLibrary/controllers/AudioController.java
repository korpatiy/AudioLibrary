package com.example.AudioLibrary.controllers;

import com.example.AudioLibrary.dto.MelodyWithComposerDTO;
import com.example.AudioLibrary.dto.SearchRequest;
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
        return getMelodyWithComposerDTOS(service.getAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Melody addMelody(@RequestBody Melody melody) {
        return service.save(melody);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public Melody updateMelody(@RequestBody Melody melody) {
        return service.update(melody);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<MelodyWithComposerDTO> searchMelody(@RequestBody SearchRequest request) {
        return getMelodyWithComposerDTOS(service.search(request));
    }

    /**
     * Преобразует список мелодий к DTO {@link MelodyWithComposerDTO}, устраняя проблему "бесконечного json'a"
     *
     * @param melodyList список мелодий {@link Melody}
     * @return список {@link MelodyWithComposerDTO}
     */
    private List<MelodyWithComposerDTO> getMelodyWithComposerDTOS(List<Melody> melodyList) {
        List<MelodyWithComposerDTO> melodies = new ArrayList<>();
        for (Melody melody : melodyList) {
            melodies.add(MelodyWithComposerDTO.fromModel(melody));
        }
        return melodies;
    }
}
