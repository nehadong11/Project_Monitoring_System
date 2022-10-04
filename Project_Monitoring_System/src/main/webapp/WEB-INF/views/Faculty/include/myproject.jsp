
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="container-fluid">

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Project Name</th>
					<th scope="col">Project Abstract</th>
					<th scope="col">Git Link</th>

				</tr>
			</thead>
			<tbody><%int count=0; %>
			<c:forEach var="proj" items="${sessionScope.projectsList}">
				<tr>
					<th scope="row"> ${count=count+1} </th>
					<td>${proj.title}</td>
					<td>${proj.details}</td>
					<td><a href='<spring:url value=" ${proj.link} "/>' target="blank">click Here</a> </td>
			
					
				</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</div>