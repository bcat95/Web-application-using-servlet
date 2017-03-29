<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<jsp:include page="/admin/header.do" flush="true"></jsp:include>

<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="adminpanel.do" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="danhSachTaiKhoan.do" class="current">Danh sách tài khoản</a> </div>
    <h1>Xóa bỏ tài khoản</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
			<div class="widget-title"><span class="icon"><i class="icon-bookmark"></i></span>
			  <h5>Xác nhận xóa tài khoản</h5>
			</div>
			<div class="widget-content">
				<html:form action="admin/xoaTaiKhoan">
					<div class="alert alert-block">
						<a class="close" data-dismiss="alert" href="#">×</a>
						<h4 class="alert-heading">Bạn chắc chắn muốn xóa tài khoản !</h4>
						<span class="label label-important"><bean:write name="danhSachTaiKhoanForm" property="userName"/></span> sẽ bị xóa bỏ khỏi hệ thống
		            </div>
		            <html:hidden property="userName"/>
		            <button type="submit" name="submit" value="xoaTaikhoan" class="btn btn-warning btn-large">Xác nhận</button>
					<html:link action="admin/danhSachTaiKhoan.do"><span class="btn btn-large">Quay lại</span></html:link>
				</html:form>
			</div>
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
<jsp:include page="footer.jsp"></jsp:include>