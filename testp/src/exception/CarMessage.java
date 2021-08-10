package exception;

import java.io.Serializable;

public class CarMessage implements Serializable {//직렬화를 통해 object를 보내기.

	private static final long serialVersionUID =1L;
	private int code;//코드값을 보내줄 코드 선언
	private String msg;//보내는 내용
	private String id;
	private int fontRGB;
	private int iconCmd;
	
	public CarMessage() {
		
	}
	//source ->generate constructor using files//매개변수를 받아들일때
	public CarMessage(int code,  String id, int fontRGB,String msg) {
		super();
		this.code = code;
		this.msg = msg;
		this.id = id;
		this.fontRGB = fontRGB;
	}
	
	public CarMessage(int code, int iconCmd) {
		this.code=code;
		this.iconCmd=iconCmd;
	}
	public int getIconCmd() {
		return iconCmd;
	}
	public void setIconCmd(int iconCmd) {
		this.iconCmd = iconCmd;
	}
	public CarMessage(int code, String id) {
		super();
		this.code = code;
		this.id = id;
	}
	
	
	public CarMessage(int code, String msg, int fontRGB) {
		super();
		this.code = code;
		this.msg = msg;
		this.fontRGB = fontRGB;
	}
	
	//setter, getter 만들기
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
	public int getFontRGB() {
		return fontRGB;
	}
	public void setFontRGB(int fontRGB) {
		this.fontRGB = fontRGB;
	}
	
	
	//toString() 메소드 오버라이드[26]//테스트할때만 사용할 목적으로 만듬 내용 볼려고
	@Override
	public String toString() {
		return "Message [code=" + code + ", msg=" + msg + ", id=" + id + ", fontRGB=" + fontRGB
				+ "]";
	}
	
	

}/////////////////////////////////////////////////////
