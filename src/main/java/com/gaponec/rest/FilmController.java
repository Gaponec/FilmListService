package com.gaponec.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.gaponec.domain.Film;
import com.gaponec.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FilmController {

    @Autowired
    private FilmService filmService;

    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping("/films")
    public String films(){

        return "films";
    }

    @RequestMapping("/getFilms")
    @ResponseBody
    public String getAllFilms() throws JsonProcessingException {
        return objectMapper.writeValueAsString(filmService.getFilmInfoByName("rift"));
    }
}