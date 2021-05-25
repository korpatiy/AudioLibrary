package com.example.AudioLibrary.repositories;

import com.example.AudioLibrary.entity.Melody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudioRepository extends JpaRepository<Melody, Long> {


}
