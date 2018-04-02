package com.github.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.manager.dao.CityMapper;
import com.github.manager.entity.City;
import com.github.manager.service.CityService;
import com.github.pagehelper.PageHelper;

/**
 * 城市业务逻辑实现类
 *
 * @author colg
 */
@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityMapper cityMapper;

	public List<City> findAllCity() {
		PageHelper.startPage(0, 10);
		return cityMapper.selectAll();
	}

	public City findCityById(Integer id) {
		return cityMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer saveCity(City city) {
		return cityMapper.insertSelective(city);
	}

	@Override
	public Integer updateCity(City city) {
		return cityMapper.updateByPrimaryKeySelective(city);
	}

	@Override
	public Integer deleteCity(Integer id) {
		return cityMapper.deleteByPrimaryKey(id);
	}

}
