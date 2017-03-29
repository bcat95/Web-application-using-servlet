<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<jsp:include page="header.do" flush="true"></jsp:include>
<script>
	$(function() {
    	$("#fullname").attr("placeholder", "Họ và tên");
   		$("#email").attr("placeholder", "Email");
    	$("#tenDN").attr("placeholder", "Tên đăng nhập");
    	$("#pw1").attr("placeholder", "Mật khẩu");
    	$("#pw2").attr("placeholder", "Nhập lại mật khẩu");
	});
</script>
<div id="main" class="site-main container">
	<div id="main-content" class="main-content row">
		<div class="entry-header"><h1 class="entry-title">Đăng ký tài khoản</h1></div>
		<div id="primary" class="content-area sidebar-no clearfix bcpagewithbox">
			<div id="content" class="site-content " role="main">
    			<html:form action="/Register">
    			<div style="margin:auto; width:400px; height:auto; padding-top:20px;">
        			<html:text name="taiKhoanForm" property="hoTen" styleClass="form-control" styleId="fullname"/><br/>
    				<html:text name="taiKhoanForm" property="email" styleClass="form-control" styleId="email"/><br/>
        			<html:text name="taiKhoanForm" property="userName" styleClass="form-control" styleId="tenDN"/><br/>
        			<html:password name="taiKhoanForm" property="pass" styleClass="form-control" styleId="pw1"/><br/>
        			<html:password name="taiKhoanForm" property="confirmMatKhau" styleClass="form-control" styleId="pw2"/><br/>
        			<logic:equal name="taiKhoanForm" property="thongBao" value="1">
						<h4 style="color:red;"> Vui lòng điền đầy đủ thông tin!!! </h4>
					</logic:equal>
					<logic:equal name="taiKhoanForm" property="thongBao" value="2">
						<h4 style="color:red;"> Email không đúng định dạng!!! </h4>
					</logic:equal>
					<logic:equal name="taiKhoanForm" property="thongBao" value="3">
						<h4 style="color:red;"> Tên đăng nhập không được tồn tại ký tự đặc biệt!!! </h4>
					</logic:equal>
					<logic:equal name="taiKhoanForm" property="thongBao" value="4">
						<h4 style="color:red;"> Mật khẩu không trùng khớp!!! </h4>
					</logic:equal>
					<logic:equal name="taiKhoanForm" property="thongBao" value="5">
						<h4 style="color:red;"> Tên đăng nhập đã có người sử dụng!!! </h4>
					</logic:equal>
					<logic:equal name="taiKhoanForm" property="thongBao" value="6">
						<h4 style="color:red;"> Vì lý do bảo mật 1 email chỉ được đăng ký 1 lần!!! </h4>
					</logic:equal>
					<logic:equal name="taiKhoanForm" property="thongBao" value="7">
						<h4 style="color:green;"> Đăng ký thành công!!! </h4>
					</logic:equal>
        			<html:submit property="submit" value="Register" styleClass="btn btn-primary"/><br/>
        		</div>
    			</html:form>
    		</div>
		</div>
	</div>
</div>
<jsp:include page="template_Footer.jsp"></jsp:include>