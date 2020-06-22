package com.ssafy.vue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.dto.QnADTO;
@Mapper
public interface QnADAO {
	public List<QnADTO> selectQnA();
	public QnADTO selectQnAByNo(int no);
	public int insertQnA(QnADTO board);
	public int updateQnA(QnADTO board);
	public int deleteQnA(int no);
}
