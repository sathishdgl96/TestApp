<jsp:include page="/nav/sidebar.jsp" />
<body>
	<div class="notice error">
		<p>Verify your email address to attend tests</p>
	</div>
	<div id="maincontent">
	<link href="/css/dashboard.css" rel="stylesheet">
	<script src="/js/dashboard.js"></script>
		<script type="text/javascript"
			src="https://demo.dashboardpack.com/architectui-html-free/assets/scripts/main.js"></script>
		<div class="row">
			<div class="col-md-6 col-xl-4">
				<div class="card mb-3 widget-content bg-midnight-bloom">
					<div class="widget-content-wrapper text-white">
						<div class="widget-content-left">
							<div class="widget-heading">System Clock</div>
							<div class="widget-subheading" id="date-time">_:_:_</div>
						</div>
						<div class="widget-content-right">
							<div class="widget-numbers text-white">
								<span id="today">../../202.</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-xl-4">
				<div class="card mb-3 widget-content bg-arielle-smile">
					<div class="widget-content-wrapper text-white">
						<div class="widget-content-left">
							<div class="widget-heading">Test Completed</div>
							<div class="widget-subheading">Total Test Completed this month</div>
						</div>
						<div class="widget-content-right">
							<div class="widget-numbers text-white">
								<span>568</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-xl-4">
				<div class="card mb-3 widget-content bg-grow-early">
					<div class="widget-content-wrapper text-white">
						<div class="widget-content-left">
							<div class="widget-heading">Upcoming</div>
							<div class="widget-subheading">Scheduled Exams</div>
						</div>
						<div class="widget-content-right">
							<div class="widget-numbers text-white">
								<span>46</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="main-card mb-3 card">
					<div class="card-header">
						Active Exams
						<div class="btn-actions-pane-right">
							<div role="group" class="btn-group-sm btn-group">
								<button class="active btn btn-focus">Upcoming Week</button>
								<button class="btn btn-focus">This Month</button>
							</div>
						</div>
					</div>
					<div class="table-responsive">
						<table
							class="align-middle mb-0 table table-borderless table-striped table-hover">
							<thead>
								<tr>
									<th class="text-center">Subject</th>
									<th>Topic</th>
									<th class="text-center">Date</th>
									<th class="text-center">Status</th>
									<th class="text-center">Actions</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="text-center text-muted" id="subject[0]">Java</td>
									<td>
										<div class="widget-content p-0">
											<div class="widget-content-wrapper">
												<div class="widget-content-left mr-3">
													<div class="widget-content-left">
														<img width="40" class="rounded-circle"
															src="assets/images/avatars/4.jpg" alt="">
													</div>
												</div>
												<div class="widget-content-left flex2">
													<div class="widget-heading" id="qtitle0">Assessment-1</div>
													<div class="widget-subheading opacity-7"id="startat0"> 20/01/2021</div>
												</div>
											</div>
										</div>
									</td>
									<td class="text-center">Madrid</td>
									<td class="text-center">
										<div class="badge badge-warning">Pending</div>
									</td>
									<td class="text-center">
										<button type="button" id="PopoverCustomT-1"
											class="btn btn-primary btn-sm">Details</button>
									</td>
								</tr>
								<tr>
									<td class="text-center text-muted">#347</td>
									<td>
										<div class="widget-content p-0">
											<div class="widget-content-wrapper">
												<div class="widget-content-left mr-3">
													<div class="widget-content-left">
														<img width="40" class="rounded-circle"
															src="assets/images/avatars/3.jpg" alt="">
													</div>
												</div>
												<div class="widget-content-left flex2">
													<div class="widget-heading">Ruben Tillman</div>
													<div class="widget-subheading opacity-7">Etiam sit
														amet orci eget</div>
												</div>
											</div>
										</div>
									</td>
									<td class="text-center">Berlin</td>
									<td class="text-center">
										<div class="badge badge-success">Completed</div>
									</td>
									<td class="text-center">
										<button type="button" id="PopoverCustomT-2"
											class="btn btn-primary btn-sm">Details</button>
									</td>
								</tr>
								<tr>
									<td class="text-center text-muted">#321</td>
									<td>
										<div class="widget-content p-0">
											<div class="widget-content-wrapper">
												<div class="widget-content-left mr-3">
													<div class="widget-content-left">
														<img width="40" class="rounded-circle"
															src="assets/images/avatars/2.jpg" alt="">
													</div>
												</div>
												<div class="widget-content-left flex2">
													<div class="widget-heading">Elliot Huber</div>
													<div class="widget-subheading opacity-7">Lorem ipsum
														dolor sic</div>
												</div>
											</div>
										</div>
									</td>
									<td class="text-center">London</td>
									<td class="text-center">
										<div class="badge badge-danger">In Progress</div>
									</td>
									<td class="text-center">
										<button type="button" id="PopoverCustomT-3"
											class="btn btn-primary btn-sm">Details</button>
									</td>
								</tr>
								<tr>
									<td class="text-center text-muted">#55</td>
									<td>
										<div class="widget-content p-0">
											<div class="widget-content-wrapper">
												<div class="widget-content-left mr-3">
													<div class="widget-content-left">
														<img width="40" class="rounded-circle"
															src="assets/images/avatars/1.jpg" alt="">
													</div>
												</div>
												<div class="widget-content-left flex2">
													<div class="widget-heading">Vinnie Wagstaff</div>
													<div class="widget-subheading opacity-7">UI Designer</div>
												</div>
											</div>
										</div>
									</td>
									<td class="text-center">Amsterdam</td>
									<td class="text-center">
										<div class="badge badge-info">On Hold</div>
									</td>
									<td class="text-center">
										<button type="button" id="PopoverCustomT-4"
											class="btn btn-primary btn-sm">Details</button>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="d-block text-center card-footer">
						<button class="mr-2 btn-icon btn-icon-only btn btn-outline-danger">
							<i class="pe-7s-trash btn-icon-wrapper"> </i>
						</button>
						<button class="btn-wide btn btn-success">Print</button>
					</div>
				</div>
			</div>
		</div>
		
		
		<div class="row">
			<div class="col-md-6 col-lg-3">
				<div
					class="card-shadow-danger mb-3 widget-chart widget-chart2 text-left card">
					<div class="widget-content">
						<div class="widget-content-outer">
							<div class="widget-content-wrapper">
								<div class="widget-content-left pr-2 fsize-1">
									<div class="widget-numbers mt-0 fsize-3 text-danger">71%</div>
								</div>
								<div class="widget-content-right w-100">
									<div class="progress-bar-xs progress">
										<div class="progress-bar bg-danger" role="progressbar"
											aria-valuenow="71" aria-valuemin="0" aria-valuemax="100"
											style="width: 71%;"></div>
									</div>
								</div>
							</div>
							<div class="widget-content-left fsize-1">
								<div class="text-muted opacity-6">Analytical</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-lg-3">
				<div
					class="card-shadow-success mb-3 widget-chart widget-chart2 text-left card">
					<div class="widget-content">
						<div class="widget-content-outer">
							<div class="widget-content-wrapper">
								<div class="widget-content-left pr-2 fsize-1">
									<div class="widget-numbers mt-0 fsize-3 text-success">54%</div>
								</div>
								<div class="widget-content-right w-100">
									<div class="progress-bar-xs progress">
										<div class="progress-bar bg-success" role="progressbar"
											aria-valuenow="54" aria-valuemin="0" aria-valuemax="100"
											style="width: 54%;"></div>
									</div>
								</div>
							</div>
							<div class="widget-content-left fsize-1">
								<div class="text-muted opacity-6">Knowedge</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-lg-3">
				<div
					class="card-shadow-warning mb-3 widget-chart widget-chart2 text-left card">
					<div class="widget-content">
						<div class="widget-content-outer">
							<div class="widget-content-wrapper">
								<div class="widget-content-left pr-2 fsize-1">
									<div class="widget-numbers mt-0 fsize-3 text-warning">32%</div>
								</div>
								<div class="widget-content-right w-100">
									<div class="progress-bar-xs progress">
										<div class="progress-bar bg-warning" role="progressbar"
											aria-valuenow="32" aria-valuemin="0" aria-valuemax="100"
											style="width: 32%;"></div>
									</div>
								</div>
							</div>
							<div class="widget-content-left fsize-1">
								<div class="text-muted opacity-6">Memory</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-lg-3">
				<div
					class="card-shadow-info mb-3 widget-chart widget-chart2 text-left card">
					<div class="widget-content">
						<div class="widget-content-outer">
							<div class="widget-content-wrapper">
								<div class="widget-content-left pr-2 fsize-1">
									<div class="widget-numbers mt-0 fsize-3 text-info">89%</div>
								</div>
								<div class="widget-content-right w-100">
									<div class="progress-bar-xs progress">
										<div class="progress-bar bg-info" role="progressbar"
											aria-valuenow="89" aria-valuemin="0" aria-valuemax="100"
											style="width: 89%;"></div>
									</div>
								</div>
							</div>
							<div class="widget-content-left fsize-1">
								<div class="text-muted opacity-6">Overall</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<script src="http://maps.google.com/maps/api/js?sensor=true"></script>

		
</body>

