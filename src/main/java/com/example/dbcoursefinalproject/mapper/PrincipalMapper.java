package com.example.dbcoursefinalproject.mapper;

import com.example.dbcoursefinalproject.entity.Principal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PrincipalMapper {
    @Select("select * from principals where personId = #{id}")
    public Principal getPrincipalById(String id);

    @Select("select * from principals where match(name) against(#{name} in NATURAL LANGUAGE MODE) order by birthYear DESC limit 100")
    public List<Principal> getPrincipalsByName(String name);
}
