package movie.vogroup;

import java.io.Serializable;
import java.sql.Date;

public class EventVO implements Serializable {

	private String event_num;
	private String event_title;
	private Date event_start;
	private Date event_end;
	private String event_con;
	
	public EventVO() {
		
	}

	public EventVO(String event_num, String event_title, Date event_start, Date event_end,
			String event_con) {
		super();
		this.event_num = event_num;
		this.event_title = event_title;
		this.event_start = event_start;
		this.event_end = event_end;
		this.event_con = event_con;
	}

	public String getEvent_num() {
		return event_num;
	}

	public void setEvent_num(String event_num) {
		this.event_num = event_num;
	}

	public String getEvent_title() {
		return event_title;
	}

	public void setEvent_title(String event_title) {
		this.event_title = event_title;
	}

	public Date getEvent_start() {
		return event_start;
	}

	public void setEvent_start(Date event_start) {
		this.event_start = event_start;
	}

	public Date getEvent_end() {
		return event_end;
	}

	public void setEvent_end(Date event_end) {
		this.event_end = event_end;
	}

	public String getEvent_con() {
		return event_con;
	}

	public void setEvent_con(String event_con) {
		this.event_con = event_con;
	}
	
	
}
