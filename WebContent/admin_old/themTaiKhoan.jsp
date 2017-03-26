<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<jsp:include page="Admin_Header.jsp" flush="true"></jsp:include>

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
        
<jsp:include page="Admin_Footer.jsp" flush="true"></jsp:include>