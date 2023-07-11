package test.com.project.reservation.model;

import java.util.List;

public interface ReservationDAO {

	List<ReservationVO> selectAll(ReservationVO vo);

	ReservationVO selectOne(ReservationVO vo);

	int insert(ReservationVO vo);

	int update(ReservationVO vo);

	int delete(ReservationVO vo);

	List<ReservationVO> searchList(String user_id, String searchKey, String searchWord);
}
