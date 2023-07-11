package test.com.project.reservation.model;

import java.sql.Date;

import lombok.Data;

@Data
public class ReservationVO {

	private int num;
	private String user_id;
	private int movie_num;
	private Date regdate;
	private String movie_date;//2023-06-13T15:16>>2023-06-13 15:16
	private int mcount;
	private String title;
	private int price;
	private String save_name;
}
