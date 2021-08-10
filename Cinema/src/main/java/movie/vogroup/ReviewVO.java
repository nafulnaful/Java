package movie.vogroup;

import java.io.Serializable;
import java.sql.Date;

public class ReviewVO implements Serializable {
	
	private String review_num;
	private int review_star;
	private String review_con;
	private Date review_day;
	private String movie_num_fk;
	private String user_num_fk;
	
	public ReviewVO() {
		
	}
	
	public ReviewVO(String review_num, int review_star, String review_con, Date review_day, String movie_num_fk,
			String user_num_fk) {
		super();
		this.review_num = review_num;
		this.review_star = review_star;
		this.review_con = review_con;
		this.review_day = review_day;
		this.movie_num_fk = movie_num_fk;
		this.user_num_fk = user_num_fk;
	}

	public String getReview_num() {
		return review_num;
	}

	public void setReview_num(String review_num) {
		this.review_num = review_num;
	}

	public int getReview_star() {
		return review_star;
	}

	public void setReview_star(int review_star) {
		this.review_star = review_star;
	}

	public String getReview_con() {
		return review_con;
	}

	public void setReview_con(String review_con) {
		this.review_con = review_con;
	}

	public Date getReview_day() {
		return review_day;
	}

	public void setReview_day(Date review_day) {
		this.review_day = review_day;
	}

	public String getMovie_num() {
		return movie_num_fk;
	}

	public void setMovie_num(String movie_num_fk) {
		this.movie_num_fk = movie_num_fk;
	}

	public String getUser_num() {
		return user_num_fk;
	}

	public void setUser_num(String user_num_fk) {
		this.user_num_fk = user_num_fk;
	}
	
	
	
}
