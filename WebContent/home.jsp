<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<jsp:include page="header.do" flush="true"></jsp:include>
<div id="page" class="noheadbg">
	<div class="bc-rs-container">
		<div class="bc-header-slogan">
			<span class="hea-slo-big">Chào mừng bạn đến với <b>Hoàn hảo</b> của danh bạ thương mại </span>
			<span class="hea-slo-sma">
				<p>Đây là là <b>điểm đến</b> cao cấp cho các nhà sản xuất quyết định.</p>
				<p>Tìm một sản phẩm, dịch vụ, hoặc công ty mà bạn đang tìm kiếm.</p>
			</span>
		</div>
		<div class="bc-header-search">
			<div class="bc-header-search-inner">
			<html:form action="/timKiem" method="get">
				<div class="bc-search-row listing-name">
					<label for="bc-search-listing_name">Bạn đang tìm kiếm điều gì?</label>
					<!--input tim kiem ten bai dang-->
					<html:text property="noiDung" styleClass="bc-search-listing_name" ></html:text>
				</div>
				<div class="bc-search-row listing-address">
					<label for="bc-search-listing_address">Khu vực</label>
					<!--input tim kiem khu vuc-->
					<div class="bc-custom-select-container">
						<html:select property="maTinhThanh">
							<option value="">-- Chọn khu vực --</option>
							<html:optionsCollection name="homeForm" property="listTinhThanh" 
							label="tenTinhThanh" value="maTinhThanh" />
						</html:select>
					</div>
				</div>
				<div class="bc-search-row listing-category">
					<label>Danh mục</label>
					<!--combox tim kiem danh muc-->
					<div class="bc-custom-select-container">
						<html:select property="maDanhMuc">
							<option value="">-- Chọn danh mục --</option>
							<html:optionsCollection name="homeForm" property="listDanhMuc" 
							label="tenDanhMuc" value="maDanhMuc" />
						</html:select>
					</div>
				</div>
            	<html:submit styleClass="bc-header-search-submit bc-button bc-button-danger" >
            	Tìm
            	</html:submit>
        	</html:form>
			</div>
		</div>
		<div class="bc-header-categories">
			<div class="bc-header-category-item" data-id="14">
				<span class="bc-header-category-icon wl-beauty"></span>
				<span class="bc-header-category-name">Sắc đẹp</span>
			</div>
			<div class="bc-header-category-item" data-id="13">
				<span class="bc-header-category-icon wl-catering"></span>
				<span class="bc-header-category-name">Ăn uống</span>
			</div>
			<div class="bc-header-category-item" data-id="16">
				<span class="bc-header-category-icon wl-finances"></span>
				<span class="bc-header-category-name">Tài chánh</span>
			</div>
			<div class="bc-header-category-item" data-id="15">
				<span class="bc-header-category-icon wl-health"></span>
				<span class="bc-header-category-name">Sức khỏe</span>
			</div>
			<div class="bc-header-category-item" data-id="17">
				<span class="bc-header-category-icon wl-plants"></span>
				<span class="bc-header-category-name">Cây cảnh</span>
			</div>
		</div>
		<div class="slotholder">
			<!-- Start WOWSlider.com BODY section --> <!-- add to the <body> of your page -->
			<div id="wowslider-container0">
			<div class="ws_images"><ul>
			<li><img src="data0/images/dalat.jpg" alt="Đà Lạt" title="Đà Lạt" id="wows0_0"/>Đà Lạt mộng mơ và nên thơ nhờ cái lạnh cao nguyên ban đêm,  sương mù buổi sớm và những dải rừng thông bao quanh thành phố.</li>
			<li><img src="data0/images/hanoi1.jpg" alt="Hà Nội" title="Hà Nội" id="wows0_1"/>Hà Nội thủ đô ngàn năm văn hiến luôn cuốn hút du khách bởi nét cổ kính, yên bình lạ kỳ. Với 36 khu phố nghề cổ kính của Hà Nội.</li>
			<li><img src="data0/images/hue.jpg" alt="Huế" title="Huế" id="wows0_2"/>Huế là thành phố có bề dày văn hóa lâu đời, cảnh quan thiên nhiên đẹp và hữu tình cùng quần thể di tích lịch sử được thế giới công nhận</li>
			<li><img src="data0/images/nhatrang.jpg" alt="Nha Trang" title="Nha Trang" id="wows0_3"/>Được tôn vinh là một trong những vịnh đẹp nhất thế giới, Vịnh Nha Trang  trở thành một điểm đến khi muốn tìm đến với biển.</li>
			<li><img src="data0/images/quangninh.jpg" alt="Quảng Ninh" title="Quảng Ninh" id="wows0_4"/>Quảng Ninh được biết đến với những danh lam thắng cảnh được xếp vào loại  bậc đẹp nhất nước ta. Di sản thế giới vịnh Hạ Long.</li>
			<li><a href="http://wowslider.net"><img src="data0/images/hcm.jpg" alt="http://wowslider.net/" title="Hồ Chí Minh" id="wows0_5"/></a>Hồ Chí Minh là thành phố lớn nhất Việt Nam đồng thời cũng là đầu tàu kinh tế và là trung tâm văn hóa, giáo dục quan trọng nhất của nước.</li>
			<li><img src="data0/images/danang.jpg" alt="Đà Nẵng" title="Đà Nẵng" id="wows0_6"/>Thành phố Đà Nẵng nằm ở miền Trung Việt Nam với khoảng cách gần như chia đều giữa thủ đô Hà Nội và thành phố Hồ Chí Minh.</li>
			</ul></div>
			<div class="ws_script" style="position:absolute;left:-99%"><a href="http://wowslider.com/vi">bootstrap slider</a> by WOWSlider.com v8.7</div>
			<div class="ws_shadow"></div>
			</div>	
			<script type="text/javascript" src="engine0/wowslider.js"></script>
			<script type="text/javascript" src="engine0/script.js"></script>
			<!-- End WOWSlider.com BODY section -->
			<!--Off slide <div class="bc-bgimg"></div>-->
		</div>
	</div>
	<div class="clearfix"></div>
	<div id="main" class="site-main container">
		<div id="main-content" class="main-content row">
			<!--begin danh sách nổi bật-->
			<div class="col-sm-12">
				<div class="column-inner">
					<div class="bc-module-title">
						<!--gia tri mac dinh-->
						<span class="bc-module-background-title">Nổi Bật</span>
						<span class="bc-module-front-title">Danh sách nổi bật</span>
					</div>
					<div class="bc-featured-listings">
						<!--begin list item nổi bật -->
						<logic:iterate id="bd" name="homeForm" property="listBaiDang">
						<bean:define id="maBaiDang" name="bd" property="maBaiDang"></bean:define>
						<div class="bc-featured-listings-item">
							<div class="bc-featured-listings-item-inner">
								<div class="bc-featured-listings-image">
									<!--Anh dai dien bai dang-->
									<a href="xembaidang.do?maBaiDang=${maBaiDang}" class="bc-featured-item-image" 
										style="background: url('<bean:write name="bd" property="anhBia"/>')"></a>
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
									<a href="xembaidang.do?maBaiDang=${maBaiDang}" class="bc-featured-listings-title">
										<bean:write name="bd" property="tieuDe"/>
									</a>
									<!--to ta ngan bai dang-->
									<div class="bc-featured-listings-description">
										<bean:write name="bd" property="noiDung" filter="fasle"/>
									</div>
									<div class="bc-featured-listings-meta clearfix">
										<!--danh muc bai dang-->
										<a href="timKiem.do?maDanhMuc=<bean:write name="bd" property="maDanhMuc"/>" class="bc-featured-listings-category hotel" style="color: #00a9e8">
											<bean:write name="bd" property="tenDanhMuc"/>
										</a>
										<span class="bc-featured-listings-rating" data-original="5" data-id="91">
											<span id="bl_<bean:write name="bd" property="maBaiDang"/>" class="ratings" title="<bean:write name="bd" property="diemDanhGia"/>">
												<span class="star"></span>
												<span class="star"></span>
												<span class="star"></span>
												<span class="star"></span>
												<span class="star"></span>
										</span>
										<script>
											var ddg = $('#bl_<bean:write name="bd" property="maBaiDang"/>').attr('title');
											for (i = 1; i <= ddg; i++) { 
												$('#bl_<bean:write name="bd" property="maBaiDang"/> span:nth-child('+i+')').addClass(" Full");
											}
										</script>
										</span>
									</div>
								</div>
							</div>
						</div>
						</logic:iterate>
						<!--end list item nổi bật -->
					</div>
				</div>
			</div>
			<!--end danh sách nổi bật-->
			<!--Begin Khu vuc-->
			<div class="col-sm-12">
				<div class="column-inner">
					<div class="bc-module-title">
						<!--gia tri mac dinh-->
						<span class="bc-module-background-title">Các thành phố nổi tiếng</span>
						<span class="bc-module-front-title">Thành phố phổ biến trên khắp đất nước</span>
					</div>
					<!--Danh sách các khu vực-->
					<div class="bc-popular-cities clearfix">
						<a href="#?listing_address=New York" class="bc-popular-city-item">
							<div class="bc-popular-city-container" style="background: url(img/khuvuc/kv1.jpg)">
								<div class="bc-popular-city-inner">
									<img src="img/icon_next.svg" alt="">
									<span class="bc-popular-city-name">New York</span>
								</div>
							</div>
						</a>
						<a href="#?listing_address=London" class="bc-popular-city-item">
							<div class="bc-popular-city-container" style="background: url(img/khuvuc/kv2.jpg)">
								<div class="bc-popular-city-inner">
									<img src="img/icon_next.svg" alt="">
									<span class="bc-popular-city-name">London</span>
								</div>
							</div>
						</a>
						<a href="#?listing_address=New Delhi" class="bc-popular-city-item">
							<div class="bc-popular-city-container" style="background: url(img/khuvuc/kv3.jpg)">
								<div class="bc-popular-city-inner">
									<img src="img/icon_next.svg" alt="">
									<span class="bc-popular-city-name">
									New Delhi</span>
								</div>
							</div>
						</a>
						<a href="#?listing_address=San Francisco" class="bc-popular-city-item">
							<div class="bc-popular-city-container" style="background: url(img/khuvuc/kv4.jpg)">
								<div class="bc-popular-city-inner">
									<img src="img/icon_next.svg" alt="">
									<span class="bc-popular-city-name">San Francisco</span>
								</div>
							</div>
						</a>
						<a href="#?listing_address=Paris" class="bc-popular-city-item">
							<div class="bc-popular-city-container" style="background: url(img/khuvuc/kv5.jpg)">
								<div class="bc-popular-city-inner">
									<img src="img/icon_next.svg" alt="">
									<span class="bc-popular-city-name">Paris</span>
								</div>
							</div>
						</a>
						<a href="#?listing_address=Madrid" class="bc-popular-city-item">
							<div class="bc-popular-city-container" style="background: url(img/khuvuc/kv6.jpg)">
								<div class="bc-popular-city-inner">
									<img src="img/icon_next.svg" alt="">
									<span class="bc-popular-city-name">Madrid</span>
								</div>
							</div>
						</a>
						<a href="#?listing_address=&#10;Rome" class="bc-popular-city-item">
							<div class="bc-popular-city-container" style="background: url(img/khuvuc/kv7.jpg)">
								<div class="bc-popular-city-inner">
									<img src="img/icon_next.svg" alt="">
									<span class="bc-popular-city-name">Rome</span>
								</div>
							</div>
						</a>
						<a href="#?listing_address=Ottawa" class="bc-popular-city-item">
							<div class="bc-popular-city-container" style="background: url(img/khuvuc/kv8.jpg)">
								<div class="bc-popular-city-inner">
									<img src="img/icon_next.svg" alt="">
									<span class="bc-popular-city-name">Ottawa</span>
								</div>
							</div>
						</a>
					</div>
					<!--End danh sách các khu vực-->
				</div>
			</div>	
			<!--End Khu vuc-->
			<!--begin danh sách tin moi-->
			<div class="col-sm-12">
				<div class="column-inner">
					<div class="bc-module-title">
						<!--gia tri mac dinh-->
						<span class="bc-module-background-title">Tin mới nhất</span>
						<span class="bc-module-front-title">Bắt đầu</span>
					</div>
					<div class="bc-featured-listings">
						<!--begin list item nổi bật -->
						<div class="bc-featured-listings-item">
							<div class="bc-featured-listings-item-inner">
								<div class="bc-featured-listings-image">
									<!--Anh dai dien bai dang-->
									<a href="xemChiTietBaiDang.jsp" class="bc-featured-item-image" style="background: url(img/img_featured_item_1.jpg)"></a>
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
									<a href="xemChiTietBaiDang.jsp" class="bc-featured-listings-title">The Morning Hotel</a>
									<!--to ta ngan bai dang-->
									<p class="bc-featured-listings-description">A commercial establishment providing lodging, meals, and other guest services. In general, to be called a hotel, an establishment must have at least one bedroom and maybe more.</p>
									<div class="bc-featured-listings-meta clearfix">
										<!--danh muc bai dang-->
										<a href="xemChiTietBaiDang.jsp" class="bc-featured-listings-category hotel" style="color: #00a9e8">Hotel</a>
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
						<div class="bc-featured-listings-item">
							<div class="bc-featured-listings-item-inner">
								<div class="bc-featured-listings-image">
									<!--Anh dai dien bai dang-->
									<a href="xemChiTietBaiDang.jsp" class="bc-featured-item-image" style="background: url(img/img_featured_item_1.jpg)"></a>
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
									<a href="xemChiTietBaiDang.jsp" class="bc-featured-listings-title">The Morning Hotel</a>
									<!--to ta ngan bai dang-->
									<p class="bc-featured-listings-description">A commercial establishment providing lodging, meals, and other guest services. In general, to be called a hotel, an establishment must have at least one bedroom and maybe more.</p>
									<div class="bc-featured-listings-meta clearfix">
										<!--danh muc bai dang-->
										<a href="xemChiTietBaiDang.jsp" class="bc-featured-listings-category hotel" style="color: #00a9e8">Hotel</a>
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
						<div class="bc-featured-listings-item">
							<div class="bc-featured-listings-item-inner">
								<div class="bc-featured-listings-image">
									<!--Anh dai dien bai dang-->
									<a href="xemChiTietBaiDang.jsp" class="bc-featured-item-image" style="background: url(img/img_featured_item_1.jpg)"></a>
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
									<a href="xemChiTietBaiDang.jsp" class="bc-featured-listings-title">The Morning Hotel</a>
									<!--to ta ngan bai dang-->
									<p class="bc-featured-listings-description">A commercial establishment providing lodging, meals, and other guest services. In general, to be called a hotel, an establishment must have at least one bedroom and maybe more.</p>
									<div class="bc-featured-listings-meta clearfix">
										<!--danh muc bai dang-->
										<a href="xemChiTietBaiDang.jsp" class="bc-featured-listings-category hotel" style="color: #00a9e8">Hotel</a>
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
					</div>
				</div>
			</div>
			<!--end danh sách tin moi-->
		</div>
	</div>
</div>
<jsp:include page="template_Footer.jsp"></jsp:include>