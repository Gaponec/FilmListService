package com.gaponec.repository;

import com.gaponec.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, String>{
    @Override
    List<Film> findAll();

    @Override
    Film getOne(String name);
}
