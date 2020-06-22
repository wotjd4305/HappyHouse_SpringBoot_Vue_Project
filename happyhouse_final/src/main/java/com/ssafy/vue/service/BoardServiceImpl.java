package com.ssafy.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vue.dao.BoardDAO;
import com.ssafy.vue.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
    @Autowired
	private BoardDAO boardDao;

    @Override
	public List<Board> retrieveBoard() {
		return boardDao.selectBoard();
	}

	@Override
	public List<Board> selectBoardBySearchWord(String searchword) {
		return boardDao.selectBoardBySearchWord(searchword);
	}

  	@Override
	public boolean writeBoard(Board board) {
		return boardDao.insertBoard(board) == 1;
	}

	@Override
	public Board detailBoard(int no) {
		return boardDao.selectBoardByNo(no);
	}

	@Override
	@Transactional
	public boolean updateBoard(Board board) {
		return boardDao.updateBoard(board) == 1;
	}

	@Override
	@Transactional
	public boolean deleteBoard(int no) {
		return boardDao.deleteBoard(no) == 1;
	}

}