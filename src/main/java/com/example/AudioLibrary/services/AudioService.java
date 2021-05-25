package com.example.AudioLibrary.services;

import com.example.AudioLibrary.controllers.AudioController;
import com.example.AudioLibrary.entity.Melody;
import com.example.AudioLibrary.repositories.AudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
        return update(melody);
    }

    public Melody update(Melody melody) {
        return repository.save(melody);
    }

    public List<Melody> search(AudioController.SearchRequest request) {
        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withMatcher("name",
                        ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("composer", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        Melody melody = Melody
                .builder()
                .name(request.getName())
                .composer(request.getComposer())
                .genres(request.getGenres())
                .singers(request.getSingers())
                .build();
        return repository.findAll(Example.of(melody, matcher));
    }
}
