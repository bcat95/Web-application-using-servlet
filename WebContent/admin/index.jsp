<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Matrix Admin</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
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
    <div id="breadcrumb"><a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Charts &amp; graphs</a></div>
    <h1>Bảng điều khiển</h1>
  </div>
	<div class="container-fluid">
	  <div  class="quick-actions_homepage">
	    <ul class="quick-actions">
	      <li class="bg_lb"> <a href="adminpanel.do"> <i class="icon-dashboard"></i> Bảng điều khiển </a> </li>
	      <li class="bg_lg"> <a href="danhMuc.do"> <i class="icon-shopping-cart"></i> Quản lý danh mục</a> </li>
	      <li class="bg_ly"> <a href="danhSachBaiDangDaDuyet.do"> <i class=" icon-globe"></i> Quản lý bài đăng </a> </li>
	      <li class="bg_lo"> <a href="danhSachTaiKhoan.do"> <i class="icon-group"></i> Quản lý thành viên </a> </li>
	    </ul>
	  </div>
	</div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-signal"></i> </span>
            <h5>Thống kê</h5>
          </div>
          <div class="widget-content">
	          <div class="row-fluid">
	         	 <div class="span11">  <div id="chartContainer" style="height: 400px; width: 100%;"></div></div>
	         	 <div class="span1">
		              <ul class="site-stats">
		                <li class="bg_lh"><i class="icon-user"></i> <strong>12</strong> <small>Users</small></li>
		                <li class="bg_lh"><i class="icon-tag"></i> <strong>54</strong> <small>Threads</small></li>
		                <li class="bg_lh"><i class="icon-repeat"></i> <strong>10</strong> <small>Likes</small></li>
		                <li class="bg_lh"><i class="icon-shopping-cart"></i> <strong>16</strong> <small>Comment</small></li>
		               </ul>
            	</div>
	          </div>
          </div>
        </div>
      </div>
    </div>
  </div>
   <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span6">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-signal"></i> </span>
            <h5>Thống kê tỉnh thành (All)</h5>
          </div>
          <div class="widget-content">
            <div id="tKTinhThanh" style="height: 400px; width: 100%;"></div>
          </div>
        </div>
      </div>
       <div class="span6">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-signal"></i> </span>
            <h5>Thống kê danh mục (All)</h5>
          </div>
          <div class="widget-content">
            <div id="tKDanhMuc" style="height: 400px; width: 100%;"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script type="text/javascript">
		window.onload = function () {
			var chart1 = new CanvasJS.Chart("chartContainer", {
				title: {
					text: "Tháng Gân Nhât",
					fontSize: 30
				},
				animationEnabled: true,
				axisX: {
					gridColor: "Silver",
					tickColor: "silver",
					valueFormatString: "MMM DD"
				},
				toolTip: {
					shared: true
				},
				theme: "theme2",
				axisY: {
					gridColor: "Silver",
					tickColor: "silver"
				},
				legend: {
					verticalAlign: "center",
					horizontalAlign: "right"
				},
				data: [
				{
					type: "line",
					showInLegend: true,
					/* toolTipContent: "Thời gian: {x} - Số lượng: {y}", */
					lineThickness: 2,
					name: "Bài viết",
					markerType: "square",
					color: "#F08080",
					dataPoints: [
					<logic:iterate name="adminPanelForm" property="tKBaiDang" id="bd">
					{ x: new Date(<bean:write name="bd" property="cotMot"/>), y:  <bean:write name="bd" property="soLuong"/> }, 
		          	 </logic:iterate>
					]
				},
				{
					type: "line",
					showInLegend: true,
					name: "Bình luận",
					color: "#20B2AA",
					lineThickness: 2,

					dataPoints: [
					<logic:iterate name="adminPanelForm" property="tKBinhLuan" id="bl">
					{ x: new Date(<bean:write name="bl" property="cotMot"/>), y: <bean:write name="bl" property="soLuong"/>},
					 </logic:iterate>
					]
				},
				{
					type: "line",
					showInLegend: true,
					name: "Lượt thích",
					color: "#9BBB58",
					lineThickness: 2,

					dataPoints: [
					<logic:iterate name="adminPanelForm" property="tKYeuThich" id="yt">
					{ x: new Date(<bean:write name="yt" property="cotMot"/>), y: <bean:write name="yt" property="soLuong"/>},
					 </logic:iterate>
					]
				},
				{
					type: "line",
					showInLegend: true,
					name: "Thành viên mới",
					color: "#7F6084",
					lineThickness: 2,

					dataPoints: [
					<logic:iterate name="adminPanelForm" property="tKTaiKhoan" id="tk">
					{ x: new Date(<bean:write name="tk" property="cotMot"/>), y: <bean:write name="tk" property="soLuong"/>},
					 </logic:iterate>
					]
				}
				
				],
				legend: {
					cursor: "pointer",
					itemclick: function (e) {
						if (typeof (e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
							e.dataSeries.visible = false;
						}
						else {
							e.dataSeries.visible = true;
						}
						chart1.render();
					}
				}
			});

			chart1.render();
			var chart2 = new CanvasJS.Chart("tKTinhThanh",
			{
				theme: "theme2",
				title:{
					text: "Tinh Thành / Bài Đăng"
				},
				data: [
				{
					type: "pie",
					showInLegend: true,
					toolTipContent: "Bài đăng: {y} - #percent %",
					legendText: "{indexLabel}",
					dataPoints: [
						<logic:iterate name="adminPanelForm" property="tKTinhThanh" id="tt">
						{  y: <bean:write name="tt" property="soLuong"/>, indexLabel: '<bean:write name="tt" property="cotMot"/>' },
						</logic:iterate>
					]
				}
				]
			});
			chart2.render();
			
			var chart3 = new CanvasJS.Chart("tKDanhMuc",
			{
				theme: "theme2",
				title:{
					text: "Danh Muc / Bài Đăng"
				},
				data: [
				{
					type: "pie",
					showInLegend: true,
					toolTipContent: "Bài đăng:{y} - #percent %",
					legendText: "{indexLabel}",
					dataPoints: [
						<logic:iterate name="adminPanelForm" property="tKDanhMuc" id="dm">
						{  y: <bean:write name="dm" property="soLuong"/>, indexLabel: '<bean:write name="dm" property="cotMot"/>' },
						</logic:iterate>
					]
				}
				]
			});
			chart3.render();
		}
	</script>
	<script src="bcat/js/canvasjs.min.js"></script>
</div>
<!--Footer-part-->
<div class="row-fluid">
  <div id="footer" class="span12"> 2013 &copy; Matrix Admin. Brought to you by <a href="http://themedesigner.in">Themedesigner.in</a> </div>
</div>
<!--end-Footer-part-->
<!--end-Footer-part-->
<script src="js/jquery.min.js"></script> 
<script src="js/jquery.ui.custom.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/matrix.js"></script> 
</body>
</html>
