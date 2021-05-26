package com.example.AudioLibrary.repositories;

import com.example.AudioLibrary.entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с певцами {@link Singer}
 */
@Repository
public interface SingerRepository extends JpaRepository<Singer, Long> {
}
