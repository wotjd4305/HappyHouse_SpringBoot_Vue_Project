package com.ssafy.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.dao.MemberInfoDao;
import com.ssafy.vue.dto.MemberInfo;
import com.ssafy.vue.dto.MemberLoginDTO;
import com.ssafy.vue.dto.MemberfindPassDTO;

@Service
public class MemberInfoServiceImpl implements MemberInfoService {

	@Autowired
	private MemberInfoDao dao;


	@Override
	public List<MemberInfo> list() {
		return dao.list();
	}
	
	@Override
	public boolean delete(String id) {
		return dao.delete(id)==1;
		
	}

	@Override
	public boolean regist(MemberInfo memberInfo) {
		return dao.regist(memberInfo) == 1;
	}

	@Override
	public boolean update(MemberInfo memberInfo) {
		return dao.update(memberInfo) ==1;
	}



	@Override
	public MemberInfo login(MemberLoginDTO memberLoginDTO) {
		return dao.login(memberLoginDTO);
	}

	@Override
	public MemberInfo findPass(MemberfindPassDTO memberfindPassDTO) {
		return dao.findPass(memberfindPassDTO);
	}

	@Override
	public MemberInfo findById(String id) {
		return dao.findById(id);
	}



}
