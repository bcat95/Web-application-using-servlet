<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<jsp:include page="header.do" flush="true"></jsp:include>
<bean:define id="maBaiDang" name="khuyenMaiForm" property="maBaiDang"></bean:define>
 <!-- Them khuyen mai -->
	 <div id="main" class="site-main container">
		<div id="main-content" class="main-content row">
			<div class="entry-header"><h1 class="entry-title">Quản Lý Khuyến Mãi</h1></div>
			<div id="primary" class="content-area sidebar-no clearfix ">
				<div id="entry-content-wrapper" class="clearfix">
					<ul class="db-account-menu nav-pills clearfix">
						<li class="active"><a data-toggle="pill" href="#khuyenmai_thongTin" class="active">Danh sách khuyến mãi</a></li>
						<li><a data-toggle="pill" href="#khuyenmai_themkhuyenmai" class="">Thêm mới khuyến mãi</a></li>
						<li><a href="thong-tin.do">Quay lại</a></li>
					</ul>
					<div class="tab-content">
						<!-- khuyen mai danh sach khuyen mai -->
						<div id="khuyenmai_thongTin" class="tab-pane fade in active">
							<display:table id="bckhuyenmai" name="sessionScope.khuyenMaiForm.listKhuyenMai" class="db-account-listings table table-striped table-hover"
								requestURI="/khuyenmai.do" pagesize="5">
								<display:column property="maKhuyenMai" title="ID KM" sortable="true" class="bcblock makhuyenmai" href="#" paramId="maKhuyenMai"/>
								<display:column property="tieuDe" title="Tiêu đề" class="bcblock tieude" />
								<display:column property="noiDung" title="Nội dung" class="bcblock noidung"/>
								<display:column property="ngayBatDau" title="Ngày bắt đầu" class="bcblock ngaybatdau"/>
								<display:column property="ngayKetThuc" title="Kết Thúc vào" class="bcblock ngayketthuc"></display:column>
								<display:column property="maBaiDang" title="ID BĐ" sortable="true" class="bcblock mabaidang" href="/xemtin.do" paramId="maBaiDang"/>
								<display:column title="Hành động">
									<html:link action="/xemtin?maBaiDang=${maBaiDang}"  styleClass="db-edit-listing db-account-listing-option view">
						                	<span class="db-account-listing-option-hover">Xem</span><i class="fa fa-eye" aria-hidden="true"></i>
						            </html:link>
						            <span class="db-edit-listing db-account-listing-option edit" data-toggle="modal" data-target="#suaKhuyenMai_${bckhuyenmai.maKhuyenMai}">
						                	<span class="db-account-listing-option-hover">Sửa</span><i class="fa fa-pencil" aria-hidden="true"></i>
						             </span>
								</display:column>
								<display:column class="modal_edit">
									<!-- Modal sua khuyen mai -->
									<div class="modal fade" id="suaKhuyenMai_${bckhuyenmai.maKhuyenMai}" role="dialog">
									  <div class="modal-dialog modal-lg">
									    <div class="modal-content">
									      <div class="modal-header">
									        <button type="button" class="close" data-dismiss="modal">&times;</button>
									        <h4 class="modal-title">Sửa Khuyễn Mãi</h4>
									      </div>
									      <div class="modal-body">
									        <html:form action="/suakhuyenmai" method="post">
											       <div class="form-group">
										            	<html:text property="maKhuyenMai" styleClass="form-control" styleId="maKhuyenMai" readonly="true" value="${bckhuyenmai.maKhuyenMai}"></html:text>
											        </div>
											        <div class="form-group">
										            	<html:text property="tieuDe" styleClass="form-control" styleId="tieuDe" value="${bckhuyenmai.tieuDe}"></html:text>
										            	<html:errors property="tieuDeError"/>
											        </div>
											        <div class="form-group">
										            	<html:textarea property="noiDung" styleClass="form-control" styleId="noiDung" value="${bckhuyenmai.noiDung}" ></html:textarea>
										            	<html:errors property="noiDungError"/>
											        </div>
											        <div class="form-group">
										            	<html:text property="ngayBatDau" styleClass="form-control" styleId="ngayBatDau" value="${bckhuyenmai.ngayBatDau}"></html:text>
										            	<html:errors property="ngayBatDauError"/>
											        </div>
											        <div class="form-group">
										            	<html:text property="ngayKetThuc" styleClass="form-control" styleId="ngayKetThuc" value="${bckhuyenmai.ngayKetThuc}"></html:text>
										            	<html:errors property="ngayKetThucError"/>
											        </div>
											        <div class="form-group">
											            	<input type="hidden" name="maBaiDang" value="${bckhuyenmai.maBaiDang}">
											            	<button type="submit" name="submit" value="suaKhuyenMai" class="btn btn-primary">Sửa Khuyến Mãi</button>
											                <button class="btn btn-default" data-dismiss="modal">Quay lại</button>
											        </div>
										    	</html:form>
									      </div>
									      <div class="modal-footer">
									        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
									      </div>
									    </div>
									  </div>
									</div>
									<script>
									window.onload = function(){
										$("#suaKhuyenMai_${bckhuyenmai.maKhuyenMai}").appendTo("#bc_edit_km");
									};
									</script>
								</display:column>
								<display:setProperty name="paging.banner.placement" value="bottom" />
								<display:setProperty name="basic.msg.empty_list">
								<div class="alert alert-info">
									<strong>Oh!</strong> Chưa có khuyến mãi ! Hãy tạo một khuyến mãi thôi nào.
								</div>
								</display:setProperty>
								<display:setProperty name="paging.banner.all_items_found"><span class="pagebanner"> {0} {1} được hiển thị, số khuyến mãi {2}. </span></display:setProperty>
								<display:setProperty name="paging.banner.some_items_found">
								<span class="pagebanner"> {0} {1} được hiển thị, số khuyến mãi {2} đến {3}. </span>
								</display:setProperty>
								<display:setProperty name="paging.banner.full">
								<ul class="pagination">
								  	<li class="previous"><a href="{1}">Đầu tiên</a></li>
								    <li class="previous"><a href="{2}">Trước</a></li>
								    <li class="hidetext">{0}</li>
								    <li class="next"><a href="{3}">Sau</a></li>
								    <li class="next"><a href="{4}">Cuối cùng</a></li>
								</ul>
								</display:setProperty>
								<display:setProperty name="paging.banner.first">
								<ul class="pagination">
								  	<li class="hidetext">{0}</li>	
								    <li class="next"><a href="{3}">Sau</a></li>
								    <li class="next"><a href="{4}">Cuối cùng</a></li>
								</ul>
								</display:setProperty>
								<display:setProperty name="paging.banner.last">
								<ul class="pagination">
								  	<li class="previous"><a href="{1}">Đầu tiên</a></li>
								    <li class="previous"><a href="{2}">Trước</a></li>
								    <li class="hidetext">{0}</li>
								</ul>
								</display:setProperty>
							</display:table>
						</div>
						<!-- end khuyen mai danh sach khuyen mai -->
						<!-- khuyen mai them moi khuyen mai -->
						<div id="khuyenmai_themkhuyenmai" class="tab-pane fade">
							<div id="content" class="site-content " role="main">
								<html:form action="/themkhuyenmai" method="post">
							        <div class="form-group">
						            	<html:text property="tieuDe" styleClass="form-control" styleId="add_tieuDe"></html:text>
						            	<html:errors property="tieuDeError"/>
							        </div>
							        <div class="form-group">
						            	<html:textarea property="noiDung" styleClass="form-control" styleId="add_noiDung"></html:textarea>
						            	<html:errors property="noiDungError"/>
							        </div>
							        <div class="form-group">
						            	<html:text property="ngayBatDau" styleClass="form-control" styleId="ngayBatDau"></html:text>
						            	<html:errors property="ngayBatDauError"/>
							        </div>
							        <div class="form-group">
						            	<html:text property="ngayKetThuc" styleClass="form-control" styleId="ngayKetThuc"></html:text>
						            	<html:errors property="ngayKetThucError"/>
							        </div>
							        <div class="form-group">
							            	<input type="hidden" name="maBaiDang" value="${maBaiDang}">
							            	<button type="submit" name="submit" value="themKhuyenMai" class="btn btn-primary">Thêm Khuyến Mãi</button>
							                <button class="btn btn-primary" onclick="history.go(-1);">Quay lại</button>
							        </div>
						    	</html:form>
							</div>
						</div>
					<!-- end khuyen mai them moi khuyen mai -->
					</div>
				</div>
				<div id="bc_edit_km"></div>
			</div>
		</div>
	</div>
	<script>
	$(document).ready(function(){
		$("#add_tieuDe").attr("placeholder", "Tiêu đề");
		$("#add_noiDung").attr("placeholder", "Nội dung của bạn");
		$("input").prop('required',true);
		$("textarea").prop('required',true);
		$("#khuyenmai_themkhuyenmai #ngayBatDau").prop('type','date');
		$("#khuyenmai_themkhuyenmai #ngayKetThuc").prop('type','date');
	});
	</script>
	<!-- end gui lien he -->
<jsp:include page="template_Footer.jsp"></jsp:include>