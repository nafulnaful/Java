package data;

import java.util.ArrayList;
import java.io.Serializable;
import ui.*;
import function.*;
/**ȸ������ Ŭ����*/
public class UserDB implements Serializable {
	
	//62 복붙
	
	private String name;
	private String userid;
	private String pwd;
	private String tel;
	public ArrayList<String> SallList = new ArrayList<>();     ///602
	public ArrayList<String> WishList = new ArrayList<>();//601
	
	
	//private ArrayList<String> BuyList = new ArrayList<>();  //���� 
	
	public void  AddSallList(String item) {       // setPname
		SallList.add(item);
	}
	public ArrayList<String>  getSallList() {       // setPname
		return this.SallList;
	}
//	public void  MyBuyList(String name) {       // 5/27 ���� 
//		BuyList.add(name);
//	}
//	
	public UserDB() {
		
	}
	public UserDB(String n, String u, String p, String t) {
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
	
}
