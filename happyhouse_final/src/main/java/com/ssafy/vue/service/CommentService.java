package com.ssafy.vue.service;

import java.util.List;

import com.ssafy.vue.dto.Board;
import com.ssafy.vue.dto.Comment;

public interface CommentService {
	public List<Comment> selectComment(int no);
	public int insertComment(Comment comment);
}
