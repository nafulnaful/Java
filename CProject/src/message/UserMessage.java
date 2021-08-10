package message;

import java.io.Serializable;


import db.User;

public class UserMessage implements Serializable{

	public static final int LOGIN=100;
	public static final int JOIN=200;
	public static final int EDIT=300;
	public static final int LOGOUT=400;
	public static final int CHAT=500;
	
	
	private int code;
	private String id;
	private String pw;
	
	private User user; // 메시지 코드 받는?
	private User dest; // 도착?
	private String msg;

	public UserMessage(int code, User dest, String msg) {
		super();
		this.code = code;
		this.dest = dest;
		this.msg = msg;
	}

	public UserMessage(int code, String id, String pw) {
		super();
		this.code = code;
		this.id = id;
		this.pw = pw;
	}

	public UserMessage(int code) {
		super();
		this.code = code;
	}

	public UserMessage(int code, User user) {
		super();
		this.code = code;
		this.user = user;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getDest() {
		return dest;
	}

	public void setDest(User dest) {
		this.dest = dest;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	
	
	
	
	
}/////
