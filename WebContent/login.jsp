<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<jsp:include page="header.do" flush="true"></jsp:include>
<script>
	$(function() {
   		$("#username").attr("placeholder", "Enter username");
   		$("#pw").attr("placeholder", "Enter password");
	});
</script>
<div id="main" class="site-main container">
	<div id="main-content" class="main-content row">
		<div class="entry-header"><h1 class="entry-title">Đăng nhập tài khoản của bạn</h1></div>
		<div id="primary" class="content-area sidebar-no clearfix bcpagewithbox">
			<div id="content" class="site-content " role="main">
				<div class="login-form">
		    		<html:form action="/Login">
		    			<div class="form-group">
		        			<html:text name="taiKhoanForm" property="userName" styleClass="form-control" styleId="username"/> <br/>
		        		</div>
		        		<div class="form-group">
		        			<html:password name="taiKhoanForm" property="pass" styleClass="form-control" styleId="pw"/> <br/>
		        		</div>	
		        		<logic:equal name="taiKhoanForm" property="thongBao" value="1">
							<h4 style="color:red;"> Vui lòng điền đầy đủ thông tin!!! </h4>
						</logic:equal>
						<logic:equal name="taiKhoanForm" property="thongBao" value="2">
							<h4 style="color:red;"> Mật khẩu hoặc tài khoản không đúng, vui lòng kiểm tra lại!!! </h4>
						</logic:equal>
		       			<html:submit property="submit" value="Login" styleClass="btn btn-pramery"/><br/>
		       			Bạn chưa có tài khoản <a href="Register.do">Đăng ký</a>
		        	</html:form>	
		        </div>
   			</div>
    	</div>
	</div>
</div>
<jsp:include page="template_Footer.jsp"></jsp:include>