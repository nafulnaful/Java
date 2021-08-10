package movie.vogroup;

import java.io.Serializable;

public class RoomVO implements Serializable {
	
	private String room_num;
	private String room_name;
	private int room_seatcount;
	private String cinema_num_fk;
	
	public RoomVO() {
		
	}
	
	public RoomVO(String room_num, String room_name, int room_seatcount, String cinema_num_fk) {
		super();
		this.room_num = room_num;
		this.room_name = room_name;
		this.room_seatcount = room_seatcount;
		this.cinema_num_fk = cinema_num_fk;
	}

	public String getRoom_num() {
		return room_num;
	}

	public void setRoom_num(String room_num) {
		this.room_num = room_num;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public int getRoom_seatcount() {
		return room_seatcount;
	}

	public void setRoom_seatcount(int room_seatcount) {
		this.room_seatcount = room_seatcount;
	}

	public String getCinema_num() {
		return cinema_num_fk;
	}

	public void setCinema_num(String cinema_num_fk) {
		this.cinema_num_fk = cinema_num_fk;
	}
	
	
	
}
