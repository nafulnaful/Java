package movie.vogroup;

import java.io.Serializable;
import java.sql.Date;

public class AnswerVO implements Serializable {

	private String answer_num;
	private String answer_id;
	private Date answer_day;
	private String answer_con;
	private String service_num_fk;
	
	public AnswerVO() {
		
	}

	public AnswerVO(String answer_num, String answer_id, Date answer_day, String answer_con,
			String service_num_fk) {
		super();
		this.answer_num = answer_num;
		this.answer_id = answer_id;
		this.answer_day = answer_day;
		this.answer_con = answer_con;
		this.service_num_fk = service_num_fk;
	}

	public String getAnswer_num() {
		return answer_num;
	}

	public void setAnswer_num(String answer_num) {
		this.answer_num = answer_num;
	}

	public String getAnswer_id() {
		return answer_id;
	}

	public void setAnswer_id(String answer_id) {
		this.answer_id = answer_id;
	}

	public Date getAnswer_day() {
		return answer_day;
	}

	public void setAnswer_day(Date answer_day) {
		this.answer_day = answer_day;
	}

	public String getAnswer_con() {
		return answer_con;
	}

	public void setAnswer_con(String answer_con) {
		this.answer_con = answer_con;
	}

	public String getService_num() {
		return service_num_fk;
	}

	public void setService_num(String service_num_fk) {
		this.service_num_fk = service_num_fk;
	}
	
	
}
