package shop.model;

import java.io.Serializable;

public class CategoryVO implements Serializable {
	
	private String upCg_code;//���� ī�װ� �ڵ�
	private String upCg_name;
	
	private String downCg_code;//���� ī�װ� �ڵ�
	private String downCg_name;
	
	public CategoryVO() {
		
	}

	public CategoryVO(String upCg_code, String upCg_name, String downCg_code, String downCg_name) {
		super();
		this.upCg_code = upCg_code;
		this.upCg_name = upCg_name;
		this.downCg_code = downCg_code;
		this.downCg_name = downCg_name;
	}

	public String getUpCg_code() {
		return upCg_code;
	}

	public void setUpCg_code(String upCg_code) {
		this.upCg_code = upCg_code;
	}

	public String getUpCg_name() {
		return upCg_name;
	}

	public void setUpCg_name(String upCg_name) {
		this.upCg_name = upCg_name;
	}

	public String getDownCg_code() {
		return downCg_code;
	}

	public void setDownCg_code(String downCg_code) {
		this.downCg_code = downCg_code;
	}

	public String getDownCg_name() {
		return downCg_name;
	}

	public void setDownCg_name(String downCg_name) {
		this.downCg_name = downCg_name;
	}
	
}////////////////////////////////////
