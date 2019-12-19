package com.zb.user.service;

import java.util.List;

import com.zb.pojo.Comment;
import com.zb.user.dao.CommentDao;
import com.zb.vo.CommentVo;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;

public class CommentService {
	CommentDao commentDao=new CommentDao();

	public void add(Comment comment) {
		comment.setCoid(IdUtil.simpleUUID());
		commentDao.add(comment);		
	}

	public List<CommentVo> list() {
		
		return (List<CommentVo>) commentDao.findAll();
	}

	public List<CommentVo> listByPid(String pid) {
		return commentDao.findAllByPid(pid);
	}

}
