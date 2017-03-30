<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.do" flush="true">
	<jsp:param name="bcTitle" value="Liên hệ -"/>
</jsp:include>
	 <!-- gui lien he -->
	 <div id="main" class="site-main container">
		<div id="main-content" class="main-content row">
			<div class="entry-header"><h1 class="entry-title">Mọi yêu cầu của bạn được giải quyết tại đây</h1></div>
			<div id="primary" class="content-area sidebar-no clearfix bcpagewithbox">
				<div id="content" class="site-content " role="main">
					<html:form action="/themlh" method="post">
			        <div class="form-group">
		            	<html:text property="tieuDe" styleClass="form-control" styleId="tieuDe"></html:text>
		            	<html:errors property="tieuDeError"/>
			        </div>
			        <div class="form-group">
		            	<html:textarea property="noiDung" styleClass="form-control" styleId="noiDung"></html:textarea>
		            	<html:errors property="noiDungError"/>
			        </div>
			        <div class="form-group">
		            	<html:text property="soDT" styleClass="form-control" styleId="soDT"></html:text>
		            	<html:errors property="soDtError"/>
			        </div>
			        <div class="form-group">
		            	<html:text property="email" styleClass="form-control" styleId="email"></html:text>
		            	<html:errors property="emailError"/>
			        </div>
			        <div class="form-group">
			            <label>Loại yêu cầu</label>
			            	<html:select property="maVanDe" styleClass="form-control">
			            		<html:optionsCollection name="lienHeForm" property="listVanDe" label="tenVanDe" value="maVanDe" />
			            	</html:select>
			        </div>
			        <div class="form-group">
			            	 <button type="submit" class="btn btn-primary" name="submit" value="submit" style="max-width: 170px;height: 39px;">Thêm liên hệ</button>
			                <button class="btn btn-primary" onclick="history.go(-1);">Quay lại</button>
			        </div>
			    </html:form>
				</div> 
			</div>
		</div>
	</div>
	<script>
	$(document).ready(function(){
		$("#tieuDe").attr("placeholder", "Tiêu đề");
		$("#noiDung").attr("placeholder", "Nội dung của bạn");
		$("#soDT").attr("placeholder", "Số điện thoại của bạn");
		$("#email").attr("placeholder", "Email của bạn");
		$("input").prop('required',true);
		$("textarea").prop('required',true);
		$("#email").prop('type','email');
		$("#soDT").prop('pattern','(\\+84|0)\\d{9,10}');
		//$("#soDT").prop('maxlength','10');
		
	});
	</script>
	<!-- end gui lien he -->
<jsp:include page="template_Footer.jsp"></jsp:include>