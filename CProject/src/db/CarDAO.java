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
		try {
			con = util.DBUtil.getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** DB�ݱ� ��� �޼ҵ� */
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

	/** ������ȣ �ߺ� üũ */
	public boolean ExistCar(String id, String no) {
		boolean result = true;
		try {
			con=DBUtil.getCon();
			String sql = "SELECT * FROM car_info" 
					+ " WHERE carId=? AND carNo=?";
			ps = con.prepareStatement(sql);

			ps.setString(1, id.trim());
			ps.setString(2, no.trim());
			rs = ps.executeQuery();// ����

			if (rs.next()) {
				result = false; // ������ȣ �ߺ��Ǹ� false
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return result;
	}// ExistCar()-------------------

	/** �������� insert */
	public boolean insertCar(CarDB car) {

		try {
			con=DBUtil.getCon();
			String sql = "INSERT INTO car_info(carId, carNo, carBrand, carModel, carYear, carAcc, carKm, carPrice, carImg)"
					+ " VALUES(?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);

			ps.setString(1, car.getCarId());
			ps.setString(2, car.getCarNo());
			ps.setString(3, car.getCarBrand());
			ps.setString(4, car.getCarModel());
			ps.setString(5, car.getCarYear());
			ps.setString(6, car.getCarAcc());
			ps.setString(7, car.getCarKm());
			ps.setString(8, car.getCarPrice());
			ps.setString(9, car.getCarImg());

			int r=ps.executeUpdate(); // ���� -> ����
			System.out.println(r);
			return(r>0)?true:false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			dbClose();
		}
		
	}// insertUser()-------------------

	/** �������� update */
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

			result = ps.executeUpdate(); // ����

		} catch (SQLException e) {
			System.out.println(e + "=> updateCar fail");
		} finally {
			dbClose();
		}

		return result;
	}// updateUser()----------------------
	
	/** �������� delete */
	public int deleteCar(String no) {
		int result = 0;

		try {
			con=DBUtil.getCon();
			String sql = "DELETE"
					+ " FROM car_info"
					+ " WHERE carNo=?";
			ps = con.prepareStatement(sql);

			ps.setString(1, no);

			result = ps.executeUpdate(); // ����
			System.out.println(result);
		} catch (SQLException e) {
			System.out.println(e + "=> deleteCar fail");
		} finally {
			dbClose();
		}

		return result;
	}// deleteLikeCar()----------------------

	/** �������� selectAll */
	public ArrayList<CarDB> selectCar() {
		try {
			con=DBUtil.getCon();
			String sql = "SELECT carNo, carBrand, carModel, carYear, carAcc, carKm, carPrice, carImg"
					+ " FROM car_info"
					+ " ORDER BY carId DESC";
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery(); // ����

			// ����� ���� ArrayList����
			ArrayList<CarDB> list = new ArrayList<CarDB>();

			// ResultSet�� ��� ����� ArrayList�� ���
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

	/** �������� selectCarBr: �귣������� �˻� */
	public ArrayList<CarDB> selectCarBr(String carBrand) {
		try {
			con=DBUtil.getCon();
			String sql = "SELECT carNo, carBrand, carModel, carYear, carAcc, carKm, carPrice, carImg"
					+ " FROM car_info"
					+ " WHERE carBrand=?"
					+ " ORDER BY carId DESC";
			ps = con.prepareStatement(sql);
			ps.setString(1, carBrand);

			rs = ps.executeQuery(); // ����

			// ����� ���� ArrayList����
			ArrayList<CarDB> list = new ArrayList<CarDB>();

			// ResultSet�� ��� ����� ArrayList�� ���
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
			System.out.println(e + "=> selectCarBr fail");
			e.printStackTrace();
			return null;
		} finally {
			dbClose();
		}

	}
	
	
	/** �������� selectCarMo: �𵨸����� �˻� */
	public ArrayList<CarDB> selectCarMo(String carModel) {
		try {
			con=DBUtil.getCon();
			String sql = "SELECT carNo, carBrand, carModel, carYear, carAcc, carKm, carPrice, carImg"
					+ " FROM car_info"
					+ " WHERE carModel LIKE ?"
					+ " ORDER BY carid DESC";
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+carModel+"%");

			rs = ps.executeQuery(); // ����

			// ����� ���� ArrayList����
			ArrayList<CarDB> list = new ArrayList<CarDB>();

			// ResultSet�� ��� ����� ArrayList�� ���
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
			System.out.println(e + "=> selectCarBr fail");
			e.printStackTrace();
			return null;
		} finally {
			dbClose();
		}
	
	}
	
	/** �������� selectCarInfo: ��������ȸ */
	public ArrayList<CarDB> selectCarInfo(String carNo) {
		try {
			con=DBUtil.getCon();
			String sql = "SELECT * FROM CAR_INFO WHERE CARNO=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, carNo);

			rs = ps.executeQuery(); // ����

			// ����� ���� ArrayList����
			ArrayList<CarDB> list = new ArrayList<CarDB>();

			// ResultSet�� ��� ����� ArrayList�� ���
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
			System.out.println(e + "=> selectCarBr fail");
			e.printStackTrace();
			return null;
		} finally {
			dbClose();
		}

	}
	
	/** �������� selectMyCar: ���������ȸ */
	public ArrayList<CarDB> selectMyCar(String carId) {
		try {
			con=DBUtil.getCon();
			String sql = "SELECT carNo, carBrand, carModel, carYear, carAcc, carKm, carPrice, carImg"
					+ " FROM car_info"
					+ " WHERE carId=?"
					+ " ORDER BY carid DESC";
			ps = con.prepareStatement(sql);
			ps.setString(1, carId);

			rs = ps.executeQuery(); // ����

			// ����� ���� ArrayList����
			ArrayList<CarDB> list = new ArrayList<CarDB>();

			// ResultSet�� ��� ����� ArrayList�� ���
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
			System.out.println(e + "=> selectCarBr fail");
			e.printStackTrace();
			return null;
		} finally {
			dbClose();
		}

	}
	
	/** ���� ���ϱ� insert */
	public int likeCar(CarDB car) {
		int result = 0;

		try {
			con=DBUtil.getCon();
			String sql = "INSERT INTO car_like(carId, carNo, carBrand, carModel, carYear, carAcc, carKm, carPrice, carImg)"
					+ " VALUES(?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, car.getCarId());
			ps.setString(2, car.getCarNo());
			ps.setString(3, car.getCarBrand());
			ps.setString(4, car.getCarModel());
			ps.setString(5, car.getCarYear());
			ps.setString(6, car.getCarAcc());
			ps.setString(7, car.getCarKm());
			ps.setString(8, car.getCarPrice());
			ps.setString(9, car.getCarImg());

			result = ps.executeUpdate(); // ���� -> ����

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			dbClose();
		}

		return result;
	}// insertUser()-------------------
	
	/** ���ϱ�: ������ȣ �ߺ� üũ */
	public boolean likeExistCar(String id, String no) {
		boolean result = true;
		try {
			con=DBUtil.getCon();
			String sql = "SELECT * FROM car_like"
					+ " WHERE carId=? AND carNo=?";
			ps = con.prepareStatement(sql);

			ps.setString(1, id.trim());
			ps.setString(2, no.trim());
			rs = ps.executeQuery();// ����

			if (rs.next()) {
				result = false; // ������ȣ �ߺ��Ǹ� false
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return result;
	}// ExistUser()-------------------
	
	/** �� ���� */
	public int deleteLikeCar(String id, String no) {
		int result = 0;

		try {
			con=DBUtil.getCon();
			String sql = "DELETE"
					+ " FROM car_like"
					+ " WHERE carId=? AND carNo=?";
			ps = con.prepareStatement(sql);

			ps.setString(1, id);
			ps.setString(2, no);

			result = ps.executeUpdate(); // ����

		} catch (SQLException e) {
			System.out.println(e + "=> deleteLikeCar fail");
		} finally {
			dbClose();
		}

		return result;
	}// deleteLikeCar()----------------------
	
	/** �������� selectLikeCar: ����������ȸ */
	public ArrayList<CarDB> selectLikeCar(String id) {
		int result=0;
		try {
			con=DBUtil.getCon();
			String sql = "SELECT carNo, carBrand, carModel, carYear, carAcc, carKm, carPrice, carImg"
					+ " FROM car_like"
					+ " WHERE carId=?"
					+ " ORDER BY carId DESC";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);

			rs = ps.executeQuery(); // ����

			// ����� ���� ArrayList����
			ArrayList<CarDB> list = new ArrayList<CarDB>();

			// ResultSet�� ��� ����� ArrayList�� ���
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
			System.out.println(e + "=> selectCarBr fail");
			e.printStackTrace();
			return null;
		} finally {
			dbClose();
		}

	}
	
	/** ������������ selectCarIn: ����ȣ�� ���� �ҷ����� */
	public ArrayList<CarDB> selectCarIn(String carNo) {
		try {
			con=DBUtil.getCon();
			String sql = "SELECT carNo, carBrand, carModel, carYear, carAcc, carKm, carPrice, carImg"
					+ " FROM car_info"
					+ " WHERE carNo=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, carNo);

			rs = ps.executeQuery(); // ����

			// ����� ���� ArrayList����
			ArrayList<CarDB> list = new ArrayList<CarDB>();

			// ResultSet�� ��� ����� ArrayList�� ���
			while (rs.next()) {
				CarDB cdb = new CarDB();
				cdb.setCarNo(rs.getString("carNo"));
				cdb.setCarBrand(rs.getString("carBrand"));
				cdb.setCarModel(rs.getString("carYear"));
				cdb.setCarYear(rs.getString("carYear"));
				cdb.setCarAcc(rs.getString("carAcc"));
				cdb.setCarKm(rs.getString("carKm"));
				cdb.setCarPrice(rs.getString("carPrice"));
				cdb.setCarImg(rs.getString("carImg"));
				list.add(cdb);
			}
			return list;

		} catch (SQLException e) {
			System.out.println(e + "=> selectCarIn fail");
			e.printStackTrace();
			return null;
		} finally {
			dbClose();
		}

	}
	
}///
