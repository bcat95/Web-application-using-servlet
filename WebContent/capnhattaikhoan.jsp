<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<jsp:include page="header.do" flush="true"></jsp:include>
<script>
	$(function() {
		$("#datepicker").attr("type", "date");
	});
</script>
<div id="main" class="site-main container">
		<div id="main-content" class="main-content row">
			<div class="entry-header"><h1 class="entry-title">Thông tin tài khoản cá nhân.</h1></div>
			<div id="primary" class="content-area sidebar-no clearfix ">
				<div id="content" class="site-content " role="main">
		<html:form action="/Update">
		<div class="row" style="padding-top:20px;">
		<div class="col-sm-6">
			<table>
            	<tr>
            		<td> <label style="width:150px;">Họ và tên:</label> </td>
            		<td>
            			<html:text style="width:250px;" name="taiKhoanForm" property="hoTen" styleClass="form-control"></html:text>
            		</td>
        		</tr>
        		<tr>
            		<td> <label>Ngày sinh:</label> </td>
            		<td>
            			<html:text name="taiKhoanForm" property="ngaySinh" styleClass="form-control" styleId="datepicker"></html:text>
            		</td>
        		</tr>
        	    <tr>
            		<td> <label>Giới tính:</label> </td>
            		<td >
            		<html:select  name="taiKhoanForm" property="gioiTinh">
            			<html:option value="">--Chọn giới tính--</html:option>
            			<html:option value="0">Nam</html:option>
            			<html:option  value="1">Nữ</html:option>
            		</html:select>
            		</td>
            	</tr>
        		<tr>
            		<td> <label>Email:</label> </td>
            		<td>
            			<html:text name="taiKhoanForm" property="email" styleClass="form-control"></html:text>
            		</td>
        		</tr>
    			<tr>
            		<td> <label>Số điện thoại:</label> </td>
            		<td>
            			<html:text name="taiKhoanForm" property="SDT" styleClass="form-control"></html:text>
            		</td>
        		</tr>
    			<tr>
            		<td> <label>Tên đăng nhập:</label> </td>
            		<td>
            			<html:text name="taiKhoanForm" property="userName" styleClass="form-control" readonly="true"></html:text>
            		</td>
        		</tr>
        		<tr>
            		<td> <label>Mật khẩu:</label> </td>
            		<td>
            			<html:password name="taiKhoanForm" property="pass" styleClass="form-control" value=""></html:password>
            		</td>
        		</tr>
        		<tr>
					<td> <html:submit property="submit" value="Update" styleClass="btn btn-primary"/> </td>
				</tr>
			</table>
			<div>
				<logic:equal name="taiKhoanForm" property="thongBao" value="10">
						<h4 style="color:red;"> Lỗi!!! </h4>
					</logic:equal>
					<logic:equal name="taiKhoanForm" property="thongBao" value="1">
						<h4 style="color:red;"> Vui lòng nhập đầy đủ thông tin!!! </h4>
					</logic:equal>
					<logic:equal name="taiKhoanForm" property="thongBao" value="2">
						<h4 style="color:red;"> Email không đúng định dạng!!! </h4>
					</logic:equal>
					<logic:equal name="taiKhoanForm" property="thongBao" value="3">
						<h4 style="color:red;"> Email này đã được sử dụng!!! </h4>
					</logic:equal>
					<logic:equal name="taiKhoanForm" property="thongBao" value="4">
						<h4 style="color:red;"> Số điện thoại không đúng!!! </h4>
					</logic:equal>
					<logic:equal name="taiKhoanForm" property="thongBao" value="5">
						<h4 style="color:red;"> Mật khẩu không đúng, vui lòng kiểm tra lại!!! </h4>
					</logic:equal>
					<logic:equal name="taiKhoanForm" property="thongBao" value="6">
						<h4 style="color:green;"> Cập nhật thông tin thành công!!! </h4>
					</logic:equal>
			</div>
		</div>
		<div class="col-sm-3">
			<div> <img style="height:300px; width:270px;" src="img/user.png"/> </div>
			<%-- <html:file property="avatar" title="chon file" value="file" onchange="readURL(this);" accept="pic/*"></html:file> --%>
		</div>
		<div class="col-sm-3">
			
		</div>
		</div>
		</html:form>
		</div> 
			</div>
		</div>
	</div>
<jsp:include page="template_Footer.jsp"></jsp:include>