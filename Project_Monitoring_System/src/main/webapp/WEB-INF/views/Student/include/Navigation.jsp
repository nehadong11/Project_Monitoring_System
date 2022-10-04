 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


		<div class="app-main">
			<div class="app-sidebar sidebar-shadow">
				<div class="app-header__logo">
					<div class="logo-src"></div>
					<div class="header__pane ml-auto">
						<div>
							<button type="button"
								class="hamburger close-sidebar-btn hamburger--elastic"
								data-class="closed-sidebar">
								<span class="hamburger-box"> <span
									class="hamburger-inner"></span>
								</span>
							</button>
							
						</div>
					</div>
				</div>
				
				<div class="scrollbar-sidebar">
					<div class="app-sidebar__inner">
						<ul class="vertical-nav-menu">
							<li class="app-sidebar__heading">Dashboards</li>
							<li><a href='<spring:url value="/Student/Dashboard"/>' class="mm-active"> <i class="fa fa-television" style="font-size:20px;color:red"></i> HOME
							</a></li>
							<li class="app-sidebar__heading">Project Monitoring System</li>
							<li><a href="#"> <i class="fa fa-sort-amount-desc"></i>
									Menu <i class="fa fa-sort-amount-asc"></i>
							</a>
								<ul>
									<li><a href='<spring:url value="/Student/createProject"/>'> <i
											class="metismenu-icon"></i> Submit Project Request
									</a></li>
									<li><a href='<spring:url value="/Student/Add_Git_link"/>'> <i
											class="metismenu-icon"></i> Add Git Link
									</a></li>
									<li><a href='<spring:url value="/Student/discussion"/>'> <i
											class="metismenu-icon"> </i> Discussion
									</a></li>
									<li><a href='<spring:url value="/Student/report"/>'> <i
											class="metismenu-icon"> </i> Report
									</a></li>
									
									
								</ul></li>
							
					</div>
				</div>
			</div>

