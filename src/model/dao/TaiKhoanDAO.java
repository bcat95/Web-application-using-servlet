package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.DataBaseConnect;
import model.bean.BaiDangBean;
import model.bean.BinhLuanBean;
import model.bean.TaiKhoanBean;
import model.bean.User;

public class TaiKhoanDAO extends DataBaseConnect{
	private static PreparedStatement prepSt=null;
	private static Statement st=null;
	private static ResultSet rs=null;
	private ArrayList<TaiKhoanBean> arrTaiKhoan;

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
	public TaiKhoanBean selectOne(String username) {
		Connection conn = common.DataBaseConnect.getConnect();
		String sql=	"SELECT Username, Pass, HoTen, MaQuyen FROM TaiKhoan where Username = '"+username+"'";
		ResultSet resultSet = null;
		TaiKhoanBean item = null;
		try {
			Statement stmt = conn.createStatement();
			resultSet = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(resultSet.next())
			{
				item  = new TaiKhoanBean (resultSet.getString("Username"), 
						resultSet.getString("Pass"),
						resultSet.getString("HoTen"),
						resultSet.getInt("MaQuyen"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return item;
	}
	
	/**
	 * get all list thanh vien create by 
	 * 
	 * @return list thanh vien
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
			String email = rs.getString("Email");
			String hoTen = rs.getString("HoTen");
			String matKhau = rs.getString("MatKhau");
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
				String user= rs.getString("Username");
				String pass= rs.getString("Pass");
				String mail= rs.getString("Email");
				/*taiKhoanBean.setUserName(rs.getString("Username"));
				taiKhoanBean.setPassWord(rs.getString("Pass"));
				taiKhoanBean.seteMail(rs.getString("Email"));
				taiKhoan.add(taiKhoanBean);*/
				taiKhoanBean= new TaiKhoanBean(user, pass, mail, 0);
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

	public static ArrayList<BaiDangBean> danhSachYeuThich(User user) {
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
	//danh sach bai dang by user
	public static ArrayList<BaiDangBean> danhSachBaiDang(User username){
		Connection con= DataBaseConnect.getConnect();
		//String sql=	"select baidang.tieude, loaitin.tenloaitin, danhmuc.tendanhmuc, baidang.ngayhethan from baidang inner join loaitin on baidang.maloaitin= loaitin.maloaitin inner join danhmuc on baidang.madanhmuc= danhmuc.madanhmuc where username='"+username.getUserName() +"'";
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
	

}
