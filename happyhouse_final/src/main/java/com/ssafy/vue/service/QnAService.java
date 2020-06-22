package com.ssafy.vue.service;

import java.util.List;

import com.ssafy.vue.dto.Board;
import com.ssafy.vue.dto.QnADTO;

public interface QnAService {
	public List<QnADTO> retrieveQnA();
	public QnADTO detailQnA(int no);
	public boolean writeQnA(QnADTO board);
	public boolean updateQnA(QnADTO board);
	public boolean deleteQnA(int no);
}
