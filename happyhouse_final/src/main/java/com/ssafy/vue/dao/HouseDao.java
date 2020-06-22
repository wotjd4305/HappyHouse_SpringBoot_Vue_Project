package com.ssafy.vue.dao;

import java.util.List;

import com.ssafy.vue.dto.HouseDeal;

public interface HouseDao {
	public List<HouseDeal> searchAllDealinfo();

	public List<HouseDeal> selectDetail(String key, String word);
	public HouseDeal search(String no);
	
}
