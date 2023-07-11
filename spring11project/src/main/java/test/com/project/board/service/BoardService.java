package test.com.project.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import test.com.project.board.model.BoardDAO;
import test.com.project.board.model.BoardVO;

@Slf4j
@Service
public class BoardService {

	@Autowired
	BoardDAO dao;

	public BoardService() {
		log.info("BoardService...");
	}

	public int insert(BoardVO vo) {
		return dao.insert(vo);
	}

	public int update(BoardVO vo) {
		return dao.update(vo);
	}

	public int delete(BoardVO vo) {
		return dao.delete(vo);
	}

	public List<BoardVO> selectAll() {
		return dao.selectAll();
	}

	public BoardVO selectOne(BoardVO vo) {
		return dao.selectOne(vo);
	}

	public List<BoardVO> searchList(String searchKey, String searchWord) {
		return dao.searchList(searchKey, searchWord);
	}

	public void vcountUp(BoardVO vo) {
		dao.vcountUp(vo);
	}

}
