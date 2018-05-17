package server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import elders.Elder;
import server.service.ElderService;

@RestController
public class ApplicationController 
{
	@Autowired
	private ElderService services;
	
	@RequestMapping("/elders")
	public List<Elder> getElders()
	{
		return services.getElders();
	}
	@RequestMapping("/elders/{id}")
	public Elder getElderByID(@PathVariable int id)
	{
		return services.getElderByRoomNumber(id);
	}
	@RequestMapping(method=RequestMethod.DELETE , value = "/elders/{id}/{message}")
	public void deleteMessage(@PathVariable int id, @PathVariable String message)
	{
		List<Elder> e = services.getElders();
		e.remove(message);
	}

}
