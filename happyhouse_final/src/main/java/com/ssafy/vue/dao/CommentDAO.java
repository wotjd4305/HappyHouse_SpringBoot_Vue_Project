package com.ssafy.vue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.dto.Comment;

@Mapper
public interface CommentDAO {
	public List<Comment> selectComment(int no);
	public int insertComment(Comment comment);
}
