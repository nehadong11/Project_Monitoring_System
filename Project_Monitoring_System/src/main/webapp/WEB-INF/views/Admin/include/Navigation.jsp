
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
						<span class="hamburger-box"> <span class="hamburger-inner"></span>
						</span>
					</button>

				</div>
			</div>
		</div>

		<div class="scrollbar-sidebar">
			<div class="app-sidebar__inner">
				<ul class="vertical-nav-menu">
					<li class="app-sidebar__heading">Dashboards</li>
					<li><a href='<spring:url value="/Admin/Dashboard"/>'
						class="mm-active"> <i class="fa fa-television"
							style="font-size: 20px; color: red"></i> HOME
					</a></li>
					<li class="app-sidebar__heading">Project Monitoring System</li>
					<li><a href="#"> <i class="fa fa-sort-amount-desc"></i>
							Menu <i class="fa fa-sort-amount-asc"></i>
					</a>
						<ul>
							<li><a href='<spring:url value="/Admin/registredStudent"/>'>
									<i class="metismenu-icon"></i> Registred Student
							</a></li>
							<li><a href='<spring:url value="/Admin/registredFaculty"/>'>
									<i class="metismenu-icon"> </i> Registred Faculty
							</a></li>

							<li><a href='<spring:url value="/Admin/createGroup"/>' /> <i
								class="metismenu-icon"> </i>Create Group </a></li>
							<li class="nav-item" data-toggle="tooltip" data-placement="right"
								title="layout"><a
								class="nav-link nav-link-collapse collapsed"
								data-toggle="collapse" href="#layout"
								data-parent="#exampleAccordion"> <i
									class="fa fa-fw fa-sitemap"></i> <span class="nav-link-text">Action</span>
							</a>
								<ul class="sidenav-second-level collapse" id="layout">
									<li><a href='<spring:url value="/Admin/projectRequests"/>' />
										<i class="fa fa-fw fa-link"> </i>Project Requests </a></li>
									<li><a href='<spring:url value="/Admin/approvedProject"/>' />
										<i class="fa fa-fw fa-link"> </i>Approved Project </a></li>
									<li><a href='<spring:url value="/Admin/rejectedproject"/>' />
										<i class="fa fa-fw fa-link"> </i>Rejected Project </a></li>
										<li><a href='<spring:url value="/Admin/viewReport"/>' />
										<i class="fa fa-fw fa-link"> </i>View Report </a></li>
								</ul></li>





							<li><a href='<spring:url value="/Admin/assignGuide"/>' /> <i
								class="metismenu-icon"> </i>Assign guide </a></li>


						</ul></li>
			</div>
		</div>
	</div>