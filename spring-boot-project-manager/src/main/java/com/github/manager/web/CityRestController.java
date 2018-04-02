package com.github.manager.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.manager.entity.City;
import com.github.manager.service.CityService;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 *
 * @author colg
 */
@RestController
public class CityRestController {

	@Autowired
	private CityService cityService;

	@GetMapping("/api/city/{id}")
	public City findOneCity(@PathVariable("id") Integer id) {
		return cityService.findCityById(id);
	}

	@GetMapping("/api/city")
	public List<City> findAllCity() {
		return cityService.findAllCity();
	}

	@PostMapping("/api/city")
	public void createCity(@RequestBody City city) {
		cityService.saveCity(city);
	}

	@PutMapping("/api/city")
	public void modifyCity(@RequestBody City city) {
		cityService.updateCity(city);
	}

	@DeleteMapping("/api/city/{id}")
	public void modifyCity(@PathVariable("id") Integer id) {
		cityService.deleteCity(id);
	}
}
