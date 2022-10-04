
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.button {
	float: right; background-color : #4CAF50;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	background-color: #4CAF50;
	text-decoration:  none;
}
</style>
<div class="content-wrapper">
	<div class="container-fluid">

		<div class="alert alert-primary text-center" role="alert">
			<h2>Available Faculty List<a href='<spring:url value="/Admin/addFaculty"/>' class="button">Add
				New </a></h2>
			
		</div>
		<h3
			style="color: green; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.success}</h3>


		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Sr No</th>
							<th scope="col">Name</th>
							<th scope="col">Mobile No</th>
							<th scope="col">Email</th>
							<!-- <th scope="col">Status</th> -->
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<%
							int sr_no = 0;
						%>
						<c:forEach var="faculty" items="${sessionScope.facultyList}">
							<tr>
								<td scope="row">${sr_no=sr_no+1}</td>
								<td>${faculty.name}</td>
								<td>${faculty.mobile}</td>
								<td>${faculty.email}</td>
								<%-- <td>${faculty.status}</td> --%>
								<td><a
									href='<spring:url value="/admin/faculty_status?fid=${faculty.id}"/>'><button
											type="button" class="btn btn-primary">
											<i class="fa fa-tags"></i>
										</button></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>