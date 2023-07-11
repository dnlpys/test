package test.com.project.member.model;

import java.util.List;

public interface MemberDAO {

	List<MemberVO> selectAll();

	MemberVO selectOne(MemberVO vo);

	int insert(MemberVO vo);

	int update(MemberVO vo);

	int delete(MemberVO vo);

	MemberVO login(MemberVO vo);

	List<MemberVO> searchList(String searchKey, String searchWord);

	MemberVO idCheck(MemberVO vo);
}
