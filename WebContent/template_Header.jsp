<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>${param.bcTitle} SE12 Địa Điểm Hấp Dẫn</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-te-1.4.0.min.js"></script>
	<link rel="stylesheet" href="css/styles.css">
	<link rel="stylesheet" href="css/jquery-te-1.4.0.css">
	<link rel="stylesheet" href="owlcarousel/assets/owl.carousel.min.css">
	<link rel="stylesheet" href="owlcarousel/assets/owl.theme.default.min.css">
	<link href="css/wolf-animation.css?v=1.0" rel="stylesheet">
	<link rel="stylesheet" href="css/bcat.css">
	<script src="js/nprogress.js"></script>
	<script src="js/jquery.validate.js"></script>
	<link rel="stylesheet" href="css/nprogress.css"/>
	<script>
		$(function() {
    		$("#username").attr("placeholder", "Enter username");
    		$("#pw").attr("placeholder", "Enter password");
		});
	</script>
	<script>
	$(document).ready(function() {
		if ('<bean:write name="taiKhoanForm" property="tacVu"/>' == "success") {
			$('.content.baseHtml').html("Tác vụ thành công");
			$('.timedMessage').animate({'opacity': 'show', 'top': 0}, 800);
			setTimeout(function() {$('.timedMessage').animate({'opacity': 'hide', 'top': -100}, 800);}, 1500);
		}else if ('<bean:write name="taiKhoanForm" property="tacVu"/>' == "that bai") {
			$('.content.baseHtml').html("Tác vụ thất bại");
			$('.timedMessage').animate({'opacity': 'show', 'top': 0}, 800);
			setTimeout(function() {$('.timedMessage').animate({'opacity': 'hide', 'top': -100}, 800);}, 1500);
		}
	});
	</script>
</head>
<body style='display: none' id="page" class="<logic:equal name="taiKhoanForm" property="maQuyen" value="-1">LoggedOut</logic:equal><logic:notEqual name="taiKhoanForm" property="maQuyen" value="-1">LoggedInt</logic:notEqual>">
<!--Begin header-->
	<header>
		<div class="header-content page-with">
			<div class="header-main">
				<div class="site-title">
					<a href="index.jsp" rel="home">
						<img src="img/img_footer-min.png" alt="Logo">
					</a>
				</div>
				<div class="head_nav">
					<logic:notEqual name="taiKhoanForm" property="maQuyen" value="-1">
						<a href="dangtin.do" class="bc-create-listing bc-button bc-button-invert">Đăng tin mới</a>
					</logic:notEqual>
					<logic:equal name="taiKhoanForm" property="maQuyen" value="-1">
						<a href="Login.do" id ="bccrea_login" class="bc-create-listing bc-button bc-button-invert">Đăng tin mới</a>
						<a href="#modalLogin" data-toggle="modal" data-target="#modalLogin" class="bc-login-register" id="bcLogin">
							<i class="fa fa-sign-in" aria-hidden="true"></i>Đăng nhập / Đăng ký
						</a>
					</logic:equal>
					<ul class="nav navbar-nav main-header-right-side">
						<li><a href="timKiem.do">Tìm kiếm</a></li>
						<li><a href="banDo.do">Bản đồ</a></li>
						<logic:equal name="taiKhoanForm" property="maQuyen" value="1">
						<li class="dropdown"><a data-toggle="dropdown"> Admin <span class="caret"></span></a>
							<ul class="dropdown-menu">
                                 <li><a href="admin/adminpanel.do">Trang admin</a></li>
                                <li><a href="admin/danhSachBaiDangChuaDuyet.do">Duyệt bài đăng</a></li>
								<li><a href="admin/danhSachBaiDangDaDuyet.do">Quản lý bài đăng</a></li>
                           	</ul>
						</li>
						</logic:equal>
						<li class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" href="#">Trợ giúp
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li><a href="themlh.do">Liên hệ</a></li>
							</ul>
						</li>
						<logic:notEqual name="taiKhoanForm" property="maQuyen" value="-1">
							<li class="dropdown"><a data-toggle="dropdown"> <bean:write name="taiKhoanForm" property="hoTen"/> <span class="caret"></span></a>
								<ul class="dropdown-menu">
                                    <li><a href="thong-tin.do">Thông tin cá nhân</a></li>
									<li><a href="Logout.do">Đăng xuất</a></li>
                            	</ul>
							</li>
						</logic:notEqual>
					</ul>
				</div>
	
			</div>
		</div>
	</header>
	<!--End header-->