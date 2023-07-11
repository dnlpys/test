package test.com.project.member.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import test.com.project.member.model.MemberVO;
import test.com.project.member.service.MemberService;

@Slf4j
@Controller
public class MemberController {

	@Autowired
	MemberService service;

	@Autowired
	ServletContext sContext;
	
	@Autowired
	HttpSession session;

	@RequestMapping(value = "/m_selectAll.do", method = RequestMethod.GET)
	public String m_selectAll(Model model) {
		log.info("/m_selectAll.do");

		List<MemberVO> vos = service.selectAll();

		model.addAttribute("vos", vos);

		return "member/selectAll";
	}

	@RequestMapping(value = "/m_searchList.do", method = RequestMethod.GET)
	public String m_searchList(String searchKey,String searchWord,Model model) {
		log.info("/m_searchList.do...searchKey:{}",searchKey);
		log.info("/m_searchList.do...searchWord:{}",searchWord);

		List<MemberVO> vos = service.searchList(searchKey,searchWord);

		model.addAttribute("vos", vos);
		
		return "member/selectAll";
	}

	@RequestMapping(value = "/m_insert.do", method = RequestMethod.GET)
	public String m_insert() {
		log.info("/m_insert.do");

		return "member/insert";
	}

	@RequestMapping(value = "/m_insertOK.do", method = RequestMethod.POST)
	public String m_insertOK(MemberVO vo) throws IllegalStateException, IOException {
		log.info("/m_insertOK.do...{}", vo);

		String getOriginalFilename = vo.getFile().getOriginalFilename();
		int fileNameLength = vo.getFile().getOriginalFilename().length();
		log.info("getOriginalFilename:{}", getOriginalFilename);
		log.info("fileNameLength:{}", fileNameLength);

		if (getOriginalFilename.length() == 0) {
			vo.setSave_name("default.png");
		} else {
			vo.setSave_name(getOriginalFilename);
			// 웹 어플리케이션이 갖는 실제 경로: 이미지를 업로드할 대상 경로를 찾아서 파일저장.
			String realPath = sContext.getRealPath("resources/uploadimg");
			log.info("realPath : {}", realPath);

			File f = new File(realPath + "\\" + vo.getSave_name());
			vo.getFile().transferTo(f);

			//// create thumbnail image/////////
			BufferedImage original_buffer_img = ImageIO.read(f);
			BufferedImage thumb_buffer_img = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D graphic = thumb_buffer_img.createGraphics();
			graphic.drawImage(original_buffer_img, 0, 0, 50, 50, null);

			File thumb_file = new File(realPath + "/thumb_" + vo.getSave_name());
			String formatName = vo.getSave_name().substring(vo.getSave_name().lastIndexOf(".") + 1);
			log.info("formatName : {}", formatName);
			ImageIO.write(thumb_buffer_img, formatName, thumb_file);

		} // end else
		log.info("{}", vo);

		int result = service.insert(vo);

		if (result == 1) {
			return "redirect:m_selectAll.do";
		} else {
			return "redirect:m_insert.do";
		}
	}

	@RequestMapping(value = "/m_updateOK.do", method = RequestMethod.POST)
	public String m_updateOK(MemberVO vo) throws IllegalStateException, IOException {
		log.info("/m_updateOK.do...{}", vo);

		String getOriginalFilename = vo.getFile().getOriginalFilename();
		int fileNameLength = vo.getFile().getOriginalFilename().length();
		log.info("getOriginalFilename:{}", getOriginalFilename);
		log.info("fileNameLength:{}", fileNameLength);

		if (getOriginalFilename.length() != 0) {

			vo.setSave_name(getOriginalFilename);
			// 웹 어플리케이션이 갖는 실제 경로: 이미지를 업로드할 대상 경로를 찾아서 파일저장.
			String realPath = sContext.getRealPath("resources/uploadimg");
			log.info("realPath : {}", realPath);

			File f = new File(realPath + "\\" + vo.getSave_name());
			vo.getFile().transferTo(f);

			//// create thumbnail image/////////
			BufferedImage original_buffer_img = ImageIO.read(f);
			BufferedImage thumb_buffer_img = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D graphic = thumb_buffer_img.createGraphics();
			graphic.drawImage(original_buffer_img, 0, 0, 50, 50, null);

			File thumb_file = new File(realPath + "/thumb_" + vo.getSave_name());
			String formatName = vo.getSave_name().substring(vo.getSave_name().lastIndexOf(".") + 1);
			log.info("formatName : {}", formatName);
			ImageIO.write(thumb_buffer_img, formatName, thumb_file);

		} // end else
		log.info("{}", vo);

		int result = service.update(vo);

		if (result == 1) {
			return "redirect:m_selectOne.do?num=" + vo.getNum();
		} else {
			return "redirect:m_update.do?num=" + vo.getNum();
		}
	}

	@RequestMapping(value = "/loginOK.do", method = RequestMethod.POST)
	public String loginOK(MemberVO vo) {
		log.info("/loginOK.do...{}",vo);
		
		MemberVO vo2 = service.login(vo);
		log.info("vo2...{}",vo2);
		
		if(vo2 == null) {
			return "redirect:login.do?message=fail";
		}else {
			session.setAttribute("user_id", vo2.getId());
			return "redirect:home.do";
		}

	}

	@RequestMapping(value = "/m_deleteOK.do", method = RequestMethod.GET)
	public String m_deleteOK(MemberVO vo) {
		log.info("/m_deleteOK.do");

		int result = service.delete(vo);

		if (result == 1) {
			return "redirect:m_selectAll.do";
		} else {
			return "redirect:m_selectOne.do?num=" + vo.getNum();
		}

	}

	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout() {
		log.info("/logout.do");
		
		session.invalidate();

		return "redirect:home.do";
	}

	@RequestMapping(value = "/m_selectOne.do", method = RequestMethod.GET)
	public String m_selectOne(MemberVO vo, Model model) {
		log.info("/m_selectOne.do...{}", vo);

		MemberVO vo2 = service.selectOne(vo);

		model.addAttribute("vo2", vo2);

		return "member/selectOne";
	}

	@RequestMapping(value = "/m_update.do", method = RequestMethod.GET)
	public String m_update(MemberVO vo, Model model) {
		log.info("/m_update.do...{}", vo);

		MemberVO vo2 = service.selectOne(vo);

		model.addAttribute("vo2", vo2);

		return "member/update";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(String message,Model model) {
		log.info("/login.do....{}",message);

		if(message!=null) message = "아이디/비번 을 확인하세요";
		model.addAttribute("message", message);
		
		return "member/login";
	}

}
