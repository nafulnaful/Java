package function;
import data.UserDB;
import ui.MainPanel;

public class UserFunction {
	
	MainPanel mp;
	
	public UserFunction(MainPanel mp) {
		this.mp = mp;
		
		
	}
	
	public void UpdateInfo() {
		
		
		String tel = mp.myP2.tfTel.getText();
		mp.Iam.setTel(tel);
		
		char[] pwd = mp.myP2.tfPwd.getPassword();
		String upw = new String(pwd);
		mp.Iam.setPwd(upw);
		
			}
	
	
	
	public void showInfo() {
		mp.myP2.tfN.setText(mp.Iam.getName());//529d
		mp.myP2.tfId.setText(mp.Iam.getUserid());//529d
		mp.myP2.tfTel.setText(mp.Iam.getTel());//529d
		
		String pwd = mp.Iam.getPwd();//529d
		mp.myP2.tfPwd.setText(pwd);//529d
	}

}
