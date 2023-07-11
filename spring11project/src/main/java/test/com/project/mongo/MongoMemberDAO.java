package test.com.project.mongo;

import java.util.List;

import org.bson.Document;

public interface MongoMemberDAO {

	public List<MongoMemberVO> findAll();

	public MongoMemberVO findOne(MongoMemberVO vo);

	public int insert(MongoMemberVO vo);

	public List<MongoMemberVO> searchList(String searchKey, String searchWord);

	public List<MongoMemberVO> searchList2(int num1, int num2);

	public List<Document> searchList3(int num1, int num2);

	public List<MongoMemberVO> findAll2(int page, int limit);

	public int update(MongoMemberVO vo);

	public int delete(MongoMemberVO vo);

	public MongoMemberVO findOne_idCheck(MongoMemberVO vo);

	public List<Document> findAll_doc();

}
