<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
</head>
<body>

<!-- tai khoan cap nhat tai khoan -->
					<div class="tab-pane fade">
					<div class="db-account-profile">
						<label class="db-account-title">Thông tin của bạn</label>
						<html:form action="/cap-nhat-thong-tin" method="post" styleId="db-add-listing-form">
						<div class="db-field-row text-added">
							<label for="display_name">Username</label>
							<html:text property="userName" disabled="true"></html:text>
      										<html:errors property="userNameError"/>
						</div>
						<div class="db-field-row text-added">
							<label for="display_name">E-Mail:</label>
							<html:text property="eMail" disabled="true"></html:text>
      										<html:errors property="eMailError"/>
						</div>
						<div class="db-field-row text-added">
							<label for="display_name">PassWord:</label>
							<html:password property="passCu" styleId="pass" value=""></html:password>
      										<html:errors property="passError"/>
						</div>
						<div class="db-field-row text-added">
							<label for="display_name">PassWord New:</label>
							<html:password property="passMoi" styleId="passMoi"></html:password>
      										<html:errors property="passError"/>
						</div>
						<div class="db-field-row text-added">
							<label for="display_name">Confirm PassWord:</label>
							<html:password property="passMoiXN" styleId="passMoiXN"></html:password>
      										<span id="passError"></span>
      										<html:errors property="passError"/>
						</div class="db-field-row text-added">
						<div>
							<button type="submit" name="submit" value="CapNhapPass" class="btn btn-primary">Cap Nhap</button>
							<%-- <html:submit styleClass="btn btn-primary">submit</html:submit> --%>
						</div>
						</html:form>
						</div>
						<div class="clearfix"></div>
						<div styleId="thongBao"></div>
					</div>
					<script type="text/javascript">
					$(document).ready(function(){
						$("#passMoi").bind('keyup mouseup', function () {
							var passCu= $('#pass').val();
							var passMoi = $('#passMoi').val();
							if (passMoi==passCu )
								$("#passError").html("Mật khẩu mới không được trùng với mật khẩu cũ..!");
						});
						$("#passMoiXN").bind('keyup mouseup', function () {
							var passMoi = $('#passMoi').val();
							var xnpassMoi = $('#passMoiXN').val();
							if (passMoi==xnpassMoi )
								$("#passError").html("Ok");
							else
								$("#passError").html("Mật khẩu mới chưa giống nhau !");	
						});
					    });
					});
						
					</script>
					<!-- end tai khoan cap nhat tai khoan -->



</body>
</html>
