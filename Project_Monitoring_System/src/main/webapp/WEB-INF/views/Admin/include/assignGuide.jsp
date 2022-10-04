
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<h3 style="color: green;"> ${requestScope.message} </h3>
		<div class="row jumbotron">
		
			<form action='<spring:url value="/Admin/assignGuide"/>'
					method="post">
			<div class="col-lg-12 form-group">
				<label for="name-f">Select Project</label> <select type="text"
					class="form-control" name="proj" id="proj" required>
					<c:forEach var="proj" items="${sessionScope.projectList}">
						<option value="${proj.id}">${proj.title}</option>
					</c:forEach>
				</select>
				<p>${requestScope.nameerror}</p>
			</div>
			
			<div class="col-lg-12 form-group">
				<label for="name-f">Select Faculty</label> <select type="text"
					class="form-control" name="fac" id="fac" required>
					<c:forEach var="fac" items="${sessionScope.FacultyList}">
						<option value="${fac.id}">${fac.name}</option>
					</c:forEach>
				</select>
				<p>${requestScope.nameerror}</p>
			</div>
			<div class="col-sm-12 form-group mb-0">
				<button class="btn btn-primary float-left">Assign Guide</button>
			</div>
		</div>
		</form>

	</div>

</div>
</div>