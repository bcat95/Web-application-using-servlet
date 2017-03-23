<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<jsp:include page="header.do" flush="true"></jsp:include>
<script>
$(document.body).addClass('noheabac');
</script>
<div id="page">
	<!-- Tim kiem jsp  -->
		<div id="db-main-listing-search">
		<div class="db-main-wrapper">
			<div class="db-search-side-one bottom">
				
				<div id="db-main-search-map" style="width: 100%; height: 572px; position: relative; overflow: hidden;"></div>
				<script>
					function initMap() {
						var myLatLng = {lat: 16.0474325, lng: 108.1712203};
						var zoom=6;
						<logic:equal name="timKiemForm" property="maTinhThanh" value="1">
						var myLatLng = {lat: 16.0474325, lng: 108.1712203};
						var zoom=10;
						</logic:equal>
						<logic:equal name="timKiemForm" property="maTinhThanh" value="2">
						var myLatLng = {lat: 11.9038763, lng: 108.3106383};
						var zoom=11;
						</logic:equal>
						<logic:equal name="timKiemForm" property="maTinhThanh" value="3">
						var myLatLng = {lat: 16.4534748, lng: 107.5419039};
						var zoom=13;
						</logic:equal>
						<logic:equal name="timKiemForm" property="maTinhThanh" value="4">
						var myLatLng = {lat: 10.7680339, lng: 106.4141804};
						var zoom=10;
						</logic:equal>
						<logic:equal name="timKiemForm" property="maTinhThanh" value="5">
						var myLatLng = {lat: 21.0227003, lng: 105.8019443};
						var zoom=13;
						</logic:equal>
						<logic:equal name="timKiemForm" property="maTinhThanh" value="6">
						var myLatLng = {lat: 12.2595881, lng: 109.17073};
						var zoom=12;
						</logic:equal>
						<logic:equal name="timKiemForm" property="maTinhThanh" value="7">
						var myLatLng = {lat: 14.9779335, lng: 108.3790455};
						var zoom=10;
						</logic:equal>
						<logic:equal name="timKiemForm" property="maTinhThanh" value="8">
						var myLatLng = {lat: 17.5043687, lng: 105.7418899};
						var zoom=9;
						</logic:equal>
						var map = new google.maps.Map(document.getElementById('db-main-search-map'), {
					    zoom: zoom,
					    center: myLatLng,
					    mapTypeId: google.maps.MapTypeId.ROADMAP
					  	});
						var infowindow = new google.maps.InfoWindow();
						<logic:iterate id="bd" name="timKiemForm" property="listBaiDang">
							<bean:define id="maBaiDang" name="bd" property="maBaiDang"></bean:define>
							<bean:define id="kinhDo" name="bd" property="kinhDo"></bean:define>
							<bean:define id="viDo" name="bd" property="viDo"></bean:define>
							<bean:define id="tieuDe" name="bd" property="tieuDe"></bean:define>
							<bean:define id="anhBia" name="bd" property="anhBia"></bean:define>
							<bean:define id="tenDanhMuc" name="bd" property="tenDanhMuc"/>
							<bean:define id="diemDanhGia" name="bd" property="diemDanhGia"/>
							 var thr_${maBaiDang}_LatLng = {lat: ${viDo}, lng: ${kinhDo}};
							 var thr_${maBaiDang}_marker = new google.maps.Marker({
							     position: thr_${maBaiDang}_LatLng,
							     map: map,
							     title: '${tieuDe}',
							     animation: google.maps.Animation.DROP,
							 });
							 var cont_${maBaiDang}="<div class='card'><div class='car_bac' style='background-image: url(${anhBia})'></div><a class='car_tit' href='xemtin.do?maBaiDang=${maBaiDang}'>${tieuDe}</a><span><span class='label label-success'>${tenDanhMuc}</span><span class='label label-info'>${diemDanhGia}</span></span></div>";
							 thr_${maBaiDang}_marker.addListener('click', function() {
								 infowindow.setContent("<div id='thr_${maBaiDang}_con' class='thr_con clearfix'>"+cont_${maBaiDang}+"</div>");
								 infowindow.open(map, thr_${maBaiDang}_marker);
						     });	
						</logic:iterate>
						 function toggleBounce() {
					        if (marker.getAnimation() !== null) {
					          marker.setAnimation(null);
					        } else {
					          marker.setAnimation(google.maps.Animation.BOUNCE);
					        }
					      }
					 }
					</script>
					<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC2dl2OOrUh7HFZwsJP8deel-3DTgfWZtk&callback=initMap"></script>
			</div>
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
							<div class="clearfix"></div>
						</div>
					</div>
					<!--Danh sach tin-->
					<div class="db-main-search-listings">
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
									<div class="bc-featured-listings-item" id="thr_${maBaiDang}">
										<div class="bc-featured-listings-item-inner">
											<div class="bc-featured-listings-image">
												<!--Anh dai dien bai dang-->
												<a href="xemtin.do?maBaiDang=${maBaiDang}" class="bc-featured-item-image" style="background: url('${anhBia}')"></a>
												<div class="bc-featured-image-overlay"></div>
												<!--gia tri mac dinh-->
												<span class="bc-featured-listings-image-note">Featured</span>
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