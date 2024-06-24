package com.example.dbcoursefinalproject.mapper;


import com.example.dbcoursefinalproject.entity.Comment;
import com.example.dbcoursefinalproject.entity.Crew;
import com.example.dbcoursefinalproject.entity.Film;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FilmMapper {

    @Select("SELECT * FROM films WHERE MATCH(title) AGAINST(#{title} IN BOOLEAN MODE)")
    public List<Film> findFilmByTitle(String title);

    @Select("SELECT * FROM films WHERE workId = #{id} and ordering = #{ordering}")
    public Film findFilmById(String id,String ordering);


//    @Select(("select * from films where numberofGraders>#{minRatingNum} and ordering=1 order by rating limit #{limit}"))
//    public List<Film> getTopRatedFilmForHome(int minRatingNum,int limit);

    @Select("select * from films where rating>8.0 and ordering='1' order by numberOfGraders DESC limit 9")
    public List<Film> getTopRatedFilmForHome();

    @Select("select * from films where rating>8.0 and ordering='1' and type LIKE CONCAT('%',#{type},'%') order by numberOfGraders DESC limit 100")
    public List<Film> getTopRatedFilmForType(String type);

    @Select("select * from films where rating>8.0 and ordering='1' and type LIKE CONCAT('%',#{type},'%') order by startYear DESC limit 100")
    public List<Film> getLatestFilmForType(String type);

    @Select("select * from workIn where workId = #{id}")
    public List<Crew> getCrewsByFilmId(String id);

    @Select("select * from comments where filmId = #{id}")
    public List<Comment> getCommentsByFilmId(String id);
}
