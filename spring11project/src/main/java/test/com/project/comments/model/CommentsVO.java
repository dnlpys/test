package test.com.project.comments.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CommentsVO {
	private int cnum;
	private int wnum;
	private String content;
	private String writer;
	private Timestamp wdate;
}
