package movie.vogroup;

import java.io.Serializable;

public class UserVO implements Serializable {

	private String user_num;
	private String user_id;
	private String user_pass;
	private String user_name;
	private String user_birth;
	private String user_sex;
	private String user_email;
	private String user_call1;
	private String user_call2;
	private String user_call3;
	private String user_zipcode;
	private String user_addr1;
	private String user_addr2;
	private String user_status;
	private int user_point;
	
	public UserVO() {
		
	}
	
	
	
	
	/**
	 * @param user_id
	 * @param user_pass
	 */
	public UserVO(String user_id, String user_pass) {
		super();
		this.user_id = user_id;
		this.user_pass = user_pass;
	}




	/**
	 * @param user_id
	 * @param user_pass
	 * @param user_name
	 * @param user_birth
	 * @param user_sex
	 * @param user_email
	 * @param user_call1
	 * @param user_call2
	 * @param user_call3
	 * @param user_zipcode
	 * @param user_addr1
	 * @param user_addr2
	 */
	public UserVO(String user_id, String user_pass, String user_name, String user_birth, String user_sex,
			String user_email, String user_call1, String user_call2, String user_call3, String user_zipcode,
			String user_addr1, String user_addr2) {
		super();
		this.user_id = user_id;
		this.user_pass = user_pass;
		this.user_name = user_name;
		this.user_birth = user_birth;
		this.user_sex = user_sex;
		this.user_email = user_email;
		this.user_call1 = user_call1;
		this.user_call2 = user_call2;
		this.user_call3 = user_call3;
		this.user_zipcode = user_zipcode;
		this.user_addr1 = user_addr1;
		this.user_addr2 = user_addr2;
	}


	public UserVO(String user_num, String user_id, String user_pass, String user_name, String user_birth,
			String user_sex, String user_email, String user_call1, String user_call2, String user_call3,
			String user_zipcode, String user_addr1, String user_addr2, String user_status,
			int user_point) {
		super();
		this.user_num = user_num;
		this.user_id = user_id;
		this.user_pass = user_pass;
		this.user_name = user_name;
		this.user_birth = user_birth;
		this.user_sex = user_sex;
		this.user_email = user_email;
		this.user_call1 = user_call1;
		this.user_call2 = user_call2;
		this.user_call3 = user_call3;
		this.user_zipcode = user_zipcode;
		this.user_addr1 = user_addr1;
		this.user_addr2 = user_addr2;
		this.user_status = user_status;
		this.user_point = user_point;
	}

	public String getUser_num() {
		return user_num;
	}

	public void setUser_num(String user_num) {
		this.user_num = user_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_birth() {
		return user_birth;
	}

	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}

	public String getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_call1() {
		return user_call1;
	}

	public void setUser_call1(String user_call1) {
		this.user_call1 = user_call1;
	}

	public String getUser_call2() {
		return user_call2;
	}

	public void setUser_call2(String user_call2) {
		this.user_call2 = user_call2;
	}

	public String getUser_call3() {
		return user_call3;
	}

	public void setUser_call3(String user_call3) {
		this.user_call3 = user_call3;
	}

	public String getUser_zipcode() {
		return user_zipcode;
	}

	public void setUser_zipcode(String user_zipcode) {
		this.user_zipcode = user_zipcode;
	}

	public String getUser_addr1() {
		return user_addr1;
	}

	public void setUser_addr1(String user_addr1) {
		this.user_addr1 = user_addr1;
	}

	public String getUser_addr2() {
		return user_addr2;
	}

	public void setUser_addr2(String user_addr2) {
		this.user_addr2 = user_addr2;
	}

	public String getUser_status() {
		return user_status;
	}

	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}

	public int getUser_point() {
		return user_point;
	}

	public void setUser_point(int user_point) {
		this.user_point = user_point;
	}
	
	
}
