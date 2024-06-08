package com.example.dbcoursefinalproject.controller;

import com.example.dbcoursefinalproject.entity.Film;
import com.example.dbcoursefinalproject.mapper.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class FilmController {

    @Autowired
    private FilmMapper filmMapper;

    @GetMapping("getFilmByTitle/{title}")
    public List<Film> getFilmByTitle(@PathVariable String title){
        System.out.println("Success");
        return filmMapper.findFilmByTitle(title);
    }

    @GetMapping("/hello")
    public String Hello(){
        return "Hello World";
    }
}
