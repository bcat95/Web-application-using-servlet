<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Matrix Admin</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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

<!--sidebar-menu-->
<jsp:include page="sidebar.jsp"></jsp:include>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#">Form elements</a> <a href="#" class="current">Validation</a> </div>
    <h1>Cập nhật tài khoản</h1>
  </div>
  <div class="container-fluid"><hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-info-sign"></i> </span>
            <h5>Cập nhật thông tin tài khoản</h5>
          </div>
          <div class="widget-content nopadding">
            <html:form action="admin/suaTaiKhoan" method="post" styleClass="form-horizontal" styleId="suaTaiKhoan">
             <div class="control-group">
                <label class="control-label">Username</label>
                <div class="controls">
                  <html:text property="userName" readonly="true"></html:text>
                </div>
              </div>
              <div class="control-group">
                <label class="control-label">Mật khẩu</label>
                <div class="controls">
                  <html:password property="passWord" styleClass="required"></html:password>
                </div>
              </div>
               <div class="control-group">
                <label class="control-label">Quyền</label>
                <div class="controls">
					<html:select property="maQuyen">
					    <html:optionsCollection name="danhSachTaiKhoanForm" property="listQuyen" label="tenQuyen" value="maQuyen"/>
					</html:select>
                </div>
              </div>
              <div class="control-group">
                <label class="control-label">Loại tài khoản</label>
                <div class="controls">
					<html:select property="maLoaiTaiKhoan">
					     <html:optionsCollection name="danhSachTaiKhoanForm" property="listLoaiTaiKhoan" label="tenLoaiTaiKhoan" value="maLoaiTaiKhoan" />
					</html:select>
                </div>
              </div>
               <div class="control-group">
                <label class="control-label">Họ tên</label>
                <div class="controls">
					<html:text property="hoTen" styleClass="required"></html:text>
                </div>
              </div>
              <div class="control-group">
              <label class="control-label">Giới tính</label>
              <div class="controls">
				<label>
				  <div class="radio" id="uniform-undefined"><span class="checked">
				  	<input type="radio" name="gioiTinh" style="opacity: 0;" value="1" checked></span></div>
				  Nam</label>
				<label>
				  <div class="radio" id="uniform-undefined"><span class="">
				  	<input type="radio" name="gioiTinh" style="opacity: 0;" value="0"></span></div>
				      Nữ</label>
				    <label>
				  </div>
				</div>
              <div class="control-group">
                <label class="control-label">Ngày sinh</label>
                <div class="controls">
                	<html:text property="ngaySinh" styleClass="date"></html:text>
                </div>
              </div>
              <div class="control-group">
                <label class="control-label">Số điện thoại</label>
                <div class="controls">
                	 <html:text property="sDT"></html:text>
                </div>
              </div>
               <div class="control-group">
                <label class="control-label">Email</label>
                <div class="controls">
                	 <html:text property="eMail" styleId="email"></html:text>
                </div>
              </div>
              <div class="control-group">
                <label class="control-label">Ngày đăng ký</label>
                <div class="controls">
                	<html:text property="ngayDangKy"></html:text>
                </div>
              </div>
              <div class="form-actions">
                <button type="submit" name="submit" value="suaTK" class="btn btn-success">Cập nhật</button>
              </div>
           </html:form>
          </div>
        </div>
      </div>
    </div>
  </div>
    <script type="text/javascript">
	window.onload = function(){ 
		$("#taiKhoan").addClass( "active" );
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
<script src="js/jquery.validate.js"></script> 
<script src="js/matrix.js"></script> 
<script src="js/matrix.form_validation.js"></script>
</body>
</html>
