package test.com.project.board.model;

import java.util.List;

public interface BoardDAO {

	public int insert(BoardVO vo);

	public int update(BoardVO vo);

	public int delete(BoardVO vo);

	public List<BoardVO> selectAll();

	public BoardVO selectOne(BoardVO vo);

	public List<BoardVO> searchList(String searchKey, String searchWord);

	public void vcountUp(BoardVO vo);

}
