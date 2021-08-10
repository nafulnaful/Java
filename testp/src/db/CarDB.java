package db;

import java.io.*;

import java.sql.*;
import javax.swing.*;

public class CarDB implements java.io.Serializable{
	
	private int code;
	private String myId;
	public String carNo;
	private String carBrand;
	private String carModel;
	private String carYear;
	private String carAcc;
	private String carKm;
	private String carPrice;
	private String carImg;
	
	public CarDB() {
		
	}
	
	public CarDB(int code, String myId, String carNo, String carBrand, String carModel, String carYear, String carAcc,
			String carKm, String carPrice, String carImg) {
		super();
		this.code = code;
		this.myId = myId;
		this.carNo = carNo;
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.carYear = carYear;
		this.carAcc = carAcc;
		this.carKm = carKm;
		this.carPrice = carPrice;
		this.carImg = carImg;
	}

	public String getMyId() {
		return myId;
	}

	public void setMyId(String myId) {
		this.myId = myId;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarYear() {
		return carYear;
	}

	public void setCarYear(String carYear) {
		this.carYear = carYear;
	}

	public String getCarAcc() {
		return carAcc;
	}

	public void setCarAcc(String carAcc) {
		this.carAcc = carAcc;
	}

	public String getCarKm() {
		return carKm;
	}

	public void setCarKm(String carKm) {
		this.carKm = carKm;
	}

	public String getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(String carPrice) {
		this.carPrice = carPrice;
	}
	
	public String getCarImg() {
		return carImg;
	}
	
	public void setCarImg(String carImg) {
		this.carImg = carImg;
	}

	
}////
