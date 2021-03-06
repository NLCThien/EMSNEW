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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<style type="text/css">
body {
	background-color: #e1e1ef;
}

.row.form-info {
	margin-left: 15px;
	margin-top: 10px;
}

.info {
	margin-right: 5px;
	margin-left: 5px;
	border-radius: 3px;
}

hr {
	margin-top: 5px !important;
}

.title {
	margin-top: 10px;
	font-size: 1.2rem;
	font-weight: 500;
	color: #48465b;
}

.role {
	font-size: 13px;
	display: block;
	color: #74788d;
}

.get-info {
	padding-bottom: 0.5rem;
}

.info-student-ct {
	font-size: 20px;
	color: inherit;
	padding-left: 20px;
}

.info.col-sm-3 {
	height: fit-content;
}

.info-student {
	margin-bottom: 20px;
	padding: 10px;
}

.name-parents {
	font-size: 19px;
	font-weight: 500;
}

.info-form-label {
	padding-top: 4px;
	margin-bottom: 0;
	font-size: inherit;
	line-height: 1.5;
}

.form-control {
	font-size: 1rem;
	font-weight: 400;
	color: #495057;
	display: block;
}

.form-control[readonly] {
	background-color: white;
}

.parent-info {
	float: right;
}
</style>
</head>
<body>
	<div class="row form-info">
		<div class="info col-sm-3" style="background-color: white;">
			<div class="title">Thông tin cá nhân</div>
			<hr>
			<div class="info-header row">
				<div class="col-xl-3" style="margin-left: 20px;">
					<svg width="50px" height="50px" viewBox="0 0 16 16"
						class="bi bi-person" fill="currentColor">
  			<path fill-rule="evenodd"
							d="M10 5a2 2 0 1 1-4 0 2 2 0 0 1 4 0zM8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm6 5c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z" />
		</svg>
				</div>
				<div class="col-lg-9 col-xl-8">
					<span class="hidden-xs">
						<div class="name-parents">
							<c:forEach var="sp" items="${List}">${sp.fname} ${sp.lname}
		</c:forEach>
						</div> <a class="role"> Phụ huynh</a>
					</span>
				</div>
			</div>
			<div class="info-body">
				<span class="hidden-xs">
					<div class="get-info">
						<a>Email:</a>
						<div class="parent-info">
							<c:forEach var="sp" items="${List}">${sp.email}
			</c:forEach>
						</div>
					</div>
					<div class="get-info ">
						<a>Số điện thoại:</a>
						<div class="parent-info">
							<c:forEach var="sp" items="${List}">${sp.phone}
			</c:forEach>
						</div>
					</div>
					<div class="get-info ">
						<a>Địa chỉ:</a>
						<div class="parent-info">
							<c:forEach var="sp" items="${List}">${sp.address}
			</c:forEach>
						</div>
					</div>
					<div class="get-info ">
						<a>Ngày sinh:</a>
						<div class="parent-info">
							<c:forEach var="sp" items="${List}">${sp.dob}
			</c:forEach>
						</div>
					</div>
				</span>
			</div>
		</div>
		<div class="info col-sm-8" style="background-color: white;">
			<div class="title">Thông tin sinh viên</div>
			<hr>
			<div class="info-student">
				<div class="row">
					<label class="col-xl-3"></label>
					<div class="col-lg-9 col-xl-6">
						<h3 class="info-student-ct">Thông tin cá nhân sinh viên</h3>
					</div>
				</div>
				<c:if test="${not empty Liststudent}">
					<c:forEach var="sp" items="${Liststudent}">

						<div class="form-info row">
							<label class="col-xl-3 col-lg-3 info-form-label">Họ và
								tên</label>
							<div class="col-lg-9 col-xl-6">
								<input type="text" value="${sp.fname} ${sp.lname}"
									class="form-control" readonly>
							</div>
						</div>
						<div class="form-info row">
							<label class="col-xl-3 col-lg-3 info-form-label">Mã số
								sinh viên</label>
							<div class="col-lg-9 col-xl-6">
								<input type="text" value="${sp.id}" class="form-control"
									readonly>
							</div>
						</div>
						<div class="form-info row">
							<label class="col-xl-3 col-lg-3 info-form-label">Ngày
								sinh</label>
							<div class="col-lg-9 col-xl-6">
								<input type="text" value="${sp.dob}" class="form-control"
									readonly>
							</div>
						</div>
						<div class="form-info row">
							<label class="col-xl-3 col-lg-3 info-form-label">Địa chỉ</label>
							<div class="col-lg-9 col-xl-6">
								<input type="text" value="${sp.address}" class="form-control"
									readonly>
							</div>
						</div>
						<div class="form-info row">
							<label class="col-xl-3 col-lg-3 info-form-label">CMND/Căn
								cước</label>
							<div class="col-lg-9 col-xl-6">
								<input type="text" value="${sp.idcard}" class="form-control"
									readonly>
							</div>
						</div>
						<div class="form-info row">
							<label class="col-xl-3 col-lg-3 info-form-label">Email</label>
							<div class="col-lg-9 col-xl-6">
								<input type="text" value="${sp.email}" class="form-control"
									readonly>
							</div>
						</div>
						<div class="form-info row">
							<label class="col-xl-3 col-lg-3 info-form-label">Trạng
								thái học tập</label>
							<div class="col-lg-9 col-xl-6">
								<input type="text" value="${sp.status}" class="form-control"
									readonly>
							</div>
						</div>
					</c:forEach>
				</c:if>

			</div>
		</div>
	</div>

</body>
</html>
