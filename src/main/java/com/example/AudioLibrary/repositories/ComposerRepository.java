package com.example.AudioLibrary.repositories;

import com.example.AudioLibrary.entity.Composer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComposerRepository extends JpaRepository<Composer, Long> {

}
