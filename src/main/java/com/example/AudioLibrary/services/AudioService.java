package com.example.AudioLibrary.services;

import com.example.AudioLibrary.entity.Melody;
import com.example.AudioLibrary.repositories.AudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AudioService {

    private final AudioRepository repository;

    @Autowired
    public AudioService(AudioRepository repository) {
        this.repository = repository;
    }

    public List<Melody> getAll() {
        return repository.findAll();
    }

    public Melody save(Melody melody) {
        return repository.save(melody);
    }
}
