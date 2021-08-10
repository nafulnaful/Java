package message;

import java.io.Serializable;

import db.User;

public class SystemMessage implements Serializable {
	public static final int LOGIN_SUCCESS = 100;
	public static final int LOGIN_FAIL = 200;
	
	
	private int code;
	private User user;
	
}
