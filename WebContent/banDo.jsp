<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<jsp:include page="header.do" flush="true">
	<jsp:param name="bcTitle" value="Tìm kiếm bản đồ -"/>
</jsp:include>
<div id="page"class="bcbanDo">
	<!-- Tim kiem jsp  -->
		<div id="db-main-listing-search">
		<div class="db-main-wrapper">
			<div class="bc_map_lef pull-left">
				<div class="db-search-input">
					<div id="inp_tenTinhThanh"></div>
					<div id="inp_tenDanhMuc"></div>
					<script>
					$( document ).ready(function() {	
						$('#inp_tenTinhThanh').html($('#tenTinhThanh option:selected').text());
						$('#inp_tenDanhMuc').html($('#tenDanhMuc option:selected').text());
					});
					</script>
				</div>
				<a class="bac_tim" href="timKiem.do"><button type="button" class="btn btn-default">Trở lại danh sach</button></a>
				<div class="db-search-controls">
				<html:form action="/banDo" method="get" styleId="db-main-search">
					<!--  <div class="db-main-search">-->
						<div class="clearfix"></div>
						<div class="db-search-custom-fields clearfix">
							<!-- tim kiem 1 -->
							<div class="db-search-row clearfix">
								<!--tim kiem theo khu vuc -->
								<div class="form-group custom-select">
									<html:select onchange="this.form.submit()" property="maTinhThanh" styleId="tenTinhThanh">
										<option value="">-- Chọn khu vực --</option>
										<html:optionsCollection name="timKiemForm" property="listTinhThanh"
										label="tenTinhThanh" value="maTinhThanh" />
									</html:select>		
								</div>
								<!--end tim kiem theo khu vuc -->
								<!--tim kiem theo danh muc -->
								
								<div class="form-group db-search-categories custom-select">
									<html:select onchange="this.form.submit()"  property="maDanhMuc" styleId="tenDanhMuc">
										<option value="">-- Chọn danh mục --</option>
										<html:optionsCollection name="timKiemForm" property="listDanhMuc" 
										label="tenDanhMuc" value="maDanhMuc" />
									</html:select>
								</div>
								<!--end tim kiem theo danh muc -->
								<!--tim kiem theo ten -->
								<div class="form-group">
									<label class="form-group-label" for="listing_address">Tìm theo tên</label>
									<!-- <input type="text" class="db-search-listing_name" placeholder="Listing name" value=""> -->
									<html:text property="noiDung" styleClass="db-search-listing_name" ></html:text>
								</div>
								<!--end tim kiem theo ten -->
							</div>
							<!-- end tim kiem 1 -->
								<!-- tim kiem 2 -->
								<div class="db-search-row clearfix">
									<html:submit styleClass="bc-create-listing bc-button bc-button-invert" >Xem</html:submit>
									<!-- <div class="form-group db-slider-field-wrapper">
										<label class="form-group-label" for="listing_search_radius">Search radius (Kilometers)</label>
										<div class="db-slider-field ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all text-added" data-value=" km">
											<span class="db-slider-left" style="width: 50%;"></span>
											<input type="text" id="listing_search_radius" class="db-search-listing_search_radius" data-default="150" value="150">
											<span class="ui-slider-handle ui-state-default ui-corner-all" tabindex="0" data-value="150 km" style="left: 50%;"></span>
											
										</div>
									</div> -->
								</div>
							</div>
						<!-- </div> -->
						</html:form>
						<!--tim kiem sort -->
					</div>
					<!--Danh sach tin-->
					<!--end danh sach tin--></div>
			<div class="bc_map_rig">
				<div id="db-main-search-map" style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>
				<script>
					function initMap() {
						var myLatLng = {lat: 16.0474325, lng: 108.1712203};
						var zoom=6;
						<logic:equal name="timKiemForm" property="maTinhThanh" value="1">
						var myLatLng = {lat: 16.0474325, lng: 108.1712203};
						var zoom=11;
						</logic:equal>
						<logic:equal name="timKiemForm" property="maTinhThanh" value="2">
						var myLatLng = {lat: 11.9038763, lng: 108.3106383};
						var zoom=11;
						</logic:equal>
						<logic:equal name="timKiemForm" property="maTinhThanh" value="3">
						var myLatLng = {lat: 16.4534748, lng: 107.5419039};
						var zoom=11;
						</logic:equal>
						<logic:equal name="timKiemForm" property="maTinhThanh" value="4">
						var myLatLng = {lat: 10.7680339, lng: 106.4141804};
						var zoom=9;
						</logic:equal>
						<logic:equal name="timKiemForm" property="maTinhThanh" value="5">
						var myLatLng = {lat: 21.0227003, lng: 105.8019443};
						var zoom=11;
						</logic:equal>
						<logic:equal name="timKiemForm" property="maTinhThanh" value="6">
						var myLatLng = {lat: 12.2595881, lng: 109.17073};
						var zoom=11;
						</logic:equal>
						<logic:equal name="timKiemForm" property="maTinhThanh" value="7">
						var myLatLng = {lat: 14.9779335, lng: 108.3790455};
						var zoom=11;
						</logic:equal>
						<logic:equal name="timKiemForm" property="maTinhThanh" value="8">
						var myLatLng = {lat: 17.5043687, lng: 105.7418899};
						var zoom=11;
						</logic:equal>
						var map = new google.maps.Map(document.getElementById('db-main-search-map'), {
					    zoom: zoom,
					    center: myLatLng,
					    mapTypeId: 'roadmap'
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
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- end Tim kiem jsp  -->
	<script>
		$("#sor_ddg").attr("href", $('.sor_ddg a').attr('href'));
	</script>
	<script>
	$('body').show();
	$('.version').text(NProgress.version);
	NProgress.start();
	setTimeout(function() { NProgress.done(); $('.fade').removeClass('out'); }, 1000);
	</script>
	<!-- Modal login-->
	  <div class="modal fade" id="modalLogin" role="dialog">
	    <div class="modal-dialog">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">Đăng nhập</h4>
	        </div>
	        <div class="modal-body">
	          <form name="loginForm" method="post" action="Login.do">
	    			<div class="form-group">
	        			<input type="text" name="userName" value="" id="username" class="form-control" placeholder="Enter username"> <br>
	        		</div>
	        		<div class="form-group">
	        			<input type="password" name="pass" value="" id="pw" class="form-control" placeholder="Enter password"> <br>
	        		</div>
	       			<input type="submit" name="submit" value="Login" class="btn btn-pramery"><br>
	       			<a href="Register.do"><ins>Bạn chưa có tài khoản</ins> Đăng ký</a>
		        </form>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        </div>
	      </div>
	      
	    </div>
	  </div>
	<script>
	function imgError(image) {
	    image.onerror = "";
	    image.src = "img/noimage.png";
	    return true;
	}
	</script>
	<div class="bcOverlay timedMessage" style="top: -100px;left: 0px;position: fixed;">
		<div class="content baseHtml"></div>
	</div>
	<script>
    $('body').show();
    $('.version').text(NProgress.version);
    NProgress.start();
    setTimeout(function() { NProgress.done(); $('.fade').removeClass('out'); }, 1000);
  </script>
</body>
</html>