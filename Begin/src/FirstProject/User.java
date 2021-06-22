package FirstProject;

import java.io.Serializable;

public class User implements Serializable {

	private String name;
	private String birth;
	private String id;
	private String pwd;
	private String tel;
	private String email;

	public User() {

	}

	public User(String n, String b, String i, String p, String t, String e) {
		name = n;
		birth = b;
		id = i;
		pwd = p;
		tel = t;
		email = e;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIid() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

}////////////////////////////////
