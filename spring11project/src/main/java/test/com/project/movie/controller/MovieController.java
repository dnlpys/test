package test.com.project.movie.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import test.com.project.movie.model.MovieVO;
import test.com.project.movie.service.MovieService;

@Slf4j
@Controller
public class MovieController {

	@Autowired
	MovieService service;

	@Autowired
	ServletContext sContext;

	@RequestMapping(value = "/mv_selectAll.do", method = RequestMethod.GET)
	public String mv_selectAll(Model model) {
		log.info("/mv_selectAll.do");

		List<MovieVO> vos = service.selectAll();

		model.addAttribute("vos", vos);

		return "movie/selectAll";
	}

	@RequestMapping(value = "/mv_searchList.do", method = RequestMethod.GET)
	public String mv_searchList(Model model, String searchKey, String searchWord) {
		log.info("/mv_searchList.do");
		log.info("searchKey:{}", searchKey);
		log.info("searchWord:{}", searchWord);

		List<MovieVO> vos = service.searchList(searchKey, searchWord);

		model.addAttribute("vos", vos);

		return "movie/selectAll";
	}

	@RequestMapping(value = "/mv_selectOne.do", method = RequestMethod.GET)
	public String mv_selectOne(Model model, MovieVO vo) {
		log.info("/mv_selectOne.do...{}", vo);

		MovieVO vo2 = service.selectOne(vo);
		log.info("vo2:{}", vo2);

		model.addAttribute("vo2", vo2);

		return "movie/selectOne";
	}

	@RequestMapping(value = "/mv_update.do", method = RequestMethod.GET)
	public String mv_update(Model model, MovieVO vo) {
		log.info("/mv_update.do...{}", vo);

		MovieVO vo2 = service.selectOne(vo);
		log.info("vo2:{}", vo2);

		model.addAttribute("vo2", vo2);

		return "movie/update";
	}

	@RequestMapping(value = "/mv_updateOK.do", method = RequestMethod.POST)
	public String mv_updateOK(MovieVO vo) throws IllegalStateException, IOException {
		log.info("/mv_updateOK.do...{}", vo);

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

		} // end if
		log.info("{}", vo);

		int result = service.update(vo);
		log.info("result:{}", result);

		if (result == 1) {
			return "redirect:mv_selectOne.do?num=" + vo.getNum();
		} else {
			return "redirect:mv_update.do?num=" + vo.getNum();
		}

	}

	@RequestMapping(value = "/mv_deleteOK.do", method = RequestMethod.GET)
	public String mv_deleteOK(MovieVO vo) {
		log.info("/mv_deleteOK.do...{}", vo);

		int result = service.delete(vo);
		log.info("result:{}", result);

		if (result == 1) {
			return "redirect:mv_selectAll.do";
		} else {
			return "redirect:mv_selectOne.do?num=" + vo.getNum();
		}

	}
	
	@RequestMapping(value = "/mv_insert.do", method = RequestMethod.GET)
	public String mv_insert() {
		log.info("/mv_insert.do...");

		return "movie/insert";
	}
	
	@RequestMapping(value = "/mv_insertOK.do", method = RequestMethod.POST)
	public String mv_insertOK(MovieVO vo) throws IllegalStateException, IOException {
		log.info("/mv_insertOK.do...{}", vo);

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

		} else {
			vo.setSave_name("mv_default.png");
		}
		log.info("{}", vo);

		int result = service.insert(vo);
		log.info("result:{}", result);

		if (result == 1) {
			return "redirect:mv_selectAll.do";
		} else {
			return "redirect:mv_insert.do";
		}

	}

}
