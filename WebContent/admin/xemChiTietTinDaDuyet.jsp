<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<title>Matrix Admin</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/uniform.css" />
<link rel="stylesheet" href="css/select2.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/matrix-media.css" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>

<!--Header-part-->
<div id="header">
  <h1><a href="dashboard.html">Matrix Admin</a></h1>
</div>
<!--close-Header-part--> 

<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav">
    <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i>  <span class="text">Welcome User</span><b class="caret"></b></a>
      <ul class="dropdown-menu">
        <li><a href="#"><i class="icon-user"></i> My Profile</a></li>
        <li class="divider"></li>
        <li><a href="#"><i class="icon-check"></i> My Tasks</a></li>
        <li class="divider"></li>
        <li><a href="login.html"><i class="icon-key"></i> Log Out</a></li>
      </ul>
    </li>
    <li class="dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">Messages</span> <span class="label label-important">5</span> <b class="caret"></b></a>
      <ul class="dropdown-menu">
        <li><a class="sAdd" title="" href="#"><i class="icon-plus"></i> new message</a></li>
        <li class="divider"></li>
        <li><a class="sInbox" title="" href="#"><i class="icon-envelope"></i> inbox</a></li>
        <li class="divider"></li>
        <li><a class="sOutbox" title="" href="#"><i class="icon-arrow-up"></i> outbox</a></li>
        <li class="divider"></li>
        <li><a class="sTrash" title="" href="#"><i class="icon-trash"></i> trash</a></li>
      </ul>
    </li>
    <li class=""><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">Settings</span></a></li>
    <li class=""><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
  </ul>
</div>

<!--start-top-serch-->
<div id="search">
  <input type="text" placeholder="Search here..."/>
  <button type="submit" class="tip-bottom" title="Search"><i class="icon-search icon-white"></i></button>
</div>
<!--close-top-serch--> 
<jsp:include page="sidebar.jsp"></jsp:include>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="danhSachBaiDangChuaDuyet.do" class="current">Duyệt bài</a> </div>
    <h1>Xem chi tiết bài đăng đã duyệt</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <html:form action="/admin/xemtindaduyet">
           <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <a style="margin: 4px;" href="xemtindaduyet.do?maBaiDang=<bean:write name="danhSachBaiDangDaDuyetForm" property="maBaiDang"/>&goDuyetTin=true" type="button" class="btn btn-success">Hủy duyệt Tin</a>
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
  </div>
<!--Footer-part-->
<div class="row-fluid">
  <div id="footer" class="span12"> 2013 &copy; Matrix Admin. Brought to you by <a href="http://themedesigner.in">Themedesigner.in</a> </div>
</div>
<!--end-Footer-part-->
<script src="js/jquery.min.js"></script> 
<script src="js/jquery.ui.custom.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/jquery.uniform.js"></script> 
<script src="js/select2.min.js"></script> 
<script src="js/jquery.dataTables.min.js"></script> 
<script src="js/matrix.js"></script> 
<script src="js/matrix.tables.js"></script>
<script src="js/jquery.validate.js"></script> 
<script src="js/matrix.form_validation.js"></script>
</body>
</html>
