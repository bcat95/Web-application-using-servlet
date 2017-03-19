<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.do" flush="true"></jsp:include>
<script>
jQuery(document).ready(function($) {
  $('.owl-carousel').owlCarousel({
	    items: 5,
	    lazyLoad: true,
	    margin: 10
	});
  $( ".cat_des_3" ).html('😳 Mắt đẫn đờ, dạ dày rỗng, con tim rối bời chỉ vì không biết ăn gì ở đâu? Đừng lo, vào đây có hết! 🧀🍰🍦🍼 🍒🍭🍣');
});
</script>
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
			<logic:iterate id="danhmuc" name="homeForm" property="listDanhMuc">
			<bean:define id="maDanhMuc" name="danhmuc" property="maDanhMuc"></bean:define>
			
			<div class="col-sm-12 cat_ites">
					<div class="column-inner cat_ite">
						<div class="cat_inf">
							<div class="cat_tit clearfix"><h1><bean:write name="danhmuc" property="tenDanhMuc"/></h1><html:link styleClass="vie_all" href="timKiem.do?maDanhMuc=${maDanhMuc}">xem toàn bộ</html:link></div>
							<div class="cat_des_${maDanhMuc}">💅Biến hoá bản thân từ chân tới tóc với đủ dịch vụ: tóc, móng, spa nha💇</div>
						</div>
						<div class="bc-featured-listings cate_${maDanhMuc} owl-carousel owl-theme">
							<!--begin list item nổi bật -->
							<logic:notEmpty name="homeForm" property="listBaiDang_${maDanhMuc}">
							<logic:iterate id="bd" name="homeForm" property="listBaiDang_${maDanhMuc}">
							<bean:define id="maBaiDang" name="bd" property="maBaiDang"></bean:define>
							<div class="bc-featured-listings-item">
								<div class="bc-featured-listings-item-inner">
									<div class="bc-featured-listings-image">
										<!--Anh dai dien bai dang-->
										<a href="xemtin.do?maBaiDang=${maBaiDang}" class="bc-featured-item-image" 
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
										<a href="xemtin.do?maBaiDang=${maBaiDang}" class="bc-featured-listings-title">
											<bean:write name="bd" property="tieuDe"/>
										</a>
										<!--to ta ngan bai dang-->
										<div class="bc-featured-listings-description">
											<bean:write name="bd" property="noiDung" filter="fasle"/>
										</div>
										<div class="bc-featured-listings-meta clearfix">
											<!--so luot thich bai dang-->
												<i class="fa fa-heart-o" aria-hidden="true"></i> 
												<bean:write name="bd" property="soLuotThich"/>
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
							</logic:notEmpty>
							<!--end list item nổi bật -->
						</div>
					</div>
			</div>
			</logic:iterate>
			<!--end danh sách nổi bật-->
		</div>
	</div>
</div>
<script src="owlcarousel/owl.carousel.min.js"></script>
<jsp:include page="template_Footer.jsp"></jsp:include>