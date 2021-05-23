package com.example.AudioLibrary.repositories;

import com.example.AudioLibrary.entity.Melody;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioRepository extends JpaRepository<Melody, Long> {

}
