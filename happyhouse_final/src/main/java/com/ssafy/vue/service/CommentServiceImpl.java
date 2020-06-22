package com.ssafy.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vue.dao.BoardDAO;
import com.ssafy.vue.dao.CommentDAO;
import com.ssafy.vue.dto.Board;
import com.ssafy.vue.dto.Comment;

@Service
public class CommentServiceImpl implements CommentService {
	
    @Autowired
	private CommentDAO commentDAO;

	@Override
	public List<Comment> selectComment(int no) {
		return commentDAO.selectComment(no);
	}

	@Override
	public int insertComment(Comment comment) {
		return commentDAO.insertComment(comment);
	}



}