package com.example.AudioLibrary.services;

import com.example.AudioLibrary.dto.SearchRequest;
import com.example.AudioLibrary.entity.Melody;
import com.example.AudioLibrary.repositories.AudioRepository;
import com.example.AudioLibrary.repositories.CustomTextSearcherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * service layer для работы с {@link Melody}
 */
@Service
public class AudioService implements AudioLibraryService<Melody> {

    private final AudioRepository repository;
    private final CustomTextSearcherRepository searcherRepository;

    @Autowired
    public AudioService(AudioRepository repository, EntityManager em, CustomTextSearcherRepository searcherRepository) {
        this.repository = repository;
        this.searcherRepository = searcherRepository;
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

    public List<Melody> search(SearchRequest request) {
        return searcherRepository.findAllByRequest(request);
    }
}

