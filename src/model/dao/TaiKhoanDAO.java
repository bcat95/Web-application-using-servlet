package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.DataBaseConnect;
import common.StringProcess;
import model.bean.BaiDangBean;
import model.bean.TaiKhoanBean;


/**
 * TaiKhoanDAO
 *
 * Version 1.0
 *
 * Date: 14-3-2017
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 14-3-2017         VangLVD            Create
 */
public class TaiKhoanDAO extends DataBaseConnect{
	private static Statement st=null;
	private static ResultSet rs=null;
	private ArrayList<TaiKhoanBean> arrTaiKhoan;

	/**
	 * Ham kiem tra username co ton tai chua
	 * @param username
	 * @return
	 */
	public boolean checkUsername(String username) {
		Connection conn = common.DataBaseConnect.getConnect();
		String sql=	"SELECT Username FROM TaiKhoan WHERE Username = '"+username+"'";
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 
	 * Kiem tra email co ton tai trong CSDL hay chua
	 * @param email
	 * @return
	 */
	public boolean checkEmail(String email) {
		Connection conn = common.DataBaseConnect.getConnect();
		String sql=	"SELECT Username FROM TaiKhoan WHERE Email = '"+email+"'";
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Ham kiem tra bi trung email hay k 
	 * @param email
	 * @param username
	 * @return
	 */
	public boolean checkEmailUpdate(String email, String username) {
		Connection conn = common.DataBaseConnect.getConnect();
		String sql=	"SELECT Username FROM TaiKhoan WHERE Email = '"+email+"' and Username <> '"+username+"'";
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Ham kiem tra dang nhap
	 * @param tenDangNhap
	 * @param matKhau
	 * @return
	 */
	public boolean checkLogin(String tenDangNhap, String matKhau) {
		Connection conn = common.DataBaseConnect.getConnect();
		String sql=	"SELECT Username FROM TaiKhoan WHERE Username = '"+tenDangNhap+"' AND Pass = '"+matKhau+"'";
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void updateTK(String username, String pass, String email, String avatar, String hoTen, String gioiTinh, String ngaySinh, String SDT) {
		Connection conn = common.DataBaseConnect.getConnect();
		String sql=	String.format("UPDATE TaiKhoan "+
					" SET Pass = '%s', Email = '%s', Avatar = '%s', HoTen = N'%s', GioiTinh = %s, NgaySinh = '%s', SDT = '%s' " +
					" WHERE Username = '%s'", pass, email, avatar, hoTen, gioiTinh, ngaySinh, SDT, username);
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Ham them tai khoan cua User
	 * @param tenDangNhap
	 * @param matKhau
	 * @param email
	 * @param avatar
	 * @param hoTen
	 * @param MaQuyen
	 * @param MaLoaiTK
	 */
	public void themTaiKhoan(String tenDangNhap, String matKhau, String email, String avatar, String hoTen, int MaQuyen, int MaLoaiTK) {
		Connection conn = common.DataBaseConnect.getConnect();
		String sql= String.format("INSERT INTO TaiKhoan(Username, Pass, Email, Avatar, HoTen, MaQuyen, MaLoaiTK)"
					+ " VALUES ('%s','%s','%s','%s',N'%s','%d','%d')", tenDangNhap, matKhau, email, avatar, hoTen, MaQuyen, MaLoaiTK);
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Ham lay thong tin cua 1 tai khoan
	 * @param username
	 * @return
	 */
	public TaiKhoanBean selectOne(String username) {
		Connection conn = common.DataBaseConnect.getConnect();
		String sql=	"SELECT Username, Pass, Email, Avatar, HoTen, GioiTinh, NgaySinh, SDT, NgayDangKy, MaQuyen, MaLoaiTk"
				+ " FROM TaiKhoan WHERE Username = '"+username+"'";
		ResultSet resultSet = null;
		TaiKhoanBean item = new TaiKhoanBean();
		try {
			Statement stmt = conn.createStatement();
			resultSet = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(resultSet.next())
			{
				item.setUserName(resultSet.getString("Username"));
				item.setPassWord(resultSet.getString("Pass"));
				item.seteMail(resultSet.getString("Email"));
				item.setAvatar(resultSet.getString("Avatar"));
				item.setHoTen(resultSet.getString("HoTen"));
				item.setGioiTinh(resultSet.getString("GioiTinh"));
				item.setNgaySinh(resultSet.getString("NgaySinh"));
				item.setsDT(resultSet.getString("SDT"));
				item.setNgayDangKy(resultSet.getString("NgayDangKy"));
				item.setMaQuyen(resultSet.getInt("MaQuyen"));
				item.setMaLoaiTaiKhoan(resultSet.getInt("MaLoaiTK"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return item;
	}
	
	/**
	 * Ham lay danh sach tai khoan
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<TaiKhoanBean> danhSachTaiKhoan() throws SQLException {
		arrTaiKhoan = new ArrayList<>();
		Connection conn = common.DataBaseConnect.getConnect();
		String query = "Select * from TaiKhoan";
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(query);
		while (rs.next()) {
//			String maTaiKhoan = rs.getString("MaTaiKhoan");
/*			String email = rs.getString("Email");
			String hoTen = rs.getString("HoTen");
			String matKhau = rs.getString("MatKhau");*/
//			String diaChi = rs.getString("DiaChi");
//			String soDienThoai = rs.getString("SoDienThoai");
//			int trangThai = rs.getInt("TrangThai");
//			String ghiChu = rs.getString("GhiChu");
			
//			TaiKhoanBean itemTaiKhoanBean = new TaiKhoanBean(maTaiKhoan, email, hoTen, matKhau, diaChi, soDienThoai, ghiChu, trangThai);
//			arrTaiKhoan.add(itemTaiKhoanBean);
		}
		System.out.println(arrTaiKhoan.size()+"");
		return arrTaiKhoan;
	}
	
	/**
	 * lay thong tin cua 1 user
	 * @param userName
	 */
	public TaiKhoanBean getThongTinTaiKhoan(String userName) {
		Connection conn = common.DataBaseConnect.getConnect();
		TaiKhoanBean taiKhoanBean=null;
		String sql=	String.format("select * from taikhoan where Username= '%s'", userName);
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()){
				taiKhoanBean=new TaiKhoanBean();
				taiKhoanBean.setUserName(rs.getString("Username"));
				taiKhoanBean.setPassWord(rs.getString("Pass"));
				taiKhoanBean.seteMail(rs.getString("Email"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taiKhoanBean;
	}
	
	/**
	 * Cap nhat thong tin tai khoan
	 * @param userName
	 * @param passWord
	 * @param eMail
	 */
	public void capNhatThongTinTaiKhoan(String userName, String passWord) {
		Connection conn = common.DataBaseConnect.getConnect();
		String sql=	String.format("update TaiKhoan set Pass= '%s' where Username='%s'",passWord, userName);
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<BaiDangBean> danhSachYeuThich(TaiKhoanBean user) {
		ArrayList<BaiDangBean> listYeuThich = new ArrayList<BaiDangBean>();
		BaiDangBean baiDang;
		try {
			st=getConnect().createStatement();
			rs=st.executeQuery("select * FROM BaiDang "
					+ "join Thich on BaiDang.MaBaiDang=Thich.MaBaiDang "
					+ "join DanhMuc on BaiDang.MaDanhMuc=DanhMuc.MaDanhMuc "
					+ "where Thich.Username= '"+user.getUserName()+"' and BaiDang.Username != '"+user.getUserName()+"'");
			while(rs.next()){
				baiDang = new BaiDangBean();
				baiDang.setMaBaiDang(rs.getInt("MaBaiDang"));
				baiDang.setTieuDe(rs.getString("TieuDe"));
				baiDang.setNoiDung(rs.getString("NoiDung"));
				baiDang.setDiaChi(rs.getString("DiaChi"));
				baiDang.setDiaChiWeb(rs.getString("DiaChiWeb"));
				baiDang.setsDT(rs.getString("SDT"));
				baiDang.setAnhBia(rs.getString("AnhBia"));
				baiDang.setMaDanhMuc(rs.getInt("maDanhMuc"));
				baiDang.setTenDanhMuc(rs.getString("TenDanhMuc"));
				baiDang.setDiemDanhGia(rs.getInt("DiemDanhGia"));
				listYeuThich.add(baiDang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				getConnect().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listYeuThich;
	}

	/**
	 * Ham danh sach bai dang by user
	 * @param username
	 * @return
	 */
	public static ArrayList<BaiDangBean> danhSachBaiDang(TaiKhoanBean username){
		Connection con= DataBaseConnect.getConnect();
		String sql=	"select * from baidang inner join loaitin on baidang.maloaitin= loaitin.maloaitin inner join danhmuc on baidang.madanhmuc= danhmuc.madanhmuc where username='"+username.getUserName() +"'";
		ResultSet rs = null;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<BaiDangBean> listBD = new ArrayList<BaiDangBean>();
		BaiDangBean baiDangBean;
		try {
			while(rs.next()){
				baiDangBean = new BaiDangBean();
				baiDangBean.setMaBaiDang(rs.getInt("MaBaiDang"));
				baiDangBean.setTieuDe(rs.getString("TieuDe"));
				baiDangBean.setMaLoaiTin(rs.getInt("MaLoaiTin"));
				baiDangBean.setTenLoaiTin(rs.getString("TenLoaiTin"));
				baiDangBean.setTenDanhMuc(rs.getString("TenDanhMuc"));
				baiDangBean.setNgayHetHan(rs.getDate("NgayHetHan"));
				listBD.add(baiDangBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBD;
	}


	/**
	 * Ham lay danh sach tai khoan
	 * @return
	 */
	public ArrayList<TaiKhoanBean> getListTaiKhoan() {
		ArrayList<TaiKhoanBean> list = new ArrayList<>();
		try {
			st=getConnect().createStatement();
			String sql= "select taikhoan.*, quyen.tenquyen, loaitaikhoan.TenLoaiTK FROM taikhoan inner join quyen on taikhoan.maquyen= quyen.maquyen inner join loaitaikhoan on taikhoan.maloaitk= loaitaikhoan.maloaitk";
			rs=st.executeQuery(sql);
			TaiKhoanBean taiKhoanBean;
			int i=0;
			while(rs.next()){
				taiKhoanBean = new TaiKhoanBean();
				i++;
				taiKhoanBean.setsTT(i);
				taiKhoanBean.setUserName(rs.getString("Username"));
				taiKhoanBean.setTenQuyen(rs.getString("TenQuyen"));
				taiKhoanBean.setTenLoaiTaiKhoan(rs.getString("TenLoaiTK"));
				taiKhoanBean.setHoTen(rs.getString("HoTen"));
				taiKhoanBean.setGioiTinh(StringProcess.gioiTinh(rs.getString("GioiTinh")));
				taiKhoanBean.setNgaySinh(rs.getString("NgaySinh"));
				taiKhoanBean.setsDT(rs.getString("SDT"));
				taiKhoanBean.seteMail(rs.getString("Email"));
				list.add(taiKhoanBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				getConnect().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * Ham xoa tai khoan
	 * @param user
	 */
	public void xoaTaiKhoan(String user) {
		String sql=	String.format("DELETE FROM taikhoan WHERE username = '%s'", user);
		try {
			st=getConnect().createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				getConnect().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

	/**
	 * Ham them tai khoan cua Admin
	 * @param taiKhoan
	 */
		public void themTaiKhoan(TaiKhoanBean taiKhoan) {
			String sql= "insert into taikhoan values('"+taiKhoan.getUserName()+"', '"+taiKhoan.getPassWord()+"',"
					+ "'"+taiKhoan.geteMail()+"','"+taiKhoan.getAvatar()+"','"+taiKhoan.getHoTen()+"',"
							+ "'"+taiKhoan.getGioiTinh()+"','"+taiKhoan.getNgaySinh()+"','"+taiKhoan.getsDT()+"',"
									+ "'"+taiKhoan.getNgayDangKy()+"','"+taiKhoan.getMaQuyen()+"','"+taiKhoan.getMaLoaiTaiKhoan()+"')";
			try {
				PreparedStatement prepSt = getConnect().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				System.out.println("sql themtaikhoan= "+sql);
				prepSt.executeUpdate();
			} catch (SQLException e1) {
				 
				e1.printStackTrace();
			}
			System.out.println("sql themtaikhoan= "+sql);
			try {
				st=getConnect().createStatement();
				st.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
			try {
				getConnect().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}
		
		/**
		 * Ham lay danh sach tai khoan theo user
		 * @param username
		 * @return
		 */
		public TaiKhoanBean getListTaiKhoan(String username){
			String sql= String.format("select * from taikhoan where username= '%s'", username);
			try {
				st=getConnect().createStatement();
				rs= st.executeQuery(sql);
			} catch (SQLException e) {
				 
				e.printStackTrace();
			}
			
			TaiKhoanBean taiKhoanBean=null;
			try {
				while(rs.next()){
					taiKhoanBean= new TaiKhoanBean();
					taiKhoanBean.setUserName(rs.getString("Username"));
					taiKhoanBean.setPassWord(rs.getString("Pass"));
					taiKhoanBean.setHoTen(rs.getString("HoTen"));
					taiKhoanBean.setGioiTinh(StringProcess.gioiTinh(rs.getString("GioiTinh")));
					taiKhoanBean.setNgaySinh(rs.getString("NgaySinh"));
					taiKhoanBean.setsDT(rs.getString("SDT"));
					taiKhoanBean.seteMail(rs.getString("Email"));
					taiKhoanBean.setNgayDangKy(rs.getString("NgayDangKy"));
				}
			} catch (SQLException e) {
				 
				e.printStackTrace();
			}
			return taiKhoanBean;
		}
		
		/**
		 * Ham sua thong tin tai khoan
		 * @param taiKhoan
		 */
		public void suaTaiKhoan(TaiKhoanBean taiKhoan){
			String sql="update taikhoan set pass='"+taiKhoan.getPassWord()+"', email='"+taiKhoan.geteMail()+"',"
					+ " avatar='Avatar', hoten=N'"+taiKhoan.getHoTen()+"', gioitinh='"+taiKhoan.getGioiTinh()+"', "
							+ "ngaysinh='"+new Date(taiKhoan.getNgayDangDate().getTime())+"', "
									+ "sdt='"+taiKhoan.getsDT()+"', "
											+ "ngaydangky='"+new Date(taiKhoan.getNgayDangDate().getTime())+"',"
									+ " maquyen='"+taiKhoan.getMaQuyen()+"', maloaitk='"+taiKhoan.getMaLoaiTaiKhoan()+"' "
											+ "where username='"+taiKhoan.getUserName()+"'";
			PreparedStatement prepSt;
			try {
				prepSt = getConnect().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				prepSt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
	

}
