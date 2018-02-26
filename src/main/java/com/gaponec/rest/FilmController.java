package com.gaponec.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaponec.dto.FilmDto;
import com.gaponec.repository.FilmRepository;
import com.gaponec.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FilmController {

    @Autowired
    private FilmService filmService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    FilmRepository filmRepository;

    @RequestMapping("/films")
    public String films(){

        return "films";
    }

    @RequestMapping("/getFilms")
    @ResponseBody
    public String getAllFilms() throws JsonProcessingException {
        List<FilmDto> films = filmRepository.findAll();
        List<String> strings = new ArrayList<>();

        for (FilmDto film : films){
            strings.add(objectMapper.writeValueAsString(filmService.getFilmInfoByName(film.getTitle())));
        }

        return strings.toString();
    }
}
