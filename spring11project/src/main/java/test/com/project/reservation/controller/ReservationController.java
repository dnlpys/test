package test.com.project.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import test.com.project.reservation.model.ReservationVO;
import test.com.project.reservation.service.ReservationService;

@Slf4j
@Controller
public class ReservationController {

	@Autowired
	ReservationService service;
	
	
	@RequestMapping(value = "/r_insert.do", method = RequestMethod.GET)
	public String r_insert() {
		log.info("/r_insert.do...");

		return "reservation/insert";
	}
	
	
	@RequestMapping(value = "/r_selectOne.do", method = RequestMethod.GET)
	public String r_selectOne() {
		log.info("/r_selectOne.do...");
		
		return "reservation/selectOne";
	}
	@RequestMapping(value = "/r_update.do", method = RequestMethod.GET)
	public String r_update() {
		log.info("/r_update.do...");
		
		return "reservation/update";
	}
	
	@RequestMapping(value = "/r_insertOK.do", method = RequestMethod.GET)
	public String r_insertOK(ReservationVO vo) {
		log.info("/r_insertOK.do...{}",vo);
		
		vo.setMovie_date(vo.getMovie_date().replace("T", " "));
		log.info("replace data:{}",vo.getMovie_date());
		
		int result = service.insert(vo);
		log.info("result:{}",result);
		if(result == 1) {
			return "redirect:r_selectAll.do?user_id="+vo.getUser_id();
		}else {
			return "redirect:r_selectOne.do?num="+vo.getMovie_num();
		}
	}
	
	@RequestMapping(value = "/r_updateOK.do", method = RequestMethod.GET)
	public String r_updateOK(ReservationVO vo) {
		log.info("/r_updateOK.do...{}",vo);
		log.info("/r_updateOK.do...{}",vo.getMovie_date().length());
		
		if(vo.getMovie_date().length()!=0) {
			vo.setMovie_date(vo.getMovie_date().replace("T", " "));
			log.info("replace data:{}",vo.getMovie_date());
			
			int result = service.update(vo);
			log.info("result:{}",result);
			if(result == 1) {
				return "redirect:r_selectAll.do?user_id="+vo.getUser_id();
			}else {
				return "redirect:r_update.do?movie_num="
						+vo.getMovie_num()
						+"&user_id="+vo.getUser_id()
						+"&num="+vo.getNum();
			}
		}else {
			return "redirect:r_update.do?movie_num="
					+vo.getMovie_num()
					+"&user_id="+vo.getUser_id()
					+"&num="+vo.getNum();
		}
	}
	
	@RequestMapping(value = "/r_deleteOK.do", method = RequestMethod.GET)
	public String r_deleteOK(ReservationVO vo) {
		log.info("/r_deleteOK.do...{}",vo);
		
		int result = service.delete(vo);
		log.info("result:{}",result);
		
		return "redirect:r_selectAll.do?user_id="+vo.getUser_id();
	}
	
	@RequestMapping(value = "/r_selectAll.do", method = RequestMethod.GET)
	public String r_selectAll(ReservationVO vo,Model model) {
		log.info("/r_selectAll.do...{}",vo);
		
		List<ReservationVO> vos = service.selectAll(vo);
		
		log.info("{}",vos);
		model.addAttribute("vos", vos);
		
		return "reservation/selectAll";
	}
	
	@RequestMapping(value = "/r_searchList.do", method = RequestMethod.GET)
	public String r_searchList(String user_id,String searchKey,String searchWord,Model model) {
		log.info("/r_searchList.do...");
		log.info("user_id : {}",user_id);
		log.info("searchKey : {}",searchKey);
		log.info("searchWord : {}",searchWord);
		
		List<ReservationVO> vos = service.searchList(user_id,searchKey,searchWord);
		
		log.info("{}",vos);
		model.addAttribute("vos", vos);
		
		return "reservation/selectAll";
	}

}
