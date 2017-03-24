<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<jsp:include page="header.do" flush="true"></jsp:include>
<div id="page">
	<!-- Tim kiem jsp  -->
		<div id="db-main-listing-search">
		<div class="db-main-wrapper">
			<div class="db-search-side-one bottom">
				<div class="db-search-controls">
				<html:form action="/timKiem" method="get" styleId="db-main-search">
					<!--  <div class="db-main-search">-->
						<div class="clearfix"></div>
						<div class="db-search-custom-fields clearfix">
							<!-- tim kiem 1 -->
							<div class="db-search-row clearfix">
								<!--tim kiem theo ten -->
								<div class="db-field-row row_max">
									<html:text property="noiDung" styleClass="db-search-listing_name" ></html:text>
									<html:submit styleClass="bc-button-invert horus-btn-search" >Tìm</html:submit>
								</div>
								<!--end tim kiem theo ten -->
								<!--tim kiem theo danh muc -->
								
								<div class="db-field-row db-search-categories custom-select">
									<html:select onchange="this.form.submit()"  property="maDanhMuc">
										<option value="">-- Chọn danh mục --</option>
										<html:optionsCollection name="timKiemForm" property="listDanhMuc" 
										label="tenDanhMuc" value="maDanhMuc" />
									</html:select>
								</div>
								<!--end tim kiem theo danh muc -->
								<!--tim kiem theo khu vuc -->
								<div class="db-field-row custom-select">
									<html:select onchange="this.form.submit()" property="maTinhThanh">
										<option value="">-- Chọn khu vực --</option>
										<html:optionsCollection name="timKiemForm" property="listTinhThanh"
										label="tenTinhThanh" value="maTinhThanh" />
									</html:select>		
								</div>
								<!--end tim kiem theo khu vuc -->
							</div>
							<!-- end tim kiem 1 -->
							</div>
						</html:form>
						<!--tim kiem sort -->
					</div>
			</div>
			<div class="db-search-side-two bottom">
					<div class="db-search-side-lef">
						<div class="map-access sidebox-container ta-center" >
							<div class="map-access--bg">
								<button class="btn btn--tertiary ">Đến bản đồ</button>
							</div>
						</div>
						<div class="sidebox-container ta-center" >
							<div class="ser_box">
								<span class="sidebox_tit">Đánh giá</span>
								<span class="sea_rat_ite">
									<span></span><span></span><span></span><span></span><span></span>
								</span>
							</div>
							<div class="ser_box">
								<span class="sidebox_tit">Giá</span>
								<span>tối đa ‎19.877.400đ</span>
								<div class="progress">
									<div class="progress-bar" role="progressbar" aria-valuenow="70"
									aria-valuemin="0" aria-valuemax="100" style="width:70%">
									  70%
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="db-search-side-rig">
						<div class="db-search-sort-container">
							<span class="db-found-count total-hidden">8 results</span>
							<div class="dt-sort-row single-select">
								<div class="dropdown">
									  <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">Sắp xếp
									  <span class="caret"></span></button>
									  <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
									    <li role="presentation"><a id="sor_ddg" role="menuitem" tabindex="-1" href="timKiem.do?&d-1343431-s=1">Đánh giá</a></li>
									  </ul>
								</div>
							</div>
						</div>
						<!--Danh sach tin-->
						<div class="db-main-search-listings lis_ful">
							<!--begin list item nổi bật -->
							<display:table id="threads" name="sessionScope.timKiemForm.listBaiDang"
									requestURI="/timKiem.do" pagesize="8">
									<logic:notEmpty name="timKiemForm" property="listBaiDang">
											<bean:define id="maBaiDang" name="threads" property="maBaiDang"/>
											<bean:define id="anhBia" name="threads" property="anhBia"/>
											<bean:define id="diaChi" name="threads" property="diaChi"/>
											<bean:define id="tenDanhMuc" name="threads" property="tenDanhMuc"/>
											<bean:define id="sDT" name="threads" property="sDT"/>
											<bean:define id="tieuDe" name="threads" property="tieuDe"/>
											<bean:define id="noiDung" name="threads" property="noiDung"/>
											<bean:define id="diemDanhGia" name="threads" property="diemDanhGia"/>
									</logic:notEmpty>
									<display:column sortable="true" title="diemDanhGia" headerClass="sor_ddg"/>
									<display:column class="bcthread item">
										<div class="thread-list-item" id="thr_${maBaiDang}">
											<div class="thread-list-item-inner">
												<div class="thread-list-item-image col-md-4 row_w">
													<!--Anh dai dien bai dang-->
													<a href="xemtin.do?maBaiDang=${maBaiDang}" class="bc-featured-item-image" style="background: url('${anhBia}')"></a>
													<!--gia tri mac dinh-->
													<span class="bc-featured-listings-image-note"><i class="fa fa-heart-o wolf-zoom alway-active" aria-hidden="true"></i></span>
													<div class="bc-featured-listings-image-meta">
													<span class="bc-featured-listings-custom-fields">
														<span class="bc-featured">
															<!--dia chi bai dang-->
															<span class="db-listing-icon wl-location" title="Address"></span>
															${diaChi}
														</span>
														<span class="bc-featured">
															<!--so dien thoai bai dang-->
															<span class="db-listing-icon wl-phone" title="Phone number"></span>
																${sDT}
															</span>
														</span>
													</div>
												</div>
												<div class="bc-featured-listings-data" >
													<!--tieu de bai dang-->
													<a href="xemtin.do?maBaiDang=${maBaiDang}" class="bc-featured-listings-title">
														${tieuDe}
													</a>
													<!--to ta ngan bai dang-->
													<div class="bc-featured-listings-description">
														${noiDung}
													</div>
													<div class="bc-featured-listings-meta clearfix">
														<!--danh muc bai dang-->
														<a href="timKiem.do?maDanhMuc=<bean:write name="timKiemForm" property="maDanhMuc"/>" class="bc-featured-listings-category hotel" style="color: #00a9e8">
															${tenDanhMuc}
														</a>
														<span class="bc-featured-listings-rating">
															<span id="bl_${diemDanhGia}" class="ratings rating-lv<bean:write name="threads" property="diemDanhGia" format="#,0"/>" title="${diemDanhGia}">
																${diemDanhGia}
															</span>
														</span>
													</div>
												</div>
											</div>
										</div>
									</display:column>
									<display:setProperty name="paging.banner.placement" value="bottom" />
									<display:setProperty name="basic.msg.empty_list">
										<div class="alert alert-info">
											<strong>Oh!</strong> Chưa có bài viết theo nội dung tìm kiếm của bạn! Hãy thử từ khác
										</div>
									</display:setProperty>
									<display:setProperty name="paging.banner.all_items_found"><span class="pagebanner"> {0} {1} được hiển thị, số bài viết {2}. </span></display:setProperty>
									<display:setProperty name="paging.banner.some_items_found">
										<span class="pagebanner"> {0} {1} được hiển thị, số bài viết {2} đến {3}. </span>
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
							<!--end list item nổi bật -->
							<div class="clearfix"></div>
						</div>
					</div>
					<!--end danh sach tin-->
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- end Tim kiem jsp  -->
	<script>
		$("#sor_ddg").attr("href", $('.sor_ddg a').attr('href'));
	</script>
<jsp:include page="template_Footer.jsp"></jsp:include>