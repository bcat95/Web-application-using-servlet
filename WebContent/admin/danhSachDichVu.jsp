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
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="danhSachDichVu.do" class="current">Dịch vụ</a> </div>
    <h1>Dịch Vụ</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Quản Lý Dịch Vụ</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>Mã Dịch vụ</th>
                  <th>Tên Dịch vụ</th>
                  <th>Sửa</th>
                  <th>Xóa</th>
                </tr>
              </thead>
              <tbody>
                <logic:iterate name="danhSachDichVuForm" property="listDichVu" id="dm">
                <tr class="gradeA">
                   <html:form action="admin/danhSachDichVu" method="post">
						<td><bean:write name="dm" property="maDichVu"/></td>
						<td><bean:write name="dm" property="tenDichVu"/></td>
						<bean:define id="maDichVu" name="dm" property="maDichVu"></bean:define>
						<bean:define id="tenDichVu" name="dm" property="tenDichVu"></bean:define>
						<td class="center">
						
						   	<a href="#sDV_${maDichVu}" data-toggle="modal" class="btn btn-info" ><i class="icon-pencil"></i></a>
							<div id="sDV_${maDichVu}" class="modal hide">
							       <div class="modal-header">
							         <button data-dismiss="modal" class="close" type="button">×</button>
							         <h3>Sửa dịch vụ</h3>
							       </div>
							       <div class="modal-body">
							       
							        	<!-- <form action="suaDichVu.do" name="danhSachDichVuForm" method="get" class="form-horizontal"> -->
							        	<%-- <html:form action="admin/suaDichVu" name="danhSachDichVuForm" > --%>
							        		<div class="control-group">
								              <label class="control-label">Mã dịch vụ :</label>
								              <div class="controls">
								                <html:text name="dm" property="maDichVu" readonly="true" ></html:text>
								              </div>
								            </div>
								            <div class="control-group">
								              <label class="control-label">Tên dịch vụ :</label>
								              <div class="controls">
								                <html:text styleClass="span11" name="dm" property="tenDichVu" ></html:text>
								              </div>
								            </div>
								            <div class="form-actions">
								              <button type="submit" name="submit" value="Sua" class="btn btn-success">
								              <%-- <a class="btn btn-primary" href="suaDichVu.do?maDichVu=${maDichVu}tenDichVu=${tenDichVu}"> --%>
								              Cập nhật
								              </button>
								              <a data-dismiss="modal" class="btn btn-warning" href="#">Hủy</a>
								            </div>
								       <%--  </html:form> --%>
							         
							       </div>
							       <%-- <div class="modal-footer"> <a class="btn btn-primary" href="xoaDichVu.do?maDichVu=${maDichVu}">Xác nhận</a> <a data-dismiss="modal" class="btn" href="#">Hủy</a> </div> --%>
						</div>
						</td>
						<td class="center">
						    <%-- <bean:define id="maDichVu" name="dm" property="maDichVu"></bean:define> --%>
							<a href="#rmDM_${maDichVu}" data-toggle="modal" class="btn btn-warning"><i class="icon-remove"></i></a>							
							<div id="rmDM_${maDichVu}" class="modal hide">
							       <div class="modal-header">
							         <button data-dismiss="modal" class="close" type="button">×</button>
							         <h3>Xóa bỏ dịch vụ</h3>
							       </div>
							       <div class="modal-body">
							         <p>Bạn có muốn xóa bỏ dịch vụ này?</p>
							       </div>
							       <div class="modal-footer"> <a class="btn btn-primary" href="xoaDichVu.do?maDichVu=${maDichVu}">Xác nhận</a> <a data-dismiss="modal" class="btn" href="#">Hủy</a> </div>
							</div>
						</td>
					</html:form>
                </tr>
                </logic:iterate>
              </tbody>
            </table>
          </div>
        </div>
       	<div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>Thêm dịch vụ</h5>
        </div>
        <div class="widget-content nopadding">
          <form action="danhSachDichVu.do" method="post" class="form-horizontal">
            <div class="control-group">
              <label class="control-label">Tên dịch vụ :</label>
              <div class="controls">
                <input type="text" class="span11" name="tenDichVu" placeholder="Tên dịch vụ" required="required"/>
              </div>
            </div>
            <div class="form-actions">
              <button type="submit" name="submit" value="ADD" class="btn btn-success">Thêm mới</button>
            </div>
          </form>
        </div>
      </div>
        </div>
      </div>
    </div>
    <script type="text/javascript">
	window.onload = function(){ 
		$("#danhMuc").addClass( "active" );
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
