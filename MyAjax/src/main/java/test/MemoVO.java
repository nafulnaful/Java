package test;
import java.sql.Date;

//VO: Value Object 
//ȭ����̳� DB�ʿ��� ������ ���� ����ִ� ��ü
//Domain����  : ������ ���� ȭ������� ���Ӽ� �������� �����͸� �ְ���� �� ����Ѵ�
public class MemoVO implements java.io.Serializable{
	private int idx;
	private String title;
	private String msg;
	private String wdate;
	
	public MemoVO() {
		
	}
	public MemoVO(int idx, String title, String msg, String wdate) {
		super();
		this.idx = idx;
		this.title = title;
		this.msg = msg;
		this.wdate = wdate;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	} 

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	
	
	
	
}////////////////////////////////
