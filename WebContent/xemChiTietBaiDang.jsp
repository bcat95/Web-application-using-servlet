<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<jsp:include page="header.do" flush="true"></jsp:include>
<script>
jQuery(document).ready(function($) {
	document.title = '<bean:write name="baiDangForm" property="tieuDe"/>';
	$(document.body).addClass('noheabac');
	
	$('.thr_inf_bot:not(:has(*))').remove();
	
	$('.thr_inf_bot:not(:has(*))').remove();
});
</script>
<style>
body {
    margin-bottom: calc(175px + 130px);
}
</style>
<script>
	$(document).ready(function(){
		$("#review-title").attr("placeholder", "Tiêu đề bình luận");
		$("#comment").attr("placeholder", "Nội dung bình luận");
		$("#review-title").prop('maxlength',50);
		$("#review-title").prop('required',true);
		$("#comment").prop('required',true);
	});
	</script>
	<!-- chi tiet tin-->
	<%-- <html:form action="xembaidang" method="get" styleId="db-add-listing-form" enctype="multipart/form-data"> --%>
	<div class="db-single-listing-wrapper">
		<bean:define id="maBaiDang" name="baiDangForm" property="maBaiDang"></bean:define>
		<style>
			/*Ảnh nền của bài đăng*/
			<logic:notEmpty name="baiDangForm" property="anhBia">
			.db-single-overlay {
				background: url(<bean:write name="baiDangForm" property="anhBia"/>);
			}
			</logic:notEmpty>
		</style>
		
			<!--tieu de tin-->
			<div class="db-listing-featured-img">
				<div class="db-single-overlay"></div>
				<div class="db-single-listing-head page-with">
					<div class="thr_hea_lef" style="background: url(<bean:write name="baiDangForm" property="anhBia"/>)"></div>
					<div class="thr_hea_rig">
						<span class="db-single-listing-category"><bean:write name="baiDangForm" property="tenDanhMuc"/> - <a href='timKiem.do?maTinhThanh=<bean:write name="baiDangForm" property="maTinhThanh"/>'><bean:write name="baiDangForm" property="tenTinhThanh"/></a></span>
						<h1 class="single-listing-title"><bean:write name="baiDangForm" property="tieuDe"/></h1>
						<!--thong tin bai-->
						<div class="thr_inf">
							<!-- <h3 class="db-listing-side-title">Chi tiết liên hệ</h3> -->
							<span class="db-single-contact-item thr_add">
								<i class="fa fa-map-marker" aria-hidden="true"></i><bean:write name="baiDangForm" property="diaChi" />
							</span>
							<span class="db-single-contact-item ">
								<i class="fa fa-money" aria-hidden="true"></i>
								<bean:write name="baiDangForm" property="giaThapNhat" format="#,##0"/> - <bean:write name="baiDangForm" property="giaCaoNhat" format="#,##0"/> vnđ
							</span>
							<span class="db-single-contact-item">
								<i class="fa fa-clock-o" aria-hidden="true"></i>10:00 - 23:00 <b class="bc_gre">Đang mở cửa</b>
							</span>
							<span class="db-single-contact-item pull-left">
								<i class="fa fa-phone" aria-hidden="true"></i><bean:write name="baiDangForm" property="sDT"/>
							</span>
							<span class="db-single-contact-item pull-left" style="margin-left: 5px;">
								 - <i class="fa fa-internet-explorer" aria-hidden="true"></i>
								<a href="http://example.com"><bean:write name="baiDangForm" property="diaChiWeb"/></a>
							</span>
						</div>
						<div class="thr_inf_bot">
							<logic:iterate id="khuyenmai" name="baiDangForm" property="listKhuyenMai">
									<div class="thr_km_hea">
										<i class="fa fa-gift fa-2 alway-active wolf-surprise bc_gre" aria-hidden="true"></i> <bean:write name="khuyenmai" property="tieuDe"/>
										<span>
											<span><i class="fa fa-calendar-check-o bc_gre" aria-hidden="true"></i><bean:write name="khuyenmai" property="ngayBatDau"/> -></span>
											<span><i class="fa fa-calendar-times-o bc_gre" aria-hidden="true"></i><bean:write name="khuyenmai" property="ngayKetThuc"/></span>
										</span>
										<span id="bc_gif_end"></span>
									</div>
									<div class="db-single-listing-side-container thr_km"> <bean:write name="khuyenmai" property="noiDung"/></div>
							</logic:iterate>
						</div>
						<!--end thong tin bai-->
					</div>
				</div>
			</div>
		<div class="db-single-listing-container">
			<!--end tieu de tin-->
			<div class="db-single-listing-left">
				<div class="db-single-listing-main clearfix">
					<!-- head noi dung tin -->
						<div class="hea_inf_thr clearfix">
							<div class="rating rating-lv<bean:write name="baiDangForm" property="diemDanhGia" format="#,0"/>">
								<meta itemprop="reviewCount" content="26">
								<span itemprop="ratingValue"><bean:write name="baiDangForm" property="diemDanhGia" format="0.0"/></span>
							</div>
						</div>
					<!-- end  head noi dung tin-->
					<!--chi tiet tin noi dung tin-->
					<div class="bcnoidungtin">
						<bean:write name="baiDangForm" property="noiDung" filter="false"/>
					</div>
					<!--end chi tiet tin noi dung tin-->
					<!--Chi tiet tin hinh anh tin-->
						<script>
						$(document).ready(function () {
						    var contentGallery1a=[
						    	<logic:iterate id="hinhanh" name="baiDangForm" property="listHinhAnh">
						    	{
									src: '<bean:write name="hinhanh" property="tenHinh"/>'
								},
								</logic:iterate>
								];
							
							jQuery("#nanoGallery1a").nanoGallery({
								//thumbnailWidth:155,
								thumbnailWidth: 'auto',
								thumbnailHeight:155,
								items:contentGallery1a,
								theme:'light',
								colorScheme: 'none',
								thumbnailHoverEffect:{'name':'labelAppear75','duration':300},
								useTags:false,
								thumbnailGutterWidth : 0,
							    thumbnailGutterHeight : 0,
						      	viewerDisplayLogo:true,
						      	i18n:{'thumbnailImageDescription':'Xem ảnh', 'thumbnailAlbumDescription':'Open Album'},
								thumbnailLabel:{display:true,position:'overImageOnMiddle', align:'center'},
						      colorSchemeViewer:'default'
							});
						    // ##################################################################################################################
							// ##### DEMO PANEL #####
						    // ##################################################################################################################
								jQuery("#nanoGalleryAnimation1").nanoGalleryDemo({thumbnailWidth:260, thumbnailHeight:170, itemsBaseURL:'demonstration',
						      viewerDisplayLogo:true
							});
						});
						</script>
					<!--end Chi tiet tin hinh anh tin-->
					<!--chi tiet tin footer tin -->
					<div class="db-single-listing-meta">
						<div class="db-single-listing-like" data-favorite="Yêu thích " data-favorited="Đã Thích">
							<bean:define id="yeuThich" name="baiDangForm" property="yeuThich"></bean:define>
							<logic:equal name="baiDangForm" property="yeuThich" value="true">
								<a class="favorited" href="xemtin.do?maBaiDang=${maBaiDang}&setThich=true">Đã thích <i class="fa fa-heart wolf-zoom alway-active" aria-hidden="true"></i></a>
							</logic:equal>
							<logic:equal name="baiDangForm" property="yeuThich" value="false">
								<a class="favorite" href="xemtin.do?maBaiDang=${maBaiDang}&setThich=true">Thích <i class="fa fa-heart-o wolf-zoom alway-active" aria-hidden="true"></i></a>
							</logic:equal>
							
						</div>
						<div class="db-single-listing-share">
							<span>Chia sẻ </span>
							<div class="db-single-listing-share-inner">
								<div class="db-share-item facebook">
									<a href="https://www.facebook.com/dialog/share?app_id=145634995501895&amp;display=popup&amp;href=[link_here]" target="_blank"><i class="fa fa-facebook" aria-hidden="true"></i></a>
								</div>
								<div class="db-share-item gplus">
									<a href="https://plus.google.com/share?url=[link_here]" target="_blank"><i class="fa fa-google-plus" aria-hidden="true"></i></a>
								</div>
								<div class="db-share-item twitter">
									<a href="https://twitter.com/intent/tweet?text=[title_here]&amp;url=[link_here]" target="_blank"><i class="fa fa-twitter" aria-hidden="true"></i></a>
								</div>
							</div>
						</div>
					</div>
					<!--end chi tiet tin footer tin -->
					<!--end chi tiet tin tien nghi tin-->
					<!-- chi tiet tin binh luan-->
					<div id="comments" class="comments-area ">
						<ul class="review-list">
							<div class="bcbinhluans clearfix">
								<display:table id="bcbinhluan" name="sessionScope.baiDangForm.listBinhLuan"
									requestURI="/xemtin.do" pagesize="5">
									<logic:notEmpty name="baiDangForm" property="listBinhLuan">
											<bean:define id="diemDanhGia" name="bcbinhluan" property="diemDanhGia"/>
											<bean:define id="maBinhLuan" name="bcbinhluan" property="maBinhLuan"/>
											<bean:define id="userName" name="bcbinhluan" property="userName"/>
											<bean:define id="ngayBinhLuan" name="bcbinhluan" property="ngayBinhLuan"/>
											<bean:define id="tieuDe" name="bcbinhluan" property="tieuDe"/>
											<bean:define id="noiDung" name="bcbinhluan" property="noiDung"/>
									</logic:notEmpty>
									<display:column class="bcbinhluan item">
										
										<li class="comment byuser comment-author-jolydoe1 even thread-even depth-1">
											<div class="review">
												<div class="review-meta">
													<div class="review-author vcard shadows">
														<img src="upload/avata/Bcat95.jpeg" width="54" height="54" alt="July Doe" class="avatar avatar-54 wp-user-avatar wp-user-avatar-54 alignnone photo">
													</div> 
												</div>
												<div class="review-content">
													<span class="db-review-title">${tieuDe}</span>
													<span class="db-listing-rating">
														<span id="bl_${maBinhLuan}" class="ratings" title="${diemDanhGia}"><b>${diemDanhGia}</b>/5</span>
													</span>
													<p>${noiDung}</p>
													<div class="db-review-bottom">
														<a href="#" class="db-review-author">${userName}</a> ${ngayBinhLuan}
													</div>
													<div class="clearfix"></div>
												</div>
												<div class="clearfix"></div>
											</div> 
										</li>
									</display:column>
									
									<display:setProperty name="paging.banner.placement" value="bottom" />
									<display:setProperty name="basic.msg.empty_list">
										<div class="alert alert-info">
											<strong>Oh!</strong> Chưa có bình luận nào ! Hãy là người đầu tiên.
										</div>
									</display:setProperty>
									<display:setProperty name="paging.banner.all_items_found"><span class="pagebanner"> {0} {1} được hiển thị, số số bình luận {2}. </span></display:setProperty>
									<display:setProperty name="paging.banner.some_items_found">
										<span class="pagebanner"> {0} {1} được hiển thị, số bình luận {2} đến {3}. </span>
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
								<div class="fb-comments" data-href="xemtin.do?maBaiDang=${maBaiDang}" data-numposts="5" data-width="100%"></div>
							</div>
						</ul>
						<!--end list binh luan-->
						<!-- form binh luan-->
					</div>
					<div id="respond" class="comment-respond">
						<html:form action="xemtin" method="post" styleId="commentform" styleClass="comment-form">
							<div class="db-rating-stars">
								<span class="db-rating-text">Để lại nhận xét của bạn</span>
									<div class="db-rating-container">
										<span class="star-cb-group">
										  <input type="radio" id="rating-5" name="bl_diemDanhGia" value="5" /><label for="rating-5">5</label>
										  <input type="radio" id="rating-4" name="bl_diemDanhGia" value="4" checked="checked" /><label for="rating-4">4</label>
										  <input type="radio" id="rating-3" name="bl_diemDanhGia" value="3" /><label for="rating-3">3</label>
										  <input type="radio" id="rating-2" name="bl_diemDanhGia" value="2" /><label for="rating-2">2</label>
										  <input type="radio" id="rating-1" name="bl_diemDanhGia" value="1" /><label for="rating-1">1</label>
										  <input type="radio" id="rating-0" name="bl_diemDanhGia" value="0" class="star-cb-clear" /><label for="rating-0" class="clear_rating">Clear</label>
										</span>
									</div>
							</div>
							<span class="comment-form-review-title">
								<html:text property="bl_tieuDe" styleId="review-title" styleClass="input"></html:text>
							</span>
							<span class="comment-form-comment">
								<span class="db-send-comment"></span>
								<html:textarea property="bl_noiDung" styleId="comment" rows="3"></html:textarea>
							</span>
							<script type="text/javascript">
							 $("#comment").val("");
							 $("#review-title").val("");
							</script>
							<p class="form-submit">
								<button name="submit" type="submit" id="submit" class="submit btn-danger" value="binhLuan">Bình luận</button>
								<input type="hidden" name="maBaiDang" id="comment_post_ID" value="${maBaiDang}">
							</p>
						</html:form>
					</div>
					<!-- end chi tiet tin binh luan-->
				</div>
				<!-- Địa điểm cùng danh mục-->
				<logic:notEmpty name="baiDangForm" property="listBaiDangDanhMuc">
				<div class="db-main-search-listings lis_ful dia_diem_tuong_tu">
				
				<h3 style="white-space: nowrap;overflow: hidden;" class="db-single-amenities-title">Địa điểm tương tự <bean:write name="baiDangForm" property="tieuDe"/></h3>
							<!--begin list item nổi bật -->
							<logic:iterate id="bd" name="baiDangForm" property="listBaiDangDanhMuc">
										<div class="col-sm-4 cat_ites fade out ">
									<div class="column-inner cat_ite">
										<div class="bc-featured-listings-item" id='<bean:write name="bd" property="maBaiDang" />'>
										<div class="bc-featured-listings-item-inner">
											<div class="bc-featured-listings-image">
												<!--Anh dai dien bai dang-->
												<a class='link_out' href='xemtin.do?mabaiDang=<bean:write name="bd" property="maBaiDang" />'></a>
												<div class="item__image" style="width: 100%; height: 100%; background: url('<bean:write name="bd" property="anhBia" />);" ></div>
												<a href="xemtin.do?maBaiDang=<bean:write name="bd" property="maBaiDang" />" class="bc-featured-item-image" 
													style="background: url('<bean:write name="bd" property="anhBia" />')"></a>
												<div class="bc-featured-image-overlay"></div>
												<!--gia tri mac dinh-->
												<!-- <span class="bc-featured-listings-image-note">Featured</span> -->
												<div class="bc-featured-listings-image-meta">
													<span class="bc-featured-listings-custom-fields">
														<span class="bc-featured">
															<!--dia chi bai dang-->
															<span class="db-listing-icon wl-location" title="Address"></span>
															<bean:write name="bd" property="diaChi" />
														</span>
														<span class="bc-featured">
															<!--so dien thoai bai dang-->
															<span class="db-listing-icon wl-phone" title="Phone number"></span>
															<bean:write name="bd" property="sDT" />
														</span>
													</span>
												</div>
												
											</div>
											<div style="background-color: white;" class="bc-featured-listings-data" >
												<!--tieu de bai dang-->
												<a href="xemtin.do?maBaiDang=<bean:write name="bd" property="maBaiDang" />" class="bc-featured-listings-title">
													<bean:write name="bd" property="tieuDe" />
												</a>
												<div class="bc-featured-listings-meta clearfix">
												<!--so luot thich bai dang-->
													<i class="fa fa-heart-o" aria-hidden="true"></i>
													<bean:write name="bd" property="soLuotThich" />
													<span class="bc-featured-listings-rating">
														<span id="bl_<bean:write name="bd" property="maBaiDang" />" class="ratings rating-lv<bean:write name="bd" property="diemDanhGia" format="#" />" title="<bean:write name="bd" property="diemDanhGia" />">
															<bean:write name="bd" property="diemDanhGia" />
														</span>
													</span>
												</div>
											</div>
										</div>
										</div>
										</div>
										</div>
								</logic:iterate>	
							<!--end list item nổi bật -->
							<div class="clearfix"></div>
						</div>
					</logic:notEmpty>
				<!-- END Địa điểm cùng danh mục- -->
			</div>
			<!-- chi tiet tin cot phai-->
			<div class="db-single-listing-right">
				<div class="rig_hea">
					<div class="sta_img">
						<div class="numb" id="cou_img">0</div>
						<div class="text">Hình ảnh</div>
					</div>
					<div class="sta_cmt">
						<a href="#bcbinhluan" style="color: #ed3554;">
							<div class="numb" id="cou_cmt">0</div>
							<div class="text">Đánh giá</div>
						</a>
					</div>
					<script>
					window.onload = function(){ 
						$('#cou_img').html($('.nanoGalleryThumbnailContainer .image').length -1);
					}
					$('#cou_cmt').html($('.bcbinhluan.item').length);
					</script>
				</div>
				<div class="db-single-listing-side-wrapper">
					<div class="db-gallery-mos-container clearfix">
							<div id="nanoGallery1a"></div>
							<%-- <logic:iterate id="hinhanh" name="baiDangForm" property="listHinhAnh">
								<a href="#" class="db-gallery-mos-item prettyphoto" rel="prettyPhoto[whitelab_map]" style="background: url(<bean:write name="hinhanh" property="tenHinh"/>)"></a>
							</logic:iterate> --%>
					</div>
				</div>
				<div class="db-single-listing-map-wrapper">
					<div id="db-single-listing-map" style="width: 100%; height: 300px; position: relative; overflow: hidden;"></div>
					<script>
					function myMap() {
					var myLatLng = {lat: <bean:write name="baiDangForm" property="viDo"/>, lng: <bean:write name="baiDangForm" property="kinhDo"/>};
					var zoom=13;
					var map = new google.maps.Map(document.getElementById('db-single-listing-map'), {
					    zoom: zoom,
					    center: myLatLng,
					    mapTypeId: google.maps.MapTypeId.ROADMAP
					});
					var infowindow = new google.maps.InfoWindow();
					var thr_marker = new google.maps.Marker({
					     position: myLatLng,
					     map: map,
					     animation: google.maps.Animation.DROP,
					 });
					thr_marker.addListener('click', function() {
						 infowindow.setContent("<a target='_blank' href='https://www.google.com/maps?q=loc:<bean:write name='baiDangForm' property='viDo'/>,<bean:write name='baiDangForm' property='kinhDo'/>'>Xem Trên Google map</a>");
						 infowindow.open(map, thr_marker);
				     });
					}
					</script>
					<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC2dl2OOrUh7HFZwsJP8deel-3DTgfWZtk&callback=myMap"></script>
				</div>
				<!--chi tiet tin tien nghi tin-->
				<div class="db-single-listing-side-wrapper clearfix">
					<h3 class="db-single-amenities-title">Tiện nghi</h3>
					<logic:iterate id="dichvu" name="baiDangForm" property="listDichVu">
						<span class="db-amenitie-item col-md-6 dv<bean:write name="dichvu" property="maDichVu"/>">
							<a href="timKiem.do?maDichVu=<bean:write name="dichvu" property="maDichVu"/>">
								<i class="fa fa-bcicon" aria-hidden="true"></i>
								<div class="db-amenities-inner">
									<span class="db-amenities-text"><bean:write name="dichvu" property="tenDichVu"/></span>
								</div>
							</a>
						</span>
					</logic:iterate>
				</div>
				<!--end chi tiet tin tien nghi tin-->
				<!--chi tiet tin khuyen mai-->
				<div class="db-single-listing-side-wrapper clearfix">
					<h3 class="db-single-amenities-title">Khuyến mãi</h3>
					<logic:iterate id="khuyenmai" name="baiDangForm" property="listKhuyenMai">
						<div class="thr_km_ite">
							<div class="thr_km_hea">
								<i class="fa fa-gift fa-2 alway-active wolf-surprise bc_gre" aria-hidden="true"></i> <bean:write name="khuyenmai" property="tieuDe"/>
								<span style="display: block;">
									<span><i class="fa fa-calendar-check-o bc_gre" aria-hidden="true"></i><bean:write name="khuyenmai" property="ngayBatDau"/> -></span>
									<span><i class="fa fa-calendar-times-o bc_gre" aria-hidden="true"></i><bean:write name="khuyenmai" property="ngayKetThuc"/></span>
								</span>
								<span id="bc_gif_end"></span>
							</div>
							<div class="db-single-listing-side-container thr_km"> <bean:write name="khuyenmai" property="noiDung"/></div>
						</div>
					</logic:iterate>
				</div>
				<!-- end chi tiet tin khuyen mai-->
				<!--quang cao cot phai-->
				<!-- <div class="db-single-listing-side-wrapper">
					<h3 class="db-listing-side-title">Advertisement</h3>
					<p><img class="alignnone size-full wp-image-609" src="img/ads/ad-small.png" alt="" width="263" height="240"></p>
				</div> -->
				
				<!--end quang cao cot phai-->
				
				<!-- Địa điểm gần đó -->
				<logic:notEmpty name="baiDangForm" property="listBaiDang">
				<div class="db-main-search-listings lis_ful dia_diem_gan">
				
				<h3 style="white-space: nowrap;overflow: hidden;" class="db-single-amenities-title">Địa điểm gần <bean:write name="baiDangForm" property="tieuDe"/></h3>
							<!--begin list item nổi bật -->
							<logic:iterate id="bd" name="baiDangForm" property="listBaiDang">
										<div class="cat_ites fade out ">
									<div class="column-inner cat_ite">
										<div class="bc-featured-listings-item" id='<bean:write name="bd" property="maBaiDang" />'>
										<div class="bc-featured-listings-item-inner flexbox">
											<div class="bc-featured-listings-image">
												<!--Anh dai dien bai dang-->
												<a class='link_out' href='xemtin.do?mabaiDang=<bean:write name="bd" property="maBaiDang" />'></a>
												<div class="item__image" style="width: 100%; height: 100%; background: url('<bean:write name="bd" property="anhBia" />);" ></div>
												<a href="xemtin.do?maBaiDang=<bean:write name="bd" property="maBaiDang" />" class="bc-featured-item-image" 
													style="background: url('<bean:write name="bd" property="anhBia" />')"></a>
												<div class="bc-featured-image-overlay"></div>
												<!--gia tri mac dinh-->
												<!-- <span class="bc-featured-listings-image-note">Featured</span> -->
												
											</div>
											<div style="background-color: white;" class="bc-featured-listings-data" >
												<!--tieu de bai dang-->
												<a href="xemtin.do?maBaiDang=<bean:write name="bd" property="maBaiDang" />" class="bc-featured-listings-title">
													<bean:write name="bd" property="tieuDe" />
												</a>
												<div class="bc-featured-listings-image-meta">
													<span class="bc-featured-listings-custom-fields">
														<span class="bc-featured">
															<!--dia chi bai dang-->
															<span class="db-listing-icon wl-location" title="Address"></span>
															<bean:write name="bd" property="diaChi" />
														</span>
													</span>
												</div>
												<div class="bc-featured-listings-meta clearfix">
												<!--so luot thich bai dang-->
													<i class="fa fa-heart-o" aria-hidden="true"></i>
													<bean:write name="bd" property="soLuotThich" />
													<span class="bc-featured-listings-rating">
														<span id="bl_<bean:write name="bd" property="maBaiDang" />" class="ratings rating-lv<bean:write name="bd" property="diemDanhGia" format="#" />" title="<bean:write name="bd" property="diemDanhGia" />">
															<bean:write name="bd" property="diemDanhGia" />
														</span>
													</span>
												</div>
											</div>
										</div>
										</div>
										</div>
										</div>
								</logic:iterate>	
							<!--end list item nổi bật -->
							<div class="clearfix"></div>
						</div>
					</logic:notEmpty>
				<!-- END Địa điểm cùng danh mục- -->
				<!-- END Địa điểm gần đó -->
				
				
			</div>
			<!-- end chi tiet tin cot phai-->
			<div class="clearfix"></div>
		</div>
	</div>
	<script>var D = 'log',
	  log = $('<div id="'+logID+'"></div>');
	$('body').append(log);
	  $('[type*="radio"]').change(function () {
	    var me = $(this);
	    log.html(me.attr('value'));
	  });
	//# sourceURL=pen.js
	</script>
	<%-- </html:form> --%>
	<!-- nanoGALLERY - default theme css file -->
	<link href="css/nanogallery.min.css" rel="stylesheet" type="text/css">
	<!-- nanoGALLERY - css file for the theme 'clean'-->
	<link href="css/themes/clean/nanogallery_clean.min.css" rel="stylesheet" type="text/css">
	<!-- nanoGALLERY - css file for the theme 'light'-->
	<link href="css/themes/light/nanogallery_light.min.css" rel="stylesheet" type="text/css">
	<!-- nanoGALLERY javascript-->
	<script type="text/javascript" src="js/jquery.nanogallery.min.js"></script>
  	<style>
  		.nanogallery_theme_clean .nanoGalleryContainer .nanoGalleryThumbnailContainer img {
		    width: 100%;
		    height: auto;
		    max-height: none !important;
		    max-width: none !important;
		}
  	</style>
  	<div id="fb-root"></div>
	<div id="fb-root"></div>
	<script>(function(d, s, id) {
	  var js, fjs = d.getElementsByTagName(s)[0];
	  if (d.getElementById(id)) return;
	  js = d.createElement(s); js.id = id;
	  js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.8&appId=254476368342790";
	  fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));</script>
	<!-- end chi tiet tin-->
<jsp:include page="template_Footer.jsp"></jsp:include>