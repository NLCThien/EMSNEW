<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminLTE 2 | Dashboard</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- Bootstrap 3.3.2 -->
<link href="../../../../../resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<!-- Font Awesome Icons -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link
	href="http://code.ionicframework.com/ionicons/2.0.0/css/ionicons.min.css"
	rel="stylesheet" type="text/css" />
<!-- Morris chart -->
<link href="../../../../../resources/bootstrap/css/morris.css"
	rel="stylesheet" type="text/css" />
<!-- jvectormap -->
<link
	href="../../../../../resources/bootstrap/css/jquery-jvectormap-1.2.2.css"
	rel="stylesheet" type="text/css" />
<!-- Daterange picker -->
<link
	href="../../../../../resources/bootstrap/css/daterangepicker-bs3.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="../../../../../resources/bootstrap/css/AdminLTE.min.css"
	rel="stylesheet" type="text/css" />
<!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
<link href="../../../../../resources/bootstrap/css/_all-skins.min.css"
	rel="stylesheet" type="text/css" />

<script type="text/javascript">
function validate(){
	var dob = document.myform.InputDob.value;
	var email = document.myform.InputEmail.value;
	var phone = document.myform.InputPhone.value;
	var address = document.myform.InputAddress.value;
	var level = document.myform.InputLevel.value;
	var salary = document.myform.InputSalary.value;
	
	var regExp = /^(0[234][0-9]{8}|1[89]00[0-9]{4})$/;
    var atposition = email.indexOf("@");
    var dotposition = email.lastIndexOf(".");
    
	var status = false;
	
	if(dob.length < 1){
		document.getElementById("checkDob").innerHTML = 
            " <span class='fas fa-window-close' style='color:red;'>Vui lòng nhập Ngày sinh!</span> ";
		status = false;
	}else{
		document.getElementById("checkDob").innerHTML = 
            " <span class='fa fa-check-square' style='color:#3FFF00;'></span>";
            status = true;
	}
	
	if(email.length < 1){
		document.getElementById("checkEmail").innerHTML = 
            " <span class='fas fa-window-close' style='color:red;'>Vui lòng nhập Email!</span> ";
        status = false;
	}else if(atposition < 1 || dotposition < (atposition + 2)
            || (dotposition + 2) >= email.length){
		document.getElementById("checkEmail").innerHTML = 
            " <span class='fas fa-window-close' style='color:red;'>Email không đúng định dạng!</span> ";
        status = false;
	}
	else{
		document.getElementById("checkEmail").innerHTML = 
            " <span class='fa fa-check-square' style='color:#3FFF00;'></span>";
	}
	
	if(phone.length < 1){
		document.getElementById("checkPhone").innerHTML = 
            " <span class='fas fa-window-close' style='color:red;'>Vui lòng nhập Số điện thoại!</span> ";
        status = false;
	}else if(phone.length < 9 ||phone.length > 13 ) {
		if(regExp.test(phone)){
			document.getElementById("checkPhone").innerHTML = 
	            " <span class='fa fa-check-square' style='color:#3FFF00;'></span> ";
		}else{
		document.getElementById("checkPhone").innerHTML = 
            " <span class='fas fa-window-close' style='color:red;'>Số điện không đúng định dạng!</span> ";
        status = false;
		}
	}else{
		document.getElementById("checkPhone").innerHTML = 
            " <span class='fa fa-check-square' style='color:#3FFF00;'></span>";
	}
	
	if(address.length<1){
		document.getElementById("checkAddress").innerHTML = 
            " <span class='fas fa-window-close' style='color:red;'>Vui lòng nhập Địa chỉ!</span> ";
        status = false;
	}else{
		document.getElementById("checkAddress").innerHTML = 
            " <span class='fa fa-check-square' style='color:#3FFF00;'></span>";
	}
	
	if(level.length<1){
		document.getElementById("checkLevel").innerHTML = 
            " <span class='fas fa-window-close' style='color:red;'>Vui lòng nhập Cấp độ!</span> ";
        status = false;
	}else if(!level.match(/^\d+/)){
		document.getElementById("checkLevel").innerHTML = 
            " <span class='fas fa-window-close' style='color:red;'>Cấp độ chỉ được nhập số!</span> ";
        status = false;
	}else{
		document.getElementById("checkLevel").innerHTML = 
            " <span class='fa fa-check-square' style='color:#3FFF00;'></span>";
	}
	
	if(salary.length<1){
		document.getElementById("checkSalary").innerHTML = 
            " <span class='fas fa-window-close' style='color:red;'>Vui lòng nhập Lương!</span> ";
        status = false;
	}else if(!salary.match(/^\d+/)){
		document.getElementById("checkSalary").innerHTML = 
            " <span class='fas fa-window-close' style='color:red;'>Lương chỉ được nhập số!</span> ";
        status = false;
	}else{
		document.getElementById("checkSalary").innerHTML = 
            " <span class='fa fa-check-square' style='color:#3FFF00;'></span>";
	}
	
	return status;
}
</script>
</head>
<body>
	<section class="content-header">
		<h1>Lí Lịch Nhân Viên</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>Trang chủ</a></li>
			<li class="active">Quản Lí Nhân Viên</li>
			<li class="active">Danh sách Ninh Viên</li>
			<li class="active">Cập Nhật Nhân Viên</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<!-- Info boxes -->
		<!--Thoi Khoa Bieu -->
		<div class="row">
			<div class="col-md-12">
				<form:form action="/updateTeacher" modelAttribute="teacherNew" enctype="multipart/form-data" onsubmit="return validate()" name="myform">
					<div class="box box-primary">
