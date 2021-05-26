package com.example.AudioLibrary.services;

import com.example.AudioLibrary.entity.Melody;
import com.example.AudioLibrary.entity.Singer;
import com.example.AudioLibrary.repositories.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service layer для работы с {@link Singer}
 */
@Service
public class SingerService {

    private final SingerRepository repository;

    @Autowired
    public SingerService(SingerRepository repository) {
        this.repository = repository;
    }

    public List<Singer> getAll() {
        return repository.findAll();
    }
}
