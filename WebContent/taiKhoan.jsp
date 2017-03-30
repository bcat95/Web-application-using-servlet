<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<jsp:include page="header.do" flush="true"></jsp:include>
	<div id="page">
		<!-- trang Ca Nhan -->
			<div id="main" class="site-main container">
			<div id="main-content" class="main-content row">
				<div class="entry-header"><h1 class="entry-title">Tài khoản của bạn</h1></div>
				<div id="primary" class="content-area sidebar-no clearfix ">
					<div id="content" class="site-content " role="main">
						<article id="post-456" class="post-456 page type-page status-publish hentry">
							<div class="entry-content">
								<div id="entry-content-wrapper" class="clearfix">
									<div class="db-main-wrapper">
										<div class="db-account-wrapper">
											<ul class="db-account-menu nav-pills clearfix">
												<li class="active"><a data-toggle="pill" href="#taiKhoan_thongTin" class="active">Thông tin</a></li>
												<li><a href="Update.do">Cập nhật thông tin</a></li>
												<li><a href="dangtin.do">Đăng tin</a></li>
												<li><a data-toggle="pill" href="#taiKhoan_tinDang" class="">Danh sách bài đã đăng</a></li>
												<li><a data-toggle="pill" href="#taiKhoan_yeuThich" class="">Ưa thích</a></li>
												<li><a href="Logout.do" class="db-logout dt-button dt-button-danger dt-button-middle">Đăng xuất</a></li>
											</ul>
											<div class="tab-content">
											<!-- tai khoan thong tin tai khoan -->
											<div id="taiKhoan_thongTin" class="tab-pane fade in active">
											<h3 class="db-account-intro">Chào mừng bạn đến với trang tổng quan của bạn! Từ đây bạn có thể quản lý tất cả các bài đăng của bạn, kiểm tra các mục ưa thích của bạn và chỉnh sửa hồ sơ của bạn.</h3>
											<label for="listing_title" >Hồ sơ</label>
											<html:form action="/thong-tin" method="post" styleId="db-add-listing-form">
											<div class="db-account-profile-intro">
													<span class="db-account-row">
														<span class="db-account-label">Tên đăng nhập:</span>
														<span class="db-account-value"><bean:write name="thongTinTaiKhoanForm" property="userName"/></span>
													</span>
													<span class="db-account-row">
														<span class="db-account-label">E-Mail:</span>
														<span class="db-account-value"><bean:write name="thongTinTaiKhoanForm" property="eMail"/></span>
													</span>
													<span class="db-account-row">
														<span class="db-account-label">Password:</span>
														<span class="db-account-value"><bean:write name="thongTinTaiKhoanForm" property="passCu"/></span>
													</span>
													<a data-toggle="pill" href="#taiKhoan_capNhap" class="">Đổi mật khẩu</a>
													<div class="clearfix"></div>
												</div>
											</html:form>
											</div>
											<!-- end tai khoan thong tin tai khoan -->
											<!-- tai khoan cap nhat tai khoan -->
											<div id="taiKhoan_capNhap" class="tab-pane fade">
											<div class="db-account-profile">
												<label class="db-account-title">Thông tin của bạn</label>
												<html:form action="/cap-nhat-thong-tin" method="post" styleId="db-add-listing-form">
												<div class="db-field-row text-added">
													<label for="display_name">Username</label>
													<html:text property="userName" disabled="true"></html:text>
            										<html:errors property="userNameError"/>
												</div>
												<div class="db-field-row text-added">
													<label for="display_name">E-Mail:</label>
													<html:text property="eMail" disabled="true"></html:text>
            										<html:errors property="eMailError"/>
												</div>
												<div class="db-field-row text-added">
													<label for="display_name">PassWord:</label>
													<html:password property="passCu" styleId="pass" value=""></html:password>
            										<html:errors property="passError"/>
												</div>
												<div class="db-field-row text-added">
													<label for="display_name">PassWord New:</label>
													<html:password property="passMoi" styleId="passMoi"></html:password>
            										<html:errors property="passError"/>
												</div>
												<div class="db-field-row text-added">
													<label for="display_name">Confirm PassWord:</label>
													<html:password property="passMoiXN" styleId="passMoiXN"></html:password>
            										<span id="passError"></span>
            										<html:errors property="passError"/>
												</div class="db-field-row text-added">
												<div>
													<button type="submit" name="submit" value="CapNhapPass" class="btn btn-primary">Cập nhật</button>
													<%-- <html:submit styleClass="btn btn-primary">submit</html:submit> --%>
												</div>
												</html:form>
												</div>
												<div class="clearfix"></div>
												<div styleId="thongBao"></div>
											</div>
											<script type="text/javascript">
											$(document).ready(function(){
												$("#passMoi").bind('keyup mouseup', function () {
													var passCu= $('#pass').val();
													var passMoi = $('#passMoi').val();
													if (passMoi==passCu )
														$("#passError").html("Mật khẩu mới không được trùng với mật khẩu cũ..!");
												});
												$("#passMoiXN").bind('keyup mouseup', function () {
													var passMoi = $('#passMoi').val();
													var xnpassMoi = $('#passMoiXN').val();
													if (passMoi==xnpassMoi )
														$("#passError").html("Ok");
													else
														$("#passError").html("Mật khẩu mới chưa giống nhau !");	
												});
											});
											</script>
											<!-- end tai khoan cap nhat tai khoan -->
											
											<!-- tai khoan danh sach tin dang -->
											<div id="taiKhoan_tinDang" class="tab-pane fade in active">
												<div class="db-account-profile">
													<h2 class="db-account-title">Danh sách các bài đăng của bạn</h2>
													<display:table id="bcbaidang" name="sessionScope.thongTinTaiKhoanForm.listBaiDang" class="db-account-listings table table-striped table-hover"
															requestURI="/thong-tin.do" pagesize="5">
															<display:column property="maBaiDang" title="ID" sortable="true" class="bcblock mabaidang" href="/xemtin.do" paramId="maBaiDang"/>
															<display:column property="tieuDe" title="Tiêu đề" class="bcblock tieude" />
															<display:column property="tenLoaiTin" title="Trạng thái" class="bcblock tenlt"/>
															<display:column property="tenDanhMuc" title="Danh mục" class="bcblock tendm"/>
															<display:column property="ngayHetHan" title="Hết hạn vào" class="bcblock ngayhh"></display:column>
															<%-- <display:column property="tenLoaiTin" title="Dán lên cao"></display:column> --%>
															<%-- <bean:define id="maLoaiTin" name="bcbaidang" property="maLoaiTin"></bean:define> --%>
															<display:column title="Hành động">
																<html:link action="/khuyenmai?maBaiDang=${bcbaidang.maBaiDang}" styleClass="db-edit-listing db-account-listing-option gift">
													                	<span class="db-account-listing-option-hover">Khuyến Mãi</span><i class="fa fa-gift fa-2 alway-active wolf-surprise bc_gre" aria-hidden="true"></i>
													            </html:link>
																<html:link action="/xemtin?maBaiDang=${bcbaidang.maBaiDang}"  styleClass="db-edit-listing db-account-listing-option view">
													                	<span class="db-account-listing-option-hover">Xem</span><i class="fa fa-eye" aria-hidden="true"></i>
													            </html:link>
																<logic:equal name="bcbaidang" property="maLoaiTin" value="1">
																<html:link action="/suatin?maBaiDang=${bcbaidang.maBaiDang}"  styleClass="db-edit-listing db-account-listing-option edit">
																	<span class="db-account-listing-option-hover">Sửa</span><i class="fa fa-pencil" aria-hidden="true"></i>
																</html:link>
																</logic:equal>
															</display:column>
															
															<display:setProperty name="paging.banner.placement" value="bottom" />
															<display:setProperty name="basic.msg.empty_list">
															<div class="alert alert-info">
																<strong>Oh!</strong> Chưa có bài đăng nào ! Hãy đăng một bài thôi nào.
															</div>
															</display:setProperty>
															<display:setProperty name="paging.banner.all_items_found"><span class="pagebanner"> {0} {1} được hiển thị, số số bài đăng {2}. </span></display:setProperty>
															<display:setProperty name="paging.banner.some_items_found">
															<span class="pagebanner"> {0} {1} được hiển thị, số bài đăng {2} đến {3}. </span>
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
												<div class="clearfix"></div>
											</div>
											<!-- end tai danh sach tin dang -->
											<!-- tai khoan danh sach tin thich-->
											<div id="taiKhoan_yeuThich" class="tab-pane fade in active">
												<div class="db-account-profile">
													<h2 class="db-account-title">Danh sách các bài đăng đã thích</h2>
													<div class="bcyeuthich clearfix">
														<display:table id="bcyeuthich" name="sessionScope.thongTinTaiKhoanForm.listYeuThich" class="db-account-listings table table-striped table-hover"
															requestURI="/thong-tin.do" pagesize="4">
															<display:column property="maBaiDang" title="ID bài đăng" sortable="true" class="bcblock mabaidang" href="xemtin.do" paramId="maBaiDang"/>
															<display:column autolink="ss" property="tieuDe" title="Tiêu đề" class="bcblock tieude" />
															<display:column property="tenDanhMuc" title="Danh mục" class="bcblock tendm"/>
															<display:column property="diaChi" title="Địa chỉ" class="bcblock diachi"/>
															<display:column title="Xem">
																<html:link action="/xemtin?maBaiDang=${bcyeuthich.maBaiDang}"  styleClass="db-edit-listing db-account-listing-option edit">
													                	<span class="db-account-listing-option-hover">Xem</span><i class="fa fa-eye" aria-hidden="true"></i>
													            </html:link>
															</display:column>
															
															<display:setProperty name="paging.banner.placement" value="bottom" />
															<display:setProperty name="basic.msg.empty_list">
															<div class="alert alert-info">
																<strong>Oh!</strong> Chưa có bài thích nào ! Hãy thích ngay thôi nào.
															</div>
															</display:setProperty>
															<display:setProperty name="paging.banner.all_items_found"><span class="pagebanner"> {0} {1} được hiển thị, số số bài yêu thích {2}. </span></display:setProperty>
															<display:setProperty name="paging.banner.some_items_found">
															<span class="pagebanner"> {0} {1} được hiển thị, số yêu thích {2} đến {3}. </span>
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
												</div>
												<div class="clearfix"></div>
											</div>
											<!-- end tai danh sach thich -->
										</div>
									</div>
								</div>
							</div>
						</article> 
					</div>
				</div>
			</div>
		</div>
		<!-- end trang ca nhan -->
		
	</div>
<jsp:include page="template_Footer.jsp"></jsp:include>