package com.example.AudioLibrary.controllers;

import com.example.AudioLibrary.entity.Melody;
import com.example.AudioLibrary.entity.Singer;
import com.example.AudioLibrary.services.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/singers")
public class SingerController {

    private final SingerService service;

    public SingerController(SingerService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Singer> getAllMelodies() {
        return service.getAll();
    }
}
