
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="container-fluid">

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Group No</th>
					<th scope="col">Project Tile</th>
					<th scope="col">Action</th>
					

				</tr>
			</thead>
			<tbody><%int count=0; %>
			<c:forEach var="proj" items="${sessionScope.projectsList}">
				<tr>
					<th scope="row"> ${count=count+1} </th>
					<td>${proj.title}</td>
					<td>${proj.details}</td>
					<td><a href='<spring:url value="/Faculty/viewDiscussion?pid=${proj.id}"/>'>View Discussion</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</div>