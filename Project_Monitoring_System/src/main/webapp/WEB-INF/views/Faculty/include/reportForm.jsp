
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
			<form action='<spring:url value="/Faculty/updateReport"/>' method="post">
				<tr>
				<input type="text" name="rid" value="${sessionScope.report.id}" hidden>
					<th scope="row">1</th>
					<td>Abstract</td>
					<td><input type="text" value="${sessionScope.report.description}" class="form-control" name="description"/></td>
				</tr>
				<tr>
					<th scope="row">2</th>
					<td>SRS</td>
					<td><input type="text" value="${sessionScope.report.srs}" class="form-control" name="srs"/></td>
				</tr>
				<tr>
					<th scope="row">3</th>
					<td>PPT</td>
					<td><input type="text" value="${sessionScope.report.ppt}" class="form-control" name="ppt"/></td>
				</tr>
				<tr>
					<th scope="row">4</th>
					<td>DEMO 1</td>
					<td><input type="text" value="${sessionScope.report.demo1}" class="form-control" name="demo1"/></td>
				</tr>
				<tr>
					<th scope="row">5</th>
					<td>DEMO 2</td>
					<td><input type="text" value="${sessionScope.report.demo2}" class="form-control" name="demo2"/></td>
				</tr>
				<tr>
					<th scope="row">6</th>
					<td>DEMO 3</td>
					<td><input type="text" value="${sessionScope.report.demo3}" class="form-control" name="demo3"/></td>
				</tr>
				<tr>
					<th scope="row">7</th>
					<td>REPORT</td>
					<td><input type="text" value="${sessionScope.report.report}" class="form-control" name="report"/></td>
				</tr>
				<tr>
					<th scope="row">8</th>
					<td>Progress (%)</td>
					<td><input type="text" value="${sessionScope.report.marks}"  class="form-control" name="marks"/></td>
				</tr>
							
				<tr>
					<th scope="row">8</th>
					<td>Action</td>
					<td>  <button class="btn btn-primary">Save Report</button></td>
				</tr>
				
			</tbody>
			
			</form>
		</table>

	</div>
</div>