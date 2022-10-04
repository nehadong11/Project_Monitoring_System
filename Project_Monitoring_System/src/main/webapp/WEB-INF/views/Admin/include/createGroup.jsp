
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<div class="row jumbotron">
			<div class="col-sm-6 form-group">
			<p Style="color:red;">${requestScope.message}</p>
				<form action='<spring:url value="/Admin/createGroup"/>' method="post">
					<label for="name-f">Group No</label> <input type="text"
						class="form-control" name="groupNo" id="groupNo"
						placeholder="Group No" required>
					<p>${requestScope.nameerror}</p>
			</div>
			<div class="col-lg-12 form-group">
				<label for="name-f">Student 1</label>
				<select type="text" class="form-control" name="std1"
					id="std1" required>
					<option>---select Student----</option>
					<c:forEach var="std" items="${sessionScope.studentList}">
					<option value="${std.id}">${std.prn} - ${std.name} </option>
					</c:forEach>
					</select>
				<p>${requestScope.nameerror}</p>
			</div>
			<div class="col-lg-12 form-group">
				<label for="name-f">Student 2</label>
				<select type="text" class="form-control" name="std2"
					id="std2" required>
					<option value= "0" >---select Student----</option>
					<c:forEach var="std2" items="${sessionScope.studentList}">
					<option value="${std2.id}">${std2.prn} - ${std2.name}</option>
					</c:forEach>
					</select>
				<p>${requestScope.nameerror}</p>
			</div>
			<div class="col-lg-12 form-group">
				<label for="name-f">Student 3</label>
				<select type="text" class="form-control" name="std3"
					id="std3" required>
					<option value= "0" >---select Student----</option>
					<c:forEach var="std" items="${sessionScope.studentList}">
					<option value="${std.id}">${std.prn} - ${std.name}</option>
					</c:forEach>
					</select>
				<p>${requestScope.nameerror}</p>
			</div>
			<div class="col-lg-12 form-group">
				<label for="name-f">Student 4</label>
				<select type="text" class="form-control" name="std4"
					id="std4" required>
					<option value= "0" >---select Student----</option>
					<c:forEach var="std" items="${sessionScope.studentList}">
					<option value="${std.id}">${std.prn} - ${std.name}</option>
					</c:forEach>
					</select>
				<p>${requestScope.nameerror}</p>
			</div>
			<div class="col-sm-12 form-group mb-0">
					<button class="btn btn-primary float-left">Submit</button>
				</div>
		</div>
		</form>

	</div>
	
	<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Sr No</th>
							<th scope="col">Project Title</th>
							<th scope="col">Status</th>
						
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<%
						
							int sr_no = 0;
					
						%>
						<c:forEach var="proj" items="${sessionScope.myproject}">
							<tr>
								<td scope="row">${sr_no=sr_no+1}</td>
								
								<td>${proj.title}</td>
								<td>${proj.status}</td>
								<td><a
									href='<spring:url value="/admin/student_status?sid=${proj.id}"/>'><button
											type="button" class="btn btn-primary">
											<i class="fa fa-tags"></i>
										</button></a> </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
</div>