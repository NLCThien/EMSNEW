<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>EMS | Quản Lí Phòng Học</title>

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



<script>
	$(document).ready(function() {
		$('#table1').DataTable();
	});
</script>

<style type="text/css">
#InputLastname {
	border-color: red;
}

th.image.sorting {
	width: 50px;
}
</style>
</head>

<body>
	<section class="content-header">
		<h1>
			Thêm Mới Giáo Viên
			<button type="button" class="btn btn-info" data-toggle="modal"
				data-target="#myModal">Thêm nhân viên</button>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>Trang chủ</a></li>
			<li class="active">Quản lí nhân viên</li>
			<li class="active">Danh sách Nhân Viên</li>
		</ol>
	</section>
	<!--Modalthemnhanvien-->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<form:form action="/newClassroom" modelAttribute="classroom"
				enctype="multipart/form-data">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Thêm Môn học</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<div>
							<div clas="form-group">
								<label for="InputID">Mã Ngành:</label>
								<form:input type="text" path="id" class="form-control" id="name" />
							</div>
						</div>
						<div>
							<div clas="form-group">
								<label for="InputID">Tên môn học:</label>
								<form:input type="text" path="name" class="form-control"
									id="name" />
							</div>
						</div>
						<div>
							<div clas="form-group">
								<label for="InputID">Chú thích môn:</label>
								<form:input type="text" path="description" class="form-control"
									id="name" />
							</div>
						</div>
						<div>
							<div clas="form-group">
								<label for="InputID">Trạng thái:</label>
								<form:input type="text" path="status" class="form-control"
									id="name" />
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<input type="submit" name="btnsave" class="btn btn-info"
							value="SAVE">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>

				</div>
			</form:form>
		</div>
	</div>

	<!--Table  -->
	<table id="table1" class="display">

		<thead style="background-color: aqua;">
			<tr>
				<th>Mã</th>
				<th>Tên phòng</th>
				<th>Mô tả</th>
				<th>Tình trạng phòng</th>
				<th>Actions</th>
			</tr>
		</thead>

		<tbody>
			<c:if test="${not empty List}">
				<c:forEach var="list" items="${List}">


					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/updateFormCL">
						<c:param name="id" value="${list.id}" />
					</c:url>

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/deleteClassroom">
						<c:param name="id" value="${list.id}" />
					</c:url>

					<tr>
						<td>${list.id}</td>
						<td>${list.name}</td>
						<td>${list.description}</td>
						<td>${list.status}</td>
						<td>
							<div class="btn-group" role="group" aria-label="Basic example">
								<button type="button" class="btn btn-info"
									onclick="location.href='${updateLink}';">Update</button>
								<button type="button" class="btn btn-danger"
									onclick="location.href='${deleteLink}';">Del</button>
							</div>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>

</body>

</html>