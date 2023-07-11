package test.com.project.comments.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CommentsDAOimpl implements CommentsDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insert(CommentsVO vo) {
		log.info("insert()...{}",vo);
		return sqlSession.update("C_INSERT",vo);
	}

	@Override
	public int update(CommentsVO vo) {
		log.info("update()...{}",vo);
		return sqlSession.update("C_UPDATE",vo);
	}

	@Override
	public int delete(CommentsVO vo) {
		log.info("delete()...{}",vo);
		return sqlSession.delete("C_DELETE",vo);
	}

	@Override
	public List<CommentsVO> selectAll(CommentsVO vo) {
		log.info("selectAll()...{}",vo);
		return sqlSession.selectList("C_SELECT_ALL", vo);
	}

}
