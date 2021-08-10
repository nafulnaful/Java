package javachat;
import java.io.*;
/*
100 : 클라이언트 리스트 정보(100|아이디|대화명)
400: 일반 대화 메시지(400|글꼴색|메시지)
500: 귓속말(500|귓속말 보내는 사람의 대화명|귓속말 메시지)
600: 대화명 변경(600|아이디|기존대화명|바뀐대화명)
800 : 동일한 대화명이 있을 시 접속을 종료시킨다(800|)
810 : 로그아웃-퇴장 처리(810|대화명)
900 : 채팅 종료 (900|대화명)*/


public class Message implements Serializable {//직렬화를 해야지 object를 보낼수 있다.[7]

	private static final long serialVersionUID =1L;//[79]
	private int code;//코드값을 보내줄 코드 선언
	private String msg;//보내는 내용
	private String id;
	private String nick;
	private int fontRGB;
	private int iconCmd;//[73]
	
	//private캡슐화가 원칙이다.[8]
	
	public Message() {
		
	}
	//source ->generate constructor using fiels//매개변수를 받아들일때[10]??????????????????????
	public Message(int code,  String id, String nick, int fontRGB,String msg) {
		super();
		this.code = code;
		this.msg = msg;
		this.id = id;
		this.nick = nick;
		this.fontRGB = fontRGB;
	}
	
	public Message(int code, int iconCmd) {//[74]
		this.code=code;
		this.iconCmd=iconCmd;
	}
	public int getIconCmd() {
		return iconCmd;
	}
	public void setIconCmd(int iconCmd) {
		this.iconCmd = iconCmd;
	}
	public Message(int code, String id, String nick) {
		super();
		this.code = code;
		this.id = id;
		this.nick = nick;
	}
	
	
	public Message(int code, String msg, int fontRGB) {
		super();
		this.code = code;
		this.msg = msg;
		this.fontRGB = fontRGB;
	}
	
	//setter, getter 만들기[9]
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public int getFontRGB() {
		return fontRGB;
	}
	public void setFontRGB(int fontRGB) {
		this.fontRGB = fontRGB;
	}
	
	
	//toString() 메소드 오버라이드[26]//테스트할때만 사용할 목적으로 만듬 내용 볼려고
	@Override
	public String toString() {
		return "Message [code=" + code + ", msg=" + msg + ", id=" + id + ", nick=" + nick + ", fontRGB=" + fontRGB
				+ "]";
	}
	
	

}/////////////////////////////////////////////////////
