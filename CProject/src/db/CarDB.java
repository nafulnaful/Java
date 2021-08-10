package db;

import java.io.*;

import java.sql.*;
import javax.swing.*;

public class CarDB implements java.io.Serializable{
	public int code;
	public String carId;
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
	
	public CarDB(int code, String carId, String carNo, String carBrand, String carModel, String carYear, String carAcc, String carKm, String carPrice, String carImg) {
		super();
		this.code=code;
		this.carId=carId;
		this.carNo=carNo;
		this.carBrand=carBrand;
		this.carModel=carModel;
		this.carYear=carYear;
		this.carAcc=carAcc;
		this.carKm=carKm;
		this.carPrice=carPrice;
		this.carImg=carImg;
	}
	
	public CarDB(int code, String carNo, String carId) {
		this.code=code;
		this.carNo=carNo;
		this.carId=carId;
	}
	public CarDB(int code, String carId, String carNo, String carModel) {
		this.code=code;
		this.carId=carId;
		this.carNo=carNo;
		this.carModel=carModel;
	}
	public CarDB(int code, String carNo) {
		this.code=code;
		this.carNo=carNo;
	}
	public CarDB(int code) {
		this.code=code;
	}
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
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
