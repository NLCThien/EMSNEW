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
	var name = document.myform.InputName.value;
	var number = document.myform.InputNumber.value;
	var statusCk = document.myform.InputStatus.value;
	var price = document.myform.InputPrice.value;
	
	
	var status = false;
	
	if(name.length < 1){
		document.getElementById("checkName").innerHTML = 
            " <span class='fas fa-window-close' style='color:red;'>Vui lòng nhập Tên thiết bị!</span> ";
        status = false;
	}else{
		document.getElementById("checkName").innerHTML = 
            " <span class='fa fa-check-square' style='color:#3FFF00;'></span>";
            status = true;
	}
	
	if(number.length < 1 || number == "0"){
		document.getElementById("checkNumber").innerHTML = 
            " <span class='fas fa-window-close' style='color:red;'>Vui lòng nhập Số lượng!</span> ";
        status = false;
	}else if(!number.match(/^\d+/)){
		document.getElementById("checkNumber").innerHTML = 
            " <span class='fas fa-window-close' style='color:red;'>Số lượng chỉ nhập bằng số!</span> ";
        status = false;
	}else{
		document.getElementById("checkNumber").innerHTML = 
            " <span class='fa fa-check-square' style='color:#3FFF00;'></span>";
	}
	
	if(statusCk.length < 1){
		document.getElementById("checkStatus").innerHTML = 
            " <span class='fas fa-window-close' style='color:red;'>Vui lòng nhập Tình trạng!</span> ";
        status = false;
	}else{
		document.getElementById("checkStatus").innerHTML = 
            " <span class='fa fa-check-square' style='color:#3FFF00;'></span>";
	}
	
	if(price.length < 1){
		document.getElementById("checkPrice").innerHTML = 
            " <span class='fas fa-window-close' style='color:red;'>Vui lòng nhập Giá thành!</span> ";
        status = false;
	}else if(!price.match(/^\d+/)){
		document.getElementById("checkPrice").innerHTML = 
            " <span class='fas fa-window-close' style='color:red;'>Giá thành chỉ nhập bằng số!</span> ";
        status = false;
	}else{
		document.getElementById("checkPrice").innerHTML = 
            " <span class='fa fa-check-square' style='color:#3FFF00;'></span>";
	}
	
	return status;
}
</script>

</head>
<body>
	<section class="content-header">
		<h1>THÔNG TIN</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>Trang chủ</a></li>
			<li class="active">Quản lí CSVC</li>
			<li class="active">Danh sách Thiết Bị</li>
			<li class="active">Cập nhật Thiết Bị</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<!-- Info boxes -->
		<!--Thoi Khoa Bieu -->
		<div class="row">
			<div class="col-md-12">
				<form:form action="/updateFormDevice" modelAttribute="room" onsubmit="return validate()" name="myform">
					<div class="box box-primary">
<!-- 						<img src="../../../../../resources/FileUpload/tri1703.jpg" name=""
							style="width: 200px; height: 200px;"> -->
						<!--form  -->


						<c:if test="${not empty List}">
							<c:forEach var="sp" items="${List}">
								<div class="box-body">
										<input type="hidden" id="custId" name="id" value="${sp.id}" readonly="readonly" >

									<div class="form-group">
										<label for="exampleInputEmail">Tên Thiết bị</label>
										<form:input path="deviceName" value="${sp.deviceName}"
											class="form-control" id="InputName" />
											<span id="checkName"></span>
									</div>
									<div class="form-group">
										<label for="InputPhone">Số Lượng</label>
										<form:input path="amount" value="${sp.amount}" type="text"
											class="form-control" id="InputNumber" />
											<span id="checkNumber"></span>
									</div>
									<div class="form-group">
										<label for="InputPhone">Trạng Thái</label>
										<form:input path="status" value="${sp.status}" type="text"
											class="form-control" id="InputStatus" />
											<span id="checkStatus"></span>
									</div>
									<div class="form-group">
										<label for="InputPhone">Giá Thành</label>
										<div class="input-group">
										<form:input path="price" value="${sp.price}" type="text"
											class="form-control" id="InputPrice" />
											<span class="input-group-addon">VNĐ</span>
										</div>	
										<span id="checkPrice"></span>
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
	<!-- jvectormap -->
	<script
		src="../../../../../resources/js/jquery-jvectormap-1.2.2.min.js"
		type="text/javascript"></script>
	<script
		src="../../../../resources/js/jquery-jvectormap-world-mill-en.js"
		type="text/javascript"></script>
	<!-- daterangepicker -->
	<script src="../../../../../resources/js/daterangepicker.js"
		type="text/javascript"></script>
	<!-- datepicker -->
	<script src="../../../../../resources/js/bootstrap-datepicker.js"
		type="text/javascript"></script>
	<!-- iCheck -->
	<script src="../../../../../resources/js/icheck.min.js"
		type="text/javascript"></script>
	<!-- SlimScroll 1.3.0 -->
	<script src="../../../../../resources/js/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<!-- ChartJS 1.0.1 -->
	<script src="../../../../../resources/js/Chart.min.js"
		type="text/javascript"></script>

	<!-- AdminLTE for demo purposes -->
	<script src="../../../../../resources/js/demo.js"
		type="text/javascript"></script>
</body>
</html>
