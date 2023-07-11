package test.com.project.reservation.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ReservationDAOimpl implements ReservationDAO {

	@Autowired
	SqlSession sqlSession;

	public ReservationDAOimpl() {
		log.info("ReservationDAOimpl()...");
	}

	@Override
	public List<ReservationVO> selectAll(ReservationVO vo) {
		log.info("selectAll()....{}", vo);

		return sqlSession.selectList("R_SELECT_ALL",vo);
	}

	@Override
	public ReservationVO selectOne(ReservationVO vo) {
		log.info("selectOne()...{}", vo);

		return sqlSession.selectOne("R_SELECT_ONE", vo);
	}

	@Override
	public int insert(ReservationVO vo) {
		log.info("insert()...{}", vo);

		return sqlSession.insert("R_INSERT", vo);
	}

	@Override
	public int update(ReservationVO vo) {
		log.info("update()...{}", vo);

		return sqlSession.update("R_UPDATE", vo);
	}

	@Override
	public int delete(ReservationVO vo) {
		log.info("delete()...{}", vo);

		return sqlSession.delete("R_DELETE", vo);
	}

	@Override
	public List<ReservationVO> searchList(String user_id,String searchKey, String searchWord) {
		log.info("searchList()...user_id:{}", user_id);
		log.info("searchList()...searchKey:{}", searchKey);
		log.info("searchList()...searchWord:{}", searchWord);

		String key = "";
		if (searchKey.equals("title")) {
			key = "R_SEARCH_LIST_TITLE";
		} else {
			key = "R_SEARCH_LIST_MOVIE_DATE";
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchWord", "%" + searchWord + "%");
		map.put("user_id", user_id);

		return sqlSession.selectList(key, map);
	}

}
