package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Resp;
import com.entity.User;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping
	Resp hello(byte id){
		System.out.println(id);
		List<User> list = new ArrayList<>();
		list.add(new User(1, "tom"));
		list.add(new User(2, "jerry"));
		Resp resp = new Resp(1,"ok",list);
		return resp;
	}
	@GetMapping("/hi")
	Resp hello1(int id,String name,String pwd){
		User user = new User(id, name);
		System.out.println(user);
		Resp resp = new Resp(1,"ok",user);
		return resp;
	}

	@GetMapping("/{id}")//:id req.param req.body 
	Resp hello2(@PathVariable int id){
		System.out.println(id);
		Resp resp = new Resp(1,"ok",id+"");
		return resp;
	}
	
}
