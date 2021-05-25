package com.example.AudioLibrary.controllers;

import com.example.AudioLibrary.dto.ComposerDTO;
import com.example.AudioLibrary.dto.ComposerWithMelodyDTO;
import com.example.AudioLibrary.entity.Composer;
import com.example.AudioLibrary.services.ComposerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/composers")
public class ComposerController {

    private final ComposerService service;

    public ComposerController(ComposerService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<ComposerWithMelodyDTO> getAllMelodies() {
        List<ComposerWithMelodyDTO> composers = new ArrayList<>();
        for (Composer composer : service.getAll()) {
            composers.add(ComposerWithMelodyDTO.fromModel(composer));
        }
        return composers;
    }
}
