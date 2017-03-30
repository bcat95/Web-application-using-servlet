<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<jsp:include page="header.do" flush="true"></jsp:include>
	<div id="main" class="site-main container">
		<div id="main-content" class="main-content row">
			<div class="entry-header"><h1 class="entry-title">Thêm mới địa điểm</h1></div>
			<div id="primary" class="content-area sidebar-no clearfix ">
				<div id="content" class="site-content " role="main">
					<!--dang tin-->
					<article id="post-7" class="post-7 page type-page status-publish hentry">
						<h1 class="hidden"></h1>
						<div class="entry-content">
							<div id="entry-content-wrapper" class="clearfix">
								<div class="db-main-wrapper">
								<!--form dang tin-->
								<html:form action="/dangtin.do" method="post" styleId="db-add-listing-form" enctype="multipart/form-data">
									<div class="db-field-row control-group">
										<label for="listing_title">Tiêu đề tin</label>
										<html:text property="tieuDe" styleId="listing_title" styleClass="required"></html:text>
										<div class="alert alert-warning">
											<html:errors property="tieuDeError"/>
										</div>
									</div>
									<div class="db-field-row control-group">
										<label for="listing_content">Nội dung</label>
										<html:textarea property="noiDung" styleId="listing_content" rows="5"></html:textarea>
										<div class="alert alert-warning">
											<html:errors property="noiDungError"/>
										</div>
									</div>
									<div class="db-field-row flexbox">
											<html:select property="maDanhMuc" styleClass="required" style="margin-right: 10px;">
												<html:optionsCollection name="baiDangForm" property="listDanhMuc" label="tenDanhMuc" value="maDanhMuc" />
											</html:select>
											<html:select property="maTinhThanh" styleId="tinhThanh"  styleClass="required">
												<html:optionsCollection name="baiDangForm" property="listTinhThanh" label="tenTinhThanh" value="maTinhThanh" />
											</html:select>
									</div>
									<div class="db-field-row control-group">
										<label class="db-field-row-label" for="listing_address">Địa chỉ</label>
										<html:text property="diaChi" styleId="listing_address" styleClass="required"></html:text>
										<span class="db-autolocate-me"><i class="fa fa-crosshairs" aria-hidden="true"></i></span>
										<div class="alert alert-warning">
											<html:errors property="diaChiError"/>
										</div>
									</div>
									<div id="db-listing-map" style="width: 100%; position: relative;">
										<div id="db-single-listing-map" style="width: 100%; height: 278px; position: relative; overflow: hidden;"></div>
										<script>
										function initAutocomplete() {
										  var map = new google.maps.Map(document.getElementById('db-single-listing-map'), {
										    center: {lat: 16.0474325, lng: 108.1712203},
										    zoom: 5,
										    mapTypeId: 'roadmap'
										  });
										  // Create the search box and link it to the UI element.
										  //var input = document.getElementById('listing_address');
										  var input = document.getElementById('listing_address');
										  var searchBox = new google.maps.places.SearchBox(input);
										 //map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);
										
										  // Bias the SearchBox results towards current map's viewport.
										  map.addListener('bounds_changed', function() {
										    searchBox.setBounds(map.getBounds());
										  });
										
										  var markers = [];
										  // Listen for the event fired when the user selects a prediction and retrieve
										  // more details for that place.
										  searchBox.addListener('places_changed', function() {
										    var places = searchBox.getPlaces();
										    if (places.length == 0) {
										      return;
										    }
										
										    // Clear out the old markers.
										    markers.forEach(function(marker) {
										      marker.setMap(null);
										    });
										    markers = [];
										
										    // For each place, get the icon, name and location.
										    var bounds = new google.maps.LatLngBounds();
										    places.forEach(function(place) {
										      if (!place.geometry) {
										        console.log("Returned place contains no geometry");
										        return;
										      }
										      var icon = {
										        url: place.icon,
										        size: new google.maps.Size(71, 71),
										        origin: new google.maps.Point(0, 0),
										        anchor: new google.maps.Point(17, 34),
										        scaledSize: new google.maps.Size(25, 25)
										      };
										
										      // Create a marker for each place.
										     /*markers.push(new google.maps.Marker({
										        map: map,
										        //icon: icon,
										        title: place.name,
										        draggable: true,
										        position: place.geometry.location
										      })); */
												var myMarker = new google.maps.Marker({
												    position: place.geometry.location,
												    map: map,
												    draggable: true
												});
												var latitude = place.geometry.location.lat().toFixed(7);
												var longitude = place.geometry.location.lng().toFixed(7);
												$("#listing_address_lat").val(latitude);
												$("#listing_address_lng").val(longitude);
												google.maps.event.addListener(myMarker, 'dragend', function(evt){
												    $("#listing_address_lat").val(evt.latLng.lat().toFixed(7));
												    $("#listing_address_lng").val(evt.latLng.lng().toFixed(7));
												});
												google.maps.event.addListener(myMarker, 'dragstart', function(evt){
												    $("#listing_address_lat").val("Loading...");
												    $("#listing_address_lng").val("Loading...");
												});
												if (place.geometry.viewport) {
												  // Only geocodes have viewport.
												  bounds.union(place.geometry.viewport);
												} else {
												  bounds.extend(place.geometry.location);
												}
										    });
										    map.fitBounds(bounds);
										  });
										}
										
										</script>
										<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDyVj9OfaIf5rY7HUFfWKbz_9H2Lef5BBo&libraries=places&callback=initAutocomplete"></script>
									</div>
									<div class="db-map-row control-group control-group-hidden">
										<div class="db-field-row text-added">
											<label class="db-field-row-label" for="listing_address_lat">Vĩ độ</label>
											<html:text property="viDo" styleId="listing_address_lat" value="0" readonly="true"></html:text>
										</div>
										<div class="db-field-row text-added">
											<label class="db-field-row-label" for="listing_address_lng">Kinh độ</label>
											<html:text property="kinhDo" styleId="listing_address_lng" value="0" readonly="true"></html:text>
										</div>
										
									</div>
									<div class="db-field-row control-group bor_row clearfix row">
										<div class="db-field-upload-row col-md-4">
											<div class="db-field-upload-container dropzone-upload dropzone-featured dz-clickable">
												<h3>Ảnh bìa</h3>
												<div class="db-upload-placeholder">
													<html:file property="fileAnhBia" title="chon file" value="file" onchange="readURL(this);" accept="image/*"></html:file>
												</div>
											</div>
											<div class="db-field-upload-container dropzone-upload dropzone-gallery dz-clickable">
												<h3>Thư viện ảnh</h3>
												<div class="db-upload-placeholder">
													<input type="file" name="fileHinhAnh" multiple="multiple" id="gallery-photo-add" accept="image/*" value="file"/>
												</div>
											</div>
											<span class="db-file-upload-hint">Nên sử dụng định dạng ảnh JPG, GIF or PNG, chất lượng ảnh trên 1000x1000 pixels.</span>
										</div>
										<div class="thr_thumb col-md-8">
											<div class="thr_thumb">
												<div class="anhBia col-sm-6 row_w"></div>
												<div class="thr_gallery col-sm-6 row_w"></div>
											</div>
										</div>
									</div>
									<div class="db-field-row control-group db-hop-times-row clearfix row">
										<div id="db-listing-inf" class="col-md-8">
											<div class="db-field-row">
												<label class="db-field-row-label" for="listingphone">Số điện thoại địa điểm</label>
												<html:text property="sDT" styleId="listingphone"></html:text>
											</div>
											<div class="db-field-row">
												<label class="db-field-row-label" for="listingwebsite">Địa điểm website</label>
												<html:text property="diaChiWeb" styleId="listingwebsite"></html:text>
											</div>
										</div>
										<div class="db-map-row thr_inf_rig col-md-4">
												<div class="db-field-row">
													<label class="db-field-row-label" for="tin_gia_min">Giá thấp nhất</label>
													<html:text property="giaThapNhat" styleId="tin_gia_min"></html:text>
													<span id="vie_gia_min"></span>
												</div>
												<div class="db-field-row">
													<label class="db-field-row-label" for="tin_gia_max">Giá cao nhất</label>
													<html:text property="giaCaoNhat" styleId="tin_gia_max"></html:text>
													<span id="vie_gia_max"></span>
												</div>
												<script>
												$( "#tin_gia_min" ).change(function() {
												 	var vie_min=$( "#tin_gia_min" ).val();
												 	var vie_min=vie_min.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1.");
												  $('#vie_gia_min').html(vie_min+" vnđ");
												});
												$( "#tin_gia_max" ).change(function() {
												 	var vie_max=$( "#tin_gia_max" ).val();
												 	var vie_max=vie_max.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1.");
												  $('#vie_gia_max').html(vie_max+" vnđ");
												});
												</script>
										</div>
									</div>
									<div class="db-field-row control-group db-hop-times-row bor_row clearfix">
										<h3>Bao gồm dịch vụ</h3>
										<div class="bcdichvu">
											<logic:iterate id="dichvu" name="baiDangForm" property="listDichVu">
												<span>
													<html:multibox property="dichVu">
														<bean:write name="dichvu" property="maDichVu"/>
													</html:multibox>
													<bean:write name="dichvu" property="tenDichVu"/>
												</span>
											</logic:iterate>
										</div>
									</div>
									<!-- <div class="db-field-row db-hop-times-row clearfix">
										<div id="db-listing-map" style="width: calc(66.66% - 10px); position: relative;">
											<label class="db-field-row-label">Khuyễn Mãi</label>
											<input type="text" name="listing_title" id="listing_title" placeholder="Tiêu đề khuyến mãi" value="">
											<label for="listing_excerpt">Mô tả</label>
											<textarea name="tin_khuyenmai_desc" placeholder="Mô tả về khuyến mãi của bạn" id="tin_khuyenmai_desc"></textarea>
										</div>
										<div class="db-map-row thr_km_inp_rig">
											<div class="db-field-row text-added">
												<label class="db-field-row-label" for="tin_khuyenmai_star">Ngày bắt đầu</label>
												<input type="date" id="tin_khuyenmai_star" name="tin_khuyenmai_star" class="" value="" autocomplete="off">
											</div>
											<div class="db-field-row text-added">
												<label class="db-field-row-label" for="tin_khuyenmai_end">Ngày kết thúc</label>
												<input type="date" id="tin_khuyenmai_end" name="tin_khuyenmai_end" class="" value="" autocomplete="off">
											</div>
										</div>
									</div> -->
									<div class="db-field-row">
										<h3>Gói đăng tin</h3>
										<ul class="db-payment-packages">
											<li data-for="" style="width: 100%; display: none;">
												<p>Vui lòng chọn một gói để xem các đặc quyền!</p>
											</li>
											<li class="" style="">
												<div class="db-package-inner">
													<label for="db-package-1">Cơ Bản</label>
													<div class="db-fee-description">
														<img src="img/home.png" class="db-fee-image">
														<span class="db-fee-value">Miễn Phí</span>
														<div class="db-package-desc">
															<span class="db-fee-pay">Thanh toán một lần</span>
															<span class="db-fee-run-for">Chạy bài đăng trong 10 ngày</span>
															<span class="db-fee-images">Được phép 1 hình ảnh</span>
															<span class="db-fee-sticky">Ảnh bìa</span>
															<span class="db-package-extra">Bao gồm quảng cáo</span>
														</div>
														<%-- <html:submit styleClass="btn btn-primary" property="submit" value="Đăng tin">Thêm mới</html:submit> --%>
														<button type="submit" name="submit" value="dangTin" class="btn btn-primary">Đăng Tin</button>
													</div>
												</div>
											</li>
											<li class="popular">
												<div class="db-package-inner">
													<label for="db-package-1">Không giới hạn</label>
													<div class="db-fee-description">
														<img src="img/house1.png" class="db-fee-image">
														<span class="db-fee-value">$39</span>
														<div class="db-package-desc">
															<span class="db-fee-pay">Thanh toán một lần</span>
															<span class="db-fee-run-for">Bài đăng chạy trong 365 ngày</span>
															<span class="db-fee-images">Được phép 5 hình ảnh</span>
															<span class="db-fee-sticky">Ảnh bìa</span>
															<span class="db-package-extra">Tin ưu tiên</span>
														</div>
														<%-- <html:submit styleClass="btn btn-primary" property="submit" value="Đăng tin">Thêm mới</html:submit> --%>
														<button type="submit" name="submit" value="dangTin" class="btn btn-default">Đăng Tin</button>
													</div>
												</div>
											</li>
											<li class="">
												<div class="db-package-inner">
													<label for="db-package-1">Cao cấp</label>
													<div class="db-fee-description">
														<img src="img/home2.png" class="db-fee-image">
														<span class="db-fee-value">$19</span>
														<div class="db-package-desc">
															<span class="db-fee-pay">Thanh toán một lần</span>
															<span class="db-fee-run-for">Bài đăng chạy trong 60 ngày</span>
															<span class="db-fee-images">Được phép 2 hình ảnh</span>
															<span class="db-fee-sticky">Ảnh bìa</span>
															<span class="db-package-extra">Tin ưu tiên</span>
														</div>
														<input type="hidden" name="userName" value="<bean:write name="taiKhoanForm" property="userName"/>">
														<button type="submit" name="submit" value="dangTin" class="btn btn-primary">Đăng Tin</button>
													</div>
												</div>
											</li>
										</ul>
										<div class="clearfix"></div>
									</div>
								</html:form>
								</div>
							</div>
						</div> 
					</article>
					<!--end dang tin-->
				</div> 
			</div>
		</div>
	</div>
	<script>
		$('#listing_content').jqte();
		$('.alert:not(:has(*))').remove();
	</script>
	<script>
	$(function() {
    // Multiple images preview in browser
    var imagesPreview = function(input, placeToInsertImagePreview) {
        if (input.files) {
        	var filesAmount = input.files.length;
            for (i = 0; i < filesAmount; i++) {
                var reader = new FileReader();
                reader.onload = function(event) {
                    $($.parseHTML('<img>')).attr('src', event.target.result).appendTo(placeToInsertImagePreview);
                }
                reader.readAsDataURL(input.files[i]);
            }
        }

    };
    $('#gallery-photo-add').on('change', function() {
        imagesPreview(this, 'div.thr_gallery');
    });
	});
	</script>
	<script>
	$(document).ready(function(){
		$(".required").after("<span class='required_sys'>*</span>");
		$("#listing_title").attr("placeholder", "Tên địa điểm");
		$("#listing_content").attr("placeholder", "Nội dung bài viết");
		$("#listing_address").attr("placeholder", "Địa chỉ");
		$("#listingphone").attr("placeholder", "Số điện thoại");
		$("#listingwebsite").attr("placeholder", "http://");
		// Form Validation
		$.validator.addMethod("giacao_greater_giathap", function(value, element) {
			return ( $('#tin_gia_max').val() - $('#tin_gia_min').val()) >0
		}, "Giá cao nhất phải lớn hơn giá thấp nhất");
	    $("#db-add-listing-form").validate({
			rules:{
				required:{
					required: true
				},
				tieuDe:{
					required:true,
				},
				noiDung:{
					required:true,
				},
				diaChi:{
					required:true,
				},
				sDT:{
					number: true,
					maxlength: 11,
					minlength: 10
				},
				diaChiWeb:{
					url: true
				},
				giaThapNhat:{
					 number: true,
				},
				giaCaoNhat:{
					number: true,
					giacao_greater_giathap : true
				}
			},
			messages: {
				required: {
				      required: "Vui lòng điền vào trường này.",
				},
				tieuDe:{
					 required: "Vui lòng nhập vào tiêu đề của địa điểm.",
				},
				noiDung:{
					 required: "Vui lòng nhập vào tiêu đề của địa điểm.",
				},
				diaChi:{
					 required: "Vui lòng nhập vào địa chỉ của địa điểm.",
				},
				sDT:{
					number: "Số điện thoại chỉ bao gồm chữ số",
					maxlength: "Số điện thoại không dài hơn 11 số",
					minlength: "Số điện thoại không ngắn hơn 10 số",
				},
				diaChiWeb:{
					url: "Vui lòng nhập vào trang web chính xác.",
				},
				giaThapNhat:{
					number: "Giá chỉ bao gồm chữ số",
				},
				giaCaoNhat:{
					number: "Giá chỉ bao gồm chữ số",
				}
				 
		  	},
			errorClass: "help-inline",
			errorElement: "span",
			highlight:function(element, errorClass, validClass) {
				$(element).parents('.control-group').addClass('error');
			},
			unhighlight: function(element, errorClass, validClass) {
				$(element).parents('.control-group').removeClass('error');
				$(element).parents('.control-group').addClass('success');
			}
		});
	});
	</script>
	<script>
	/* $(document).ready(function(){
		$("#db-add-listing-form").validate();
		

		$("#listing_title").prop('required',true);
		$("#listing_address").prop('required',true);
	}); */
	function readURL(input) {
		if (input.files && input.files[0]) {
            var reader = new FileReader();
	
            reader.onload = function (e) {
            	$(".anhBia").html('<img src="'+event.target.result+'"/>');
            };
            reader.readAsDataURL(input.files[0]);
        }
    }
	</script>
<jsp:include page="template_Footer.jsp"></jsp:include>