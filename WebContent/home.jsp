<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.do" flush="true"></jsp:include>
<script>
jQuery(document).ready(function($) {
	 $('.bc-featured-listings').owlCarousel({
	    items: 4,
	    lazyLoad: true,
	    margin: 10
	});
	 $('.thr_kma_sli').owlCarousel({
		items:3,
		animateOut: 'slideOutDown',
		margin:0,
	    loop:true,
	    smartSpeed:450
	})
	 $( ".cat_des_3" ).html('😳 Mắt đẫn đờ, dạ dày rỗng, con tim rối bời chỉ vì không biết ăn gì ở đâu? Đừng lo, vào đây có hết! 🧀🍰🍦🍼 🍒🍭🍣');
	 $( ".cat_des_2" ).html('Thương trường là chiến trương!!!');
	 $( ".cat_des_4" ).html('Hiện nay cả thế giới đang đau đầu về vấn đề giải quyết nợ công,Việt Nam cũng đang thực hiên chiến lược');
	 $( ".cat_des_5" ).html('Ăn được ngủ được là tiên,không ăn không ngủ mất tiền thêm lo.Tập thể thao điểu độ nhá...:D');
	 $( ".cat_des_6" ).html('Bạn cần chỗ ăn,ở,nghỉ ngủ, hãy tìm đến với chúng tôi..Cực kỳ thỏa mái..:D');
});
</script>
<div id="page" class="noheadbg">
	<div class="bc-rs-container">
		<div class="slotholder">
			<div class="owl-carousel owl-theme thr_kma_sli fade out">
				<logic:iterate id="km" name="homeForm" property="listBaiDangKM">
					<div class="item ite<bean:write name="km" property="maBaiDang"/>" style="background-image:url(<bean:write name="km" property="anhBia"/>)">
						<a class='link_out' href='xemtin.do?maBaiDang=<bean:write name="km" property="maBaiDang"/>'></a>
						<div class="km_inf">
							<h4><bean:write name="km" property="tieuDe"/></h4>
							<span><bean:write name="km" property="noiDung"/></span>
						</div>
					</div>
				</logic:iterate>
			</div>
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
            	<html:submit styleClass="bc-search-row btn btn-primary center" >Tìm</html:submit>
        	</html:form>
			</div>
		</div>
	</div>
	<div class="clearfix"></div>
	<div id="main" class="site-main container">
		<div id="main-content" class="main-content row">
			<!--begin danh sách nổi bật-->
			<logic:iterate id="danhmuc" name="homeForm" property="listDanhMuc">
			<bean:define id="maDanhMuc" name="danhmuc" property="maDanhMuc"></bean:define>
				<logic:lessThan value="8" name="danhmuc" property="maDanhMuc">
				<div class="col-sm-12 cat_ites fade out ">
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
											<!-- <span class="bc-featured-listings-image-note">Featured</span> -->
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
											</div>
											<div class="bc-featured-listings-meta clearfix">
												<!--so luot thich bai dang-->
													<i class="fa fa-heart-o" aria-hidden="true"></i> 
													<bean:write name="bd" property="soLuotThich"/>
												<span class="bc-featured-listings-rating">
													<span id="bl_<bean:write name="bd" property="maBaiDang"/>" class="ratings rating-lv<bean:write name="bd" property="diemDanhGia" format="#,0"/>" title="<bean:write name="bd" property="diemDanhGia"/>">
														<bean:write name="bd" property="diemDanhGia"/>
													</span>
												</span>
											</div>
										</div>
									</div>
								</div>
								</logic:iterate>
								</logic:notEmpty>
								<div class="bc-featured-listings-item">
									<div class="bc-featured-listings-item-inner bc_vie_mor">
										<html:link styleClass="vie_all" href="timKiem.do?maDanhMuc=${maDanhMuc}">Click để khám phá thêm nhiều điều thú vị nữa nhé!</html:link>
									</div>
								</div>
								<!--end list item nổi bật -->
							</div>
						</div>
				</div>
				</logic:lessThan>
			</logic:iterate>
			<!--end danh sách nổi bật-->
		</div>
	</div>
</div>
<script src="owlcarousel/owl.carousel.min.js"></script>
<jsp:include page="template_Footer.jsp"></jsp:include>