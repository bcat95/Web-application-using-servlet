<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<jsp:include page="/admin/header.do" flush="true"></jsp:include>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="danhSachBaiDangChuaDuyet.do" class="current">Duyệt bài</a> </div>
    <h1>Bài dăng chờ duyệt</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Quản Lý Bài Đăng Chờ Duyệt</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>STT</th>
                  <th>Tiêu đề</th>
                  <th>Danh mục</th>
                  <th>Ngày đăng</th>
                  <th>Xem</th>
                  <th>Xóa</th>
                </tr>
              </thead>
              <tbody>
                 <logic:iterate name="danhSachBaiDangDaDuyetForm" property="listBaiDang" id="bd">
                 <tr class="gradeA">
						<td><bean:write name="bd" property="sTT"/></td>
						<td><bean:write name="bd" property="tieuDe"/></td>
						<td><bean:write name="bd" property="tenDanhMuc"/></td>
						<td><bean:write name="bd" property="ngayDang"/></td>
						<bean:define id="mbd" name="bd" property="maBaiDang"></bean:define>
						<td class="center">
						<html:link action="admin/xemtinchuaduyet?maBaiDang=${mbd}" styleClass="btn btn-success btn-mini">
							<i class="fa fa-pencil fa-fw"></i><span class="db-account-listing-option-hover"> Xem</span>
						</html:link>
						</td>
						 <td class="center">
                             <html:link action="/suatin?maBaiDang=${mbd}" styleClass="btn btn-info btn-mini">
                                 <i class="glyphicon glyphicon-trash"></i><span class="db-account-listing-option-hover"> Sửa</span>
                             </html:link>
                     	</td>
						<td class="center">
                             <html:link action="admin/goBoTinChuaDuyet?maBaiDang=${mbd}" styleClass="btn btn-warning btn-mini">
                                 <i class="glyphicon glyphicon-trash"></i><span class="db-account-listing-option-hover"> Xóa</span>
                             </html:link>
                     	</td>
                </tr>
                </logic:iterate>
              </tbody>
            </table>
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
  </div>
<jsp:include page="footer.jsp"></jsp:include>