package com.gaponec.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaponec.domain.Film;
import com.gaponec.dto.FilmDto;
import com.gaponec.repository.FilmRepository;
import com.gaponec.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        List<Film> films = filmRepository.findAll();
        List<String> strings = new ArrayList<>();

        for (Film film : films){
            strings.add(objectMapper.writeValueAsString(filmService.getFilmInfoByName(film.getTitle())));
        }

        return strings.toString();
    }

    @RequestMapping("/film")
    public String film(@RequestParam(value = "title") String title, Model model){
        model.addAttribute("title",title);
        return "film";
    }

    @RequestMapping(value = "/getFilm", method = RequestMethod.GET)
    @ResponseBody
    public String getFilm(@RequestParam(value = "title", defaultValue = "Rift") String title) throws JsonProcessingException {

        FilmDto film = filmService.getFilmInfoByName(title);

        return objectMapper.writeValueAsString(film);
    }


    @RequestMapping("/test")
    @ResponseBody
    public void test(){
        String s = "https://images-na.ssl-images-amazon.com/images/M/MV5BMjE4OTg2NzU1MF5BMl5BanBnXkFtZTcwMjU2ODAyNQ@@._V1_SX300.jpg";

        System.out.println(s);
    }
}
