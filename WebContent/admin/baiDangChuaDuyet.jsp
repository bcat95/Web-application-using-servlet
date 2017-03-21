<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Admin</title>

    <!-- Bootstrap Core CSS -->
    <link href="admin/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="admin/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="admin/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="admin/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <link href="admin/datatables/jquery.dataTables.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="sidebar.jsp" flush="true"></jsp:include>
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Danh sách bài đăng chưa duyệt
                        </h1>
                    </div>
                    <!-- /.col-lg-12 -->
                    <html:form action="/danhSachBaiDangChuaDuyet" method="get">
                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                            <tr align="center">
                                <th>STT</th>
                                <th>Tiêu đề</th>
                                <th>Danh mục</th>
                                <th>Ngày đăng</th>
                                <th>Xem</th>
                            </tr>
                        </thead>
                        <tbody>
                       <logic:iterate name="danhSachBaiDangDaDuyetForm" property="listBaiDang" id="bd">
                            <tr class="odd gradeX" align="center">
                                <td><bean:write name="bd" property="sTT"/></td>
                                <td><bean:write name="bd" property="tieuDe"/></td>
                                <td><bean:write name="bd" property="tenDanhMuc"/></td>
                                <td><bean:write name="bd" property="ngayDang"/></td>
                                <bean:define id="mbd" name="bd" property="maBaiDang"></bean:define>
                               	<td class="center">
										<html:link action="/xemTinChuaDuyet?maBaiDang=${mbd}">
											<i class="fa fa-pencil fa-fw"></i><span class="db-account-listing-option-hover"> Xem</span>
										</html:link>
								</td>
                            </tr>
                         </logic:iterate>
                        </tbody>
                    </table>
                    </html:form>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="admin/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="admin/bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="admin/dist/js/sb-admin-2.js"></script>

    <!-- DataTables JavaScript -->
    <script src="admin/datatables/jquery.dataTables.min.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>
</body>
</html>
