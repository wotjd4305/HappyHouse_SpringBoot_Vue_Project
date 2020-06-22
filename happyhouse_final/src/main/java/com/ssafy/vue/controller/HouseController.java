package com.ssafy.vue.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.dto.Board;
import com.ssafy.vue.dto.HouseDeal;
import com.ssafy.vue.service.HouseService;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/vue/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/house")
public class HouseController {
	
	private static final Logger logger = LoggerFactory.getLogger(HouseController.class);
	//private static final String SUCCESS = "success";
	//private static final String FAIL = "fail";

	 @Autowired
	   private HouseService service;
	 
	    @ApiOperation(value = "모든 아파트 정보를 반환한다.", response = List.class)
		@GetMapping
		public ResponseEntity<List<HouseDeal>> searchAllDealinfo() throws Exception {
			logger.debug("searchAllDealinfo - 호출");
			return new ResponseEntity<List<HouseDeal>>(service.searchAllDealinfo(), HttpStatus.OK);
		}
	    

	    @ApiOperation(value = "아파트번호에 해당하는 아파트의 정보를 반환한다.", response = List.class)    
		@GetMapping("{key}/{word}")
		public ResponseEntity<List<HouseDeal>> detail(@PathVariable("key") String key,@PathVariable("word") String word) {
			logger.debug("detail - 호출");
			return new ResponseEntity<List<HouseDeal>>(service.selectDetail(key,word), HttpStatus.OK);
		}
	    
	    @ApiOperation(value = "번호에 맞는 아파트 정보를 반환한다.", response = HouseDeal.class)
	    @GetMapping("{no}")
	  		public ResponseEntity<HouseDeal> search(@PathVariable("no") String no) throws Exception {
	  			logger.debug("searchByName - 호출");
	  			return new ResponseEntity<HouseDeal>(service.search(no), HttpStatus.OK);
	  		}

}
