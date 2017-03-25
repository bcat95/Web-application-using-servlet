<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	  
	  <link href="admin/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="admin/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="admin/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="admin/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <link href="admin/datatables/jquery.dataTables.min.css" rel="stylesheet">
<title>Thông tin chi tiết</title>
</head>
<body>
<!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Admin Area</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Thống kê<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#">Bảng tin</a>
                                </li>
                                <li>
                                    <a href="#">Lượt truy cập</a>
                                </li>
                                <li>
                                    <a href="#">Doanh thu</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-dashboard fa-fw"></i> Danh mục<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#">Danh sách danh mục</a>
                                </li>
                                <li>
                                    <a href="#">Thêm danh mục</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-cube fa-fw"></i> Bảng tin<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#">Danh sách bảng tin</a>
                                </li>
                                <li>
                                    <a href="#">Thêm bảng tin</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-users fa-fw"></i> Tài khoản<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="danhSachTaiKhoan.do">Danh sách tài khoản</a>
                                </li>
                                <li>
                                    <a href="user_add.html">Thêm tài khoản</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
<div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <html:form action="/xemTinChuaDuyet">
                    <div class="col-lg-12">
                        <h1 class="page-header">Thông tin chi tiết</h1>
                        <a href="xemTinChuaDuyet.do?maBaiDang=<bean:write name="danhSachBaiDangDaDuyetForm" property="maBaiDang"/>&duyetTin=true" type="button" class="btn btn-success">Duyệt Tin</a>
                    </div>
                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                       
                            <tr>
							<th style="width: 28.6%;">Tiêu đề:</th>
							<td class="db-align-center db-status"><bean:write name="danhSachBaiDangDaDuyetForm" property="tieuDe"/></td>
					</tr>
					<tr>
							<th style="width: 28.6%;">Nội dung:</th>
							<td class="db-align-center db-status"><bean:write name="danhSachBaiDangDaDuyetForm" property="noiDung"/></td>
					</tr>
					<tr>
							<th style="width: 28.6%;">Địa chỉ:</th>
							<td class="db-align-center db-status"><bean:write name="danhSachBaiDangDaDuyetForm" property="diaChi"/></td>
					</tr>
					<tr>
							<th style="width: 28.6%;">Website:</th>
							<td class="db-align-center db-status"><bean:write name="danhSachBaiDangDaDuyetForm" property="diaChiWeb"/></td>
					</tr>
					<tr>
							<th style="width: 28.6%;">Số điện thoại:</th>
							<td class="db-align-center db-status"><bean:write name="danhSachBaiDangDaDuyetForm" property="sDT"/></td>
					</tr>
					<tr>
							<th style="width: 28.6%;">Giá cao nhất:</th>
							<td class="db-align-center db-status"><bean:write name="danhSachBaiDangDaDuyetForm" property="giaCaoNhat"/></td>
					</tr>
					<tr>
							<th style="width: 28.6%;">Giá thấp nhất</th>
							<td class="db-align-center db-status"><bean:write name="danhSachBaiDangDaDuyetForm" property="giaThapNhat"/></td>
					</tr>
					<tr>
							<th style="width: 28.6%;">Ngày đăng:</th>
							<td class="db-align-center db-status"><bean:write name="danhSachBaiDangDaDuyetForm" property="ngayDang"/></td>
					</tr>
					<tr>
							<th style="width: 28.6%;">Ngày hết hạn:</th>
							<td class="db-align-center db-status"><bean:write name="danhSachBaiDangDaDuyetForm" property="ngayHetHan"/></td>
					</tr>
					<tr>
							<th style="width: 28.6%;">Số lượt truy cập:</th>
							<td class="db-align-center db-status"><bean:write name="danhSachBaiDangDaDuyetForm" property="soLuongTruyCap"/></td>
					</tr>
					<tr>
							<th style="width: 28.6%;">Số lượt thích</th>
							<td class="db-align-center db-status"><bean:write name="danhSachBaiDangDaDuyetForm" property="soLuotThich"/></td>
					</tr>
					<tr>
							<th style="width: 28.6%;">Username</th>
							<td class="db-align-center db-status"><bean:write name="danhSachBaiDangDaDuyetForm" property="userName"/></td>
					</tr>
					<tr>
							<th style="width: 28.6%;">Danh mục:</th>
							<td class="db-align-center db-status"><bean:write name="danhSachBaiDangDaDuyetForm" property="tenDanhMuc"/></td>
					</tr>
					<tr>
							<th style="width: 28.6%;">Trạng thái:</th>
							<td class="db-align-center db-status"><bean:write name="danhSachBaiDangDaDuyetForm" property="tenLoaiTin"/></td>
					</tr>
					<tr>
							<th style="width: 28.6%;">Tỉnh:</th>
							<td class="db-align-center db-status"><bean:write name="danhSachBaiDangDaDuyetForm" property="tenTinhThanh"/></td>
					</tr>
					<tr>
							<th style="width: 28.6%;">Điểm đánh giá:</th>
							<td class="db-align-center db-status"><bean:write name="danhSachBaiDangDaDuyetForm" property="diemDanhGia"/></td>
					</tr>
                    </table>
                    </html:form>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- jQuery -->
    <script src="admin/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="admin/bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="admin/dist/js/sb-admin-2.js"></script>

    <!-- DataTables JavaScript -->
    <script src="admin/datatables/jquery.dataTables.min.js"></script>
        

</body>
</html>