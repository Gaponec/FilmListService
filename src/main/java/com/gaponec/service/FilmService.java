package com.gaponec.service;

import com.gaponec.dto.FilmDto;
import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FilmService {
    @Value("${application.suggestionUrlTemplate}")
    private String suggestionURL;

    @Value("${application.apiKey}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    public FilmDto getFilmInfoByName(@NonNull String name){
        ResponseEntity<FilmDto> response =
                restTemplate.getForEntity(suggestionURL, FilmDto.class, ImmutableMap.of("name", name, "apikey", apiKey));

        if(response.getStatusCode() != HttpStatus.OK){
            throw new RuntimeException(String.format("Response status code was %s", response.getStatusCode()));
        }

        return response.getBody();
    }
}
