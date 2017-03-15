<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
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
												<li><a data-toggle="pill" href="#taiKhoan_capNhap" class="">Cập nhật thông tin</a></li>
												<li><a href="dangTin.do">Đăng tin</a></li>
												<li><a data-toggle="pill" href="#taiKhoan_tinDang" class="">Danh sách bài đã đăng</a></li>
												<li><a data-toggle="pill" href="#taiKhoan_uaThich" class="">Ưa thích</a></li>
												<li><a href="wp-login.php?action=logout" class="db-logout dt-button dt-button-danger dt-button-middle">Đăng xuất</a></li>
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
													<a data-toggle="pill" href="#taiKhoan_capNhap" class="">Cập nhật</a>
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
													<button type="submit" name="submit" value="CapNhapPass" class="btn btn-primary">Cap Nhap</button>
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
											});
												
											</script>
											<!-- end tai khoan cap nhat tai khoan -->
											
											<!-- tai khoan danh sach tin dang -->
											<div id="taiKhoan_tinDang" class="tab-pane fade">
												<div class="db-account-profile">
													<h2 class="db-account-title">Danh sách các bài đăng của bạn</h2>
													<table class="db-account-listings table table-striped table-hover">
														<thead>
														<tr>
																<th style="width: 28.6%;">Tiêu đề</th>
																<th style="width: 12.5%;">Trạng thái</th>
																<th style="width: 15%;">Danh mục</th>
																<th style="width: 20%;">Hết hạn vào</th>
																<th style="width: 10%;">Dán lên cao</th>
																<th style="width: 15%;"></th>
															</tr>
														</thead>
														<tbody>
															<logic:iterate name="thongTinTaiKhoanForm" property="listBaiDang" id="bd">
															<tr>
																<td class="db-align-center db-status"><bean:write name="bd" property="tieuDe"/></td>
																<td class="db-align-center db-status"><bean:write name="bd" property="tenLoaiTin"/></td>
																<td class="db-align-center db-status"><bean:write name="bd" property="tenDanhMuc"/></td>
																<td class="db-align-center db-status"><bean:write name="bd" property="ngayHetHan"/></td>
																<td class="db-align-center db-status"><bean:write name="bd" property="tenLoaiTin"/></td>
																<td>
																	<bean:define id="mbd" name="bd" property="maBaiDang"></bean:define>
																	<html:link action="/xembaidang?maBaiDang=${mbd}"  styleClass="db-edit-listing db-account-listing-option edit" styleId="688">
													                	<span class="db-account-listing-option-hover">Xem</span><i class="fa fa-eye" aria-hidden="true"></i>
													                </html:link>
																	<html:link action="/suabaidang.?maBaiDang=${mbd}"  styleClass="db-edit-listing db-account-listing-option edit" styleId="688">
													                	<span class="db-account-listing-option-hover">Sửa</span><i class="fa fa-pencil" aria-hidden="true"></i>
													                </html:link>
																</td>
															</tr>
															</logic:iterate>
														</tbody>
													</table>
												</div>
												<div class="clearfix"></div>
											</div>
											<!-- end tai danh sach tin dang -->
													
											
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