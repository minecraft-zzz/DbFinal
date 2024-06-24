package com.example.dbcoursefinalproject.controller;

import com.example.dbcoursefinalproject.entity.Comment;
import com.example.dbcoursefinalproject.entity.Crew;
import com.example.dbcoursefinalproject.entity.Film;
import com.example.dbcoursefinalproject.mapper.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;
import com.example.dbcoursefinalproject.util.GlobalResult;

import java.util.List;


@RestController
public class FilmController {

    @Autowired
    private FilmMapper filmMapper;

    @GetMapping("/api/movie/getFilmByTitle")
    public List<Film> getFilmByTitle(@RequestParam String title){
        System.out.println("Success");
        return filmMapper.findFilmByTitle(title);
    }

    @GetMapping("/hello")
    public String Hello(){
        return "Hello World";
    }

//    @GetMapping("/api/movies/top-rated")
//    public GlobalResult getTopRatedFilms(@RequestParam int minRatingNum,@RequestParam int limit){
//        System.out.println("success getfilm");
//        List<Film> retFilms = filmMapper.getTopRatedFilmForHome(minRatingNum,limit);
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("Films",retFilms);
//        //jsonObject.put("success",minRatingNum);
//        return GlobalResult.build(200,"查询成功",jsonObject);
//    }

//    @GetMapping("/api/movies/top-rated2")
//    public GlobalResult getTopRatedFilms(){
//        System.out.println("success getfilm2");
//        List<Film> retFilms = filmMapper.getTopRatedFilmForHome2();
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("Films",retFilms);
//        //jsonObject.put("success",minRatingNum);
//        return GlobalResult.build(200,"查询成功",jsonObject);
//    }

    @GetMapping("/api/movies/top-rated")
    public List<Film> getTopRatedFilms(){
//        System.out.println("success getfilm2");
        List<Film> retFilms = filmMapper.getTopRatedFilmForHome();
        return retFilms;
    }

    @GetMapping("/api/movies/top-ratedByType")
    public List<Film> getTopRatedFilmsByType(@RequestParam String type){
        return filmMapper.getTopRatedFilmForType(type);
    }

    @GetMapping("/api/movies/latestFilmByType")
    public List<Film> getLatestFilmsByType(@RequestParam String type){
        return filmMapper.getLatestFilmForType(type);
    }

    @GetMapping("/api/movies/getFilmById")
    public JSONObject getFilmById(@RequestParam String id,@RequestParam(defaultValue = "1") String ordering){
        Film film = filmMapper.findFilmById(id,ordering);
        List<Crew> crews = filmMapper.getCrewsByFilmId(id);
        List<Comment> comments = filmMapper.getCommentsByFilmId(id);
        JSONObject ret = new JSONObject();
        ret.put("film",film);
        ret.put("crews",crews);
        ret.put("comments",comments);
        return ret;
    }
}
