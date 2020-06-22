package com.ssafy.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vue.dao.QnADAO;
import com.ssafy.vue.dto.QnADTO;

@Service
public class QnAServiceImpl implements QnAService {
	
    @Autowired
	private QnADAO qnADAO;

    @Override
	public List<QnADTO> retrieveQnA() {
		return qnADAO.selectQnA();
	}

  	@Override
	public boolean writeQnA(QnADTO board) {
		return qnADAO.insertQnA(board) == 1;
	}

	@Override
	public QnADTO detailQnA(int no) {
		return qnADAO.selectQnAByNo(no);
	}

	@Override
	@Transactional
	public boolean updateQnA(QnADTO board) {
		return qnADAO.updateQnA(board) == 1;
	}

	@Override
	@Transactional
	public boolean deleteQnA(int no) {
		return qnADAO.deleteQnA(no) == 1;
	}

}