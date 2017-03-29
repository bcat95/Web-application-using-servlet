<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<jsp:include page="/admin/header.do" flush="true"></jsp:include>

<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="danhSachBaiDangChuaDuyet.do" class="current">Duyệt bài</a> </div>
    <h1>Xóa bỏ bài đăng</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
			<div class="widget-title"><span class="icon"><i class="icon-bookmark"></i></span>
			  <h5>Xác nhận xóa bài đăng</h5>
			</div>
			<div class="widget-content">
				<html:form action="admin/goBoTinChuaDuyet">
					<div class="alert alert-block">
						<a class="close" data-dismiss="alert" href="#">×</a>
						<h4 class="alert-heading">Bạn chắc chắn muốn gỡ bỏ bài đăng !</h4>
						<span class="label label-important"><bean:write name="danhSachBaiDangDaDuyetForm" property="tieuDe"/></span> sẽ bị xóa bỏ khỏi hệ thống
		            </div>
					<html:hidden property="maBaiDang"/>
					<button type="submit" name="submit" value="xnGoBoCD" class="btn btn-warning btn-large">Xác nhận</button>
					<html:link action="admin/danhSachBaiDangChuaDuyet.do"><span class="btn btn-large">Quay lại</span></html:link>
				</html:form>
			</div>
          </div>
        </div>
        </div>
      </div>
    </div>
    <script type="text/javascript">
	window.onload = function(){ 
		$("#baiDang").addClass( "active" );
	}
    </script>
<jsp:include page="footer.jsp"></jsp:include>
