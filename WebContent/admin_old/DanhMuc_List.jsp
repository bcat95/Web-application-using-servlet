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
                        <h1 class="page-header">Danh sách danh mục
                        </h1>
                    </div>
                    <!-- /.col-lg-12 --> 
                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                            <tr align="center">
                                <th>Mã Danh mục</th>
                                <th>Tên danh mục</th>
                                <th>Sửa</th>
                                <th>Xóa</th>
                            </tr>
                        </thead>
                        <tbody>
                            <logic:iterate name="danhMucForm" property="listDanhMuc" id="dm">
                            
                            <tr class="odd gradeX" align="center">
                            <html:form action="/dsDanhMuc" method="post">
                                <td>
                					<bean:write name="dm" property="maDanhMuc"/>
								</td>
                                <td>
                                	<bean:write name="dm" property="tenDanhMuc"/>
                                </td>
                                <td class="center">
                                	<i class="glyphicon glyphicon-edit"></i><a href="#"> Sửa</a>
                                </td>
                                <td class="center">
                                <i class="glyphicon glyphicon-trash"></i>
                                <bean:define id="maDanhMuc" name="dm" property="maDanhMuc"></bean:define>
                				<html:link action="/xoa-danh-muc?maDanhMuc=${maDanhMuc}">
                					Xóa
                				</html:link>
                                </td>
                            </html:form>
                            </tr>
                            </logic:iterate>
                        </tbody>
                    </table>
                </div>
                <div class="row">
                	<html:form action="/dsDanhMuc" method="post">
                	<div class="col-lg-4">
                	<html:text name="danhMucForm" property="tenDanhMuc" styleClass="form-control" ></html:text>
                    </div>
                    <div class="col-lg-3">
                    <html:submit styleClass="btn btn-primary" property="submit" value="ADD">Thêm mới</html:submit>
                	</div>
                	</html:form>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
            
        </div>
        <!-- /#page-wrapper -->
        
<jsp:include page="Admin_Footer.jsp" flush="true"></jsp:include>
