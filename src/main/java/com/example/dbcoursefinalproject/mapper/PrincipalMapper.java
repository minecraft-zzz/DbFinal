package com.example.dbcoursefinalproject.mapper;

import com.example.dbcoursefinalproject.entity.Principal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PrincipalMapper {
    @Select("select * from principals where personId = #{id}")
    public Principal getPrincipalById(String id);
}
