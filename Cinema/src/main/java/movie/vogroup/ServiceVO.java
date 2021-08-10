package movie.vogroup;

import java.io.Serializable;
import java.sql.Date;

public class ServiceVO implements Serializable {
	
	private String service_num;
	private String service_title;
	private String service_con;
	private Date service_day;
	private String user_num_fk;
	private String service_status;
	
	public ServiceVO() {
		
	}

	public ServiceVO(String service_num, String service_title, String service_con, Date service_day, String user_num_fk, String service_status) {
		super();
		this.service_num = service_num;
		this.service_title = service_title;
		this.service_con = service_con;
		this.service_day = service_day;
		this.user_num_fk = user_num_fk;
		this.service_status = service_status;
	}

	public String getService_num() {
		return service_num;
	}

	public void setService_num(String service_num) {
		this.service_num = service_num;
	}

	public String getService_title() {
		return service_title;
	}

	public void setService_title(String service_title) {
		this.service_title = service_title;
	}

	public String getService_con() {
		return service_con;
	}

	public void setService_con(String service_con) {
		this.service_con = service_con;
	}

	public Date getService_day() {
		return service_day;
	}

	public void setService_day(Date service_day) {
		this.service_day = service_day;
	}

	public String getUser_num() {
		return user_num_fk;
	}

	public void setUser_num(String user_num_fk) {
		this.user_num_fk = user_num_fk;
	}

	public String getService_status() {
		return service_status;
	}

	public void setService_status(String service_status) {
		this.service_status = service_status;
	}
	
	
}
