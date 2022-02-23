package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@GetMapping(path="/{userID}")
	public String getUsers(@PathVariable String userID)
	{
		return "http GET request was sent for userID: "+userID;
	}
	
	@GetMapping
	public String getUsers(@RequestParam(value="page")int pageNo,@RequestParam(value="limit") int limitno)
	{
		return "http GET request was sent for page: "+pageNo+ "and limit:"+limitno;
	}
	
	@PostMapping
	public String createUsers()
	{
		return "http POST request was sent";
	}
	
	@PutMapping
	public String updateUsers()
	{
		return "http PUT request was sent";
	}
	
	
	@DeleteMapping
	public String deleteUsers()
	{
		return "http DELETE request was sent";
	}

}
