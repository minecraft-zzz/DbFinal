package com.example.dbcoursefinalproject.mapper;

import com.example.dbcoursefinalproject.entity.Comment;
import com.example.dbcoursefinalproject.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from users where userName = #{username}")
    public User findUserByName(String username);

    @Insert("insert into users values(#{userId},#{userName},#{phoneNumber},#{email},#{password},#{isMuzzled},#{userIntroduction},#{userImg},#{administrator})")
    public void regist(User user);

    @Select("select * from users where username = #{username} and password = #{password}")
    public User login(User user);

    @Insert("insert into comments values(#{commentId},#{userId},#{filmId},#{content})")
    public void comment(Comment comment);

    @Insert("insert into favourites values(#{userId},#{filmId})")
    public void collect(String userId,String filmId);

    @Delete("delete from favourites where userId = #{userId} and filmId = #{filmId}")
    public void deleteCollect(String userId,String filmId);
}
