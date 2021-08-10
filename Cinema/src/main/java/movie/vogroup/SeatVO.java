package movie.vogroup;

import java.io.Serializable;

public class SeatVO implements Serializable {
	
	private String seat_num;
	private String seat_status;
	private String time_num_fk;
	
	public SeatVO() {
		
	}
	
	public SeatVO(String seat_num, String seat_status, String time_num_fk) {
		super();
		this.seat_num = seat_num;
		this.seat_status = seat_status;
		this.time_num_fk = time_num_fk;
	}

	public String getSeat_num() {
		return seat_num;
	}

	public void setSeat_num(String seat_num) {
		this.seat_num = seat_num;
	}

	public String getSeat_status() {
		return seat_status;
	}

	public void setSeat_status(String seat_status) {
		this.seat_status = seat_status;
	}

	public String getTime_num() {
		return time_num_fk;
	}

	public void setTime_num(String time_num_fk) {
		this.time_num_fk = time_num_fk;
	}
	
	
}
