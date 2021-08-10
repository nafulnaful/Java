package db;

public class UserDB implements java.io.Serializable {
	private int code;
	private String userName;
	private String userBirth;
	private String userId;
	private String userPwd;
	private String userTel;
	private String userEmail;
	
public UserDB() {
		
	}
	
	
	

	public UserDB(String userName, String userBirth, String userId, String userPwd, String userTel, String userEmail) {
	super();
	this.userName = userName;
	this.userBirth = userBirth;
	this.userId = userId;
	this.userPwd = userPwd;
	this.userTel = userTel;
	this.userEmail = userEmail;
}




	public UserDB(int code, String userName, String userBirth, String userId, String userPwd, String userTel,
			String userEmail) {
		super();
		this.code = code;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userTel = userTel;
		this.userEmail = userEmail;
	}

	public UserDB(int code, String userId, String userPwd) {
		super();
		this.code = code;
		this.userId = userId;
		this.userPwd = userPwd;
	}

	public UserDB(int code, String userId) {
		super();
		this.code=code;
		this.userId=userId;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "UserDB [userName=" + userName + ", userBirth=" + userBirth + ", userId=" + userId + ", userPwd="
				+ userPwd + ", userTel=" + userTel + ", userEmail=" + userEmail + "]";
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
}