	

<%@page import="com.app.pojos.Admin"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content-wrapper">
	
		<div class="container-fluid">
			<div class="alert alert-primary text-center" role="alert">
				<h1>Add New Faculty</h1>
			</div>

			<h3
				style="color: green; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.success}</h3>
			<h3
				style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.erroor}</h3>
			<div class="row">

				
	
	<div class="col col-sm-12 col-lg-12">
		<section class="vh-100" style="background-color: #eee;">
			<form action='<spring:url value="/Admin/addFaculty"/>' method="post">
				<div class="container">
					<div class="col">
						<div class="card text-black" style="border-radius: 25px;">
							<div class="card-body p-md-5">
								<div class="row justify-content-center">
									<div class="col-md-12 col-lg-12">
										<div class="row row-lg-12">
											<div class="col col-lg-6 mb-4">
												<div class="form-outline flex-fill mb-0">
													<label class="form-label">First Name </label> <input
														 type="text"
														name="fname" class="form-control col-lg-12 text-center" />
												</div>
											</div>
										
											<div class="col col-lg-6 mb-4">
												<div class="form-outline flex-fill mb-0">
													<label class="form-label">Last Name</label> <input
													 type="text"
														name="lname" class="form-control col-lg-12" />
												</div>
											</div>


											
										</div>
										<div class="row">
										<div class="col col-lg-6 mb-4">
												<div class="form-outline flex-fill mb-0">
													<label class="form-label">Email </label> <input
														 type="email"
														name="email" class="form-control col-lg-12" />
												</div>
											</div>
											<div class="col col-lg-6 mb-4">
												<div class="form-outline flex-fill mb-0">
													<label class="form-label">Mobile </label> <input
														type="text"
														name="mobile" class="form-control col-lg-12" />
												</div>
											</div>


											
										</div>
										

										</div>

										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
											<input type="submit" class="btn btn-primary btn-lg"
												value="Register Faculty">
										</div>
			</form>
	</div>

</div>
</div>
</div>
</section>
</div>
</div>