<!-- 						<img src="../../../../../resources/FileUpload/tri1703.jpg" name=""
							style="width: 200px; height: 200px;"> -->
						<!--form  -->


						<c:if test="${not empty List}">
							<c:forEach var="sp" items="${List}">
							<img src="../../../../../resources/FileUpload/${sp.image}" name=""
							style="width: 120px; height: 160px;">
								<div class="box-body">
									<div class="form-group">
										<input type="hidden" id="id" name="id" value="${sp.id}">
									</div>
									<div class="form-group">
										<label for="exampleInputFile">File input</label>
										<div class="input-group">
											<input type="File" class="form-control" name="files" id="InputImage">
											<span class="input-group-btn">
												<button class="btn btn-default" type="submit">Update
												</button>
											</span>
										</div>
									</div>
									<div class="form-group">
										<label for="exampleInputName">Họ và Tên</label>
										<div class="input-group">
											<span class="input-group-addon">Họ</span>
											<input  class="form-control"
												 value="${sp.lname}" readonly />
											<span class="input-group-addon">Tên</span>
											<input value="${sp.fname}"
												class="form-control" readonly />
										</div>
									</div>
									<!-- 									<script type="text/javascript">
										var date = new Date("03/25/2015");
										document.getElementById("InputDob").value =date;
									</script> -->
									<div class="form-group">
										<label for="InputDob">Ngày sinh</label>
										<form:input path="dob" type="date" class="form-control"
											id="InputDob" min="1980-1-1" max="2020-12-31"
											value="${sp.dob}" />
											<span id="checkDob"></span>
									</div>

									<div class="form-group">
										<label for="exampleInputEmail">Email</label>
										<form:input path="email" value="${sp.email}"
											class="form-control" id="InputEmail" />
											<span id="checkEmail"></span>
									</div>
									<div class="form-group">
										<label for="InputPhone">Số Điện Thoại</label>
										<form:input path="phone" value="${sp.phone}" type="text"
											class="form-control" id="InputPhone" />
											<span id="checkPhone"></span>
									</div>
									<div class="form-group">
										<label for="InputPhone">Địa chỉ</label>
										<form:input path="address" value="${sp.address}" type="text"
											class="form-control" id="InputAddress" />
											<span id="checkAddress"></span>
									</div>
									<div class="form-group">
										<label for="InputPhone">Trạng thái:</label> <label
											id="InputStatus">Học đi</label>
									</div>
									<div class="form-group">
										<label for="InputID">Cấp độ:</label>
										<form:input path="level" value="${sp.level}" class="form-control" id="InputLevel"/>
										<span id="checkLevel"></span>
									</div>
									<div class="form-group">
										<label for="InputID">Lương</label>
										<form:input path="salary" value="${sp.salary}"
											class="form-control" id="InputSalary"/>
											<span id="checkSalary"></span>
									</div>
									<%-- <div clas="form-group">
										<label for="InputID">Phòng Ban:</label>
										<form:select path="depart" items="${sp.depart.name}" />
									</div> --%>
									<div class="form-group">
										<label for="InputID">Phòng Ban:</label>
										<form:select path="depart" class="form-control"
											idxmlns="sel1">
											<c:if test="${not empty Listdp}">
												<c:forEach var="sp" items="${Listdp}">
													<form:option value="${sp.name}" />
													<%--  <form:options items="${Listdp}" /> --%>
												</c:forEach>
											</c:if>
										</form:select>
									</div>
									<%-- 	<div clas="form-group">
										<label for="InputID">Chức vụ</label>
										<form:select path="role" items="" />
									</div> --%>

									<div class="form-group">
										<label for="InputID">Chức vụ</label>
										<form:select path="role" class="form-control"
											idxmlns="sel1">
											<c:if test="${not empty Listr}">
												<c:forEach var="sp" items="${Listr}">
													<option>${sp.roleName}</option>
												</c:forEach>
											</c:if>
										</form:select>
									</div>
								</div>
							</c:forEach>
						</c:if>
					</div>
					<!-- /.box-body -->
					<div class="box-footer">
						<button type="submit" class="btn btn-primary">Xác nhận</button>
					</div>
				</form:form>
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</section>


	<script src="../../../../../resources/js/jQuery-2.1.3.min.js"></script>
	<!-- Bootstrap 3.3.2 JS -->
	<script src="../../../../../resources/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<!-- FastClick -->
	<script src='../../../../../resources/js/fastclick.min.js'></script>
	<!-- AdminLTE App -->
	<script src="../../../../../resources/js/app.min.js"
		type="text/javascript"></script>
	<!-- Sparkline -->
	<script src="../../../../../resources/js/jquery.sparkline.min.js"
		type="text/javascript"></script>
	<!-- SlimScroll 1.3.0 -->
	<script src="../../../../../resources/js/jquery.slimscroll.min.js"
		type="text/javascript"></script>

	<!-- AdminLTE for demo purposes -->
	<script src="../../../../../resources/js/demo.js"
		type="text/javascript"></script>
</body>
</html>
