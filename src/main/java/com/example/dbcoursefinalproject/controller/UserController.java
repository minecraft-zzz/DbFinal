package com.example.dbcoursefinalproject.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.dbcoursefinalproject.entity.Comment;
import com.example.dbcoursefinalproject.entity.User;
import com.example.dbcoursefinalproject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/api/user/regist")
    public JSONObject regist(User user){
        JSONObject ret = new JSONObject();
        try{
            User existUser = userMapper.findUserByName(user.getUserName());
            System.out.println(user);
            if(existUser != null){
                ret.put("msg","用户名已存在");
                ret.put("status","fail");
            }
            else{
                userMapper.regist(user);
                ret.put("msg","注册成功");
                ret.put("status","success");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ret;
    }

    @PostMapping("/api/user/login")
    public JSONObject login(String username,String password){
        JSONObject ret = new JSONObject();
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        try{
            User retUser = userMapper.login(user);
            if(retUser == null){
                ret.put("msg","用户名或密码错误");
                ret.put("status","fail");
            }
            else{
                ret.put("msg","登录成功");
                ret.put("status","success");
                ret.put("info",retUser);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ret;
    }

    @PostMapping("/api/user/comment")
    public JSONObject comment(Comment comment){
        JSONObject ret = new JSONObject();
        try{
            userMapper.comment(comment);
        } catch (Exception e){
            ret.put("status","fail");
            return ret;
        }
        ret.put("status","success");
        return ret;
    }

    @PostMapping("/api/user/collect")
    public String collect(String userId,String filmId){
        try {
            userMapper.collect(userId,filmId);
        }catch (Exception e){
            return "fail";
        }
        return "success";
    }

    @PostMapping("/api/user/deleteCollect")
    public String deleteCollect(String userId,String filmId){
        try {
            userMapper.deleteCollect(userId,filmId);
        }catch (Exception e){
            return "fail";
        }
        return "success";
    }
}

