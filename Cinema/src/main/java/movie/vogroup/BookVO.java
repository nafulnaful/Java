package movie.vogroup;

import java.io.Serializable;
import java.sql.Date;

public class BookVO implements Serializable {
	
	private String book_num;
	private int book_np;
	private String book_seat;
	private int book_point;
	private int book_price;
	private Date book_day;
	private String book_status;
	private String time_num_fk;
	private String user_num_fk;
	
	public BookVO() {
		
	}
	
	public BookVO(String book_num, int book_np, String book_seat, int book_point, int book_price, Date book_day,
			String book_status, String time_num_fk, String user_num_fk) {
		super();
		this.book_num = book_num;
		this.book_np = book_np;
		this.book_seat = book_seat;
		this.book_point = book_point;
		this.book_price = book_price;
		this.book_day = book_day;
		this.book_status = book_status;
		this.time_num_fk = time_num_fk;
		this.user_num_fk = user_num_fk;
	}

	public String getBook_num() {
		return book_num;
	}

	public void setBook_num(String book_num) {
		this.book_num = book_num;
	}

	public int getBook_np() {
		return book_np;
	}

	public void setBook_np(int book_np) {
		this.book_np = book_np;
	}

	public String getBook_seat() {
		return book_seat;
	}

	public void setBook_seat(String book_seat) {
		this.book_seat = book_seat;
	}

	public int getBook_point() {
		return book_point;
	}

	public void setBook_point(int book_point) {
		this.book_point = book_point;
	}

	public int getBook_price() {
		return book_price;
	}

	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}

	public Date getBook_day() {
		return book_day;
	}

	public void setBook_day(Date book_day) {
		this.book_day = book_day;
	}

	public String getBook_status() {
		return book_status;
	}

	public void setBook_status(String book_status) {
		this.book_status = book_status;
	}

	public String getTime_num() {
		return time_num_fk;
	}

	public void setTime_num(String time_num_fk) {
		this.time_num_fk = time_num_fk;
	}

	public String getUser_num() {
		return user_num_fk;
	}

	public void setUser_num(String user_num_fk) {
		this.user_num_fk = user_num_fk;
	}
	
	
}
