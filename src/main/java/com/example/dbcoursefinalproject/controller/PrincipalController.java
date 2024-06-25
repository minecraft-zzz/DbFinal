package com.example.dbcoursefinalproject.controller;

import com.example.dbcoursefinalproject.entity.Principal;
import com.example.dbcoursefinalproject.mapper.PrincipalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrincipalController {
    @Autowired
    private PrincipalMapper principalMapper;

    @GetMapping("/api/principal/getInfoById")
    public Principal getPersonInfoById(@RequestParam String id){
        return principalMapper.getPrincipalById(id);
    }

    @GetMapping("/api/principal/getInfoByname")
    public List<Principal> getInfoByName(@RequestParam String name){
        return principalMapper.getPrincipalsByName(name);
    }

}
