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
                        <h1 class="page-header">Danh sách bài đăng đã duyệt
                        </h1>
                    </div>
                    <!-- /.col-lg-12 -->
                    <html:form action="/danhSachBaiDangDaDuyet" method="get">
                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                            <tr align="center">
                                <th>STT</th>
                                <th>Tiêu đề</th>
                                <th>Danh mục</th>
                                <th>Ngày đăng</th>
                                <th>Xem</th>
                                <th>Gỡ bỏ</th>
                            </tr>
                        </thead>
                        <tbody>
                       <logic:iterate name="danhSachBaiDangDaDuyetForm" property="listBaiDang" id="bd">
                            <tr class="odd gradeX" align="center">
                                <td><bean:write name="bd" property="sTT"/></td>
                                <td><bean:write name="bd" property="tieuDe"/></td>
                                <td><bean:write name="bd" property="tenDanhMuc"/></td>
                                <td><bean:write name="bd" property="ngayDang"/></td>
                                <bean:define id="mbd" name="bd" property="maBaiDang"></bean:define>
                               	<td class="center">
										<html:link action="/xemTinDaDuyet?maBaiDang=${mbd}">
											<i class="fa fa-pencil fa-fw"></i><span class="db-account-listing-option-hover"> Xem</span>
										</html:link>
								</td>
								<td class="center">
										<html:link action="/goBoTinDaDuyet?maBaiDang=${mbd}">
											<i class="glyphicon glyphicon-trash"></i><span class="db-account-listing-option-hover"> Gỡ bỏ</span>
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