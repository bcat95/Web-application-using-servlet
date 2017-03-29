<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<jsp:include page="/admin/header.do" flush="true"></jsp:include>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="danhSachBaiDangChuaDuyet.do" class="current">Duyệt bài</a> </div>
    <h1>Xem chi tiết bài đăng chờ duyệt</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <html:form action="/admin/xemtinchuaduyet">
           <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <a style="margin: 4px;" href="xemtinchuaduyet.do?maBaiDang=<bean:write name="danhSachBaiDangDaDuyetForm" property="maBaiDang"/>&duyetTin=true" type="button" class="btn btn-success">Duyệt Tin</a>
          </div>
          <div class="widget-content nopadding">
           <table class="table table-bordered table-striped">
					<tr>
                            <th>Tiêu đề:</th>
                            <td><bean:write name="danhSachBaiDangDaDuyetForm" property="tieuDe"/></td>
                    </tr>
                    <tr>
                            <th>Nội dung:</th>
                            <td><bean:write name="danhSachBaiDangDaDuyetForm" property="noiDung" filter="false"/></td>
                    </tr>
                    <tr>
                            <th>Địa chỉ:</th>
                            <td><bean:write name="danhSachBaiDangDaDuyetForm" property="diaChi"/></td>
                    </tr>
                    <tr>
                            <th>Website:</th>
                            <td><bean:write name="danhSachBaiDangDaDuyetForm" property="diaChiWeb"/></td>
                    </tr>
                    <tr>
                            <th>Số điện thoại:</th>
                            <td><bean:write name="danhSachBaiDangDaDuyetForm" property="sDT"/></td>
                    </tr>
                    <tr>
                            <th>Giá cao nhất:</th>
                            <td><bean:write name="danhSachBaiDangDaDuyetForm" property="giaCaoNhat"/></td>
                    </tr>
                    <tr>
                            <th>Giá thấp nhất</th>
                            <td><bean:write name="danhSachBaiDangDaDuyetForm" property="giaThapNhat"/></td>
                    </tr>
                    <tr>
                            <th>Ngày đăng:</th>
                            <td><bean:write name="danhSachBaiDangDaDuyetForm" property="ngayDang"/></td>
                    </tr>
                    <tr>
                            <th>Ngày hết hạn:</th>
                            <td><bean:write name="danhSachBaiDangDaDuyetForm" property="ngayHetHan"/></td>
                    </tr>
                    <tr>
                            <th>Số lượt truy cập:</th>
                            <td><bean:write name="danhSachBaiDangDaDuyetForm" property="soLuongTruyCap"/></td>
                    </tr>
                    <tr>
                            <th>Số lượt thích</th>
                            <td><bean:write name="danhSachBaiDangDaDuyetForm" property="soLuotThich"/></td>
                    </tr>
                    <tr>
                            <th>Username</th>
                            <td><bean:write name="danhSachBaiDangDaDuyetForm" property="userName"/></td>
                    </tr>
                    <tr>
                            <th>Danh mục:</th>
                            <td><bean:write name="danhSachBaiDangDaDuyetForm" property="tenDanhMuc"/></td>
                    </tr>
                    <tr>
                            <th>Trạng thái:</th>
                            <td><bean:write name="danhSachBaiDangDaDuyetForm" property="tenLoaiTin"/></td>
                    </tr>
                    <tr>
                            <th>Tỉnh:</th>
                            <td><bean:write name="danhSachBaiDangDaDuyetForm" property="tenTinhThanh"/></td>
                    </tr>
                    <tr>
                            <th>Điểm đánh giá:</th>
                            <td><bean:write name="danhSachBaiDangDaDuyetForm" property="diemDanhGia"/></td>
                    </tr>
              </tbody>
            </table>
           </div>
            </html:form>
          </div>
        </div>
        </div>
      </div>
    </div>
    <script type="text/javascript">
	window.onload = function(){ 
		$("#baiDang").addClass( "active" );
	}
    </script>
<jsp:include page="footer.jsp"></jsp:include>
