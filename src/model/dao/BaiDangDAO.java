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
import model.bean.HinhAnhBean;
/**
 * BaiDangDAO
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
 * 14-3-2017         DonNA            Create
 */
public class BaiDangDAO extends DataBaseConnect{
	private static PreparedStatement prepSt=null;
	private static Statement st=null;
	private static ResultSet rs=null;
	
	/**
	 * Ham lay danh sach bai dang
	 * @return
	 */
	public ArrayList<BaiDangBean> getListBaiDang() {
		ArrayList<BaiDangBean> list = new ArrayList<BaiDangBean>();
		try {
			st=getConnect().createStatement();
			rs=st.executeQuery("select * FROM BaiDang,DanhMuc,TinhThanh where "
					+ "BaiDang.MaDanhMuc=DanhMuc.MaDanhMuc and BaiDang.MaTinhThanh=TinhThanh.MaTinhThanh "
					+ "and MaLoaiTin=2");
			BaiDangBean BaiDang;
			while(rs.next()){
				BaiDang = new BaiDangBean();
				BaiDang.setMaBaiDang(rs.getInt("MaBaiDang"));
				BaiDang.setTieuDe(rs.getString("TieuDe"));
				BaiDang.setNoiDung(rs.getString("NoiDung"));
				BaiDang.setDiaChi(rs.getString("DiaChi"));
				BaiDang.setDiaChiWeb(rs.getString("DiaChiWeb"));
				BaiDang.setsDT(rs.getString("SDT"));
				BaiDang.setAnhBia(rs.getString("AnhBia"));
				BaiDang.setMaDanhMuc(rs.getInt("maDanhMuc"));
				BaiDang.setTenDanhMuc(rs.getString("TenDanhMuc"));
				BaiDang.setMaTinhThanh(rs.getInt("MaTinhThanh"));
				BaiDang.setTenTinhThanh(rs.getString("TenTinhThanh"));
				BaiDang.setDiemDanhGia(rs.getInt("DiemDanhGia"));
				BaiDang.setGiaThapNhat(rs.getInt("GiaThapNhat"));
				BaiDang.setGiaCaoNhat(rs.getInt("GiaCaoNhat"));
				BaiDang.setViDo(rs.getString("ViDo"));
				BaiDang.setKinhDo(rs.getString("KinhDO"));
				list.add(BaiDang);
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
	 * Ham lay danh sach bai dang theo Danh muc bai dang
	 * @param i
	 * @return
	 */
	public ArrayList<BaiDangBean> getListBaiDangByDM(int i) {
		ArrayList<BaiDangBean> list = new ArrayList<BaiDangBean>();
		try {
			st=getConnect().createStatement();
			rs=st.executeQuery("select Top 7 * FROM BaiDang,DanhMuc where "
					+ " BaiDang.MaDanhMuc=DanhMuc.MaDanhMuc and BaiDang.MaDanhMuc= "+i+"  "
							+ "and MaLoaiTin=2 order by NgayDang desc");
			BaiDangBean BaiDang;
			while(rs.next()){
				BaiDang = new BaiDangBean();
				BaiDang.setMaBaiDang(rs.getInt("MaBaiDang"));
				BaiDang.setTieuDe(rs.getString("TieuDe"));
				BaiDang.setNoiDung(rs.getString("NoiDung"));
				BaiDang.setDiaChi(rs.getString("DiaChi"));
				BaiDang.setDiaChiWeb(rs.getString("DiaChiWeb"));
				BaiDang.setsDT(rs.getString("SDT"));
				BaiDang.setAnhBia(rs.getString("AnhBia"));
				BaiDang.setMaDanhMuc(rs.getInt("maDanhMuc"));
				BaiDang.setTenDanhMuc(rs.getString("TenDanhMuc"));
				BaiDang.setDiemDanhGia(rs.getInt("DiemDanhGia"));
				BaiDang.setViDo(rs.getString("ViDo"));
				BaiDang.setKinhDo(rs.getString("KinhDO"));
				BaiDang.setSoLuotThich(rs.getInt("SoLuotThich"));
				list.add(BaiDang);
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
	
	//------------------TIM KIEM------------------//
	/**
	 * Ham lay danh sach bai dang theo ma danh muc (Tim kiem)
	 * @param maDanhMuc
	 * @return
	 */
	public ArrayList<BaiDangBean> getListBaiDangDanhMuc(String maDanhMuc) {
		Connection connection = common.DataBaseConnect.getConnect();
		String sql=	"SELECT * FROM BaiDang bd "
					+"INNER JOIN TinhThanh tt ON tt.MaTinhThanh=bd.MaTinhThanh "
					+"INNER JOIN DanhMuc dm ON bd.MaDanhMuc=dm.MaDanhMuc "
					+"INNER JOIN LoaiTin lt ON bd.MaLoaiTin=lt.MaLoaiTin "
					+"WHERE bd.MaLoaiTin=2 and bd.MaDanhMuc='"+maDanhMuc+"'";
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<BaiDangBean> list = new ArrayList<BaiDangBean>();
		BaiDangBean BaiDang;
		try {
			while(rs.next()){
				BaiDang = new BaiDangBean();
				BaiDang.setMaBaiDang(rs.getInt("MaBaiDang"));
				BaiDang.setTieuDe(rs.getString("TieuDe"));
				BaiDang.setNoiDung(rs.getString("NoiDung"));
				BaiDang.setDiaChi(rs.getString("DiaChi"));
				BaiDang.setDiaChiWeb(rs.getString("DiaChiWeb"));
				BaiDang.setsDT(rs.getString("SDT"));
				BaiDang.setAnhBia(rs.getString("AnhBia"));
				BaiDang.setTenDanhMuc(rs.getString("TenDanhMuc"));
				BaiDang.setTenTinhThanh(rs.getString("TenTinhThanh"));
				BaiDang.setDiemDanhGia(rs.getInt("DiemDanhGia"));
				BaiDang.setViDo(rs.getString("ViDo"));
				BaiDang.setKinhDo(rs.getString("KinhDO"));
				BaiDang.setGiaThapNhat(rs.getInt("GiaThapNhat"));
				BaiDang.setGiaCaoNhat(rs.getInt("GiaCaoNhat"));
				list.add(BaiDang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Ham lay danh sach bai dang theo ma tinh thanh (Tim kiem)
	 * @param maTinhThanh
	 * @return
	 */
	public ArrayList<BaiDangBean> getListBaiDangTinhThanh(String maTinhThanh) {
		Connection connection = common.DataBaseConnect.getConnect();
		String sql=	"SELECT * FROM BaiDang bd "
					+"INNER JOIN TinhThanh tt ON tt.MaTinhThanh=bd.MaTinhThanh "
					+"INNER JOIN DanhMuc dm ON bd.MaDanhMuc=dm.MaDanhMuc "
					+"INNER JOIN LoaiTin lt ON bd.MaLoaiTin=lt.MaLoaiTin "
					+"WHERE bd.MaLoaiTin=2 and bd.MaTinhThanh='"+maTinhThanh+"'";
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<BaiDangBean> list = new ArrayList<BaiDangBean>();
		BaiDangBean BaiDang;
		try {
			while(rs.next()){
				BaiDang = new BaiDangBean();
				BaiDang.setMaBaiDang(rs.getInt("MaBaiDang"));
				BaiDang.setTieuDe(rs.getString("TieuDe"));
				BaiDang.setNoiDung(rs.getString("NoiDung"));
				BaiDang.setDiaChi(rs.getString("DiaChi"));
				BaiDang.setDiaChiWeb(rs.getString("DiaChiWeb"));
				BaiDang.setsDT(rs.getString("SDT"));
				BaiDang.setAnhBia(rs.getString("AnhBia"));
				BaiDang.setTenDanhMuc(rs.getString("TenDanhMuc"));
				BaiDang.setTenTinhThanh(rs.getString("TenTinhThanh"));
				BaiDang.setDiemDanhGia(rs.getInt("DiemDanhGia"));
				BaiDang.setViDo(rs.getString("ViDo"));
				BaiDang.setKinhDo(rs.getString("KinhDO"));
				BaiDang.setGiaThapNhat(rs.getInt("GiaThapNhat"));
				BaiDang.setGiaCaoNhat(rs.getInt("GiaCaoNhat"));
				list.add(BaiDang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Ham lay danh sach bai dang theo danh muc va Tinh thanh
	 * @param maDanhMuc
	 * @param maTinhThanh
	 * @return
	 */
	public ArrayList<BaiDangBean> getListBaiDangDanhMucTinhThanh(String maDanhMuc,String maTinhThanh) {
		Connection connection = common.DataBaseConnect.getConnect();
		String sql=	"SELECT * FROM BaiDang bd "
					+"INNER JOIN TinhThanh tt ON tt.MaTinhThanh=bd.MaTinhThanh "
					+"INNER JOIN DanhMuc dm ON bd.MaDanhMuc=dm.MaDanhMuc "
					+"INNER JOIN LoaiTin lt ON bd.MaLoaiTin=lt.MaLoaiTin "
					+"WHERE bd.MaLoaiTin=2 and bd.MaDanhMuc='"+maDanhMuc+"' AND bd.MaTinhThanh='"+maTinhThanh+"'";
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<BaiDangBean> list = new ArrayList<BaiDangBean>();
		BaiDangBean BaiDang;
		try {
			while(rs.next()){
				BaiDang = new BaiDangBean();
				BaiDang.setMaBaiDang(rs.getInt("MaBaiDang"));
				BaiDang.setTieuDe(rs.getString("TieuDe"));
				BaiDang.setNoiDung(rs.getString("NoiDung"));
				BaiDang.setDiaChi(rs.getString("DiaChi"));
				BaiDang.setDiaChiWeb(rs.getString("DiaChiWeb"));
				BaiDang.setsDT(rs.getString("SDT"));
				BaiDang.setAnhBia(rs.getString("AnhBia"));
				BaiDang.setTenDanhMuc(rs.getString("TenDanhMuc"));
				BaiDang.setTenTinhThanh(rs.getString("TenTinhThanh"));
				BaiDang.setDiemDanhGia(rs.getInt("DiemDanhGia"));
				BaiDang.setViDo(rs.getString("ViDo"));
				BaiDang.setKinhDo(rs.getString("KinhDO"));
				BaiDang.setGiaThapNhat(rs.getInt("GiaThapNhat"));
				BaiDang.setGiaCaoNhat(rs.getInt("GiaCaoNhat"));
				list.add(BaiDang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Ham lay danh sach bai dang theo noi dung ma user nhap vao
	 * @param noiDung
	 * @return
	 */
	public ArrayList<BaiDangBean> getListBaiDangNoiDung(String noiDung) {
		Connection connection = common.DataBaseConnect.getConnect();
		String sql=	"SELECT * FROM BaiDang bd "
					+"INNER JOIN TinhThanh tt ON tt.MaTinhThanh=bd.MaTinhThanh "
					+"INNER JOIN DanhMuc dm ON bd.MaDanhMuc=dm.MaDanhMuc "
					+"INNER JOIN LoaiTin lt ON bd.MaLoaiTin=lt.MaLoaiTin "
					+"WHERE bd.MaLoaiTin=2 and  (bd.TieuDe LIKE N'%"+noiDung+"%' OR bd.NoiDung LIKE N'%"+noiDung+"%')";
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<BaiDangBean> list = new ArrayList<BaiDangBean>();
		BaiDangBean BaiDang;
		try {
			while(rs.next()){
				BaiDang = new BaiDangBean();
				BaiDang.setMaBaiDang(rs.getInt("MaBaiDang"));
				BaiDang.setTieuDe(rs.getString("TieuDe"));
				BaiDang.setNoiDung(rs.getString("NoiDung"));
				BaiDang.setDiaChi(rs.getString("DiaChi"));
				BaiDang.setDiaChiWeb(rs.getString("DiaChiWeb"));
				BaiDang.setsDT(rs.getString("SDT"));
				BaiDang.setAnhBia(rs.getString("AnhBia"));
				BaiDang.setTenDanhMuc(rs.getString("TenDanhMuc"));
				BaiDang.setTenTinhThanh(rs.getString("TenTinhThanh"));
				BaiDang.setDiemDanhGia(rs.getInt("DiemDanhGia"));
				BaiDang.setViDo(rs.getString("ViDo"));
				BaiDang.setKinhDo(rs.getString("KinhDO"));
				BaiDang.setGiaThapNhat(rs.getInt("GiaThapNhat"));
				BaiDang.setGiaCaoNhat(rs.getInt("GiaCaoNhat"));
				list.add(BaiDang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Ham lay danh sach bai dang theo Danh muc va Noi dung ma user nhap vao
	 * @param maDanhMuc
	 * @param noiDung
	 * @return
	 */
	public ArrayList<BaiDangBean> getListBaiDangDanhMucNoiDung(String maDanhMuc,String noiDung) {
		Connection connection = common.DataBaseConnect.getConnect();
		String sql=	"SELECT * FROM BaiDang bd "
					+"INNER JOIN TinhThanh tt ON tt.MaTinhThanh=bd.MaTinhThanh "
					+"INNER JOIN DanhMuc dm ON bd.MaDanhMuc=dm.MaDanhMuc "
					+"INNER JOIN LoaiTin lt ON bd.MaLoaiTin=lt.MaLoaiTin "
					+"WHERE bd.MaLoaiTin=2 and (bd.TieuDe LIKE N'%"+noiDung+"%' OR bd.NoiDung LIKE N'%"+noiDung+"%') AND bd.MaDanhMuc='"+maDanhMuc+"'";
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<BaiDangBean> list = new ArrayList<BaiDangBean>();
		BaiDangBean BaiDang;
		try {
			while(rs.next()){
				BaiDang = new BaiDangBean();
				BaiDang.setMaBaiDang(rs.getInt("MaBaiDang"));
				BaiDang.setTieuDe(rs.getString("TieuDe"));
				BaiDang.setNoiDung(rs.getString("NoiDung"));
				BaiDang.setDiaChi(rs.getString("DiaChi"));
				BaiDang.setDiaChiWeb(rs.getString("DiaChiWeb"));
				BaiDang.setsDT(rs.getString("SDT"));
				BaiDang.setAnhBia(rs.getString("AnhBia"));
				BaiDang.setTenDanhMuc(rs.getString("TenDanhMuc"));
				BaiDang.setTenTinhThanh(rs.getString("TenTinhThanh"));
				BaiDang.setDiemDanhGia(rs.getInt("DiemDanhGia"));
				BaiDang.setViDo(rs.getString("ViDo"));
				BaiDang.setKinhDo(rs.getString("KinhDO"));
				BaiDang.setGiaThapNhat(rs.getInt("GiaThapNhat"));
				BaiDang.setGiaCaoNhat(rs.getInt("GiaCaoNhat"));
				list.add(BaiDang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Ham lay danh sach bai dang theo tinh thanh va noi dung ma user nhap vao
	 * @param maTinhThanh
	 * @param noiDung
	 * @return
	 */
	public ArrayList<BaiDangBean> getListBaiDangTinhThanhNoiDung(String maTinhThanh,String noiDung) {
		Connection connection = common.DataBaseConnect.getConnect();
		String sql=	"SELECT * FROM BaiDang bd "
					+"INNER JOIN TinhThanh tt ON tt.MaTinhThanh=bd.MaTinhThanh "
					+"INNER JOIN DanhMuc dm ON bd.MaDanhMuc=dm.MaDanhMuc "
					+"INNER JOIN LoaiTin lt ON bd.MaLoaiTin=lt.MaLoaiTin "
					+"WHERE bd.MaLoaiTin=2 and (bd.TieuDe LIKE N'%"+noiDung+"%' OR bd.NoiDung LIKE N'%"+noiDung+"%' AND bd.MaTinhThanh='"+maTinhThanh+"')";
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<BaiDangBean> list = new ArrayList<BaiDangBean>();
		BaiDangBean BaiDang;
		try {
			while(rs.next()){
				BaiDang = new BaiDangBean();
				BaiDang.setMaBaiDang(rs.getInt("MaBaiDang"));
				BaiDang.setTieuDe(rs.getString("TieuDe"));
				BaiDang.setNoiDung(rs.getString("NoiDung"));
				BaiDang.setDiaChi(rs.getString("DiaChi"));
				BaiDang.setDiaChiWeb(rs.getString("DiaChiWeb"));
				BaiDang.setsDT(rs.getString("SDT"));
				BaiDang.setAnhBia(rs.getString("AnhBia"));
				BaiDang.setTenDanhMuc(rs.getString("TenDanhMuc"));
				BaiDang.setTenTinhThanh(rs.getString("TenTinhThanh"));
				BaiDang.setDiemDanhGia(rs.getInt("DiemDanhGia"));
				BaiDang.setViDo(rs.getString("ViDo"));
				BaiDang.setKinhDo(rs.getString("KinhDO"));
				BaiDang.setGiaThapNhat(rs.getInt("GiaThapNhat"));
				BaiDang.setGiaCaoNhat(rs.getInt("GiaCaoNhat"));
				list.add(BaiDang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Ham lay danh sach bai dang theo Danh muc, Tinh thanh va noi dung ma user nhap vao
	 * @param maDanhMuc
	 * @param maTinhThanh
	 * @param noiDung
	 * @return
	 */
	public ArrayList<BaiDangBean> getListBaiDangDanhMucTinhThanhNoiDung(String maDanhMuc,String maTinhThanh,String noiDung) {
		Connection connection = common.DataBaseConnect.getConnect();
		String sql=	"SELECT * FROM BaiDang bd "
					+"INNER JOIN TinhThanh tt ON tt.MaTinhThanh=bd.MaTinhThanh "
					+"INNER JOIN DanhMuc dm ON bd.MaDanhMuc=dm.MaDanhMuc "
					+"INNER JOIN LoaiTin lt ON bd.MaLoaiTin=lt.MaLoaiTin "
					+"WHERE bd.MaLoaiTin=2 and (bd.TieuDe LIKE N'%"+noiDung+"%' OR bd.NoiDung LIKE N'%"+noiDung+"%') AND bd.MaDanhMuc='"+maDanhMuc+"' AND bd.MaTinhThanh='"+maTinhThanh+"'";
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<BaiDangBean> list = new ArrayList<BaiDangBean>();
		BaiDangBean BaiDang;
		try {
			while(rs.next()){
				BaiDang = new BaiDangBean();
				BaiDang.setMaBaiDang(rs.getInt("MaBaiDang"));
				BaiDang.setTieuDe(rs.getString("TieuDe"));
				BaiDang.setNoiDung(rs.getString("NoiDung"));
				BaiDang.setDiaChi(rs.getString("DiaChi"));
				BaiDang.setDiaChiWeb(rs.getString("DiaChiWeb"));
				BaiDang.setsDT(rs.getString("SDT"));
				BaiDang.setAnhBia(rs.getString("AnhBia"));
				BaiDang.setTenDanhMuc(rs.getString("TenDanhMuc"));
				BaiDang.setTenTinhThanh(rs.getString("TenTinhThanh"));
				BaiDang.setDiemDanhGia(rs.getInt("DiemDanhGia"));
				BaiDang.setViDo(rs.getString("ViDo"));
				BaiDang.setKinhDo(rs.getString("KinhDO"));
				BaiDang.setGiaThapNhat(rs.getInt("GiaThapNhat"));
				BaiDang.setGiaCaoNhat(rs.getInt("GiaCaoNhat"));
				list.add(BaiDang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//------------------END TIM KIEM------------------//
	
	/**
	 * Ham them moi bai dang
	 * @param baiDang
	 */
	public static void insertBaiDang(BaiDangBean baiDang) {
		try {
				String insertTableSQL = "insert into BaiDang values(?,?,?,?,?,?,?,?,?,?,?,NULL,NULL,NULL,?,?,?,?,?)";
				PreparedStatement prepSt = getConnect().prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);
				prepSt.setString(1, baiDang.getTieuDe());
				prepSt.setString(2, baiDang.getNoiDung());
				prepSt.setString(3, baiDang.getAnhBia());
				prepSt.setString(4, baiDang.getDiaChi());
				prepSt.setString(5, baiDang.getDiaChiWeb());
				prepSt.setString(6, baiDang.getViDo());
				prepSt.setString(7, baiDang.getKinhDo());
				prepSt.setString(8, baiDang.getsDT());
				prepSt.setInt(9, baiDang.getGiaCaoNhat());
				prepSt.setInt(10, baiDang.getGiaThapNhat());
				prepSt.setDate(11, new Date(StringProcess.getNgayDangDate().getTime()));
				prepSt.setString(12, baiDang.getUserName());
				prepSt.setInt(13, baiDang.getMaDanhMuc());
				//prepSt.setInt(14, baiDang.getMaLoaiTin());
				prepSt.setInt(14, 1);
				prepSt.setInt(15, baiDang.getMaTinhThanh());
				prepSt.setFloat(16, baiDang.getDiemDanhGia());
				prepSt.executeUpdate();
				try (ResultSet generatedKeys = prepSt.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		                baiDang.setMaBaiDang(generatedKeys.getInt(1));
		            }
		            else {
		                throw new SQLException("K the tao bai dang");
		            }
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
		}
	
	/**
	 * Ham them hinh anh vao CSDL
	 * @param baiDang
	 * @param hinhAnhBean
	 */
	public static void insertHinhAnh(BaiDangBean baiDang, HinhAnhBean hinhAnhBean) {
		System.out.println("loi anh"+hinhAnhBean.getHinhAnh().length);
		if(baiDang.getMaBaiDang()!=0){
			int lshinhanhlen=hinhAnhBean.getHinhAnh().length;
			for (int i=0;i<lshinhanhlen;i++)
			{
				try {
					prepSt=getConnect().prepareStatement("insert into HinhAnh values(?,?)");
					prepSt.setString(1, "upload/img/bai-dang/"+hinhAnhBean.getHinhAnh()[i]);
					prepSt.setInt(2, baiDang.getMaBaiDang());
					prepSt.executeUpdate();
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
		}
		else {
            try {
				throw new SQLException("K co khoa chinh ma bai dang");
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
		
	}
	
	/**
	 * Lay thong tin chi tiet bai dang 
	 * @param maBaiDang
	 * @return
	 */
	public static BaiDangBean infobaiDang(int maBaiDang) {
		BaiDangBean baiDang= new BaiDangBean();
		KhuyenMaiDAO khuyenMaiDAO=new KhuyenMaiDAO();
		baiDang = new BaiDangBean();
		try {
			st=getConnect().createStatement();
			rs=st.executeQuery("select * FROM BaiDang "
					+ "join DanhMuc on BaiDang.MaDanhMuc= DanhMuc.MaDanhMuc "
					+ "join TinhThanh on BaiDang.MaTinhThanh= TinhThanh.MaTinhThanh "
					+ "where BaiDang.MaBaiDang = "+maBaiDang+"");
			while(rs.next()){
				baiDang.setMaBaiDang(rs.getInt("MaBaiDang"));
				baiDang.setMaLoaiTin(rs.getInt("MaLoaiTin"));
				baiDang.setUserName(rs.getString("Username"));
				baiDang.setTieuDe(rs.getString("TieuDe"));
				baiDang.setNoiDung(rs.getString("NoiDung"));
				baiDang.setDiaChi(rs.getString("DiaChi"));
				baiDang.setDiaChiWeb(rs.getString("DiaChiWeb"));
				baiDang.setsDT(rs.getString("SDT"));
				baiDang.setAnhBia(rs.getString("AnhBia"));
				baiDang.setDiemDanhGia(rs.getFloat("DiemDanhGia"));
				baiDang.setTenDanhMuc(rs.getString("TenDanhMuc"));
				baiDang.setMaTinhThanh(rs.getInt("maTinhThanh"));
				baiDang.setTenTinhThanh(rs.getString("TenTinhThanh"));
				baiDang.setKinhDo(rs.getString("kinhDo"));
				baiDang.setViDo(rs.getString("viDo"));
				baiDang.setGiaThapNhat(rs.getInt("GiaThapNhat"));
				baiDang.setGiaCaoNhat(rs.getInt("GiaCaoNhat"));
				baiDang.setNgayDang(rs.getDate("NgayDang"));
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
		baiDang.setListKhuyenMai(khuyenMaiDAO.getListKhuyenMaiExp(maBaiDang));
		baiDang.setListHinhAnh(HinhAnhDAO.infoHinhAnhByMa(maBaiDang));
		baiDang.setListDichVu(DichVuDAO.infoDichVuByMa(maBaiDang));
		baiDang.setListBinhLuan(BinhLuanDAO.infoBinhLuanByMa(maBaiDang));
		return baiDang;
	}
	
	/**
	 * Ham sua thong tin chi tiet bai dang
	 * @param maBaiDang
	 * @return
	 */
	public static BaiDangBean infoSuaBaiDang(int maBaiDang) {
		BaiDangBean baiDang= new BaiDangBean();
		baiDang = new BaiDangBean();
		try {
			st=getConnect().createStatement();
			rs=st.executeQuery("select * FROM BaiDang "
					+ "where BaiDang.MaBaiDang = "+maBaiDang+"");
			while(rs.next()){
				baiDang.setMaBaiDang(rs.getInt("MaBaiDang"));
				baiDang.setMaLoaiTin(rs.getInt("MaLoaiTin"));
				baiDang.setUserName(rs.getString("Username"));
				baiDang.setTieuDe(rs.getString("TieuDe"));
				baiDang.setNoiDung(rs.getString("NoiDung"));
				baiDang.setDiaChi(rs.getString("DiaChi"));
				baiDang.setMaDanhMuc(rs.getInt("MaDanhMuc"));
				baiDang.setMaTinhThanh(rs.getInt("MaTinhThanh"));
				baiDang.setViDo(rs.getString("ViDo"));
				baiDang.setKinhDo(rs.getString("KinhDo"));
				baiDang.setDiaChiWeb(rs.getString("DiaChiWeb"));
				baiDang.setsDT(rs.getString("SDT"));
				baiDang.setAnhBia(rs.getString("AnhBia"));
				baiDang.setDiemDanhGia(rs.getInt("DiemDanhGia"));
				baiDang.setGiaThapNhat(rs.getInt("GiaThapNhat"));
				baiDang.setGiaCaoNhat(rs.getInt("GiaCaoNhat"));
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
		baiDang.setListHinhAnh(HinhAnhDAO.infoHinhAnhByMa(maBaiDang));
		baiDang.setListDichVu(DichVuDAO.infoDichVuByMa(maBaiDang));
		return baiDang;
	}
	
	
	/**
	 * Ham lay anh bia theo Ma
	 * @param maBaiDang
	 * @return
	 */
	public static String getAnhBiaByMa(int maBaiDang) {
		String path = "";
		try {
			st=getConnect().createStatement();
			rs=st.executeQuery("select AnhBia from BaiDang where MaBaiDang = "+maBaiDang+"");
			while(rs.next()){
				path=rs.getString("AnhBia");
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
		System.out.println("path: "+path);
		return path;
	}
	
	/**
	 * Ham sua bai dang
	 * @param baiDang
	 */
	public static void updateBaiDang(BaiDangBean baiDang) {
		try {
			String updateTableSQL  = "update BaiDang set TieuDe=?,NoiDung=?,DiaChi=?,DiaChiWeb=?,ViDo=?,KinhDo=?,SDT=?,GiaCaoNhat=?,GiaThapNhat=?,NgayDang=?,MaDanhMuc=?,MaLoaiTin=?,MaTinhThanh=? where MaBaiDang="+baiDang.getMaBaiDang()+"";
			PreparedStatement prepSt = getConnect().prepareStatement(updateTableSQL);
			prepSt.setString(1, baiDang.getTieuDe());
			prepSt.setString(2, baiDang.getNoiDung());
			prepSt.setString(3, baiDang.getDiaChi());
			prepSt.setString(4, baiDang.getDiaChiWeb());
			prepSt.setString(5, baiDang.getViDo());
			prepSt.setString(6, baiDang.getKinhDo());
			prepSt.setString(7, baiDang.getsDT());
			prepSt.setInt(8, baiDang.getGiaCaoNhat());
			prepSt.setInt(9, baiDang.getGiaThapNhat());
			prepSt.setDate(10, new Date(StringProcess.getNgayDangDate().getTime()));
			prepSt.setInt(11, baiDang.getMaDanhMuc());
			prepSt.setInt(12, 1);
			prepSt.setInt(13, baiDang.getMaTinhThanh());
			prepSt.executeUpdate();
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
	 * Ham gan anh bia cho tung bai dang theo ma bai dang tuong ung
	 * @param maBaiDang
	 * @param anhBia
	 */
	public static void setAnhBia(int maBaiDang, String anhBia) {
		if (anhBia != null){
			try {
				String updateTableSQL  = "update BaiDang set AnhBia=? where MaBaiDang="+maBaiDang+"";
				PreparedStatement prepSt = getConnect().prepareStatement(updateTableSQL);
				prepSt.setString(1, anhBia);
				prepSt.executeUpdate();
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
		
	}

	/**
	 * ham lay danh sach bai dang da duyet
	 * @return
	 */
	public ArrayList<BaiDangBean> getListBaiDangDaDuyet() {
		ArrayList<BaiDangBean> list = new ArrayList<BaiDangBean>();
		int i=0;
		try {
			st=getConnect().createStatement();
			rs=st.executeQuery("select baidang.mabaidang, baidang.tieude, danhmuc.tendanhmuc, baidang.ngaydang from baidang inner join danhmuc on baidang.madanhmuc= danhmuc.madanhmuc inner join loaitin on baidang.maloaitin= loaitin.maloaitin where loaitin.TenLoaiTin=N'Đã duyệt'");
			BaiDangBean BaiDang;
			
			while(rs.next()){
				
				BaiDang = new BaiDangBean();
				BaiDang.setMaBaiDang(rs.getInt("MaBaiDang"));
				BaiDang.setTieuDe(rs.getString("TieuDe"));
				BaiDang.setTenDanhMuc(rs.getString("TenDanhMuc"));
				BaiDang.setNgayDang(rs.getDate("NgayDang"));
				i++;
				BaiDang.setsTT(i);
				list.add(BaiDang);
				
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
		System.out.println(i);
		return list;
	}

	/**
	 * Ham xem chi tiet bai dang da duyet
	 * @param maBaiDang
	 * @return
	 */
	public BaiDangBean getListChiTietBaiDangDaDuyet(int maBaiDang) {
		
		BaiDangBean baiDang=null;
		try {
			st=getConnect().createStatement();
			String sql= String.format("select baidang.maBaiDang,baidang.tieude, noidung, anhbia, diachi, diachiweb, vido, kinhdo, sdt ,"
					+ " giacaonhat, giathapnhat,  baidang.ngaydang, NgayHetHan, soluottruycap, soluotthich,"
					+ " username, danhmuc.tendanhmuc, loaitin.tenloaitin, tinhthanh.tentinhthanh , diemdanhgia "
					+ "from baidang inner join danhmuc on baidang.madanhmuc= danhmuc.madanhmuc inner join loaitin "
					+ "on baidang.maloaitin= loaitin.maloaitin inner join tinhthanh on baidang.matinhthanh= tinhthanh.matinhthanh "
					+ "where loaitin.TenLoaiTin=N'Đã duyệt' and baidang.mabaidang= %d", maBaiDang);
			System.out.println(sql);
			rs=st.executeQuery(sql);
			
			while(rs.next()){
				baiDang= new BaiDangBean();
				baiDang.setMaBaiDang(rs.getInt("MaBaiDang"));
				baiDang.setTieuDe(rs.getString("TieuDe"));
				baiDang.setNoiDung(rs.getString("NoiDung"));
				baiDang.setAnhBia(rs.getString("AnhBia"));
				baiDang.setDiaChi(rs.getString("DiaChi"));
				baiDang.setDiaChiWeb(rs.getString("DiaChiWeb"));
				baiDang.setViDo(rs.getString("ViDo"));
				baiDang.setKinhDo(rs.getString("KinhDo"));
				baiDang.setsDT(rs.getString("SDT"));
				baiDang.setGiaCaoNhat(rs.getInt("GiaCaoNhat"));
				baiDang.setGiaThapNhat(rs.getInt("GiaThapNhat"));
				baiDang.setNgayDang(rs.getDate("NgayDang"));
				baiDang.setNgayHetHan(rs.getDate("NgayHetHan"));
				baiDang.setSoLuongTruyCap(rs.getInt("SoLuotTruyCap"));
				baiDang.setSoLuotThich(rs.getInt("SoLuotThich"));
				baiDang.setUserName(rs.getString("Username"));
				baiDang.setTenDanhMuc(rs.getString("TenDanhMuc"));
				baiDang.setTenLoaiTin(rs.getString("TenLoaiTin"));
				baiDang.setTenTinhThanh(rs.getString("TenTinhThanh"));
				baiDang.setDiemDanhGia(rs.getInt("DiemDanhGia"));
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
		return baiDang;
	}

	/**
	 * Ham lay danh sach bai dang da duyet theo ma bai dang
	 * @param maBaiDang
	 * @return
	 */
	public BaiDangBean getListBaiDangDaDuyet(int maBaiDang) {
		BaiDangBean BaiDang=null;
		try {
			st=getConnect().createStatement();
			String sql= String.format("select baidang.mabaidang, baidang.tieude, danhmuc.tendanhmuc, baidang.ngaydang from baidang inner join danhmuc on baidang.madanhmuc= danhmuc.madanhmuc inner join loaitin on baidang.maloaitin= loaitin.maloaitin where loaitin.TenLoaiTin=N'Đã duyệt' and baidang.mabaidang= %d", maBaiDang);
			rs=st.executeQuery(sql);
			
			while(rs.next()){
				BaiDang = new BaiDangBean();
				BaiDang.setMaBaiDang(rs.getInt("MaBaiDang"));
				BaiDang.setTieuDe(rs.getString("TieuDe"));
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
		return BaiDang;
	}
	
	/**
	 * Ham lay danh sach bai dang chua duyet theo ma bai dang
	 * @param maBaiDang
	 * @return
	 */
	public BaiDangBean getListBaiDangChuaDuyet(int maBaiDang) {
		BaiDangBean BaiDang=null;
		try {
			st=getConnect().createStatement();
			String sql= String.format("select baidang.mabaidang, baidang.tieude, danhmuc.tendanhmuc, baidang.ngaydang from baidang inner join danhmuc on baidang.madanhmuc= danhmuc.madanhmuc inner join loaitin on baidang.maloaitin= loaitin.maloaitin where loaitin.TenLoaiTin=N'Chưa duyệt' and baidang.mabaidang= %d", maBaiDang);
			rs=st.executeQuery(sql);
			
			while(rs.next()){
				BaiDang = new BaiDangBean();
				BaiDang.setMaBaiDang(rs.getInt("MaBaiDang"));
				BaiDang.setTieuDe(rs.getString("TieuDe"));
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
		return BaiDang;
	}
	
	/**
	 * Ham lay danh sach bai dang chua duyet
	 * @return
	 */
	public ArrayList<BaiDangBean> getListBaiDangChuaDuyet() {
		ArrayList<BaiDangBean> list = new ArrayList<BaiDangBean>();
		int i=0;
		try {
			st=getConnect().createStatement();
			String sql= String.format("select baidang.mabaidang, baidang.tieude, danhmuc.tendanhmuc, baidang.ngaydang from baidang inner join danhmuc on baidang.madanhmuc= danhmuc.madanhmuc inner join loaitin on baidang.maloaitin= loaitin.maloaitin where loaitin.TenLoaiTin=N'Chưa duyệt'");
			rs=st.executeQuery(sql);
			BaiDangBean BaiDang;
			while(rs.next()){
				BaiDang = new BaiDangBean();
				BaiDang.setMaBaiDang(rs.getInt("MaBaiDang"));
				BaiDang.setTieuDe(rs.getString("TieuDe"));
				BaiDang.setTenDanhMuc(rs.getString("TenDanhMuc"));
				BaiDang.setNgayDang(rs.getDate("NgayDang"));
				i++;
				BaiDang.setsTT(i);
				list.add(BaiDang);
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

	public void goBoBaiDang(int maBaiDang) {
		
		String sql=	String.format("DELETE FROM baidang WHERE maBaiDang = %d", maBaiDang);
		try {
			st=getConnect().createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Ham xem chi tiet bai dang chua duyet
	 * @param maBaiDang
	 * @return
	 */
	public BaiDangBean getListChiTietBaiDangChuaDuyet(int maBaiDang) {
		
		BaiDangBean baiDang=null;
		try {
			st=getConnect().createStatement();
			String sql= String.format("select baidang.maBaiDang, baidang.tieude, noidung, anhbia, diachi, diachiweb, vido, kinhdo, sdt ,"
					+ " giacaonhat, giathapnhat,  baidang.ngaydang, NgayHetHan, soluottruycap, soluotthich,"
					+ " username, danhmuc.tendanhmuc, loaitin.tenloaitin, tinhthanh.tentinhthanh , diemdanhgia "
					+ "from baidang inner join danhmuc on baidang.madanhmuc= danhmuc.madanhmuc inner join loaitin "
					+ "on baidang.maloaitin= loaitin.maloaitin inner join tinhthanh on baidang.matinhthanh= tinhthanh.matinhthanh "
					+ "where loaitin.TenLoaiTin=N'Chưa duyệt' and baidang.mabaidang= %d", maBaiDang);
			rs=st.executeQuery(sql);
			
			while(rs.next()){
				baiDang= new BaiDangBean();
				baiDang.setMaBaiDang(rs.getInt("MaBaiDang"));
				baiDang.setTieuDe(rs.getString("TieuDe"));
				baiDang.setNoiDung(rs.getString("NoiDung"));
				baiDang.setAnhBia(rs.getString("AnhBia"));
				baiDang.setDiaChi(rs.getString("DiaChi"));
				baiDang.setDiaChiWeb(rs.getString("DiaChiWeb"));
				baiDang.setViDo(rs.getString("ViDo"));
				baiDang.setKinhDo(rs.getString("KinhDo"));
				baiDang.setsDT(rs.getString("SDT"));
				baiDang.setGiaCaoNhat(rs.getInt("GiaCaoNhat"));
				baiDang.setGiaThapNhat(rs.getInt("GiaThapNhat"));
				baiDang.setNgayDang(rs.getDate("NgayDang"));
				baiDang.setNgayHetHan(rs.getDate("NgayHetHan"));
				baiDang.setSoLuongTruyCap(rs.getInt("SoLuotTruyCap"));
				baiDang.setSoLuotThich(rs.getInt("SoLuotThich"));
				baiDang.setUserName(rs.getString("Username"));
				baiDang.setTenDanhMuc(rs.getString("TenDanhMuc"));
				baiDang.setTenLoaiTin(rs.getString("TenLoaiTin"));
				baiDang.setTenTinhThanh(rs.getString("TenTinhThanh"));
				baiDang.setDiemDanhGia(rs.getInt("DiemDanhGia"));
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
		return baiDang;
	}
	
	/**
	 * Ham Duyet Bai dang trong trang chi tiet bai dang chua duyet
	 * @param maBaiDang
	 */
	public void setDuyetTin(int maBaiDang) {
		try {
			String updateTableSQL  = "update BaiDang set MaLoaiTin=2 where MaBaiDang="+maBaiDang+"";
			PreparedStatement prepSt = getConnect().prepareStatement(updateTableSQL);
			prepSt.executeUpdate();
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
	 * Ham huy duyet tin trong trang chi tiet bai dang da duyet
	 * @param maBaiDang
	 */
	public void goDuyetTin(int maBaiDang) {
		try {
			String updateTableSQL  = "update BaiDang set MaLoaiTin=1 where MaBaiDang="+maBaiDang+"";
			PreparedStatement prepSt = getConnect().prepareStatement(updateTableSQL);
			prepSt.executeUpdate();
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
	 * Ham lay danh sach bai dang cung tinh thanh theo ma bai dang
	 * @param maBaiDang
	 * @return
	 */
	public ArrayList<BaiDangBean> getListBaiDangCungTinhThanh(int maBaiDang) {
		Connection connection = common.DataBaseConnect.getConnect();
		String sql=	"SELECT top 5 * "
					+"FROM BaiDang bd "
					+"INNER JOIN TinhThanh tt ON tt.MaTinhThanh=bd.MaTinhThanh "
					+"INNER JOIN DanhMuc dm ON bd.MaDanhMuc=dm.MaDanhMuc "
					+"INNER JOIN LoaiTin lt ON bd.MaLoaiTin=lt.MaLoaiTin "
					+"WHERE bd.MaLoaiTin=2 and bd.MaTinhThanh= (select MaTinhThanh from BaiDang where MaBaiDang='"+maBaiDang+"') and bd.MaBaiDang<>'"+maBaiDang+"'";
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<BaiDangBean> list = new ArrayList<BaiDangBean>();
		BaiDangBean BaiDang;
		try {
			while(rs.next()){
				BaiDang = new BaiDangBean();
				BaiDang.setMaBaiDang(rs.getInt("MaBaiDang"));
				BaiDang.setTieuDe(rs.getString("TieuDe"));
				BaiDang.setNoiDung(rs.getString("NoiDung"));
				BaiDang.setDiaChi(rs.getString("DiaChi"));
				BaiDang.setDiaChiWeb(rs.getString("DiaChiWeb"));
				BaiDang.setsDT(rs.getString("SDT"));
				BaiDang.setAnhBia(rs.getString("AnhBia"));
				BaiDang.setTenDanhMuc(rs.getString("TenDanhMuc"));
				BaiDang.setTenTinhThanh(rs.getString("TenTinhThanh"));
				BaiDang.setDiemDanhGia(rs.getInt("DiemDanhGia"));
				BaiDang.setViDo(rs.getString("ViDo"));
				BaiDang.setKinhDo(rs.getString("KinhDO"));
				list.add(BaiDang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Ham get danh sach bai dang cung danh muc theo ma bai dang
	 * @param maBaiDang
	 * @return
	 */
	public ArrayList<BaiDangBean> getListBaiDangCungDanhMuc(int maBaiDang) {
		Connection connection = common.DataBaseConnect.getConnect();
		String sql=	"SELECT top 3 * "
					+"FROM BaiDang bd "
					+"INNER JOIN TinhThanh tt ON tt.MaTinhThanh=bd.MaTinhThanh "
					+"INNER JOIN DanhMuc dm ON bd.MaDanhMuc=dm.MaDanhMuc "
					+"INNER JOIN LoaiTin lt ON bd.MaLoaiTin=lt.MaLoaiTin "
					+"WHERE bd.MaLoaiTin=2 and  bd.MaDanhMuc= (select MaDanhMuc from BaiDang where MaBaiDang='"+maBaiDang+"') and bd.MaBaiDang<>'"+maBaiDang+"'";
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<BaiDangBean> list = new ArrayList<BaiDangBean>();
		BaiDangBean BaiDang;
		try {
			while(rs.next()){
				BaiDang = new BaiDangBean();
				BaiDang.setMaBaiDang(rs.getInt("MaBaiDang"));
				BaiDang.setTieuDe(rs.getString("TieuDe"));
				BaiDang.setNoiDung(rs.getString("NoiDung"));
				BaiDang.setDiaChi(rs.getString("DiaChi"));
				BaiDang.setDiaChiWeb(rs.getString("DiaChiWeb"));
				BaiDang.setsDT(rs.getString("SDT"));
				BaiDang.setAnhBia(rs.getString("AnhBia"));
				BaiDang.setTenDanhMuc(rs.getString("TenDanhMuc"));
				BaiDang.setTenTinhThanh(rs.getString("TenTinhThanh"));
				BaiDang.setDiemDanhGia(rs.getInt("DiemDanhGia"));
				BaiDang.setViDo(rs.getString("ViDo"));
				BaiDang.setKinhDo(rs.getString("KinhDO"));
				BaiDang.setDiemDanhGia(rs.getInt("DiemDanhGia"));
				BaiDang.setSoLuotThich(rs.getInt("SoLuotThich"));
				list.add(BaiDang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
}
