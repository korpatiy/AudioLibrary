package com.example.AudioLibrary.services;

import com.example.AudioLibrary.repositories.ComposerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComposerService {

    private final ComposerRepository repository;

    @Autowired
    public ComposerService(ComposerRepository repository) {
        this.repository = repository;
    }
}
