package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")
public class HelloWorldController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World";
	}
	
	@RequestMapping(path = "hello/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String sayHelloWithParam(@PathVariable("name") String name) {
		return "hello " + name;
	}
}