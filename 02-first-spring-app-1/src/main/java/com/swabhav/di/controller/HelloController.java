package com.swabhav.di.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("health")
	public String gethealth() {
		return "I am alive";
	}
	
	@GetMapping("hello/{name}")
	public String sayHello(@PathVariable String name) {
		return "hello, " + name;
	}	
	
	@GetMapping("version/{id:[0-9]+}/check")
	public String checkVersion(@PathVariable int version) {
		return "version is live";
	}
	
	@PostMapping("post")
	public String post(@RequestBody String body) {
		return body;
	}
}
