package day23;
/*(5.4)*/
//DomainŬ����(���� ������ �ִ� Ŭ����)
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
		
		//private���� �޾����ϱ� setter getter�� �ݵ�� �޾ƾ��Ѵ�
		//Source����
		
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
