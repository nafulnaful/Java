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
	public boolean ExistCar(String id, String no) {
		boolean result = true;
		try {
			con=DBUtil.getCon();
			String sql = "SELECT * FROM car_info" 
					+ " WHERE carId=? AND carNo=?";
			ps = con.prepareStatement(sql);

			ps.setString(1, id.trim());
			ps.setString(2, no.trim());
			rs = ps.executeQuery();// 실행

			if (rs.next()) {
				result = false; // 차량번호 중복되면 false
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return result;
	}// ExistCar()-------------------

	/** 차량정보 insert */
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

			int r=ps.executeUpdate(); // 실행 -> 저장
			System.out.println(r);
			return(r>0)?true:false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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
	
	/** 차량정보 delete */
	public int deleteCar(String no) {
		int result = 0;

		try {
			con=DBUtil.getCon();
			String sql = "DELETE"
					+ " FROM car_info"
					+ " WHERE carNo=?";
			ps = con.prepareStatement(sql);

			ps.setString(1, no);

			result = ps.executeUpdate(); // 실행
			System.out.println(result);
		} catch (SQLException e) {
			System.out.println(e + "=> deleteCar fail");
		} finally {
			dbClose();
		}

		return result;
	}// deleteLikeCar()----------------------

	/** 차량정보 selectAll */
	public ArrayList<CarDB> selectCar() {
		try {
			con=DBUtil.getCon();
			String sql = "SELECT carNo, carBrand, carModel, carYear, carAcc, carKm, carPrice, carImg"
					+ " FROM car_info"
					+ " ORDER BY carId DESC";
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

	/** 차량정보 selectCarBr: 브랜드명으로 검색 */
	public ArrayList<CarDB> selectCarBr(String carBrand) {
		try {
			con=DBUtil.getCon();
			String sql = "SELECT carNo, carBrand, carModel, carYear, carAcc, carKm, carPrice, carImg"
					+ " FROM car_info"
					+ " WHERE carBrand=?"
					+ " ORDER BY carId DESC";
			ps = con.prepareStatement(sql);
			ps.setString(1, carBrand);

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
			System.out.println(e + "=> selectCarBr fail");
			e.printStackTrace();
			return null;
		} finally {
			dbClose();
		}

	}
	
	
	/** 차량정보 selectCarMo: 모델명으로 검색 */
	public ArrayList<CarDB> selectCarMo(String carModel) {
		try {
			con=DBUtil.getCon();
			String sql = "SELECT carNo, carBrand, carModel, carYear, carAcc, carKm, carPrice, carImg"
					+ " FROM car_info"
					+ " WHERE carModel LIKE ?"
					+ " ORDER BY carid DESC";
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+carModel+"%");

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
			System.out.println(e + "=> selectCarBr fail");
			e.printStackTrace();
			return null;
		} finally {
			dbClose();
		}
	
	}
	
	/** 차량정보 selectCarInfo: 상세정보조회 */
	public ArrayList<CarDB> selectCarInfo(String carNo) {
		try {
			con=DBUtil.getCon();
			String sql = "SELECT * FROM CAR_INFO WHERE CARNO=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, carNo);

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
			System.out.println(e + "=> selectCarBr fail");
			e.printStackTrace();
			return null;
		} finally {
			dbClose();
		}

	}
	
	/** 차량정보 selectMyCar: 등록차량조회 */
	public ArrayList<CarDB> selectMyCar(String carId) {
		try {
			con=DBUtil.getCon();
			String sql = "SELECT carNo, carBrand, carModel, carYear, carAcc, carKm, carPrice, carImg"
					+ " FROM car_info"
					+ " WHERE carId=?"
					+ " ORDER BY carid DESC";
			ps = con.prepareStatement(sql);
			ps.setString(1, carId);

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
			System.out.println(e + "=> selectCarBr fail");
			e.printStackTrace();
			return null;
		} finally {
			dbClose();
		}

	}
	
	/** 차량 찜하기 insert */
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

			result = ps.executeUpdate(); // 실행 -> 저장

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			dbClose();
		}

		return result;
	}// insertUser()-------------------
	
	/** 찜하기: 차량번호 중복 체크 */
	public boolean likeExistCar(String id, String no) {
		boolean result = true;
		try {
			con=DBUtil.getCon();
			String sql = "SELECT * FROM car_like"
					+ " WHERE carId=? AND carNo=?";
			ps = con.prepareStatement(sql);

			ps.setString(1, id.trim());
			ps.setString(2, no.trim());
			rs = ps.executeQuery();// 실행

			if (rs.next()) {
				result = false; // 차량번호 중복되면 false
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return result;
	}// ExistUser()-------------------
	
	/** 찜 삭제 */
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

			result = ps.executeUpdate(); // 실행

		} catch (SQLException e) {
			System.out.println(e + "=> deleteLikeCar fail");
		} finally {
			dbClose();
		}

		return result;
	}// deleteLikeCar()----------------------
	
	/** 차량정보 selectLikeCar: 관심차량조회 */
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
			System.out.println(e + "=> selectCarBr fail");
			e.printStackTrace();
			return null;
		} finally {
			dbClose();
		}

	}
	
	/** 차량정보수정 selectCarIn: 차번호로 정보 불러오기 */
	public ArrayList<CarDB> selectCarIn(String carNo) {
		try {
			con=DBUtil.getCon();
			String sql = "SELECT carNo, carBrand, carModel, carYear, carAcc, carKm, carPrice, carImg"
					+ " FROM car_info"
					+ " WHERE carNo=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, carNo);

			rs = ps.executeQuery(); // 실행

			// 결과를 담을 ArrayList생성
			ArrayList<CarDB> list = new ArrayList<CarDB>();

			// ResultSet에 담긴 결과를 ArrayList에 담기
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
