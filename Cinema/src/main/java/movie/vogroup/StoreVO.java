package movie.vogroup;

import java.io.Serializable;

public class StoreVO implements Serializable {
	private String store_num;
	private String store_name;
	private String store_price;
	private String store_img;
	/**
	 * @param store_num
	 * @param store_name
	 * @param store_price
	 * @param store_img
	 */
	public StoreVO(String store_num, String store_name, String store_price, String store_img) {
		super();
		this.store_num = store_num;
		this.store_name = store_name;
		this.store_price = store_price;
		this.store_img = store_img;
	}
	
	
	public String getStore_num() {
		return store_num;
	}
	public String getStore_name() {
		return store_name;
	}
	public String getStore_price() {
		return store_price;
	}
	public String getStore_img() {
		return store_img;
	}
	public void setStore_num(String store_num) {
		this.store_num = store_num;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public void setStore_price(String store_price) {
		this.store_price = store_price;
	}
	public void setStore_img(String store_img) {
		this.store_img = store_img;
	}
	
	
}
