

<%@page import="com.app.pojos.Admin"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.fun{
background-color: aqua;
font-size: 14px;
font-style: bold;

}
</style>
<div class="content-wrapper">

	<div class="container-fluid">
		<div class="alert alert-primary text-center" role="alert">
			<h1>Student Profile</h1>
		</div>

		<h3
			style="color: green; background-color: white; margin-right: 150px; margin-left: 150px;">${sessionScope.success}</h3>
		<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.erroor}</h3>
		<div class="row">



			<div class="col col-sm-12 col-lg-12">
				<section class="vh-100" style="background-color: #eee;">
					<form action='<spring:url value="/Student/updateProfile"/>' method="post">
						<div class="container">
							<div class="col">
								<div class="card text-black" style="border-radius: 25px;">
									<div class="card-body p-md-5">
										<div class="row justify-content-center">
											<div class="col-md-10 col-lg-12">
												<div class="row jumbotron">
			<div class="col-sm-6 form-group">
					<label for="name-f">PRN</label> <input type="text"
						class="form-control" name="prn" id="prn" value="${sessionScope.userDetails.prn}"
						placeholder="Enter your PRN no" 
						required>
					<p>${requestScope.nameerror}</p>
				</div>
				
				<div class="col-sm-6 form-group">
					<label for="name-f">Course Name</label> <input type="text"
						class="form-control" name="courseName" id="courseName" value="${sessionScope.userDetails.courseName}"
						placeholder="Enter your course Name" 
						required>
					<p>${requestScope.nameerror}</p>
				</div>
				<div class="col-sm-6 form-group">
					<label for="name-f">Course Batch Year</label> <input type="text"
						class="form-control" name="courseBatchYear" id="courseBatchYear" value="${sessionScope.userDetails.courseBatchYear}"
						placeholder="Enter your Course Batch Year" 
						required>
					<p>${requestScope.nameerror}</p>
				</div>
				
				<div class="col-sm-6 form-group">
					<label for="name-f">Course Duration</label> <input type="text"
						class="form-control" name="courseDuration" id="courseDuration"value="${sessionScope.userDetails.courseDuration}"
						placeholder="Enter your course Duration" 
						required>
					<p>${requestScope.nameerror}</p>
				</div>
				<div class="col-sm-6 form-group">
					<label for="name-f">Student Full Name</label> <input type="text"
						class="form-control" name="name" id="name" value="${sessionScope.userDetails.name}"
						placeholder="Enter your full name" oninput="allow_alphabets(this)"
						required>
					<p>${requestScope.nameerror}</p>
				</div>
				<script>
					function allow_alphabets(element) {
						let textInput = element.value;
						textInput = textInput.replace(/[^A-Za-z ]*$/gm, "");
						element.value = textInput;
					}
				</script>

				<div class="col-sm-6 form-group">
					<label for="email">Email</label> <input type="email"
						class="form-control" name="email" id="email" value="${sessionScope.userDetails.sEmail}"
						placeholder="Enter your email." required>
					<p>${requestScope.emailerror}</p>
				</div>
				<div class="col-sm-6 form-group">
					<label for="address-1">Address Line-1</label> <input type="address"
						class="form-control" name="locality" id="locality" value="${sessionScope.userDetails.address.address1}"
						placeholder="Locality/House/Street no." required>
					<p>${requestScope.localityerror}</p>
				</div>
				<div class="col-sm-6 form-group">
					<label for="address-2">Address Line-2</label> <input type="address"
						class="form-control" name="address" id="address" value="${sessionScope.userDetails.address.address2}"
						placeholder="Village/City Name." required>
					<p>${requestScope.addresserror}</p>
				</div>
				<div class="col-sm-4 form-group">
					<label for="State">State</label> <input type="address"
						class="form-control" name="state" id="state" value="${sessionScope.userDetails.address.state}"
						placeholder="Enter your state name." required>
					<p>${requestScope.stateerror}</p>
				</div>
				<div class="col-sm-2 form-group">
					<label for="zip">Postal-Code</label> <input type="zip"
						class="form-control" name="zip" id="zip" value="${sessionScope.userDetails.address.zip}"
						placeholder="Postal-Code." required>
					<p>${requestScope.ziperror}</p>
				</div>
				<div class="col-sm-6 form-group">
					<label for="Country">Country</label> <input type="text"
						name="country" value="${sessionScope.userDetails.address.country}" class="form-control custom-select browser-default">
						
					<p>${requestScope.countryerror}</p>
				</div>
				
				<div class="col-sm-6 form-group">
					<label for="gender">Gender</label> <input type="text" value="${sessionScope.userDetails.gender}" id="gender"
						name="gender" class="form-control browser-default custom-select">
						
					<p>${requestScope.gendererror}</p>
				</div>
				
				<div class="col-sm-4 form-group">
					<label for="tel">Phone</label> <input type="tel" name="mobile"
						class="form-control" id="mobile" value="${sessionScope.userDetails.sMobile}"
						placeholder="Enter Your Contact Number." required>
					<p>${requestScope.mobileerror}</p>
				</div>
				
				

				<div class="col-sm-12 form-group mb-0">
					<button class="btn btn-primary float-right">Submit</button>
				</div>

			</div>
					</form>
			</div>

		</div>
	</div>
</div>
</section>
</div>
</div>
