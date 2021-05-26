package com.example.AudioLibrary.repositories;

import com.example.AudioLibrary.entity.Composer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с композиторами {@link Composer}
 */
@Repository
public interface ComposerRepository extends JpaRepository<Composer, Long> {

}
