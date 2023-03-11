<html>
<head>
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">

				<h1 class="text-center mb-3">Employee Management System</h1>

				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Employee Name</th>
							<th scope="col">Email</th>
							<th scope="col">DOB</th>
							<th scope="col">Age</th>
							<th scope="col">Salary</th>
							<th scope="col">Status</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="employee" items="${employees }">
							<tr>
								<td>${employee.id}</td>
								<td>${employee.name}</td>
								<td>${employee.email}</td>
								<td>${employee.dob}</td>
								<td>${employee.age}</td>
								<td>${employee.salary}</td>
								<td><c:if test="${employee.status}">
								Active
								</c:if> <c:if test="${!employee.status}">
								Inactive
								</c:if></td>



								<td><a href="delete/${employee.id}"><button
											type="button" class="btn btn-danger">Delete</button> </a> <a
									href="update/${employee.id}"><button type="button"
											class="btn btn-success">Update</button> </a></td>


							</tr>
						</c:forEach>
					</tbody>
				</table>

				<div class="container" text="center">
					<a href="add-Employee" class="btn btn-outline-success">Add
						Emplyoee</a>



				</div>


			</div>


		</div>

	</div>
</body>
</html>
