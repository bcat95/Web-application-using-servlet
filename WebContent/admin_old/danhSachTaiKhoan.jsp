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
                        <h1 class="page-header">Danh sách tài khoản
                        </h1>
                    </div>
                    <!-- /.col-lg-12 -->
                    <html:form action="/danhSachTaiKhoan" method="get">
                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
          	                  <tr align="center">
                                <th>STT</th>
                                <th>Username</th>
                                <th>Quyền</th>
                                <th>Loại tài khoản</th>
                                <th>Họ Tên</th>
                                <th>Giới tính</th>
                                <th>Ngày Sinh</th>
                                <th>SĐT</th>
                                <th>Email</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                        <logic:iterate name="danhSachTaiKhoanForm" property="listTaiKhoan" id="tk">

                            <tr class="odd gradeX" align="center">
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
										<html:link action="/sua-tai-khoan?userName=${taiKhoan}">
											<i class="fa fa-pencil fa-fw"></i><span class="db-account-listing-option-hover"></span>
										</html:link>
								</td>
								<td class="center">
										<html:link action="/xoaTaiKhoan?userName=${taiKhoan }">
											<i class="glyphicon glyphicon-trash"></i><span class="db-account-listing-option-hover"></span>
										</html:link>
								</td>
                            </tr>
                        </logic:iterate>
                        </tbody>
                    </table>
                    </html:form>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
        
<jsp:include page="Admin_Footer.jsp" flush="true"></jsp:include>