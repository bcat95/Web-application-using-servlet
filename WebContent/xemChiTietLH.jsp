<%@page import="model.bean.LienHe"%>
<%@page import="model.bean.VanDe"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Xem chi tiết Liên Hệ</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h3>Xem chi tiết liên hệ: 
		<bean:write name="lienHeForm" property="tieuDe"/>
	</h3>
    <br>
	<html:form action="/xoalh" method="post">
        <div class="row form-group">
            <label class="col-lg-2">Mã LH</label>
            <div class="col-lg-3">
                <html:text property="maLienHe" styleClass="form-control" readonly="true"></html:text>
            </div>
        </div> 
        <div class="row form-group">
            <label class="col-lg-2">Tiêu đề</label>
            <div class="col-lg-3">
                <html:text property="tieuDe" styleClass="form-control" readonly="true"></html:text>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Nội dung</label>
            <div style="height:auto;width:1000px;padding-left:210px;">
                <bean:write name="lienHeForm" property="noiDung"/>
                <%-- <html:textarea property="noiDung" styleClass="form-control" readonly="true"></html:textarea> --%>
            </div>
        </div>
       <div class="row form-group">
            <label class="col-lg-2">Ngày gửi</label>
            <div class="col-lg-3">
                <html:text property="ngayGui" styleClass="form-control" readonly="true"></html:text>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Số điện thoại</label>
            <div class="col-lg-3">
                <html:text property="soDT" styleClass="form-control" readonly="true"></html:text>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Email</label>
            <div class="col-lg-3">
                <html:text property="email" styleClass="form-control" readonly="true"></html:text>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">VanDe</label>
            <div class="col-lg-3">
               	<html:select property="maVanDe" styleClass="form-control" disabled="true">
            		<html:optionsCollection name="lienHeForm" property="listVanDe" label="tenVanDe" value="maVanDe"/>
            	</html:select>
            </div>
        </div>
        <div class="row form-group">
            <div class="col-lg-3 col-lg-offset-2">
               <%--  <html:submit styleClass="btn btn-primary" property="submit" value="submit">Xác nhận</html:submit> --%>
                <button class="btn btn-primary" onclick="history.go(-1);"><a href="chay.jsp" style="color: white">Quay lại</a></button>
            </div>
        </div>
    </html:form>
</div>
</body>
</html>