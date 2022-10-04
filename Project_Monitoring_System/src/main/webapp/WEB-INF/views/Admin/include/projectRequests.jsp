
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="container-fluid">
		

<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Sr No</th>
							<th scope="col">Student prn</th>
							<th scope="col">Student Name</th>
							<th scope="col">Project Title</th>
							<th scope="col">Project Abstract</th>
							<th scope="col">Status</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<%
						
							int sr_no = 0;
					
						%>
						<c:forEach var="proj" items="${sessionScope.projectRequest}">
							<tr>
								<td scope="row">${sr_no=sr_no+1}</td>
								<td>${proj.createdBy.prn}</td>
								<td>${proj.createdBy.name}</td>
								<td>${proj.title}</td>
								<td>${proj.details}</td>
								<td>${proj.status}</td>
								<td>
								<a
									href='<spring:url value="/Admin/Accept_project?rid=${proj.id}"/>'><button
											type="button" class="btn btn-primary">
											<i class="fa fa-tags"></i>
										</button></a>
								<a
									href='<spring:url value="/Admin/reject_project?rid=${proj.id}"/>'><button
											type="button" class="btn btn-danger">
											<i class="fa fa-tags"></i>
										</button></a> </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
			
	</div>
</div>