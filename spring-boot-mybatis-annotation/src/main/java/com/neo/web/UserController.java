package com.neo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.neo.entity.UserEntity;
import com.neo.mapper.UserMapper;

@RestController
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value="/getUsers",method = RequestMethod.GET)
	public List<UserEntity> getUsers() {
		List<UserEntity> users=userMapper.getAll();
		return users;
	}
	
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public UserEntity getUser(Long id) {
    	UserEntity user=userMapper.getOne(id);
        return user;
    }
    
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void save(@RequestBody UserEntity user) {
    	userMapper.insert(user);
    }
    
    @RequestMapping(value="update",method = RequestMethod.PUT)
    public void update(UserEntity user) {
    	userMapper.update(user);
    }
    
    @RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	userMapper.delete(id);
    }
    
    
}