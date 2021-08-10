package movie.vogroup;

import java.io.Serializable;
import java.sql.Date;

public class TimeVO implements Serializable {
	
	private String time_num;
	private Date time_day;
	private String time_start;
	private String time_end;
	private String movie_num_fk;
	private String cinema_num_fk;
	private String room_num_fk;
	
	public TimeVO() {
		
	}
	
	public TimeVO(String time_num, Date time_day, String time_start, String time_end, String movie_num_fk,
			String cinema_num_fk, String room_num_fk) {
		super();
		this.time_num = time_num;
		this.time_day = time_day;
		this.time_start = time_start;
		this.time_end = time_end;
		this.movie_num_fk = movie_num_fk;
		this.cinema_num_fk = cinema_num_fk;
		this.room_num_fk = room_num_fk;
	}

	public String getTime_num() {
		return time_num;
	}

	public void setTime_num(String time_num) {
		this.time_num = time_num;
	}

	public Date getTime_day() {
		return time_day;
	}

	public void setTime_day(Date time_day) {
		this.time_day = time_day;
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getTime_end() {
		return time_end;
	}

	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

	public String getMovie_num() {
		return movie_num_fk;
	}

	public void setMovie_num(String movie_num_fk) {
		this.movie_num_fk = movie_num_fk;
	}

	public String getCinema_num() {
		return cinema_num_fk;
	}

	public void setCinema_num(String cinema_num_fk) {
		this.cinema_num_fk = cinema_num_fk;
	}

	public String getRoom_num() {
		return room_num_fk;
	}

	public void setRoom_num(String room_num_fk) {
		this.room_num_fk = room_num_fk;
	}
	
	
	
	
}
