<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
</head>
<body>
<div class="container">

	<center><h1>Add Employee Details</h1></center>
	
	<form action="handle-employee" method="post">
		<div class="form-group">
			<label for="name">Name:</label> <input type="text"
				class="form-control" id="name" name="name" placeholder="Name" required>
		</div>
		<div class="form-group">
			<label for="email">Email:</label> 
			<input type="email"
				class="form-control" id="email" name="email"  placeholder="Email-id"required>
		</div>
		<div class="form-group">
			<label for="do">Date of Birth:</label> 
			<input type="date"
				class="form-control" id="do" name="dob" required>
		</div>
		
		
		<div class="form-group">
			<label for="salary">Salary:</label> 
			<input type="number" 
				class="form-control" id="salary" name="salary"  placeholder="Salary"required>
		</div>
		
		
		<div class="form-group form-check">
			<input type="checkbox" class="form-check-input" id="status"
				name="status" value="true" checked> 
				<label
				class="form-check-label" for="status">Active</label>
		</div>
		
		<pre><button type="submit" class="btn
btn-primary">Save</button>  <a href="${pageContext.request.contextPath}/"
			class="btn btn-secondary">Cancel</a></pre>
	</form>
</div>
</body>
</html>