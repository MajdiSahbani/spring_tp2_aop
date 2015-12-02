<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Welcome ${loggedStudent.studentFirstName} ${loggedStudent.studentLastName} in your home page</title>
<link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/dist/css/sb-admin-2.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="container">
		
		<div class="row">
			<center>hello ${loggedStudent.studentFirstName} ${loggedStudent.studentLastName}</center>
			<div class="col-lg-12">
				<h1 class="page-header">List of Students</h1>
			</div>
			<div class="col-lg-8">
				<div class="panel panel-default">
					<div class="panel-heading">Student Management</div>
					<div class="panel-body">
						<!-- /.table-responsive -->
						<div class="table-responsive">
							<table style="cellspacing:20px;">
								<thead>
									<tr>
										<th>#</th>
										<th>First Name</th>
										<th>Last Name</th>
										<th>Classroom Name</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${students}" var="item">
										<tr>
											<td> ${item.studentId}</td>
											<td>${item.studentFirstName}</td>
											<td> ${item.studentLastName}</td>
											<td>${item.classroom.classroomName}</td>
											<td>
												<f:form method="POST" action="update1"  >
													<input type="submit" value="Update" class="btn btn-lg btn-success btn-block" />
													<input type="hidden" value="${item.studentId}" name="cin" />
													
												</f:form>
												<f:form method="POST" action="delete" >
													<input type="submit" value="Delete" class="btn btn-lg btn-danger btn-block" />
													<input type="hidden" value="${item.studentId}" name="id" />
												</f:form>
												<f:form method="POST" action="note" >
													<input type="submit" value="Notes" class="btn btn-lg btn-danger btn-block" />
													<input type="hidden" value="${item.studentId}" name="StudentOfNotes" />
												</f:form>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						
						
					</div>
				</div>
			</div>
			<br/>
			<div class="col-lg-4">
				<div class="panel panel-default">
					<div class="panel-heading">Add or Update Student</div>
					<div class="panel-body">
						<!-- formulaire a ajouter ici -->
						<f:form modelAttribute="student" method="POST"
							action="update2" commandName="studentToUpdate" >
							<fieldset>
							
								<div class="form-group">
									<f:input path="studentFirstName" cssClass="form-control"
										placeholder="Firstname" />
								</div>
								<div class="form-group">
									<f:input path="studentLastName" cssClass="form-control"
										placeholder="Lastname" />
								</div>
								<div class="form-group">
									<f:input path="studentId" cssClass="form-control"
										placeholder="studentId" />
								</div>
								<div class="form-group">
									<f:input path="classroom.classroomName" cssClass="form-control"
										placeholder="classroomName" />
								</div>
								<div class="form-group">
									<f:input path="classroom.classroomId" cssClass="form-control"
										placeholder="classroomId" />
								</div>
								<input type="submit" value="Add/Update"
									class="btn btn-lg btn-success btn-block" />
									
							</fieldset>
						</f:form>
						
					</div>
				</div>
			</div>
			
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/resources/bower_components/jquery/dist/jquery.min.js" />
	<script
		src="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js" />
	<script
		src="${pageContext.request.contextPath}/resources/bower_components/metisMenu/dist/metisMenu.min.js" />
	<script
		src="${pageContext.request.contextPath}/resources/dist/js/sb-admin-2.js" />
</body>

</html>