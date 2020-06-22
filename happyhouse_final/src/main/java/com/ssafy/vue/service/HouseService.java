package com.ssafy.vue.service;

import java.util.List;

import com.ssafy.vue.dto.HouseDeal;

public interface HouseService {
	public List<HouseDeal> searchAllDealinfo();

	public List<HouseDeal> selectDetail(String key, String word);
	
	public HouseDeal search(String no);
	

}
