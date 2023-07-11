package test.com.project.mongo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class MongoMemberRestController {
	
	@Autowired
	MongoMemberService service;
	
	@RequestMapping(value = "/mongo_rest_api.do", method = RequestMethod.GET)
	public String mongo_rest_api() {
		log.info("/mongo_rest_api.do");

		return "mongo_rest_api";
	}
	
	@ResponseBody
	@RequestMapping(value = "/mongo_findAll.do", method = RequestMethod.GET)
	public List<MongoMemberVO> mongo_findAll() {
		log.info("/mongo_findAll.do");
	
		List<MongoMemberVO> list = service.findAll();
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/mongo_findAll_doc.do", method = RequestMethod.GET)
	public List<Document> mongo_findAll_doc() {
		log.info("/mongo_findAll_doc.do");
		
		List<Document> list = service.findAll_doc();
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/mongo_findAll2.do", method = RequestMethod.GET)
	public List<MongoMemberVO> mongo_findAll2(int page, int limit) {
		log.info("/mongo_findAll2.do...{},{}",page,limit);
		
		List<MongoMemberVO> list = service.findAll2(page,limit);
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/mongo_searchList.do", method = RequestMethod.GET)
	public List<MongoMemberVO> mongo_searchList(String searchKey, String searchWord) {
		log.info("/mongo_searchList.do....{},{}",searchKey,searchWord);
		
		List<MongoMemberVO> list = service.searchList(searchKey,searchWord);
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/mongo_searchList2.do", method = RequestMethod.GET)
	public List<MongoMemberVO> mongo_searchList2(int num1,int num2) {
		log.info("/mongo_searchList2.do....{},{}",num1,num2);
		
		List<MongoMemberVO> list = service.searchList2(num1,num2);
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/mongo_searchList3.do", method = RequestMethod.GET)
	public List<Document> mongo_searchList3(int num1,int num2) {
		log.info("/mongo_searchList3.do....{},{}",num1,num2);
		
		List<Document> list = service.searchList3(num1,num2);
		
		return list;
	}
	
	
	
	
	@ResponseBody
	@RequestMapping(value = "/mongo_findOne.do", method = RequestMethod.GET)
	public MongoMemberVO mongo_findOne(MongoMemberVO vo) {
		log.info("/mongo_findOne.do....{}",vo);
		
		MongoMemberVO vo2 = service.findOne(vo);
		
		return vo2;
	}
	
	@ResponseBody
	@RequestMapping(value = "/mongo_findOne_idCheck.do", method = RequestMethod.GET)
	public MongoMemberVO mongo_findOne_idCheck(MongoMemberVO vo) {
		log.info("/mongo_findOne_idCheck.do....{}",vo);
		
		MongoMemberVO vo2 = service.findOne_idCheck(vo);
		
		return vo2;
	}
	
	@ResponseBody
	@RequestMapping(value = "/mongo_insertOK.do", method = RequestMethod.GET)
	public Map<String, Integer> mongo_insertOK(MongoMemberVO vo) {
		log.info("/mongo_insertOK.do...{}",vo);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		int result = service.insert(vo);
		
		map.put("result", result);
		
		return map; //{"result":1}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/mongo_updateOK.do", method = RequestMethod.GET)
	public Map<String, Integer> mongo_updateOK(MongoMemberVO vo) {
		log.info("/mongo_updateOK.do...{}",vo);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		int result = service.update(vo);
		
		map.put("result", result);
		
		return map; //{"result":1}
	}
	
	@ResponseBody
	@RequestMapping(value = "/mongo_deleteOK.do", method = RequestMethod.GET)
	public Map<String, Integer> mongo_deleteOK(MongoMemberVO vo) {
		log.info("/mongo_deleteOK.do...{}",vo);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		int result = service.delete(vo);
		
		map.put("result", result);
		
		return map; //{"result":1}
	}
	
	
	
}
