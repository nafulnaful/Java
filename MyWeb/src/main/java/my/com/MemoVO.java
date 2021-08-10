package my.com;
import java.sql.*;
//VO: Value Object 
//ȭ����̳� DB�ʿ��� ������ ���� ����ִ� ��ü
//Domain����  : ������ ���� ȭ������� ���Ӽ� �������� �����͸� �ְ���� �� ����Ѵ�
public class MemoVO implements java.io.Serializable{
	private int idx;
	private String name;
	private String msg;
	private Date wdate;
	
	public MemoVO() {
		
	}
	public MemoVO(int idx, String name, String msg, Date wdate) {
		super();
		this.idx = idx;
		this.name = name;
		this.msg = msg;
		this.wdate = wdate;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	
	
	
	
}////////////////////////////////
