package com.github.manager.service;

import java.util.List;

import com.github.manager.entity.City;

/**
 * 城市业务逻辑接口类
 *
 * @author colg
 */
public interface CityService {

	/**
	 * 获取城市信息列表
	 *
	 * @return
	 */
	List<City> findAllCity();

	/**
	 * 根据城市 ID,查询城市信息
	 *
	 * @param id
	 * @return
	 */
	City findCityById(Integer id);

	/**
	 * 新增城市信息
	 *
	 * @param city
	 * @return
	 */
	Integer saveCity(City city);

	/**
	 * 更新城市信息
	 *
	 * @param city
	 * @return
	 */
	Integer updateCity(City city);

	/**
	 * 根据城市 ID,删除城市信息
	 *
	 * @param id
	 * @return
	 */
	Integer deleteCity(Integer id);
}
