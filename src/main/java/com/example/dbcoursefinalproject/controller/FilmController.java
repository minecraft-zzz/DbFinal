package com.example.dbcoursefinalproject.controller;

import com.example.dbcoursefinalproject.entity.Comment;
import com.example.dbcoursefinalproject.entity.Crew;
import com.example.dbcoursefinalproject.entity.Film;
import com.example.dbcoursefinalproject.mapper.FilmMapper;
import com.example.dbcoursefinalproject.mapper.PrincipalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;
import com.example.dbcoursefinalproject.util.GlobalResult;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;


@RestController
public class FilmController {

    @Autowired
    private FilmMapper filmMapper;
    @Autowired
    private PrincipalMapper principalMapper;

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
        System.out.println(film);
        List<Crew> crews = filmMapper.getCrewsByFilmId(id);
        List<String> crewnames = new ArrayList<>();
        for(Crew crew : crews){
            if(crew.getJob().equals("actor") || crew.getJob().equals("actress"))
                crewnames.add(principalMapper.getPrincipalNameById(crew.getPersonId()));
        }
        List<Comment> comments = filmMapper.getCommentsByFilmId(id);
        JSONObject ret = new JSONObject();
        ret.put("film",film);
        ret.put("crewnames",crewnames);
        ret.put("comments",comments);
        return ret;
    }

    @GetMapping("/api/movies/advanced_search")
    public List<Film> advanceSearch(String name,int startYear,int endYear,String type,String region){
        return filmMapper.advanceSearch(name,startYear,endYear,type,region);
    }

    @GetMapping("/api/movies/top-rated-with-number")
    public List<Film> getTopRatedFilmsWithNumber(@RequestParam int number){
//        System.out.println("success getfilm2");
        List<Film> retFilms = filmMapper.getTopRatedFilmWithNumebr(number);
        return retFilms;
    }


    @PostMapping("/api/movies/update")
    public String UpdateFilmInfo(Film film){
        try {
            filmMapper.updateFilm(film);
            return "success";
        } catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @PostMapping("/api/movies/insert")
    public String InsertFilm(Film film){
        try {
            Film existFilm= filmMapper.getExactFilmByName(film.getTitle());
            if(existFilm == null){
                film.setWorkId(incrementFilmId(filmMapper.findMaxWorkId()));
                film.setOrdering("1");
            }
            else{
                film.setWorkId(existFilm.getWorkId());
                film.setOrdering(incrementNumericString(filmMapper.findMaxOrdering(existFilm.getWorkId())));
            }
            filmMapper.insertFilm(film);
            return "success";
        } catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @PostMapping("/api/movies/delete")
    public String DeleteFilm(Film film){
        try {
            filmMapper.deleteFilm(film);
            return "success";
        } catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    public static String incrementFilmId(String filmId) {
        if (filmId == null || filmId.isEmpty()) {
            throw new IllegalArgumentException("Film ID cannot be null or empty");
        }

        // Find the position of the first digit in the string
        int pos = 0;
        while (pos < filmId.length() && !Character.isDigit(filmId.charAt(pos))) {
            pos++;
        }

        if (pos == filmId.length()) {
            throw new IllegalArgumentException("No digits found in Film ID");
        }

        // Split the string into prefix and numeric part
        String prefix = filmId.substring(0, pos);
        String numberPart = filmId.substring(pos);

        // Parse the numeric part, increment it, and format it back to the same length with leading zeros
        int number = Integer.parseInt(numberPart);
        number++;
        String incrementedNumberPart = String.format("%0" + numberPart.length() + "d", number);

        // Combine the prefix and incremented numeric part
        return prefix + incrementedNumberPart;
    }

    public static String incrementNumericString(String numericString) {
        if (numericString == null || numericString.isEmpty()) {
            throw new IllegalArgumentException("Numeric string cannot be null or empty");
        }

        // Parse the numeric part, increment it
        int number = Integer.parseInt(numericString);
        number++;
        return Integer.toString(number);
    }

}
