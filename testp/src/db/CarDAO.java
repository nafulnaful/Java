package db;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import db.CarDB;
import page.Buy_itembox;
import page.MainFrame;
import util.DBUtil;

public class CarDAO {
	public Connection con;
	private Statement st;
	public PreparedStatement ps;
	public ResultSet rs;
	MainFrame mainF;
	Buy_itembox bib;

	public CarDAO() {
		
	}

	/** DB닫기 기능 메소드 */
	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			System.out.println(e + "=> dbClose fail");
		}
	}// dbClose()---

	/** 차량번호 중복 체크 */
	public boolean ExistCar(String no) {
		boolean result = true;
		try {
			con=DBUtil.getCon();
			String sql = "SELECT * FROM car_info" + " WHERE carNo=?";
			ps = con.prepareStatement(sql);

			ps.setString(1, no.trim());
			rs = ps.executeQuery();// 실행

			if (rs.next()) {
				result = false; // 차량번호 중복되면 false
			}
		} catch (SQLException e) {
			System.out.println(e + "=> ExistUser fail");
		} finally {
			dbClose();
		}
		return result;
	}// ExistUser()-------------------

	/** 차량정보 insert */
	public int insertCar(CarDB car) {
		int result = 0;
		System.out.println("DAO넘어오는가?");
		try {
			con=DBUtil.getCon();
			String sql = "INSERT INTO car_info(carIdx,myId, carNo, carBrand, carModel, carYear, carAcc, carKm, carPrice, carImg)"
					+ " VALUES(car_seq.nextval,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, car.getMyId());
			ps.setString(2, car.getCarNo());
			ps.setString(3, car.getCarBrand());
			ps.setString(4, car.getCarModel());
			ps.setString(5, car.getCarYear());
			ps.setString(6, car.getCarAcc());
			ps.setString(7, car.getCarKm());
			ps.setString(8, car.getCarPrice());
			ps.setString(9, car.getCarImg());

			result = ps.executeUpdate(); // 실행 -> 저장
			System.out.println("carinsert() 통과하는가?");
			return result;
		} catch (Exception e) {
			System.out.println(e + "=> insertCar fail");
			return result;
		} finally {
			dbClose();
		}


	}// insertUser()-------------------

	/** 차량정보 update */
	public int updateCar(CarDB car) {
		int result = 0;

		try {
			con=DBUtil.getCon();
			String sql = "UPDATE car_info"
					+ " SET carBrand=?, carModel=?, carYear=?, carAcc=?, carKm=?, carPrice=?, carImg=?"
					+ " WHERE carNo=?";
			ps = con.prepareStatement(sql);

			ps.setString(1, car.getCarBrand());
			ps.setString(2, car.getCarModel());
			ps.setString(3, car.getCarYear());
			ps.setString(4, car.getCarAcc());
			ps.setString(5, car.getCarKm());
			ps.setString(6, car.getCarPrice());
			ps.setString(7, car.getCarImg());
			ps.setString(8, car.getCarNo());

			result = ps.executeUpdate(); // 실행

		} catch (SQLException e) {
			System.out.println(e + "=> updateCar fail");
		} finally {
			dbClose();
		}

		return result;
	}// updateUser()----------------------

//	public ArrayList<CarDB> countCar{
//		String sql = "count * from car_info"
//	}
//	
	/** 차량정보 select */
	public ArrayList<CarDB> selectCar() {
		try {
			con=DBUtil.getCon();
			String sql = "SELECT carIdx, carNo, carBrand, carModel, carYear, carAcc, carKm, carPrice, carImg"
					+ " FROM car_info"
					+ " ORDER BY carIdx DESC";
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery(); // 실행

			// 결과를 담을 ArrayList생성
			ArrayList<CarDB> list = new ArrayList<CarDB>();

			// ResultSet에 담긴 결과를 ArrayList에 담기
			while (rs.next()) {
				CarDB cdb = new CarDB();
				cdb.setCarNo(rs.getString("carNo"));
				cdb.setCarBrand(rs.getString("carBrand"));
				cdb.setCarModel(rs.getString("carModel"));
				cdb.setCarYear(rs.getString("carYear"));
				cdb.setCarKm(rs.getString("carKm"));
				cdb.setCarAcc(rs.getString("carAcc"));
				cdb.setCarPrice(rs.getString("carPrice"));
				cdb.setCarImg(rs.getString("carImg"));
				list.add(cdb);
			}
			return list;

		} catch (SQLException e) {
			System.out.println(e + "=> selectCar fail");
			e.printStackTrace();
			return null;
		} finally {
			dbClose();
		}

	}

}///
