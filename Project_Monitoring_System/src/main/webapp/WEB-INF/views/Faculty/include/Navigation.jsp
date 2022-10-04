
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
					<li><a href='<spring:url value="/Faculty/Dashboard"/>'
						class="mm-active"> <i class="fa fa-television"
							style="font-size: 20px; color: red"></i> HOME
					</a></li>
					<li class="app-sidebar__heading">Project Monitoring System</li>
					<li><a href="#"> <i class="fa fa-sort-amount-desc"></i>
							Menu <i class="fa fa-sort-amount-asc"></i>
					</a>
						<ul>
							<li><a href='<spring:url value="/Faculty/myproject"/>'>
									<i class="metismenu-icon"></i> My Assigned Projects
							</a></li>
							<li><a href='<spring:url value="/Faculty/groupDiscussion"/>'>
									<i class="metismenu-icon"> </i>View Group Discussion
							</a></li>


							<li class="nav-item" data-toggle="tooltip" data-placement="right"
								title="layout"><a
								class="nav-link nav-link-collapse collapsed"
								data-toggle="collapse" href="#layout"
								data-parent="#exampleAccordion"> <i
									class="fa fa-fw fa-sitemap"></i> <span class="nav-link-text">Action</span>
							</a>
								<ul class="sidenav-second-level collapse" id="layout">
									<li><a href='<spring:url value="/Faculty/addRemark"/>' />
										<i class="fa fa-fw fa-link"> </i>Add Remarks </a></li>
									
									
								</ul></li>




							


						</ul></li>
			</div>
		</div>
	</div>