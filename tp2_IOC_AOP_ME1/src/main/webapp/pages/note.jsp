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
				<h1 class="page-header">List of Notes</h1>
			</div>
			<div class="col-lg-8">
				<div class="panel panel-default">
					<div class="panel-heading">Notes Management</div>
					<div class="panel-body">
						<!-- /.table-responsive -->
						<div class="table-responsive">
							<table style="cellspacing:20px;">
								<thead>
									<tr>
										<th>noteDate</th>
										<th>noteValue</th>
										<th>Student #</th>
										<th>First Name</th>
										<th>Last Name</th>
										<th>Classroom Name</th>
										<th>module #</th>
										<th>Module name</th>
										<th>Module Type</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${notes}" var="item">
										<tr>
											<td> ${item.noteDate}</td>
											<td> ${item.noteValue}</td>
											
											<td> ${item.student.studentId}</td>
											<td>${item.student.studentFirstName}</td>
											<td> ${item.student.studentLastName}</td>
											<td>${item.student.classroom.classroomName}</td>
											<td> ${item.module.moduleId}</td>
											<td> ${item.module.moduleName}</td>
											<td> ${item.module.moduleType}</td>
											
											<td>
												<f:form method="POST" action="update1note"  >
													<input type="submit" value="Update" class="btn btn-lg btn-success btn-block" />
													<input type="hidden" value="${item.noteDate}" name="cin" />
													
												</f:form>
												<f:form method="POST" action="deletenote" >
													<input type="submit" value="Delete" class="btn btn-lg btn-danger btn-block" />
													<input type="hidden" value="${item.noteDate}" name="id" />
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
			<br/>
			<div class="col-lg-4">
				<div class="panel panel-default">
					<div class="panel-heading">Add or Update Note</div>
					<div class="panel-body">
						<!-- formulaire a ajouter ici -->
						<f:form modelAttribute="note" method="POST"
							action="update2note" commandName="noteToUpdate" >
							<fieldset>
								<div class="form-group">
									<f:input path="noteDate" cssClass="form-control"
										placeholder="noteDate" />
									
								</div>
								<div class="form-group">
									<f:input path="noteValue" cssClass="form-control"
										placeholder="noteValue" />
								</div>
								
								<div class="form-group">
									<f:select path="student.studentId" items="${studentlist}" itemValue="studentId" itemLabel="studentId"/>

			
								</div>
								<!-- 
								<div class="form-group">
									<f:input path="student.classroom.classroomName" cssClass="form-control"
										placeholder="classroomName" />
								</div>
								<div class="form-group">
									<f:input path="student.classroom.classroomId" cssClass="form-control"
										placeholder="classroomId" />
								</div>
								 -->
								<div class="form-group">
									<f:input path="module.moduleId" cssClass="form-control"
										placeholder="moduleId" />
								</div>
								<div class="form-group">
									<f:input path="module.moduleName" cssClass="form-control"
										placeholder="moduleName" />
								</div>
								<div class="form-group">
									<f:select path="module.moduleType" items="${moduleTypelist}" />

			
								</div>
								<div class="form-group">
									<f:input path="module.moduleDuration" cssClass="form-control"
										placeholder="moduleDuration" />
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