package data;

import java.awt.Image;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;
   								//15�� 
/**��ǰ���� Ŭ����*/
public class ProductsDB implements Serializable { 
	
	private String nameP;//��ǰ����
	private String priceP;//��ǰ����
	private String placeP;//�ŷ����
	private String info;  //��ǰ����
	public String key;
	public String ����;//601
	public int pDate,pH,pM,pS;
	public String pDate2;
	public ArrayList<String> wishUser = new ArrayList<>();
	public ProductsDB() {
		
	}
	public ProductsDB(String nameP, String priceP, String placeP,String info) {
		this.nameP=nameP; this.priceP=priceP; this.placeP=placeP ;this.info =info;
		
	}
	
	
	
	public String getNameP() {
		return nameP;
	}
	public void setNameP(String nameP) {
		this.nameP = nameP;
	}
	public String getPriceP() {
		return priceP;
	}
	public void setPriceP(String priceP) {
		this.priceP = priceP;
	}
	public String getPlaceP() {
		return placeP;
	}
	public void setPlaceP(String placeP) {
		this.placeP = placeP;
	}
	
	public String getInfo() {
		return info;
	}
	public void setinfo(String info) {
		this.info = info;
	}
	
	
	
}
