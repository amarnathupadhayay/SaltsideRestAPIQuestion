package com.saltside.coding.excercise.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.saltside.coding.excercise.controller.exception.BadRequestException;
import com.saltside.coding.excercise.controller.exception.BirdNotFoundException;
import com.saltside.coding.excercise.db.Bird;
import com.saltside.coding.excercise.repository.BirdRepository;

/**
 * Expose Restful API for CRUD operation of db Object {@link com.saltside.coding.excercise.db.Bird}
 * 
 * @author amarnath
 *
 */

@RestController
@RequestMapping("/birds")
public class BirdController {
	
	@Autowired
	private BirdRepository birdRepository;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Bird saveBirdsMetaData(@RequestBody Bird bird, HttpServletResponse response) {
    
	    if (BirdUtils.isBadRequest(bird)) {
	    	throw new BadRequestException();
	    }
	    bird = BirdUtils.getBird(bird);
	    final Bird responseObj = birdRepository.save(bird);
	    response.setStatus(HttpServletResponse.SC_CREATED);
		return responseObj;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public @ResponseBody Bird getBirdById(@PathVariable("id") String id, HttpServletResponse response) {    
	    
		final Bird bird = birdRepository.findOne(id);
		if (bird == null) {
			throw new BirdNotFoundException();
		}
		response.setStatus(HttpServletResponse.SC_OK);
		return bird;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Bird> getBirds(HttpServletResponse response) {    
	    
		final List<Bird> birds = birdRepository.findAll();
		response.setStatus(HttpServletResponse.SC_OK);
		return birds;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public void deleteBirdById(@PathVariable("id") String id, HttpServletResponse response) {
    
		final Bird bird = birdRepository.findOne(id);
		if (bird == null) {
			throw new BirdNotFoundException();
		}		
		birdRepository.delete(bird);
		response.setStatus(HttpServletResponse.SC_OK);
	}
	
	

}
