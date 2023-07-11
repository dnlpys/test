package test.com.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import test.com.project.member.model.MemberVO;
import test.com.project.member.service.MemberService;

@Slf4j
@Controller
public class MemberRestController {

	@Autowired
	MemberService service;
	
	@ResponseBody
	@RequestMapping(value = "/json_m_idCheck.do", method = RequestMethod.GET)
	public String json_m_idCheck(MemberVO vo) {
		log.info("/json_m_idCheck.do...{}",vo);
		
		MemberVO vo2 = service.idCheck(vo);
		log.info("{}",vo2);
		if(vo2==null) {
			return "{\"result\":\"OK\"}";
		}else {
			return "{\"result\":\"NotOK\"}";
		}
	}

}
