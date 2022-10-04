<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="app-main__outer">
<h2 style="color:red;"> ${requestScope.message} </h2>
	<div class="app-main__inner">
		<div class="app-page-title">
			<div class="page-title-wrapper">
				<div class="page-title-heading">
					<div class="page-title-icon">
						<img src='<spring:url value="/img/git.png"/>' height="48px" width="50px" style="font-size: 48px; color: red">
					</div>
					<div>
						Add Git Hub Link For Project Monitoring
						<div class="page-title-subheading">
							<form action='<spring:url value="/Student/Add_Git_link"/>' method="post">
							<input type="text" class="form-control" name="link" required>
							<br>
							<button class="btn btn-primary">Save </button>
							</form>
						</div>
					</div>
				</div>
			</div>
</div>

</div>
