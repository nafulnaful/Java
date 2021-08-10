package movie.vogroup;

import java.io.Serializable;

public class CinemaVO implements Serializable {

	private String cinema_num;
	private String cinema_name;
	private String cinema_area;
	private String cinema_call;
	private String cinema_addr;
	private String cinema_con;
	
	public CinemaVO() {
		
	}
	
	public CinemaVO(String cinema_num, String cinema_name, String cinema_area, String cinema_call, String cinema_addr,
			String cinema_con) {
		super();
		this.cinema_num = cinema_num;
		this.cinema_name = cinema_name;
		this.cinema_area = cinema_area;
		this.cinema_call = cinema_call;
		this.cinema_addr = cinema_addr;
		this.cinema_con = cinema_con;
	}

	public String getCinema_num() {
		return cinema_num;
	}

	public void setCinema_num(String cinema_num) {
		this.cinema_num = cinema_num;
	}

	public String getCinema_name() {
		return cinema_name;
	}

	public void setCinema_name(String cinema_name) {
		this.cinema_name = cinema_name;
	}

	public String getCinema_area() {
		return cinema_area;
	}

	public void setCinema_area(String cinema_area) {
		this.cinema_area = cinema_area;
	}

	public String getCinema_call() {
		return cinema_call;
	}

	public void setCinema_call(String cinema_call) {
		this.cinema_call = cinema_call;
	}

	public String getCinema_addr() {
		return cinema_addr;
	}

	public void setCinema_addr(String cinema_addr) {
		this.cinema_addr = cinema_addr;
	}

	public String getCinema_con() {
		return cinema_con;
	}

	public void setCinema_con(String cinema_con) {
		this.cinema_con = cinema_con;
	}
	
	
	
	
}
