package test.com.project.movie.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MovieVO {

	private int num;
	private String title;
	private int price;
	private String producer;
	private String save_name;
	private MultipartFile file;
}
