<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<jsp:include page="/admin/header.do" flush="true"></jsp:include>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="danhMuc.do" class="current">Danh Mục</a> </div>
    <h1>Danh Mục</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Quản Lý Danh Mục</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>Mã Danh mục</th>
                  <th>Tên danh mục</th>
                  <th>Sửa</th>
                  <th>Xóa</th>
                </tr>
              </thead>
              <tbody>
                <logic:iterate name="danhMucForm" property="listDanhMuc" id="dm">
                <tr class="gradeA">
                   <html:form action="admin/danhMuc" method="post">
						<td><bean:write name="dm" property="maDanhMuc"/></td>
						<td><bean:write name="dm" property="tenDanhMuc"/></td>
						<td class="center">
						   	<a href="#sDM_${maDanhMuc}" data-toggle="modal" class="btn btn-info" ><i class="icon-pencil"></i></a>
							<div id="sDM_${maDanhMuc}" class="modal hide">
							       <div class="modal-header">
							         <button data-dismiss="modal" class="close" type="button">×</button>
							         <h3>Sửa danh mục</h3>
							       </div>
							       <div class="modal-body">
							       
							        	<!-- <form action="suaDichVu.do" name="danhSachDichVuForm" method="get" class="form-horizontal"> -->
							        	<%-- <html:form action="admin/suaDichVu" name="danhSachDichVuForm" > --%>
							        		<div class="control-group">
								              <label class="control-label">Mã danh mục :</label>
								              <div class="controls">
								                <html:text name="dm" property="maDanhMuc" readonly="true" ></html:text>
								              </div>
								            </div>
								            <div class="control-group">
								              <label class="control-label">Tên danh mục :</label>
								              <div class="controls">
								                <html:text styleClass="span11" name="dm" property="tenDanhMuc" ></html:text>
								              </div>
								            </div>
								            <div class="form-actions">
								              <button type="submit" name="submit" value="Sua" class="btn btn-success">
								              <%-- <a class="btn btn-primary" href="suaDichVu.do?maDichVu=${maDichVu}tenDichVu=${tenDichVu}"> --%>
								              Cập nhật
								              </button>
								              <a data-dismiss="modal" class="btn btn-warning" href="#">Hủy</a>
								            </div>
								       <%--  </html:form> --%>
							         
							       </div>
							       <%-- <div class="modal-footer"> <a class="btn btn-primary" href="xoaDichVu.do?maDichVu=${maDichVu}">Xác nhận</a> <a data-dismiss="modal" class="btn" href="#">Hủy</a> </div> --%>
						</div>
						</td>
						<td class="center">
						    <bean:define id="maDanhMuc" name="dm" property="maDanhMuc"></bean:define>
							<a href="#rmDM_${maDanhMuc}" data-toggle="modal" class="btn btn-warning"><i class="icon-remove"></i></a>							
							<div id="rmDM_${maDanhMuc}" class="modal hide">
							       <div class="modal-header">
							         <button data-dismiss="modal" class="close" type="button">×</button>
							         <h3>Xóa bỏ danh mục</h3>
							       </div>
							       <div class="modal-body">
							         <p>Bạn có muốn xóa bỏ danh mục này</p>
							       </div>
							       <div class="modal-footer"> <a class="btn btn-primary" href="xoadanhmuc.do?maDanhMuc=${maDanhMuc}">Confirm</a> <a data-dismiss="modal" class="btn" href="#">Cancel</a> </div>
							</div>
						</td>
					</html:form>
                </tr>
                </logic:iterate>
              </tbody>
            </table>
          </div>
        </div>
       	<div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>Thêm danh mục</h5>
        </div>
        <div class="widget-content nopadding">
          <form action="danhMuc.do" method="post" class="form-horizontal">
            <div class="control-group">
              <label class="control-label">Tên danh mục (<span class="inp_req">*</span>):</label>
              <div class="controls">
                <input type="text" class="span11" name="tenDanhMuc" placeholder="Tên danh mục" required="required" pattern="^[a-zA-Z0-9 \u0080-\u9fff , .]+$"/>
              </div>
            </div>
            <div class="form-actions">
              <button type="submit" name="submit" value="ADD" class="btn btn-success">Thêm mới</button>
            </div>
          </form>
        </div>
      </div>
        </div>
      </div>
    </div>
    <script type="text/javascript">
	window.onload = function(){ 
		$("#danhMuc").addClass( "active" );
	}
    </script>
  </div>
<jsp:include page="footer.jsp"></jsp:include>