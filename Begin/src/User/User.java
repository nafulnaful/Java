package User;
import java.io.Serializable;
//직렬화(Serializable)을 상속받은 객체만 파일로 저장할 수 있다.

//Domain클래스
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
