<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!--Box dang nhap -->
<div class="modal fade" id="bcShowLogin" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content bcShowLogin">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="dc-modal-title">Bắt đầu khám phá</h4>
          <span class="dc-modal-desc">Tiếp cận khách hàng một cách dễ dàng</span>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <html:form action="/Login" method="post">
            <div class="form-group">
             <!--Đăng nhập usrname-->
             <html:text name="accountForm" property="username" styleClass="form-control" styleId="username"/>
            </div>
            <div class="form-group">
              <!--Đăng nhập password-->
              <html:password name="accountForm" property="password" styleClass="form-control" styleId="pw"/>
				<html:errors property="matKhauError"/>
            </div>
              <html:submit value="Login" styleClass="btn btn-danger btn-pramery"/>
              <a href="#" id="bconRegister"><ins>Tôi không phải là thành viên</ins></a>
          </html:form>
		</div>
	</div>
   </div>
</div>
<script>
$(document).ready(function(){
    $("#bcLogin").click(function(){
        $("#bcShowLogin").modal();
    });
    $("#bccrea_login").click(function(){
        $("#bcShowLogin").modal();
    });
    $("#bconRegister").click(function(){
        $("#bcShowLogin").modal('hide');
        $("#bcShowRegister").modal();
    });
    
});
</script>
<!--End Box dang nhap -->
<!--Box dang ky -->
<div class="modal fade" id="bcShowRegister" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content bcShowRegister">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="dc-modal-title">Bắt đầu khám phá</h4>
          <span class="dc-modal-desc">Tiếp cận khách hàng một cách dễ dàng</span>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form role="form">
            <div class="form-group">
             <!--Đăng ký tài khoản-->
              <input type="text" class="form-control" id="username" placeholder="Tài khoản">
            </div>
            <div class="form-group">
             <!--Đăng ký email-->
              <input type="text" class="form-control" id="email" placeholder="Email">
            </div>
            <div class="form-group">
              <!--Đăng ký password-->
              <input type="text" class="form-control" id="password" placeholder="Enter password">
            </div>
            <div class="form-group">
              <!--Đăng ký confirm password-->
              <input type="text" class="form-control" id="cpassword" placeholder="Enter Confirm password">
            </div>
              <button type="submit" class="btn btn-danger btn-default">Đăng Ký</button>
              <a href="#" id="bconLogin"><ins>Tôi đã là thành viên</ins></a>
          </form>
        </div>
      </div>
    </div>
</div> 
<script>
$(document).ready(function(){
    $("#bconLogin").click(function(){
        $("#bcShowRegister").modal('hide');
        $("#bcShowLogin").modal();
    });
});
</script>
<!--End Box dang Ky -->