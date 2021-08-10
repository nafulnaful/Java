package FirstProject;

import java.io.Serializable;

public class Car implements Serializable {
	private String brand;
	private String model;
	private String local;
	private String buydate;
	private String driven;
	private String pwd;

	public Car() {

	}
	//CAR 데이터 꺼내오기
	public Car(String b, String m, String l, String b2, String d, String p) {
		this.brand = b;
		this.model = m;
		this.local = l;
		this.buydate = b2;
		this.driven = d;
		this.pwd = p;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getBuydate() {
		return buydate;
	}

	public void setBuydate(String buydate) {
		this.buydate = buydate;
	}

	public String getDriven() {
		return driven;
	}

	public void setDriven(String driven) {
		this.driven = driven;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
