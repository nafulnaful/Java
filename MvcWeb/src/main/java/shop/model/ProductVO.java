package shop.model;

import java.io.Serializable;
import java.sql.Date;

public class ProductVO implements Serializable {
	
	private String upCg_code;
	private String upCg_name;
	
	private String downCg_code;
	private String downCg_name;
	
	private String pnum;
	private String pname;
	private String pimage1;
	private String pimage2;
	private String pimage3;
	
	private int price;
	private int saleprice;
	private int point;
	private int pqty;
	
	private String pspec;
	private String pcontents;
	private String pcompany;
	private Date pindate;
	
	private int totalPrice;//���ǸŰ� = �ǸŰ�*����
	private int totalPoint;//������Ʈ = ����Ʈ*����
	
	public ProductVO() {
		
	}

	public ProductVO(String upCg_code, String upCg_name, String downCg_code, String downCg_name, String pnum,
			String pname, String pimage1, String pimage2, String pimage3, int price, int saleprice, int point, int pqty,
			String pspec, String pcontents, String pcompany, Date pindate) {
		super();
		this.upCg_code = upCg_code;
		this.upCg_name = upCg_name;
		this.downCg_code = downCg_code;
		this.downCg_name = downCg_name;
		this.pnum = pnum;
		this.pname = pname;
		this.pimage1 = pimage1;
		this.pimage2 = pimage2;
		this.pimage3 = pimage3;
		this.price = price;
		this.saleprice = saleprice;
		this.point = point;
		this.pqty = pqty;
		this.pspec = pspec;
		this.pcontents = pcontents;
		this.pcompany = pcompany;
		this.pindate = pindate;
	}

	public String getUpCg_code() {
		return upCg_code;
	}

	public void setUpCg_code(String upCg_code) {
		this.upCg_code = upCg_code;
	}

	public String getUpCg_name() {
		return upCg_name;
	}

	public void setUpCg_name(String upCg_name) {
		this.upCg_name = upCg_name;
	}

	public String getDownCg_code() {
		return downCg_code;
	}

	public void setDownCg_code(String downCg_code) {
		this.downCg_code = downCg_code;
	}

	public String getDownCg_name() {
		return downCg_name;
	}

	public void setDownCg_name(String downCg_name) {
		this.downCg_name = downCg_name;
	}

	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPimage1() {
		return pimage1;
	}

	public void setPimage1(String pimage1) {
		this.pimage1 = pimage1;
	}

	public String getPimage2() {
		return pimage2;
	}

	public void setPimage2(String pimage2) {
		this.pimage2 = pimage2;
	}

	public String getPimage3() {
		return pimage3;
	}

	public void setPimage3(String pimage3) {
		this.pimage3 = pimage3;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getPqty() {
		return pqty;
	}

	public void setPqty(int pqty) {
		this.pqty = pqty;
		//���ǸŰ��� ������Ʈ�� ��������/////////////////////
		this.totalPrice = this.saleprice * this.pqty;
		this.totalPoint = this.point * this.pqty;
		///////////////////////////////////////////////
	}

	public String getPspec() {
		return pspec;
	}

	public void setPspec(String pspec) {
		this.pspec = pspec;
	}

	public String getPcontents() {
		return pcontents;
	}

	public void setPcontents(String pcontents) {
		this.pcontents = pcontents;
	}

	public String getPcompany() {
		return pcompany;
	}

	public void setPcompany(String pcompany) {
		this.pcompany = pcompany;
	}

	public Date getPindate() {
		return pindate;
	}

	public void setPindate(Date pindate) {
		this.pindate = pindate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public int getTotalPoint() {
		return totalPoint;
	}
	
	/**���η��� ��ȯ���ִ� �޼ҵ�*/
	public int getPercent() {
		// (����-�ǸŰ�)*100/����
		int per=(this.price - this.saleprice)*100/this.price;
		return per;
	}
	public String getAllCategory() {
		return upCg_name+">"+downCg_name;
	}
	

}/////////////////////////////////////////
