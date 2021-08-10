package exception;

import java.io.Serializable;

public class CarMessage implements Serializable {//����ȭ�� ���� object�� ������.

	private static final long serialVersionUID =1L;
	private int code;//�ڵ尪�� ������ �ڵ� ����
	private String msg;//������ ����
	private String id;
	private int fontRGB;
	private int iconCmd;
	
	public CarMessage() {
		
	}
	//source ->generate constructor using files//�Ű������� �޾Ƶ��϶�
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
	
	//setter, getter �����
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
	
	
	//toString() �޼ҵ� �������̵�[26]//�׽�Ʈ�Ҷ��� ����� �������� ���� ���� ������
	@Override
	public String toString() {
		return "Message [code=" + code + ", msg=" + msg + ", id=" + id + ", fontRGB=" + fontRGB
				+ "]";
	}
	
	

}/////////////////////////////////////////////////////
