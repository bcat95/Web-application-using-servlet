<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- thu -->

		<style>
		#div1 {
		  	font-size:80px;
		   	width: 300px;
		    border: 25px;
	        padding:25px;
		    margin: 25px; 
		}
		.button {
		    background-color: #4CAF50; /* Green */
		    border: none;
		    color: white;
		    padding: 16px 32px;
		    text-align: center;
		    text-decoration: none;
		    display: inline-block;
		    font-size: 16px;
		    margin: 4px 2px;
		    -webkit-transition-duration: 0.4s; /* Safari */
		    transition-duration: 0.4s;
		    cursor: pointer;
		    border-radius: 8px;
		}
		.button2 {
	    background-color:  #008CBA; 
	    color: white; 
	    
		}
	
		.button2:hover {
		    background-color:white ;
		    color:  #008CBA;
		    border: 2px solid #008CBA;
		} 
		
		.button3 {
		    background-color: #f44336; 
		    color: white; 
		    border: 2px solid white ;
		}
		
		.button3:hover {
		    background-color: white;
		    color: #f44336;
		    border: 2px solid #f44336;
		}
		</style>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		
	<!-- end thu -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<title>Xác nhận gỡ bỏ</title>
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
                                    <a href="#"	>Thêm danh mục</a>
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
                    <div class="col-lg-8">
                        <h1 class="page-header">Xác nhận gỡ bỏ bài đăng</h1>
                    </div>    
	<html:form action="/goBoTinChuaDuyet">
		<div class="row form-group">
	         <div>
	             <html:hidden property="maBaiDang"/>
	         </div>
	    </div>
		<div class="col-lg-12">
			<h3><label>Bạn chắc chắn muốn gỡ bỏ bài đăng "</label>
			<b><i style="color:#8B0000"><bean:write name="danhSachBaiDangDaDuyetForm" property="tieuDe"/></i></b>
			<label>" ? </label></h3> 
		</div>
		<center>
		<div class="col-lg-10">
			<!--  thu -->
			<div id="div1" class="fa" ></div>
			<!-- end thu -->
		</div>
		<br>
		<div class="col-lg-10">
			<button type="submit" name="submit" value="xnGoBoCD" class="button button2">Xác nhận</button>
			<html:link action="/danhSachBaiDangChuaDuyet.do"><span class="button button3">Hủy</span>
			</html:link>
		</div>
		</center>

	</html:form>
	</div>
           <!-- /.row -->
         </div>
     <!-- /.container-fluid -->
    </div>
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

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <!-- thu -->
<!-- 	<script type="text/javascript">    
		function hourglass() {
		  var a;
		  a = document.getElementById("div1");
		  a.innerHTML = "&#xf251;";
		  setTimeout(function () {
		      a.innerHTML = "&#xf252;";
		    }, 1000);
		  setTimeout(function () {
		      a.innerHTML = "&#xf253;";
		    }, 2000);
		}
		hourglass();
		setInterval(hourglass, 3000);
	</script> -->
	<!-- end thu -->
	
</body>
</html>