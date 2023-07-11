package test.com.project.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import test.com.project.movie.model.MovieDAO;
import test.com.project.movie.model.MovieVO;
import test.com.project.reservation.model.ReservationDAO;
import test.com.project.reservation.model.ReservationVO;

@Slf4j
@Service
public class ReservationService {

	@Autowired
	ReservationDAO dao;

	public List<ReservationVO> selectAll(ReservationVO vo) {
		return dao.selectAll(vo);
	}

	public ReservationVO selectOne(ReservationVO vo) {
		return dao.selectOne(vo);
	}

	public int insert(ReservationVO vo) {
		return dao.insert(vo);
	}

	public int update(ReservationVO vo) {
		return dao.update(vo);
	}

	public int delete(ReservationVO vo) {
		return dao.delete(vo);
	}

	public List<ReservationVO> searchList(String user_id,String searchKey, String searchWord) {
		return dao.searchList(user_id,searchKey, searchWord);
	}

}
