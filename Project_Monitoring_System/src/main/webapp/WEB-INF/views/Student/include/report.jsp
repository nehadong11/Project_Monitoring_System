
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="container-fluid">

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Activity</th>
				
					<th scope="col">Status</th>

				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">1</th>
					<td>Abstract</td>
					<td>${sessionScope.userDetails.projectGroup.report.description}</td>
				</tr>
				<tr>
					<th scope="row">2</th>
					<td>SRS</td>
					<td>${sessionScope.userDetails.projectGroup.report.srs}</td>
				</tr>
				<tr>
					<th scope="row">3</th>
					<td>PPT</td>
					<td>${sessionScope.userDetails.projectGroup.report.ppt}</td>
				</tr>
				<tr>
					<th scope="row">4</th>
					<td>DEMO 1</td>
					<td>${sessionScope.userDetails.projectGroup.report.demo1}</td>
				</tr>
				<tr>
					<th scope="row">5</th>
					<td>DEMO 2</td>
					<td>${sessionScope.userDetails.projectGroup.report.demo2}</td>
				</tr>
				<tr>
					<th scope="row">6</th>
					<td>DEMO 3</td>
					<td>${sessionScope.userDetails.projectGroup.report.demo3}</td>
				</tr>
				<tr>
					<th scope="row">7</th>
					<td>REPORT</td>
					<td>${sessionScope.userDetails.projectGroup.report.report}</td>
				</tr>
				<tr>
					<th scope="row">8</th>
					<td>Progress (%)</td>
					<td>${sessionScope.userDetails.projectGroup.report.marks}</td>
				</tr>
				<tr>
					<th scope="row">9</th>
					<td>Git Link</td>
					<td><a href='<spring:url value=" ${sessionScope.userDetails.projectGroup.project.link} "/>' target="blank">click Here</a> </td>
				</tr>
			</tbody>
		</table>

	</div>
</div>