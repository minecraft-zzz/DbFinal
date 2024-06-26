package com.example.dbcoursefinalproject.mapper;


import com.example.dbcoursefinalproject.entity.Comment;
import com.example.dbcoursefinalproject.entity.Crew;
import com.example.dbcoursefinalproject.entity.Film;
import org.apache.ibatis.annotations.*;

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

    @Select("select * from films where rating>8.0 and ordering='1' order by numberOfGraders DESC limit #{n}")
    public List<Film> getTopRatedFilmWithNumebr(int n);

    @Select("select * from films where rating>8.0 and ordering='1' and type LIKE CONCAT('%',#{type},'%') order by numberOfGraders DESC limit 100")
    public List<Film> getTopRatedFilmForType(String type);

    @Select("select * from films where rating>8.0 and ordering='1' and type LIKE CONCAT('%',#{type},'%') order by startYear DESC limit 100")
    public List<Film> getLatestFilmForType(String type);

    @Select("select * from workIn where workId = #{id}")
    public List<Crew> getCrewsByFilmId(String id);

    @Select("select * from comments where filmId = #{id}")
    public List<Comment> getCommentsByFilmId(String id);

    @Select("SELECT * FROM  films WHERE MATCH(title) AGAINST(#{name} IN BOOLEAN MODE) AND startYear BETWEEN #{startYear} AND #{endYear} AND type like CONCAT('%',#{type},'%')  AND region like CONCAT('%',#{region},'%') ORDER BY rating DESC,numberOfGraders DESC LIMIT 100")
    public List<Film> advanceSearch(String name,int startYear,int endYear,String type,String region);

    @Update({
            "<script>",
            "UPDATE films",
            "SET",
            "<if test='title != null'>title = #{title},</if>",
            "<if test='region != null'>region = #{region},</if>",
            "<if test='language != null'>language = #{language},</if>",
            "<if test='type != null'>type = #{type},</if>",
            "<if test='startYear != 0'>startYear = #{startYear},</if>",
            "<if test='runtimeMinutes != 0'>runtimeMinutes = #{runtimeMinutes},</if>",
            "<if test='genres != null'>genres = #{genres},</if>",
            "<if test='url != null'>url = #{url},</if>",
            "<if test='rating != 0.0f'>rating = #{rating},</if>",
            "<if test='filmImg != null'>filmImg = #{filmImg},</if>",
            "<if test='isAdult != 0'>isAdult = #{isAdult},</if>",
            "<if test='numberOfGraders != 0'>numberOfGraders = #{numberOfGraders},</if>",
            "ordering = #{ordering}",
            "WHERE workId = #{workId} AND ordering = #{ordering}",
            "</script>"
    })
    void updateFilm(Film film);

    @Select("select * from films where title = #{title} and ordering = '1'")
    public Film getExactFilmByName(String title);

    @Select("select max(workId) from films")
    public String findMaxWorkId();

    @Select("select max(ordering) from films where workId = #{workId}")
    public String findMaxOrdering(String workId);

    @Insert("INSERT INTO films (workId, ordering, title, region, language, type, startYear, runtimeMinutes, genres, url, rating, filmImg, isAdult, numberOfGraders) " +
            "VALUES (#{workId}, #{ordering}, #{title}, #{region}, #{language}, NULL, #{startYear}, NULL, NULL, NULL, NULL, NULL, NULL, NULL)")
    public void insertFilm(Film film);

    @Delete("delete from films where workId = #{workId} and ordering = #{ordering}")
    public void deleteFilm(Film film);
}
