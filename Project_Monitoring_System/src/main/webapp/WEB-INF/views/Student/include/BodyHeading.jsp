<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="app-main__outer">
	<div class="app-main__inner">
		<div class="app-page-title">
			<div class="page-title-wrapper">
				<div class="page-title-heading">
					<div class="page-title-icon">
						<i class="fa fa-mortar-board" style="font-size: 48px; color: red"></i>
					</div>
					<div>
						Project Monitoring System
						<div class="page-title-subheading">
							<h3>Project Name:
								${sessionScope.userDetails.projectGroup.project.title}</h3>
							<h3>Project Guide:
								${sessionScope.userDetails.projectGroup.project.guide.name}</h3>
							<h4>Abstract:
								${sessionScope.userDetails.projectGroup.project.details}</h4>
						</div>
					</div>
				</div>
			</div>
</div>

</div>
