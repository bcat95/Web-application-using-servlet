<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<jsp:include page="header.do" flush="true"></jsp:include>
	<!-- chi tiet tin-->
	<%-- <html:form action="xembaidang" method="get" styleId="db-add-listing-form" enctype="multipart/form-data"> --%>
	<div class="db-single-listing-wrapper">
		<bean:define id="maBaiDang" name="baiDangForm" property="maBaiDang"></bean:define>
		<%-- <bean:define id="userName" name="baiDangForm" property="userName"></bean:define> --%>
		<style>
			/*Ảnh nền của bài đăng*/
			.db-listing-featured-img {
				background: url(<bean:write name="baiDangForm" property="anhBia"/>);
			}
		</style>
		<div class="db-listing-featured-img">
			<div class="db-single-overlay"></div>
		</div>
		<div class="db-single-listing-container">
			<!--tieu de tin-->
			<div class="db-single-listing-head">
				<span class="db-single-listing-category"><bean:write name="baiDangForm" property="tenDanhMuc"/>  </span>
				<h1 class="single-listing-title"><bean:write name="baiDangForm" property="tieuDe"/> </h1>
			</div>
			<!--end tieu de tin-->
			<div class="db-single-listing-left">
				<div class="db-single-listing-main clearfix">
					<!--chi tiet tin noi dung tin-->
					<div class="bcnoidungtin">
						<bean:write name="baiDangForm" property="noiDung" filter="false"/>
					</div>
					<!--end chi tiet tin noi dung tin-->
					<!--Chi tiet tin hinh anh tin-->
					<h3>Triển lãm ảnh</h3>
					<div class="db-gallery-mos-container clearfix">
						<logic:iterate id="hinhanh" name="baiDangForm" property="listHinhAnh">
							<a href="#" class="db-gallery-mos-item prettyphoto" rel="prettyPhoto[whitelab_map]" style="background: url(<bean:write name="hinhanh" property="tenHinh"/>)"></a>
						</logic:iterate>
					</div>
					<!--end Chi tiet tin hinh anh tin-->
					<!--chi tiet tin footer tin -->
					<div class="db-single-listing-meta">
						<div class="db-single-listing-like" data-favorite="Yêu thích " data-favorited="Đã Thích">
							<bean:define id="yeuThich" name="baiDangForm" property="yeuThich"></bean:define>
							<logic:equal name="baiDangForm" property="yeuThich" value="true">
								<a class="favorited" href="xembaidang.do?maBaiDang=${maBaiDang}&yeuThich=false">Đã thích <i class="fa fa-heart" aria-hidden="true"></i></a>
							</logic:equal>
							<logic:equal name="baiDangForm" property="yeuThich" value="false">
								<a class="favorite" href="xembaidang.do?maBaiDang=${maBaiDang}&yeuThich=true">Thích <i class="fa fa-heart-o" aria-hidden="true"></i></a>
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
				</div>
				<!--chi tiet tin quang cao include tu qcao-->
				<!-- <div class="db-single-adv">
					<h3 class="db-single-adv-title">Quảng cáo</h3>
					<img class="alignnone size-full wp-image-608" src="img/ads/ad-large.png" alt="" width="786" height="137">
				</div> -->
				<!--end chi tiet tin quang cao-->
				<!--chi tiet tin tien nghi tin-->
				<div class="db-single-amenities content-area">
					<h3 class="db-single-amenities-title">Tiện nghi</h3>
					<div class="db-amenitie-item-wrapper row row_w">
						<logic:iterate id="dichvu" name="baiDangForm" property="listDichVu">
							<span class="db-amenitie-item col-md-2 dv<bean:write name="dichvu" property="maDichVu"/>">
								<a href="timKiem.do?maDichVu=<bean:write name="dichvu" property="maDichVu"/>">
									<i class="fa fa-bcicon" aria-hidden="true"></i>
									<div class="db-amenities-inner">
										<span class="db-amenities-text"><bean:write name="dichvu" property="tenDichVu"/></span>
									</div>
								</a>
							</span>
						</logic:iterate>
					</div>
				</div>
				<!--end chi tiet tin tien nghi tin-->
				<!-- chi tiet tin binh luan-->
				<div id="comments" class="comments-area ">
					<ul class="review-list">
						<div class="bcbinhluans clearfix">
							<display:table id="bcbinhluan" name="sessionScope.baiDangForm.listBinhLuan"
								requestURI="/xembaidang.do" pagesize="5">
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
												<span id="bl_${maBinhLuan}" class="ratings" title="${diemDanhGia}">
													<span class="star"></span>
													<span class="star"></span>
													<span class="star"></span>
													<span class="star"></span>
													<span class="star"></span>
												</span>
												<script>
													var ddg = $('#bl_${maBinhLuan}').attr('title');
													for (i = 1; i <= ddg; i++) { 
														$('#bl_${maBinhLuan} span:nth-child('+i+')').addClass(" Full");
													}
												</script>
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
						</div>
					</ul>
					<!--end list binh luan-->
					<!-- form binh luan-->
					<div id="respond" class="comment-respond">
						<html:form action="xembaidang" method="post" styleId="commentform" styleClass="comment-form">
							<div class="db-rating-stars">
								<span class="db-rating-text">Để lại bình luận của bạn</span>
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
								<button name="submit" type="submit" id="submit" class="submit" value="binhLuan">Bình luận</button>
								<input type="hidden" name="maBaiDang" id="comment_post_ID" value="${maBaiDang}">
							</p>
						</html:form>
					</div> 
				</div>
				<!-- end chi tiet tin binh luan-->
			</div>
			<!-- chi tiet tin cot phai-->
			<div class="db-single-listing-right">
				<div class="db-single-listing-map-wrapper">
					<div id="db-single-listing-map" style="width: 100%; height: 300px; position: relative; overflow: hidden;"></div>
					<script>
					function myMap() {
					var mapCanvas = document.getElementById("db-single-listing-map");
					var mapOptions = {
					center: new google.maps.LatLng(51.5, -0.2), zoom: 10
					};
					var map = new google.maps.Map(mapCanvas, mapOptions);
					}
					</script>
					<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDyVj9OfaIf5rY7HUFfWKbz_9H2Lef5BBo&callback=myMap"></script>
				</div>
				<!--thong tin bai-->
				<div class="db-single-listing-side-wrapper">
					<h3 class="db-listing-side-title">Chi tiết liên hệ</h3>
					<div class="db-single-listing-side-container">
						<span class="db-single-contact-item">
							<i class="fa fa-map-marker" aria-hidden="true"></i><bean:write name="baiDangForm" property="tenTinhThanh"/>
						</span>
					<span class="db-single-contact-item">
						<i class="fa fa-phone" aria-hidden="true"></i><bean:write name="baiDangForm" property="sDT"/>
					</span>
					<span class="db-single-contact-item">
						<i class="fa fa-internet-explorer" aria-hidden="true"></i>
						<a href="http://example.com"><bean:write name="baiDangForm" property="diaChiWeb"/></a>
						</span>
					</div>
				</div>
				<!--end thong tin bai-->
				<!--chi tiet mo cua-->
				<div class="db-single-listing-side-wrapper">
					
					<h3 class="db-listing-side-title">Khuyến mãi</h3>
					<div class="db-single-listing-side-container thr_km">
						<span class="db-single-contact-item clearfix">
							<span><i class="fa fa-calendar-check-o" aria-hidden="true"></i>8/3/2017</span>
							<span><i class="fa fa-calendar-times-o" aria-hidden="true"></i>10/3/2017</span>
						</span>
						NETHOST khuyến mại chúc mừng ngày Quốc tế phụ nữ<br>
						Chào mừng ngày Quốc tế phụ nữ, NETHOST tung ra chương trình khuyến mại mua Hosting được tặng Website, Mua VPS giảm ngay 20%.
					</div>
				</div>
				<!--end chi tiet mo cua-->
				<!--quang cao cot phai-->
				<div class="db-single-listing-side-wrapper">
					<h3 class="db-listing-side-title">Advertisement</h3>
					<p><img class="alignnone size-full wp-image-609" src="img/ads/ad-small.png" alt="" width="263" height="240"></p>
				</div>
				<!--end quang cao cot phai-->
			</div>
			<!-- end chi tiet tin cot phai-->
			<div class="clearfix"></div>
		</div>
	</div>
	<script>var logID = 'log',
	  log = $('<div id="'+logID+'"></div>');
	$('body').append(log);
	  $('[type*="radio"]').change(function () {
	    var me = $(this);
	    log.html(me.attr('value'));
	  });
	//# sourceURL=pen.js
	</script>
	<<script type="text/javascript">
	$("#review-title").attr("placeholder", "Tiêu đề bình luận");
	$("#comment").attr("placeholder", "Nội dung bình luận");
	</script>
	<%-- </html:form> --%>
	<!-- end chi tiet tin-->
<jsp:include page="template_Footer.jsp"></jsp:include>