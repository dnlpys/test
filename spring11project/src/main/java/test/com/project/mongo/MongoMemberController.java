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
public class MongoMemberController {
	
	@Autowired
	MongoMemberService service;
	
	@RequestMapping(value = "/mongo_insert.do", method = RequestMethod.GET)
	public String mongo_insert() {
		log.info("/mongo_insert.do");

		return "mongo/member/insert";
	}
	
	@RequestMapping(value = "/mongo_update.do", method = RequestMethod.GET)
	public String mongo_update() {
		log.info("/mongo_update.do");
		
		return "mongo/member/update";
	}
	
	@RequestMapping(value = "/mongo_selectAll.do", method = RequestMethod.GET)
	public String mongo_selectAll() {
		log.info("/mongo_selectAll.do");
		
		return "mongo/member/selectAll";
	}
	
	@RequestMapping(value = "/mongo_selectOne.do", method = RequestMethod.GET)
	public String mongo_selectOne() {
		log.info("/mongo_selectOne.do");
		
		return "mongo/member/selectOne";
	}
	
	
	
	
}
