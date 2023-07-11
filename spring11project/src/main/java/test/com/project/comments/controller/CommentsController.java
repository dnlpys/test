package test.com.project.comments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import test.com.project.board.model.BoardVO;
import test.com.project.comments.model.CommentsVO;
import test.com.project.comments.service.CommentsService;

@Slf4j
@Controller
public class CommentsController {
	
	@Autowired
	CommentsService commService;

	@RequestMapping(value = "/c_updateOK.do", method = RequestMethod.GET)
	public String c_updateOK(CommentsVO vo) {
		log.info("/c_updateOK.do...{}", vo);
		
		int result = commService.update(vo);
		log.info("result...{}", result);
		
		return "redirect:b_selectOne.do?wnum="+vo.getWnum();
		
	}
	
	@RequestMapping(value = "/c_deleteOK.do", method = RequestMethod.GET)
	public String c_deleteOK(CommentsVO vo) {
		log.info("/c_deleteOK.do...{}", vo);
		
		int result = commService.delete(vo);
		log.info("result...{}", result);
		
		return "redirect:b_selectOne.do?wnum="+vo.getWnum();
		
	}
	
	@RequestMapping(value = "/c_insertOK.do", method = RequestMethod.GET)
	public String c_insertOK(CommentsVO vo) {
		log.info("/c_insertOK.do...{}", vo);
		
		int result = commService.insert(vo);
		log.info("result...{}", result);
		
		return "redirect:b_selectOne.do?wnum="+vo.getWnum();
		
	}
	

}
