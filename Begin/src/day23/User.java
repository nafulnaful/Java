package day23;
/*(5.4)*/
//Domain클래스(값을 가지고 있는 클레스)
public class User {

		private String name;
		private String userid;
		private String pwd;
		private String tel;
		
		
		public User() {
			
		}
		public User(String n, String u, String p, String t) {
			name=n; userid=u; pwd=p; tel=t;
		}
		
		//private으로 받았으니까 setter getter로 반드시 받아야한다
		//Source에서
		
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
		
	
		
		
		
		
}///////////////////////////////
