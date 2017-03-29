<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head lang="en">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Liên Hệ</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <%-- <div class="row">
        <html:form action="danhsachlh" method="post">
            <div class="col-lg-4">
                <html:select property="maVanDe" styleClass="form-control">
					<option value="">-- Chọn vấn đề --</option>
					<html:optionsCollection name="danhSachLienHeForm" 
					property="listVanDe" 
						label="tenVanDe" value="maVanDe" />
				</html:select>
            </div>
            <script type="text/javascript">
            	$("[name='maVanDe']").val('<bean:write name="danhSachLienHeForm" property="maVanDe"/>');
            </script>
            <table>
            	<tr>
          			<td><html:text styleId="name" property="tim" styleClass="form-control" style="width:300px;"></html:text>
            			<html:errors property="timError"/> </td>
            		<td style="padding-left:10px;"> <html:submit styleClass="btn btn-primary">Xem</html:submit> </td>
            	</tr>
            </table>
            <div class="col-lg-2 pull-right">
            	<html:link styleClass="btn btn-primary" action="/themlh">Gửi yêu cầu</html:link>
            </div>
        </html:form>
    </div>
    <br> --%>
    
    <div class="bs-example">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Mã liên hệ</th>
                <th>Tiêu đề</th>
                <th>Nội dung</th>
                <th>Ngày gửi</th>
                <th>SDT</th>
                <th>Email</th>
                <th>Tên vấn đề</th>
            </tr>
            </thead>
            <tbody>
            <%-- <logic:iterate name="lienHeForm" property="listLienHe" id="lh"> --%>
            	<tr>
                <th scope="row">
                	<bean:write name="lienHeForm" property="maLienHe"/>
				</th>
                <td>
                	<bean:write name="lienHeForm" property="tieuDe"/>
                </td>
                <td>
                	<div style="height: auto;width: auto;">
                	<bean:write name="lienHeForm" property="noiDung"/>
                	</div>
                </td>
                <td>
                	<bean:write name="lienHeForm" property="ngayGui"/>
				</td>
                <td>
                	<bean:write name="lienHeForm" property="soDT"/>
                </td>
                <td>
                	<bean:write name="lienHeForm" property="email"/>
                </td>
                <td>
                	<bean:write name="lienHeForm" property="tenVanDe"/>
                	
                	
                </td>
                <%-- <td>
                	<bean:define id="maLienHe" name="lh" property="maLienHe"></bean:define>
                	<html:link action="/xemlh?maLienHe=${maLienHe}">
                		<span class="glyphicon glyphicon-pencil" aria-hidden="true">Chi tiết</span>
                	</html:link>
                	<html:link action="/xemlh?maLienHe=${maLienHe}">
                		<a></a><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>Chi tiết</a>
                	</html:link>
                	<html:link action="/xoalh?maLienHe=${maLienHe}" style="margin-left: 30px;">
                		<span class="glyphicon glyphicon-trash"></span>
                	</html:link>
                </td> --%>
            </tr>
           <%--  </logic:iterate> --%>
            </tbody>
        </table>
        <div class="row form-group">
            <div class="col-lg-3 col-lg-offset-2">
                <button class="btn btn-primary" onclick="history.go(-1);"><a href="chay.jsp" style="color: white">Quay lại</a></button>
            </div>
        </div>
    </div>
</div>
</body>
</html>