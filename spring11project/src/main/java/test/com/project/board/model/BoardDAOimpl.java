package test.com.project.board.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BoardDAOimpl implements BoardDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public BoardDAOimpl() {
		log.info("BoardDAOimpl....");
	}

	@Override
	public int insert(BoardVO vo) {
		log.info("insert()....{}",vo);
		return sqlSession.insert("B_INSERT",vo);
	}

	@Override
	public int update(BoardVO vo) {
		log.info("update()....{}",vo);
		return sqlSession.update("B_UPDATE",vo);
	}

	@Override
	public int delete(BoardVO vo) {
		log.info("delete()....{}",vo);
		return sqlSession.delete("B_DELETE",vo);
	}

	@Override
	public List<BoardVO> selectAll() {
		log.info("selectAll()....");
		return sqlSession.selectList("B_SELECT_ALL");
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		log.info("selectOne()....{}",vo);
		
		return sqlSession.selectOne("B_SELECT_ONE",vo);
	}

	@Override
	public List<BoardVO> searchList(String searchKey, String searchWord) {
		log.info("searchList()....searchKey:{}",searchKey);
		log.info("searchList()....searchWord:{}",searchWord);
		String key = "";
		if(searchKey.equals("title")) {
			key = "B_SEARCH_LIST_TITLE";
		}else if(searchKey.equals("content")) {
			key = "B_SEARCH_LIST_CONTENT";
			
		}else {
			key = "B_SEARCH_LIST_WRITER";
			
		}
		return sqlSession.selectList(key,"%"+searchWord+"%");
	}

	@Override
	public void vcountUp(BoardVO vo) {
		log.info("vcountUp()....{}",vo);
		sqlSession.update("B_VCOUNT_UP",vo);
	}

}
