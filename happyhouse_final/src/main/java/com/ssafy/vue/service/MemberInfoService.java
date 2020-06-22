package com.ssafy.vue.service;

import java.util.List;

import com.ssafy.vue.dto.MemberInfo;
import com.ssafy.vue.dto.MemberLoginDTO;
import com.ssafy.vue.dto.MemberfindPassDTO;

public interface MemberInfoService {

	public List<MemberInfo> list();//조회
	public boolean delete(String id);//삭제
	public boolean regist(MemberInfo memberInfo);//등록
	public boolean update(MemberInfo memberInfo);//수정
	public MemberInfo login(MemberLoginDTO memberLoginDTO);//로그인
	public MemberInfo findPass(MemberfindPassDTO memberfindPassDTO);//비번찾기
	public MemberInfo findById(String id);//id로 찾기
	
	
	
}
