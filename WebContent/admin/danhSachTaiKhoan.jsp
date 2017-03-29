<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<jsp:include page="/admin/header.do" flush="true"></jsp:include>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="danhSachTaiKhoan.do" class="current">Tài khoản</a> </div>
    <h1>Danh sách tài khoản</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Quản lý tài khoản</h5>
          </div>
          <div class="widget-content nopadding">
            <html:form action="admin/danhSachTaiKhoan" method="post">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>STT</th>
                  <th>Username</th>
                  <th>Quyền</th>
                  <th>Loại tài khoản</th>
                  <th>Họ Tên</th>
                  <th>Giới tính</th>
                  <th>Ngày Sinh</th>
                  <th>SĐT</th>
                  <th>Email</th>
                  <th>Sửa</th>
                  <th>Xóa</th>
                </tr>
              </thead>
              <tbody>
                 <logic:iterate name="danhSachTaiKhoanForm" property="listTaiKhoan" id="tk">
                 <tr class="gradeA">
					<bean:define id="taiKhoan" name="tk" property="userName" ></bean:define>
                     <td><bean:write name="tk" property="sTT"/></td>
                     <td><bean:write name="tk" property="userName"/></td>
                     <td><bean:write name="tk" property="tenQuyen"/></td>
                     <td><bean:write name="tk" property="tenLoaiTaiKhoan"/></td>
                     <td><bean:write name="tk" property="hoTen"/></td>
                     <td><bean:write name="tk" property="gioiTinh"/></td>
                     <td><bean:write name="tk" property="ngaySinh"/></td>
                     <td><bean:write name="tk" property="sDT"/></td>
                     <td><bean:write name="tk" property="eMail"/></td>
                     <td class="center">
						<html:link action="admin/suaTaiKhoan?userName=${taiKhoan}" styleClass="btn btn-info btn-mini">
							<i class="fa fa-pencil fa-fw"></i><span class="db-account-listing-option-hover"> Sửa</span>
						</html:link>
					</td>
					<td class="center">
						<html:link action="admin/xoaTaiKhoan?userName=${taiKhoan }" styleClass="btn btn-warning btn-mini">
						<i class="glyphicon glyphicon-trash"></i><span class="db-account-listing-option-hover"> Xóa</span>
					</html:link>
					</td>
                </tr>
                </logic:iterate>
              </tbody>
            </table>
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
