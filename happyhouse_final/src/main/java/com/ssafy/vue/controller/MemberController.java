package com.ssafy.vue.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.dto.Board;
import com.ssafy.vue.dto.MemberInfo;
import com.ssafy.vue.dto.MemberLoginDTO;
import com.ssafy.vue.dto.MemberfindPassDTO;
import com.ssafy.vue.service.MemberInfoService;

import io.swagger.annotations.ApiOperation;
//http://localhost:9999/vue/swagger-ui.html

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private MemberInfoService service;
	
	//회원정보조회	
	@ApiOperation(value = "모든 회원의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<MemberInfo>> list() throws Exception {
		logger.debug("list - 호출");
		return new ResponseEntity<List<MemberInfo>>(service.list(), HttpStatus.OK);
	}
		
	//회원정보삭제
	 @ApiOperation(value = "회원번호에 해당하는 회원 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	 @DeleteMapping("{id}")
	 public ResponseEntity<String> delete(@PathVariable String id) {
	 	logger.debug("delete - 호출");
	 	if (service.delete(id)) {
			 return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	 	}
		 return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	 }
	
	//회원가입
	  @ApiOperation(value = "새로운 회원 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	  @PostMapping
	  public ResponseEntity<String> regist(@RequestBody MemberInfo memberInfo) {
		logger.debug("regist - 호출");
	 	if (service.regist(memberInfo)) {
		 	return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	 	}
		 return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	 }
	  
	  //회원정보 수정
	    @ApiOperation(value = "회원아이디에 해당하는 회원 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
		@PutMapping("")
		public ResponseEntity<String> update(@RequestBody MemberInfo memberInfo) {
			logger.debug("update - 호출");
			logger.debug("" + memberInfo);
			
			if (service.update(memberInfo)) {
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			}
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}  
	  
	  
	  
	  
	    
	    @ApiOperation(value = "사용자의 로그인 정보.", response = MemberInfo.class)    
	  	@PostMapping("/login")
	  	public ResponseEntity<MemberInfo> listComment(@RequestBody MemberLoginDTO memberLoginDTO) {
	  		logger.debug("memberLogin - 호출");
	  		MemberInfo dto =  service.login(memberLoginDTO);
	  		if(dto == null) {
	  			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	  		}
	  		 return new ResponseEntity<>(dto, HttpStatus.OK);
	  	}
	    
	    
	    
	    @ApiOperation(value = "사용자의 비밀번호 찾기(아이디,이름,주소로 찾기)", response = MemberInfo.class)    
	  	@PostMapping("/findPass")
	  	public ResponseEntity<MemberInfo> MememberfindPass(@RequestBody MemberfindPassDTO memberfindPassDTO) {
	  		logger.debug("memberfindBy - 호출");
	  		MemberInfo dto =  service.findPass(memberfindPassDTO);
	  		if(dto == null) {
	  			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	  		}
	  		 return new ResponseEntity<>(dto, HttpStatus.OK);
	  	}
	    
	    //id로 회원정보조회	
		@ApiOperation(value = "id로 회원의 정보를 반환한다.", response = MemberInfo.class)
		@GetMapping("{id}")
		public ResponseEntity<MemberInfo> MememberfindId(@PathVariable String id) throws Exception {
			logger.debug("memberfindById - 호출");
			return new ResponseEntity<MemberInfo>(service.findById(id), HttpStatus.OK);
		}
	    
	  
	  
	  
	  
	
}
