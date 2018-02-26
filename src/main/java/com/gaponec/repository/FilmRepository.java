package com.gaponec.repository;

import com.gaponec.dto.FilmDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<FilmDto, Integer>{
    @Override
    List<FilmDto> findAll();
}
