package test.com.project.mongo;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoMemberService {

	@Autowired
	MongoMemberDAO dao;
	
	public List<MongoMemberVO> findAll(){
		return dao.findAll();
	}
	

	public int insert(MongoMemberVO vo) {
		return dao.insert(vo);
	}

	public MongoMemberVO findOne(MongoMemberVO vo) {
		return dao.findOne(vo);
	}


	public List<MongoMemberVO> searchList(String searchKey, String searchWord) {
		return dao.searchList(searchKey, searchWord) ;
	}


	public List<MongoMemberVO> searchList2(int num1, int num2) {
		return dao.searchList2(num1, num2);
	}

	public List<Document> searchList3(int num1, int num2) {
		return dao.searchList3(num1, num2);
	}


	public List<MongoMemberVO> findAll2(int page, int limit) {
		return dao.findAll2(page, limit);
	}


	public int update(MongoMemberVO vo) {
		return dao.update(vo);
	}


	public int delete(MongoMemberVO vo) {
		return dao.delete(vo);
	}


	public MongoMemberVO findOne_idCheck(MongoMemberVO vo) {
		return dao.findOne_idCheck(vo);
	}


	public List<Document> findAll_doc() {
		return dao.findAll_doc();
	}
	



	

}
