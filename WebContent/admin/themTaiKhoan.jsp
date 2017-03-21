<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<!-- form -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/3/w3.css">
	<!-- end form -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Admin</title>
    <!-- Bootstrap Core CSS -->
    <link href="admin/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="admin/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
 	<!-- Custom CSS -->
    <link href="admin/dist/css/sb-admin-2.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="admin/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <link href="admin/datatables/jquery.dataTables.min.css" rel="stylesheet">
</head>

<body>

    <div id="wrapper">

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
                                    <a href="themTaiKhoan.jsp">Thêm tài khoản</a>
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

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Thêm tài khoản
                        </h1>
                    </div>
                    <!-- /.col-lg-12 -->
                    <div class="col-lg-7" style="padding-bottom:120px">
                    	<html:form action="/them-tai-khoan" method="post" >
                            <div class="form-group">
                                <label class="w3-label">Username</label>
                                <html:text property="userName" styleClass="w3-input w3-animate-input" style="width:500px" ></html:text>
                                <!-- <input class="form-control" name="txtUser" placeholder="Nhập username"/> -->
                            </div>
                            <div class="form-group">
                                <label class="w3-label">Mật khẩu</label>
                                <html:password property="passWord" styleClass="w3-input w3-animate-input" style="width:500px" ></html:password>
                            </div>
           
                            <div class="form-group">
                                <label class="w3-label">Quyền</label>
                                <html:select property="maQuyen" styleClass="w3-select">
                                <html:optionsCollection name="danhSachTaiKhoanForm" property="listQuyen" label="tenQuyen" value="maQuyen"/>
                                </html:select>
                            </div>
                            <div class="form-group">
                                <label class="w3-label">Loại tài khoản</label>
                                <html:select property="maLoaiTaiKhoan" styleClass="w3-select">
					            	<html:optionsCollection name="danhSachTaiKhoanForm" property="listLoaiTaiKhoan" label="tenLoaiTaiKhoan" value="maLoaiTaiKhoan" />
					            </html:select>
                            </div>
                            
                            <div class="form-group">
                                <label class="w3-label">Họ tên</label>
                                <html:text property="hoTen" styleClass="w3-input w3-animate-input" style="width:500px"></html:text>
                            </div>
                            <div class="form-group">
                                <label class="w3-label">Giới tính</label> <br>
                                <html:radio property="gioiTinh" value="1" styleClass="w3-radio" ></html:radio>
                                 <label class="w3-validate">Nam</label>
                                 <html:radio property="gioiTinh" value="0" styleClass="w3-radio" ></html:radio>
                                 <label class="w3-validate">Nữ</label>
                            </div>
                            <div class="form-group">
                                <label class="w3-label">Ngày sinh</label>
                                <html:text property="ngaySinh" styleClass="w3-input w3-animate-input" style="width:500px"></html:text>
                            </div>
                            <div class="form-group">
                                <label class="w3-label">Số điện thoại</label>
                                <html:text property="sDT" styleClass="w3-input w3-animate-input" style="width:500px"></html:text>
                            </div>
                            
                            <div class="form-group">
                                <label class="w3-label">Email</label>
                                <html:text property="eMail" styleClass="w3-input w3-animate-input" style="width:500px"></html:text>
                            </div>
                            <div class="form-group">
                                <label class="w3-label">Ngày đăng ký</label>
                                <html:text property="ngayDangKy" styleClass="w3-input w3-animate-input" style="width:500px"></html:text>
                            </div>
                            <br>
                            <center>
                            <div class="form-group">
	                            <%-- <html:button property="submit" styleClass="w3-btn w3-Black" value="themTK">Thêm</html:button> --%>
	                            <button type="submit" name="submit" value="themTK" class="w3-btn w3-Black">Thêm</button>
	                            <html:reset styleClass="w3-btn w3-Black">Reset</html:reset>
                            </div></center>
                        </html:form>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

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
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->2
</body>

</html>
