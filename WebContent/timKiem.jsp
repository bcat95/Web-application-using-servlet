<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<jsp:include page="header.do" flush="true"></jsp:include>
<div id="page">
	<!-- Tim kiem jsp  -->
		<div id="db-main-listing-search">
		<div class="db-main-wrapper">
			<!-- Ban do tim kiem - se cap nhap sau tam thoi bo qua tinh nang nay 
			
			<div class="db-search-side-one bottom">
				<div id="db-main-search-map" style="width: 100%; height: 572px; position: relative; overflow: hidden;"></div>
				<script>
					function myMap() {
					var mapCanvas = document.getElementById("db-main-search-map");
					var mapOptions = {
					center: new google.maps.LatLng(51.5, -0.2), zoom: 10
					};
					var map = new google.maps.Map(mapCanvas, mapOptions);
					}
				</script>
				<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDyVj9OfaIf5rY7HUFfWKbz_9H2Lef5BBo&callback=myMap"></script>
			</div> -->
			<div class="db-search-side-two bottom">
				<div class="db-search-controls">
				<html:form action="/timKiem" method="get" styleId="db-main-search">
					<!--  <div class="db-main-search">-->
						<div class="clearfix"></div>
						<div class="db-search-custom-fields clearfix">
							<!-- tim kiem 1 -->
							<div class="db-search-row clearfix">
								<!--tim kiem theo ten -->
								<div class="db-field-row">
									<label class="db-field-row-label" for="listing_address">Listing name</label>
									<!-- <input type="text" class="db-search-listing_name" placeholder="Listing name" value=""> -->
									<html:text property="noiDung" styleClass="db-search-listing_name" ></html:text>
								</div>
								<!--end tim kiem theo ten -->
								<!--tim kiem theo danh muc -->
								
								<div class="db-field-row db-search-categories custom-select">
									<html:select property="maDanhMuc">
										<option value="">-- Chọn danh mục --</option>
										<html:optionsCollection name="timKiemForm" property="listDanhMuc" 
										label="tenDanhMuc" value="maDanhMuc" />
									</html:select>
								</div>
								<!--end tim kiem theo danh muc -->
								<!--tim kiem theo khu vuc -->
								<div class="db-field-row custom-select">
									<html:select property="maTinhThanh">
										<option value="">-- Chọn khu vực --</option>
										<html:optionsCollection name="timKiemForm" property="listTinhThanh" 
										label="tenTinhThanh" value="maTinhThanh" />
									</html:select>		
								</div>
								<!--end tim kiem theo khu vuc -->
							</div>
							<!-- end tim kiem 1 -->
								<!-- tim kiem 2 -->
								<div class="db-search-row clearfix">
									<html:submit styleClass="bc-create-listing bc-button bc-button-invert" >Xem</html:submit>
									<div class="db-field-row db-slider-field-wrapper">
										<label class="db-field-row-label" for="listing_search_radius">Search radius (Kilometers)</label>
										<div class="db-slider-field ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all text-added" data-value=" km">
											<span class="db-slider-left" style="width: 50%;"></span>
											<input type="text" id="listing_search_radius" class="db-search-listing_search_radius" data-default="150" value="150">
											<span class="ui-slider-handle ui-state-default ui-corner-all" tabindex="0" data-value="150 km" style="left: 50%;"></span>
											
										</div>
									</div>
								</div>
							</div>
						<!-- </div> -->
						</html:form>
						<!--tim kiem sort -->
						<div class="db-search-sort-container">
							<span class="db-found-count total-hidden" data-found="8" data-total-found="8 of 8"> results</span>
							<div class="dt-sort-row single-select">
									<select>
											<option>Sắp xếp</option>
											<option value="1">Tiều đề</option>
											<option value="2">Ngày</option>
											<option value="3">Đánh giá</option>
										</select>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
					<!--Danh sach tin-->
					<div class="db-main-search-listings">
						<!--begin list item nổi bật -->
						<logic:iterate id="bd" name="timKiemForm" property="listBaiDang">
						<div class="bc-featured-listings-item db-main-search-item">
							<div class="bc-featured-listings-item-inner">
								<div class="bc-featured-listings-image">
									<!--Anh dai dien bai dang-->
									<a href="xemChiTietBaiDang.jsp" class="bc-featured-item-image" 
										style="background: url('bai/<bean:write name="bd" property="anhBia"/>')"></a>
									<div class="bc-featured-image-overlay"></div>
									<!--gia tri mac dinh-->
									<span class="bc-featured-listings-image-note">Featured</span>
									<div class="bc-featured-listings-image-meta">
										<span class="bc-featured-listings-custom-fields">
											<span class="bc-featured">
												<!--dia chi bai dang-->
												<span class="db-listing-icon wl-location" title="Address"></span>
												<bean:write name="bd" property="diaChi"/>, 
												<bean:write name="bd" property="tenTinhThanh"/>
												
											</span>
											<span class="bc-featured">
												<!--so dien thoai bai dang-->
												<span class="db-listing-icon wl-phone" title="Phone number"></span>
												<bean:write name="bd" property="sDT"/>
											</span>
										</span>
									</div>
								</div>
								<div class="bc-featured-listings-data" >
									<!--tieu de bai dang-->
									<a href="xemChiTietBaiDang.jsp" class="bc-featured-listings-title">
										<bean:write name="bd" property="tieuDe"/>
									</a>
									<!--to ta ngan bai dang-->
									<p class="bc-featured-listings-description">
										
										<bean:write name="bd" property="noiDung"/>
									</p>
									<div class="bc-featured-listings-meta clearfix">
										<!--danh muc bai dang-->
										<a href="xemChiTietBaiDang.jsp" class="bc-featured-listings-category hotel" style="color: #00a9e8">
											<bean:write name="bd" property="tenDanhMuc"/>
										</a>
										<span class="bc-featured-listings-rating" data-original="5" data-id="91">
											<bean:write name="bd" property="diemDanhGia"/>
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-empty.svg" alt="">
										</span>
									</div>
								</div>
							</div>
						</div>
						</logic:iterate>
						<!--end list item nổi bật -->
						<!--begin list item nổi bật -->
						<div class="bc-featured-listings-item db-main-search-item">
							<div class="bc-featured-listings-item-inner">
								<div class="bc-featured-listings-image">
									<!--Anh dai dien bai dang-->
									<a href="#" class="bc-featured-item-image" style="background: url(img/img_featured_item_1.jpg)"></a>
									<div class="bc-featured-image-overlay"></div>
									<!--gia tri mac dinh-->
									<span class="bc-featured-listings-image-note">Featured</span>
									<div class="bc-featured-listings-image-meta">
										<span class="bc-featured-listings-custom-fields">
											<span class="bc-featured">
												<!--dia chi bai dang-->
												<span class="db-listing-icon wl-location" title="Address"></span>9 Merritt St, Jersey City, NJ 07305, USA</span>
											<span class="bc-featured">
												<!--so dien thoai bai dang-->
												<span class="db-listing-icon wl-phone" title="Phone number"></span>+371 123 456 789</span>
										</span>
									</div>
								</div>
								<div class="bc-featured-listings-data">
									<!--tieu de bai dang-->
									<a href="#" class="bc-featured-listings-title">The Morning Hotel</a>
									<!--to ta ngan bai dang-->
									<p class="bc-featured-listings-description">A commercial establishment providing lodging, meals, and other guest services. In general, to be called a hotel, an establishment must have at least one bedroom and maybe more.</p>
									<div class="bc-featured-listings-meta clearfix">
										<!--danh muc bai dang-->
										<a href="#" class="bc-featured-listings-category hotel" style="color: #00a9e8">Hotel</a>
										<span class="bc-featured-listings-rating" data-original="4" data-id="91">
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-empty.svg" alt="">
										</span>
									</div>
								</div>
							</div>
						</div>
						<!--end list item nổi bật -->
						<!--begin list item nổi bật -->
						<div class="bc-featured-listings-item db-main-search-item">
							<div class="bc-featured-listings-item-inner">
								<div class="bc-featured-listings-image">
									<!--Anh dai dien bai dang-->
									<a href="#" class="bc-featured-item-image" style="background: url(img/img_featured_item_1.jpg)"></a>
									<div class="bc-featured-image-overlay"></div>
									<!--gia tri mac dinh-->
									<span class="bc-featured-listings-image-note">Featured</span>
									<div class="bc-featured-listings-image-meta">
										<span class="bc-featured-listings-custom-fields">
											<span class="bc-featured">
												<!--dia chi bai dang-->
												<span class="db-listing-icon wl-location" title="Address"></span>9 Merritt St, Jersey City, NJ 07305, USA</span>
											<span class="bc-featured">
												<!--so dien thoai bai dang-->
												<span class="db-listing-icon wl-phone" title="Phone number"></span>+371 123 456 789</span>
										</span>
									</div>
								</div>
								<div class="bc-featured-listings-data">
									<!--tieu de bai dang-->
									<a href="#" class="bc-featured-listings-title">The Morning Hotel</a>
									<!--to ta ngan bai dang-->
									<p class="bc-featured-listings-description">A commercial establishment providing lodging, meals, and other guest services. In general, to be called a hotel, an establishment must have at least one bedroom and maybe more.</p>
									<div class="bc-featured-listings-meta clearfix">
										<!--danh muc bai dang-->
										<a href="#" class="bc-featured-listings-category hotel" style="color: #00a9e8">Hotel</a>
										<span class="bc-featured-listings-rating" data-original="4" data-id="91">
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-empty.svg" alt="">
										</span>
									</div>
								</div>
							</div>
						</div>
						<!--end list item nổi bật-->
						<!--begin list item nổi bật -->
						<div class="bc-featured-listings-item db-main-search-item">
							<div class="bc-featured-listings-item-inner">
								<div class="bc-featured-listings-image">
									<!--Anh dai dien bai dang-->
									<a href="#" class="bc-featured-item-image" style="background: url(img/img_featured_item_1.jpg)"></a>
									<div class="bc-featured-image-overlay"></div>
									<!--gia tri mac dinh-->
									<span class="bc-featured-listings-image-note">Featured</span>
									<div class="bc-featured-listings-image-meta">
										<span class="bc-featured-listings-custom-fields">
											<span class="bc-featured">
												<!--dia chi bai dang-->
												<span class="db-listing-icon wl-location" title="Address"></span>9 Merritt St, Jersey City, NJ 07305, USA</span>
											<span class="bc-featured">
												<!--so dien thoai bai dang-->
												<span class="db-listing-icon wl-phone" title="Phone number"></span>+371 123 456 789</span>
										</span>
									</div>
								</div>
								<div class="bc-featured-listings-data">
									<!--tieu de bai dang-->
									<a href="#" class="bc-featured-listings-title">The Morning Hotel</a>
									<!--to ta ngan bai dang-->
									<p class="bc-featured-listings-description">A commercial establishment providing lodging, meals, and other guest services. In general, to be called a hotel, an establishment must have at least one bedroom and maybe more.</p>
									<div class="bc-featured-listings-meta clearfix">
										<!--danh muc bai dang-->
										<a href="#" class="bc-featured-listings-category hotel" style="color: #00a9e8">Hotel</a>
										<span class="bc-featured-listings-rating" data-original="4" data-id="91">
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-empty.svg" alt="">
										</span>
									</div>
								</div>
							</div>
						</div>
						<!--end list item nổi bật -->
						<!--begin list item nổi bật -->
						<div class="bc-featured-listings-item db-main-search-item">
							<div class="bc-featured-listings-item-inner">
								<div class="bc-featured-listings-image">
									<!--Anh dai dien bai dang-->
									<a href="#" class="bc-featured-item-image" style="background: url(img/img_featured_item_1.jpg)"></a>
									<div class="bc-featured-image-overlay"></div>
									<!--gia tri mac dinh-->
									<span class="bc-featured-listings-image-note">Featured</span>
									<div class="bc-featured-listings-image-meta">
										<span class="bc-featured-listings-custom-fields">
											<span class="bc-featured">
												<!--dia chi bai dang-->
												<span class="db-listing-icon wl-location" title="Address"></span>9 Merritt St, Jersey City, NJ 07305, USA</span>
											<span class="bc-featured">
												<!--so dien thoai bai dang-->
												<span class="db-listing-icon wl-phone" title="Phone number"></span>+371 123 456 789</span>
										</span>
									</div>
								</div>
								<div class="bc-featured-listings-data">
									<!--tieu de bai dang-->
									<a href="#" class="bc-featured-listings-title">The Morning Hotel</a>
									<!--to ta ngan bai dang-->
									<p class="bc-featured-listings-description">A commercial establishment providing lodging, meals, and other guest services. In general, to be called a hotel, an establishment must have at least one bedroom and maybe more.</p>
									<div class="bc-featured-listings-meta clearfix">
										<!--danh muc bai dang-->
										<a href="#" class="bc-featured-listings-category hotel" style="color: #00a9e8">Hotel</a>
										<span class="bc-featured-listings-rating" data-original="4" data-id="91">
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-empty.svg" alt="">
										</span>
									</div>
								</div>
							</div>
						</div>
						<!--end list item nổi bật -->
						<!--begin list item nổi bật -->
						<div class="bc-featured-listings-item db-main-search-item">
							<div class="bc-featured-listings-item-inner">
								<div class="bc-featured-listings-image">
									<!--Anh dai dien bai dang-->
									<a href="#" class="bc-featured-item-image" style="background: url(img/img_featured_item_1.jpg)"></a>
									<div class="bc-featured-image-overlay"></div>
									<!--gia tri mac dinh-->
									<span class="bc-featured-listings-image-note">Featured</span>
									<div class="bc-featured-listings-image-meta">
										<span class="bc-featured-listings-custom-fields">
											<span class="bc-featured">
												<!--dia chi bai dang-->
												<span class="db-listing-icon wl-location" title="Address"></span>9 Merritt St, Jersey City, NJ 07305, USA</span>
											<span class="bc-featured">
												<!--so dien thoai bai dang-->
												<span class="db-listing-icon wl-phone" title="Phone number"></span>+371 123 456 789</span>
										</span>
									</div>
								</div>
								<div class="bc-featured-listings-data">
									<!--tieu de bai dang-->
									<a href="#" class="bc-featured-listings-title">The Morning Hotel</a>
									<!--to ta ngan bai dang-->
									<p class="bc-featured-listings-description">A commercial establishment providing lodging, meals, and other guest services. In general, to be called a hotel, an establishment must have at least one bedroom and maybe more.</p>
									<div class="bc-featured-listings-meta clearfix">
										<!--danh muc bai dang-->
										<a href="#" class="bc-featured-listings-category hotel" style="color: #00a9e8">Hotel</a>
										<span class="bc-featured-listings-rating" data-original="4" data-id="91">
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-colored.svg" alt="">
											<img src="img/icon_star-empty.svg" alt="">
										</span>
									</div>
								</div>
							</div>
						</div>
						<!--end list item featured -->
						<div class="clearfix"></div>
					</div>
					<!--end danh sach tin-->
					<ul class="pagination">
						<li><a href="#">1</a></li>
						<li class="active"><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- end Tim kiem jsp  -->
</div>
<jsp:include page="template_Footer.jsp"></jsp:include>