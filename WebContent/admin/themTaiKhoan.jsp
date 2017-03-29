<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<jsp:include page="/admin/header.do" flush="true"></jsp:include>

<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="adminpanel.do" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="themTaiKhoan.do">Thêm tài khoản</a></div>
    <h1>Tạo mới tài khoản</h1>
  </div>
  <div class="container-fluid"><hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-info-sign"></i> </span>
            <h5>Tạo mới thông tin tài khoản</h5>
          </div>
          <div class="widget-content nopadding">
            <html:form action="admin/themTaiKhoan" method="post" styleClass="form-horizontal" styleId="suaTaiKhoan">
             <div class="control-group">
                <label class="control-label">Username (<span class="inp_req">*</span>)</label>
                <div class="controls">
                  <html:text property="userName" styleClass="required"></html:text>
                </div>
              </div>
              <div class="control-group">
                <label class="control-label">Mật khẩu (<span class="inp_req">*</span>)</label>
                <div class="controls">
                  <html:password property="passWord" styleClass="required"></html:password>
                </div>
              </div>
               <div class="control-group">
                <label class="control-label">Quyền (<span class="inp_req">*</span>)</label>
                <div class="controls">
					<html:select property="maQuyen">
					    <html:optionsCollection name="danhSachTaiKhoanForm" property="listQuyen" label="tenQuyen" value="maQuyen"/>
					</html:select>
                </div>
              </div>
              <div class="control-group">
                <label class="control-label">Loại tài khoản (<span class="inp_req">*</span>)</label>
                <div class="controls">
					<html:select property="maLoaiTaiKhoan">
					     <html:optionsCollection name="danhSachTaiKhoanForm" property="listLoaiTaiKhoan" label="tenLoaiTaiKhoan" value="maLoaiTaiKhoan" />
					</html:select>
                </div>
              </div>
               <div class="control-group">
                <label class="control-label">Họ tên (<span class="inp_req">*</span>)</label>
                <div class="controls">
					<html:text property="hoTen" styleClass="required"></html:text>
                </div>
              </div>
              <div class="control-group">
              <label class="control-label">Giới tính</label>
              <div class="controls">
				<label>
				  <div class="radio" id="uniform-undefined"><span class="checked">
				  	<input type="radio" name="gioiTinh" style="opacity: 0;" value="1" checked></span></div>
				  Nam</label>
				<label>
				  <div class="radio" id="uniform-undefined"><span class="">
				  	<input type="radio" name="gioiTinh" style="opacity: 0;" value="0"></span></div>
				      Nữ</label>
				    <label>
				  </div>
				</div>
              <div class="control-group">
                <label class="control-label">Ngày sinh</label>
                <div class="controls">
                	<html:text property="ngaySinh" styleClass="date"></html:text>
                </div>
              </div>
              <div class="control-group">
                <label class="control-label">Số điện thoại</label>
                <div class="controls">
                	 <html:text property="sDT" styleClass="inp_number inp_sdt"></html:text>
                </div>
              </div>
               <div class="control-group">
                <label class="control-label">Email</label>
                <div class="controls">
                	 <html:text property="eMail" styleClass="inp_email"></html:text>
                </div>
              </div>
              <div class="control-group">
                <label class="control-label">Ngày đăng ký (<span class="inp_req">*</span>)</label>
                <div class="controls">
                	<html:text property="ngayDangKy" styleClass="inp_date required"></html:text>
                </div>
              </div>
              <div class="form-actions">
                <button type="submit" name="submit" value="themTK" class="btn btn-success">Tạo tài khoản</button>
              </div>
           </html:form>
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
</div>
<jsp:include page="footer.jsp"></jsp:include>
  <script>
	$(document).ready(function(){
		$(".date").prop('type','date');
		$(".inp_date").prop('type','date');
		$(".inp_email").prop('type','email');
		$(".inp_number").prop('type','number');
		$(".inp_sdt").attr('minlength','10');
		$(".inp_sdt").attr('maxlength','11');
	});
	</script>