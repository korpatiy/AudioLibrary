package com.example.AudioLibrary.services;

import com.example.AudioLibrary.entity.Composer;
import com.example.AudioLibrary.entity.Melody;
import com.example.AudioLibrary.repositories.ComposerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service layer для работы с {@link Composer}
 */
@Service
public class ComposerService {

    private final ComposerRepository repository;

    @Autowired
    public ComposerService(ComposerRepository repository) {
        this.repository = repository;
    }

    public List<Composer> getAll() {
        return repository.findAll();
    }
}
