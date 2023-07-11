package test.com.project.board.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardVO {

	private int wnum;
	private String title;
	private String content;
	private String writer;
	private Timestamp wdate;
	private int vcount;

}
