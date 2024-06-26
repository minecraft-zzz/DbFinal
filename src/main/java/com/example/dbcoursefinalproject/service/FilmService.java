package com.example.dbcoursefinalproject.service;

import com.example.dbcoursefinalproject.mapper.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {

    @Autowired
    private FilmMapper filmMapper;


}
