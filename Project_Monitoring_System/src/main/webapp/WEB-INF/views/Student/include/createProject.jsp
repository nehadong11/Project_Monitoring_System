
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<div class="row jumbotron">
			<div class="col-sm-6 form-group">
				<form action='<spring:url value="/Student/createProject"/>' method="post">
					<label for="name-f">Project Title</label> <input type="text"
						class="form-control" name="title" id="title"
						placeholder="Project Title" required>
					<p>${requestScope.nameerror}</p>
			</div>
			<div class="col-lg-12 form-group">
				<label for="name-f">Project Description</label>
				<textarea type="text" class="form-control" name="description"
					id="description" required></textarea>
				<p>${requestScope.nameerror}</p>
			</div>
			<div class="col-sm-12 form-group mb-0">
					<button class="btn btn-primary float-left">Submit</button>
				</div>
		</div>
		</form>

	</div>
	<h2 style="color:green;"> ${requestScope.message}</h2>
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
									href='<spring:url value="/Student/addtogroup?pid=${proj.id}"/>'><button
											type="button" class="btn btn-primary">
											<i class="fa fa-tags">Add to Group</i>
										</button></a> </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
</div>