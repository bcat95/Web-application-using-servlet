<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--sidebar-menu-->

<div id="sidebar"> <a href="#" class="visible-phone"><i class="icon icon-th"></i>Tables</a>
  <ul>
    <li><a href="adminpanel.do"><i class="icon icon-home"></i> <span>Bảng điều khiển</span></a> </li>
    <li><a href="../index.jsp"><i class="icon icon-home"></i> <span>Trang chủ</span></a> </li>
    <li id="danhMuc"><a href="danhMuc.do"><i class="icon icon-signal"></i> <span>Danh mục</span></a> </li>
    <li id="dichVu"><a href="danhSachDichVu.do"><i class="icon icon-play-circle"></i> <span>Dịch vụ</span></a> </li>
    <li id="baiDang" class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>Bài đăng</span></a>
      <ul>
        <li><a href="danhSachBaiDangChuaDuyet.do">Bài đăng chưa duyệt</a></li>
        <li><a href="danhSachBaiDangDaDuyet.do">Bài đăng đã duyệt</a></li>
      </ul>
    </li>
    <li id="taiKhoan" class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>Thành viên</span></a>
      <ul>
        <li><a href="danhSachTaiKhoan.do">Danh sách thành viên</a></li>
        <li><a href="themTaiKhoan.do">Tạo mới tài khoản</a></li>
      </ul>
    </li>
    <li id="lienHe"><a href="danhsachlh.do"><i class="icon icon-play-circle"></i> <span>Danh sách liên hệ</span></a> </li>
  </ul>
</div>