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

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

<!-- modal -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link
	href="http://code.ionicframework.com/ionicons/2.0.0/css/ionicons.min.css"
	rel="stylesheet" type="text/css" />
<!-- Daterange picker -->
<link
	href="../../../../../resources/bootstrap/css/daterangepicker-bs3.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="../../../../../resources/bootstrap/css/AdminLTE.min.css"
	rel="stylesheet" type="text/css" />
<!-- AdminLTE Skins. Choose a skin from the cs/skins 
         folder instead of downloading all of them to reduce the load. -->
<link href="../../../../../resources/bootstrap/css/_all-skins.min.css"
	rel="stylesheet" type="text/css" />
<link href="../../../../../resources/css/table.css"
	rel="stylesheet" type="text/css" />


<script>
	$(document).ready(function() {
		$('#table1').DataTable();
	});
</script>

<style type="text/css">
#InputLastname {
	border-color: red;
}
</style>
</head>
<body>
	<section class="content-header">
		<h1>Thời khóa biểu</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>Trang chủ</a></li>
			<li class="active">Học tập </li>
			<li class="active">Thời khóa biểu</li>
		</ol>
	</section>
	<!--Table  -->
	<section class="content">
	<form:form action="/save" modelAttribute="room">
		<table id="table1" class="display" style="width: 100%">
<colgroup>
       		<col span="1" style="width: 3%;">
       		<col span="1" style="width: 7%;">
       		<col span="1" style="width: 10%;">
       		<col span="1" style="width: 7%;">
       		<col span="1" style="width: 17%;">
       		<col span="1" style="width: 10%;">
       		<col span="1" style="width: 7%;">
       		<col span="1" style="width: 11%;">
       		<col span="1" style="width: 9%;">
       		<col span="1" style="width: 8%;">
       		<col span="1" style="width: 5%;">
       		<col span="1" style="width: 6%;">       		       		       		
    	</colgroup>
			<thead style="background-color: #4876FF; color: white">
				<tr>
					<th>ID</th>
					<th>Ngày</th>
					<th>Tên Giảng Đường</th>
					<th>Tên lớp</th>
					<th>Tên Phòng</th>
					<th>Tên Ca</th>
					<th>Tên Môn</th>
					<th>Tên Giáo Viên</th>
					<th>Thời Gian</th>
				</tr>
			</thead>

			<tbody>
				<c:if test="${not empty List}">
					<c:forEach var="sp" items="${List}">

						<c:url var="updateLink" value="/updatescheduletoform">
							<c:param name="id" value="${sp.id}" />
						</c:url>

						<!-- construct an "delete" link with customer id -->
						<c:url var="deleteLink" value="/deleteschedule">
							<c:param name="id" value="${sp.id}" />
						</c:url>


						<tr style="color: red;">
							<td class="input-id">${sp.id}</td>
								<td class="table-time">${sp.date}</td>
							<td class="table-name">${sp.amphitheater.amphitheaterName}</td>
							<td class="table-name">${sp.classroom.name}</td>
							<td class="table-name">${sp.schoolroom.name}(${sp.schoolroom.schoolroomnumber})</td>
							<td class="table-name">${sp.studyShift.nameShift}</td>
							<td class="table-name">${sp.course.name}</td>
							<td class="table-name">${sp.course.teacher.fname}</td>
							<td class="table-time">${sp.studyShift.startingTime}-${sp.studyShift.endTime}</td>
							
						</tr>

					</c:forEach>
				</c:if>

			</tbody>

		</table>


	</form:form>
	</section>
<!-- </section>
 -->
</body>
</html>
