package com.myxiaowang.neo4j.controller;

import com.myxiaowang.neo4j.aop.annotation.PageAnnotation;
import com.myxiaowang.neo4j.entity.User;
import com.myxiaowang.neo4j.entity.requset.RequestDto;
import com.myxiaowang.neo4j.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年05月23日 14:32:00
 */

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @DeleteMapping("/deleteRelaShipRep/{userId}/{roleId}")
    public User deleteUserRelationByRep(@PathVariable String roleId, @PathVariable String userId){
        return userService.deleteUserRelationByRep(roleId,userId);
    }

    @DeleteMapping("/deleteRelaShip/{userId}/{roleId}")
    public User deleteUserRelation(@PathVariable String roleId, @PathVariable String userId){
        return userService.deleteUserRelation(roleId,userId);
    }


    @GetMapping("/addRelaShip/{userId}/{roleId}")
    public User addRelaShip(@PathVariable String roleId, @PathVariable String userId){
        return userService.addRelaShip(roleId,userId);
    }



    @PostMapping("/userPage")
    @PageAnnotation
    public Page<User> selectUserPage(@RequestBody  RequestDto requestDto){
        return userService.userByPage(requestDto);
    }



    @DeleteMapping("/batchDeleteUser")
    public List<User> deleteUsers(){
        return userService.deleteBatchUsers();
    }

    @GetMapping("/list")
    public List<User> getListUser(){
        return userService.listUser();
    }

    @PostMapping("/updateUser")
    public User updateUserById(@RequestBody User user){
        return userService.updateUser(user);
    }

    @GetMapping("/userById/{id}")
    public User userById(@PathVariable String id){
      return userService.findUserById(id);
    }


    @PostMapping("/insert")
    public User insertUser(@RequestBody User user){
      return userService.insertUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public User deleteUserById(@PathVariable String id)
    {
        return userService.deleteUserById(id);
    }
}
