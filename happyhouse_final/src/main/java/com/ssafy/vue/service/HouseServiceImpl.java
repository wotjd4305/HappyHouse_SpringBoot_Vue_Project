package com.ssafy.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.dao.HouseDao;
import com.ssafy.vue.dto.HouseDeal;

@Service
public class HouseServiceImpl implements HouseService{

	@Autowired
	HouseDao dao;


	@Override
	public List<HouseDeal> searchAllDealinfo() {
		return dao.searchAllDealinfo();
	}


	@Override
	public List<HouseDeal> selectDetail(String key, String word) {
		System.out.println("houseServiceImpl - " + key +","+ word);
		return dao.selectDetail(key,word);
	}


	@Override
	public HouseDeal search(String no) {
		// TODO Auto-generated method stub
		return dao.search(no);
	}

	

}
