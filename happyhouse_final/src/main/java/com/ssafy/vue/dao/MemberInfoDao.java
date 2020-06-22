package com.ssafy.vue.dao;

import java.util.List;

import com.ssafy.vue.dto.MemberInfo;
import com.ssafy.vue.dto.MemberLoginDTO;
import com.ssafy.vue.dto.MemberfindPassDTO;

public interface MemberInfoDao {
	
	public List<MemberInfo> list();

	public int delete(String id);

	public int regist(MemberInfo memberInfo);

	public int update(MemberInfo memberInfo);

	public MemberInfo login(MemberLoginDTO memberLoginDTO);
	
	public MemberInfo findPass(MemberfindPassDTO memberfindPassDTO);

	public MemberInfo findById(String id);
	
}
