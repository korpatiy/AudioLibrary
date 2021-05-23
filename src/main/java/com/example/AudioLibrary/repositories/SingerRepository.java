package com.example.AudioLibrary.repositories;

import com.example.AudioLibrary.entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingerRepository extends JpaRepository<Singer, Long> {
}
