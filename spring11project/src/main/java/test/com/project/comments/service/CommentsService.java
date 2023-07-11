package test.com.project.comments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.project.comments.model.CommentsDAO;
import test.com.project.comments.model.CommentsVO;

@Service
public class CommentsService {

	@Autowired
	CommentsDAO dao;

	public int insert(CommentsVO vo) {
		return dao.insert(vo);
	}

	public int update(CommentsVO vo) {
		return dao.update(vo);
	}

	public int delete(CommentsVO vo) {
		return dao.delete(vo);
	}

	public List<CommentsVO> selectAll(CommentsVO vo) {
		return dao.selectAll(vo);
	}

}
