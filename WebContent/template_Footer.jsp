<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<footer class="footer">
		<div class="site-footer-wrapper minimal">
				<div class="footer-bottom-container">
					<div class="footer-bottom-inner">
						<div class="site-footer-container">
							<footer id="colophon" class="site-footer">
								<div id="supplementary">
									<div id="footer-sidebar" class="footer-sidebar widget-area" role="complementary">
										<div class="footer-column-1">
											<aside id="text-2" class="widget widget_text">
												<div class="textwidget">
													<div class="dt-footer-min-logo">
														<img src="img/img_footer-min.png" alt="">
													</div>
													<div class="bc-footer-copyright">Copyright 2017, Directory.<br>All rights reserved
													</div>
												</div>
											</aside>
										</div>
										<div class="footer-column-2">
											<aside id="wysija-2" class="widget widget_wysija">
												<h3 class="widget-title"></h3>
												<div class="widget_wysija_cont">
												</div>
											</aside>
										</div>
										<div class="footer-column-3">
											<aside id="social-widget-2" class="widget widget_socials">
												<p class="socials">
													<a class="social-icon facebook" href="http://facebook.com"><i class="fa fa-facebook" aria-hidden="true"></i></a>
													<a class="social-icon gplus" href="http://plus.google.com"><i class="fa fa-google-plus" aria-hidden="true"></i></a>
													<a class="social-icon linkedin" href="http://linkedin.com"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
													<a class="social-icon twitter" href="http://twitter.com"><i class="fa fa-twitter" aria-hidden="true"></i></a>
												</p>
											</aside>
										</div>
									</div> 
								</div> 
							</footer> 
							<div class="clearfix"></div>
						</div>
						<div class="footer-menu-wrapper">
							<div class="menu-footer-menu-container">
								<ul id="menu-footer-menu" class="footer-menu">
									<li id="menu-item-32" class="">
										<a href="#">Pricing</a>
									</li>
									<li id="menu-item-334" class="">
										<a href="#">Explore</a>
									</li>
									<li id="menu-item-34" class="">
										<a href="#">Blog</a>
									</li>
								</ul>
							</div>
							<div class="clearfix"></div>
						</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</footer>
	<!-- <img src="attachments/{$news.attach.attachment_id}/" alt="" class="entry-thumb" onerror="imgError(this);"/> -->
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