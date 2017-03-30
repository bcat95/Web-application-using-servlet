<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<jsp:include page="/admin/header.do" flush="true"></jsp:include>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="danhSachBaiDangChuaDuyet.do" class="current">Duyệt bài</a> </div>
    <h1>Danh sách liên hệ</h1>
  </div>
  <div class="container-fluid">
        <div class="widget-box">
	        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
	          <h5>Tìm kiếm liên hệ</h5>
	        </div>
        	<div class="widget-content nopadding">
		        <html:form action="admin/danhsachlh" method="post" styleClass="form-horizontal">
		           
			   <div class="control-group">
			                	<label class="control-label">Chọn loại vấn đề</label>
				                <div class="controls">
					                <html:select property="maVanDe" styleClass="form-control">
										<option value="">-- Chọn vấn đề --</option>
										<html:optionsCollection name="danhSachLienHeForm" property="listVanDe" label="tenVanDe" value="maVanDe" />
									</html:select>
						            <script type="text/javascript">
						            	$("[name='maVanDe']").val('<bean:write name="danhSachLienHeForm" property="maVanDe"/>');
						            </script>
						         </div>
				</div>
			   <div class="control-group">
           			<div class="controls">
	           			<html:text styleId="name" property="tim" styleClass="form-control" style="width:300px;"></html:text>
	            			<html:errors property="timError"/>
	            		<html:submit styleClass="btn btn-primary">Xem</html:submit>
	            	</div>
			    </div>
		        </html:form>
		       </div>
    <br>
    <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Danh sách liên hệ</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                 <th>Mã liên hệ</th>
                <th>Tiêu đề</th>
                <th>Ngày gửi</th>
                <th>SDT</th>
                <th>Email</th>
                <th>Tên vấn đề</th>
                <th>Hành động</th>
                </tr>
              </thead>
              <tbody>
                 <logic:iterate name="danhSachLienHeForm" property="listLienHe" id="lh">
	                <tr class="gradeX">
	                 <td scope="row">
                		<bean:write name="lh" property="maLienHe"/>
					</td>
	                <td>
	                	<bean:write name="lh" property="tieuDe"/>
	                </td>
	                <td>
	                	<bean:write name="lh" property="ngayGui"/>
					</td>
	                <td>
	                	<bean:write name="lh" property="SDT"/>
	                </td>
	                <td>
	                	<bean:write name="lh" property="email"/>
	                </td>
	                <td>
	                	<bean:write name="lh" property="tenVanDe"/>
	                </td>
	                <td>
                		<bean:define id="maLienHe" name="lh" property="maLienHe"></bean:define>
	                	<html:link action="/xemlh?maLienHe=${maLienHe}">
	                		<span class="glyphicon glyphicon-pencil" aria-hidden="true">Chi tiết</span>
	                	</html:link>
	                	<html:link action="/xoalh?maLienHe=${maLienHe}">
	                		<a class="glyphicon glyphicon-trash" data-toggle="modal" data-target="#myModal${maLienHe}">Xóa</a>
	                	</html:link>
					<td>
					<!-- Modal -->
					
					<div class="modal fade" id="myModal${maLienHe}" role="dialog">
						<div class="modal-dialog">
						
						<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h1 class="modal-title" style="color: black;">Xác nhận xóa</h1>
								</div>
								<div class="modal-body">
								
								<p style="color: red;">Bạn có chắc chắn muốn xóa hay không?</p>
								</div>
								<div class="modal-footer">
								
								<a href="xoalh.do?maLienHe=${maLienHe}" class="btn btn-danger" >Xác nhận</a>
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
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
<script>
$(document).ready(function(){
	$("#name").attr("placeholder", "Tìm kiếm");
});
</script>
<jsp:include page="footer.jsp"></jsp:include>