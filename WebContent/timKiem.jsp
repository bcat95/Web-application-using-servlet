<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<jsp:include page="header.do" flush="true">
	<jsp:param name="bcTitle" value="Tìm kiếm -"/>
</jsp:include>
<div id="page">
	<!-- Tim kiem jsp  -->
		<div id="db-main-listing-search">
		<div class="db-main-wrapper">
			<div class="db-search-side-one bottom fade out">
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
								<div class="db-field-row custom-select">
									<div class="map-access sidebox-container ta-center" >
										<div class="map-access--bg">
											<button class="btn btn-default"><a href="banDo.do">Đến bản đồ</a></button>
										</div>
									</div>
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
					<!-- <div class="db-search-side-lef">
						<div class="map-access sidebox-container ta-center" >
							<div class="map-access--bg">
								<a href="banDo.do"><button class="btn btn-default">Đến bản đồ</button></a>
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
					</div> -->
					<div class="db-search-side-rig fade out">
						<div class="db-search-sort-container">
							<span class="db-found-count total-hidden">8 results</span>
							<script>
							window.onload = function(){ 
								$('.db-found-count.total-hidden').html($('.threadItem').length+" địa điểm / trang")
							};
							</script>
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
									requestURI="/timKiem.do" pagesize="8" class="discussionListItems">
									<logic:notEmpty name="timKiemForm" property="listBaiDang">
											<bean:define id="maBaiDang" name="threads" property="maBaiDang"/>
											<bean:define id="anhBia" name="threads" property="anhBia"/>
											<bean:define id="diaChi" name="threads" property="diaChi"/>
											<bean:define id="tenDanhMuc" name="threads" property="tenDanhMuc"/>
											<bean:define id="maTinhThanh" name="threads" property="maTinhThanh"/>
											<bean:define id="tenTinhThanh" name="threads" property="tenTinhThanh"/>
											<bean:define id="sDT" name="threads" property="sDT"/>
											<bean:define id="giaThapNhat" name="threads" property="giaThapNhat"/>
											<bean:define id="tieuDe" name="threads" property="tieuDe"/>
											<bean:define id="diemDanhGia" name="threads" property="diemDanhGia"/>
											<bean:define id="diaChiWeb" name="threads" property="diaChiWeb"/>
											<bean:define id="viDo" name="threads" property="viDo"/>
											<bean:define id="kinhDo" name="threads" property="kinhDo"/>
									</logic:notEmpty>
									<display:column sortable="true" title="diemDanhGia" headerClass="sor_ddg"/>
									<display:column class="threadItem">
										<div class="discussionListItem flexbox" id="thr_${maBaiDang}">
											<div class="listBlock posterAvatar item__image-area pos-relative">
												<!--Anh dai dien bai dang-->
												<a class='link_out' href='xemtin.do?mabaiDang=${maBaiDang}'></a>
												<div class="item__image" style="background: url('${anhBia}')"></div>
												<!--gia tri mac dinh-->
												<!-- <span class="bc-featured-listings-image-note"><i class="fa fa-heart-o wolf-zoom alway-active" aria-hidden="true"></i></span> -->
											</div>
											<div class="listBlock main item__flex-column" >
												<div class="item__details">
													<div class="item__name"><!--tieu de bai dang-->
														<a href="xemtin.do?maBaiDang=${maBaiDang}" class="name__copytext">${tieuDe}</a>
													</div>
													<div class="item__info"><!--so dien thoai bai dang-->
														<span class="db-listing-icon" title="Phone number">${tenTinhThanh}, <span id="khoangcach_${maBaiDang}"></span> km tới Trung tâm thành phố</span>
													<script type="text/javascript">
														$(document).ready(function () {
															$('#khoangcach_${maBaiDang}').html(getDistanceFromLatLonInKm(${viDo},${kinhDo},${maTinhThanh}));
														});
													</script>
													</div>
													<%-- 
													<div class="item__info"><!--so dien thoai bai dang-->
														<span class="db-listing-icon" title="Phone number">${sDT}</span>
													</div> --%>
													<div class="item__info">
														<logic:equal name="threads" property="diemDanhGia" value="0">
															<img class="icon-rating" src="img/icon/norating.png"/><span style="color: #9ba2a6;">Hiện tại chưa có đánh giá</span>
														</logic:equal>
														<span id="bl_${diemDanhGia}" class="ratings rating-lv<bean:write name="threads" property="diemDanhGia" format="#,0"/>" title="${diemDanhGia}">
															${diemDanhGia}
														</span>
													</div>
												</div>
												<div class="item__contact">
													<div class="item__info price"><!--gia ca bai dang-->
														<span class="db-listing-icon min-price" title="Giá thấp nhất"><bean:write name="threads" property="giaThapNhat" format="#,##0"/> đ</span>
														<span class="db-listing-icon max-price" title="Giá cao nhất"><bean:write name="threads" property="giaCaoNhat" format="#,##0"/> đ</span>
													</div>
													<div class="item__info"><!--dia chi web bai dang-->
														<span class="db-listing-icon website" title="Địa chỉ web">${diaChiWeb}</span>
													</div>
													<div class="item__info"><!--so dien thoai bai dang-->
														<span class="db-listing-icon" title="Phone number">${sDT}</span>
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
	$(document).ready(function () {	
		$("#sor_ddg").attr("href", $('.sor_ddg a').attr('href'));
	});
	</script>
	<script type="text/javascript">
	  function getDistanceFromLatLonInKm(lat1,lon1,maTinhThanh) {
		var R = 6371; // Radius of the earth in km
		var lat2=16.0474325;
		var lon2=108.1712201;
		if (maTinhThanh ==1){
		lat2=16.0474325;
		lon2=108.1712203;
		}
		
		if (maTinhThanh ==2){
		var lat2=11.9039022;
		var lon2=108.3806817;
		};
		if (maTinhThanh ==3){
		lat2=6.4534748;
		lon2=107.5419039;
		};
		if (maTinhThanh ==4){
		lat2=21.0227003;
		lon2=105.8019443;
		};
		if (maTinhThanh ==5){
		var lat2=21.0227003;
		var lon2=105.801944;
		};
		if (maTinhThanh ==6){
		lat2=12.2595881;
		lon2=109.17073;
		107.5419039
		};
		if (maTinhThanh ==7){
		lat2=14.9779335;
		lon2=108.3790455;
		};
		if (maTinhThanh ==8){
		lat2=17.5043687;
		lon2=105.7418899;
		};
		var dLat = deg2rad(lat2-lat1);  // deg2rad below
		var dLon = deg2rad(lon2-lon1); 
		var a = 
		   Math.sin(dLat/2) * Math.sin(dLat/2) +
		   Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * 
		   Math.sin(dLon/2) * Math.sin(dLon/2)
		   ; 
		 var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
		 var d = R * c; // Distance in km
		 var n = parseFloat(d);
		 d = Math.round(n * 100)/100;
		 return d;
	}
	
	function deg2rad(deg) {
	  return deg * (Math.PI/180)
	}
	</script>
<jsp:include page="template_Footer.jsp"></jsp:include>