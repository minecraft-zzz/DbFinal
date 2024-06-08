package com.example.dbcoursefinalproject.mapper;


import com.example.dbcoursefinalproject.entity.Film;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FilmMapper {

    @Select("select * from films where title LIKE CONCAT('%', #{title}, '%') limit 100")
    public List<Film> findFilmByTitle(String title);
}
