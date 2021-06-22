package User;
import java.io.Serializable;
//����ȭ(Serializable)�� ��ӹ��� ��ü�� ���Ϸ� ������ �� �ִ�.

//DomainŬ����
public class User implements Serializable{
	
	private String name;
	private String userid;
	private String pwd;
	private String tel;
	
	public User() {
		
	}
	public User(String n, String u, String p, String t) {
		name=n; userid=u; pwd=p; tel=t;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	

}////////////////////////////////
