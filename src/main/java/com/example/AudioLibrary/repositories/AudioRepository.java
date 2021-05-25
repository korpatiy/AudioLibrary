package com.example.AudioLibrary.repositories;

import com.example.AudioLibrary.entity.Melody;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AudioRepository extends JpaRepository<Melody, Long>, JpaSpecificationExecutor<Melody> {

    @Override
    List<Melody> findAll(Specification<Melody> specification);
}
