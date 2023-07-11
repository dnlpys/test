package test.com.project.movie.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MovieDAOimpl implements MovieDAO {

	@Autowired
	SqlSession sqlSession;

	public MovieDAOimpl() {
		log.info("MovieDAOimpl()...");
	}

	@Override
	public List<MovieVO> selectAll() {
		log.info("selectAll()...");

		return sqlSession.selectList("MV_SELECT_ALL");
	}

	@Override
	public MovieVO selectOne(MovieVO vo) {
		log.info("selectOne()...{}", vo);

		return sqlSession.selectOne("MV_SELECT_ONE", vo);
	}

	@Override
	public int insert(MovieVO vo) {
		log.info("insert()...{}", vo);

		return sqlSession.insert("MV_INSERT", vo);
	}

	@Override
	public int update(MovieVO vo) {
		log.info("update()...{}", vo);

		return sqlSession.update("MV_UPDATE", vo);
	}
	
	@Override
	public int delete(MovieVO vo) {
		log.info("delete()...{}", vo);

		return sqlSession.delete("MV_DELETE", vo);
	}


	@Override
	public List<MovieVO> searchList(String searchKey, String searchWord) {
		log.info("searchList()...searchKey:{}", searchKey);
		log.info("searchList()...searchWord:{}", searchWord);
		
		String key = "";
		if(searchKey.equals("title")) {
			key = "MV_SEARCH_LIST_TITLE";
		}else {
			key = "MV_SEARCH_LIST_PRODUCER";
		}
		
		return sqlSession.selectList(key,"%"+searchWord+"%");
	}

}
