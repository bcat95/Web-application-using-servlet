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
import model.bean.User;
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
	
	public ArrayList<BaiDangBean> getListBaiDang() {
		ArrayList<BaiDangBean> list = new ArrayList<BaiDangBean>();
		try {
			st=getConnect().createStatement();
			rs=st.executeQuery("select * FROM BaiDang,DanhMuc where BaiDang.MaDanhMuc=DanhMuc.MaDanhMuc");
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
				BaiDang.setViDO(rs.getString("ViDo"));
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
	//---------------TÌM KIẾM---------------//
			public ArrayList<BaiDangBean> getListBaiDangDanhMuc(String maDanhMuc) {
				Connection connection = common.DataBaseConnect.getConnect();
				String sql=	"SELECT * FROM BaiDang bd "
							+"INNER JOIN TinhThanh tt ON tt.MaTinhThanh=bd.MaTinhThanh "
							+"INNER JOIN DanhMuc dm ON bd.MaDanhMuc=dm.MaDanhMuc "
							+"INNER JOIN LoaiTin lt ON bd.MaLoaiTin=lt.MaLoaiTin "
							+"WHERE bd.MaDanhMuc='"+maDanhMuc+"'";
				
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
						BaiDang.setViDO(rs.getString("ViDo"));
						BaiDang.setKinhDo(rs.getString("KinhDO"));
						list.add(BaiDang);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
			public ArrayList<BaiDangBean> getListBaiDangTinhThanh(String maTinhThanh) {
				Connection connection = common.DataBaseConnect.getConnect();
				String sql=	"SELECT * FROM BaiDang bd "
							+"INNER JOIN TinhThanh tt ON tt.MaTinhThanh=bd.MaTinhThanh "
							+"INNER JOIN DanhMuc dm ON bd.MaDanhMuc=dm.MaDanhMuc "
							+"INNER JOIN LoaiTin lt ON bd.MaLoaiTin=lt.MaLoaiTin "
							+"WHERE bd.MaTinhThanh='"+maTinhThanh+"'";
				
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
						BaiDang.setViDO(rs.getString("ViDo"));
						BaiDang.setKinhDo(rs.getString("KinhDO"));
						list.add(BaiDang);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
			public ArrayList<BaiDangBean> getListBaiDangDanhMucTinhThanh(String maDanhMuc,String maTinhThanh) {
				Connection connection = common.DataBaseConnect.getConnect();
				String sql=	"SELECT * FROM BaiDang bd "
							+"INNER JOIN TinhThanh tt ON tt.MaTinhThanh=bd.MaTinhThanh "
							+"INNER JOIN DanhMuc dm ON bd.MaDanhMuc=dm.MaDanhMuc "
							+"INNER JOIN LoaiTin lt ON bd.MaLoaiTin=lt.MaLoaiTin "
							+"WHERE bd.MaDanhMuc='"+maDanhMuc+"' AND bd.MaTinhThanh='"+maTinhThanh+"'";
				
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
						BaiDang.setViDO(rs.getString("ViDo"));
						BaiDang.setKinhDo(rs.getString("KinhDO"));
						list.add(BaiDang);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
			
			public ArrayList<BaiDangBean> getListBaiDangNoiDung(String noiDung) {
				Connection connection = common.DataBaseConnect.getConnect();
				String sql=	"SELECT * FROM BaiDang bd "
							+"INNER JOIN TinhThanh tt ON tt.MaTinhThanh=bd.MaTinhThanh "
							+"INNER JOIN DanhMuc dm ON bd.MaDanhMuc=dm.MaDanhMuc "
							+"INNER JOIN LoaiTin lt ON bd.MaLoaiTin=lt.MaLoaiTin "
							+"WHERE (bd.TieuDe LIKE N'%"+noiDung+"%' OR bd.NoiDung LIKE N'%"+noiDung+"%')";
				
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
						BaiDang.setViDO(rs.getString("ViDo"));
						BaiDang.setKinhDo(rs.getString("KinhDO"));
						list.add(BaiDang);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
			
			public ArrayList<BaiDangBean> getListBaiDangDanhMucNoiDung(String maDanhMuc,String noiDung) {
				Connection connection = common.DataBaseConnect.getConnect();
				String sql=	"SELECT * FROM BaiDang bd "
							+"INNER JOIN TinhThanh tt ON tt.MaTinhThanh=bd.MaTinhThanh "
							+"INNER JOIN DanhMuc dm ON bd.MaDanhMuc=dm.MaDanhMuc "
							+"INNER JOIN LoaiTin lt ON bd.MaLoaiTin=lt.MaLoaiTin "
							+"WHERE (bd.TieuDe LIKE N'%"+noiDung+"%' OR bd.NoiDung LIKE N'%"+noiDung+"%') AND bd.MaDanhMuc='"+maDanhMuc+"'";
				
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
						BaiDang.setViDO(rs.getString("ViDo"));
						BaiDang.setKinhDo(rs.getString("KinhDO"));
						list.add(BaiDang);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
			
			public ArrayList<BaiDangBean> getListBaiDangTinhThanhNoiDung(String maTinhThanh,String noiDung) {
				Connection connection = common.DataBaseConnect.getConnect();
				String sql=	"SELECT * FROM BaiDang bd "
							+"INNER JOIN TinhThanh tt ON tt.MaTinhThanh=bd.MaTinhThanh "
							+"INNER JOIN DanhMuc dm ON bd.MaDanhMuc=dm.MaDanhMuc "
							+"INNER JOIN LoaiTin lt ON bd.MaLoaiTin=lt.MaLoaiTin "
							+"WHERE (bd.TieuDe LIKE N'%"+noiDung+"%' OR bd.NoiDung LIKE N'%"+noiDung+"%' AND bd.MaTinhThanh='"+maTinhThanh+"')";
				
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
						BaiDang.setViDO(rs.getString("ViDo"));
						BaiDang.setKinhDo(rs.getString("KinhDO"));
						list.add(BaiDang);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
			
			public ArrayList<BaiDangBean> getListBaiDangDanhMucTinhThanhNoiDung(String maDanhMuc,String maTinhThanh,String noiDung) {
				Connection connection = common.DataBaseConnect.getConnect();
				String sql=	"SELECT * FROM BaiDang bd "
							+"INNER JOIN TinhThanh tt ON tt.MaTinhThanh=bd.MaTinhThanh "
							+"INNER JOIN DanhMuc dm ON bd.MaDanhMuc=dm.MaDanhMuc "
							+"INNER JOIN LoaiTin lt ON bd.MaLoaiTin=lt.MaLoaiTin "
							+"WHERE (bd.TieuDe LIKE N'%"+noiDung+"%' OR bd.NoiDung LIKE N'%"+noiDung+"%') AND bd.MaDanhMuc='"+maDanhMuc+"' AND bd.MaTinhThanh='"+maTinhThanh+"'";
				
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
						BaiDang.setViDO(rs.getString("ViDo"));
						BaiDang.setKinhDo(rs.getString("KinhDO"));
						list.add(BaiDang);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
			//------------------END TIM KIEM------------------//
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
	
	//them hinh anh vao data
	public static void insertHinhAnh(BaiDangBean baiDang, HinhAnhBean hinhAnhBean) {
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
	//get thong tin xem chi tiet bai dang 
	public static BaiDangBean infobaiDang(int maBaiDang) {
		BaiDangBean baiDang= new BaiDangBean();
		baiDang = new BaiDangBean();
		try {
			st=getConnect().createStatement();
			rs=st.executeQuery("select * FROM BaiDang "
					+ "join DanhMuc on BaiDang.MaDanhMuc= DanhMuc.MaDanhMuc "
					+ "join TinhThanh on BaiDang.MaTinhThanh= TinhThanh.MaTinhThanh "
					+ "where BaiDang.MaBaiDang = "+maBaiDang+"");
			while(rs.next()){
				baiDang.setMaBaiDang(rs.getInt("MaBaiDang"));
				baiDang.setUserName(rs.getString("Username"));
				baiDang.setTieuDe(rs.getString("TieuDe"));
				baiDang.setNoiDung(rs.getString("NoiDung"));
				baiDang.setDiaChi(rs.getString("DiaChi"));
				baiDang.setDiaChiWeb(rs.getString("DiaChiWeb"));
				baiDang.setsDT(rs.getString("SDT"));
				baiDang.setAnhBia(rs.getString("AnhBia"));
				baiDang.setDiemDanhGia(rs.getInt("DiemDanhGia"));
				baiDang.setTenDanhMuc(rs.getString("TenDanhMuc"));
				baiDang.setTenTinhThanh(rs.getString("TenTinhThanh"));
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
		baiDang.setListBinhLuan(BinhLuanDAO.infoBinhLuanByMa(maBaiDang));
		return baiDang;
	}
	public static BaiDangBean infoSuaBaiDang(int maBaiDang) {
		BaiDangBean baiDang= new BaiDangBean();
		baiDang = new BaiDangBean();
		try {
			st=getConnect().createStatement();
			rs=st.executeQuery("select * FROM BaiDang "
					+ "where BaiDang.MaBaiDang = "+maBaiDang+"");
			while(rs.next()){
				baiDang.setMaBaiDang(rs.getInt("MaBaiDang"));
				baiDang.setUserName(rs.getString("Username"));
				baiDang.setTieuDe(rs.getString("TieuDe"));
				baiDang.setNoiDung(rs.getString("NoiDung"));
				baiDang.setDiaChi(rs.getString("DiaChi"));
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
	public static void updateBaiDang(BaiDangBean baiDang) {
		try {
			String updateTableSQL  = "update BaiDang set TieuDe=?,NoiDung=?,DiaChi=?,DiaChiWeb=?,ViDo=?,KinhDo=?,SDT=?,GiaCaoNhat=?,GiaThapNhat=?,NgayDang=?,MaDanhMuc=?,MaLoaiTin=?,MaTinhThanh=? where MaBaiDang="+baiDang.getMaBaiDang()+"";
			PreparedStatement prepSt = getConnect().prepareStatement(updateTableSQL);
			prepSt.setString(1, baiDang.getTieuDe());
			prepSt.setString(2, baiDang.getNoiDung());
			prepSt.setString(4, baiDang.getDiaChi());
			prepSt.setString(5, baiDang.getDiaChiWeb());
			prepSt.setString(6, baiDang.getViDo());
			prepSt.setString(7, baiDang.getKinhDo());
			prepSt.setString(8, baiDang.getsDT());
			prepSt.setInt(9, baiDang.getGiaCaoNhat());
			prepSt.setInt(10, baiDang.getGiaThapNhat());
			prepSt.setDate(11, new Date(StringProcess.getNgayDangDate().getTime()));
			prepSt.setInt(12, baiDang.getMaDanhMuc());
			//prepSt.setInt(14, baiDang.getMaLoaiTin());
			prepSt.setInt(13, 1);
			prepSt.setInt(14, baiDang.getMaTinhThanh());
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
	public static void setAnhBia(int maBaiDang, String anhBia) {
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
