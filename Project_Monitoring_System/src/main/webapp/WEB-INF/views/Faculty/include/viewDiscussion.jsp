
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
#chat1 .form-outline .form-control ~.form-notch div {
	pointer-events: none;
	border: 1px solid;
	border-color: #eee;
	box-sizing: border-box;
	background: transparent;
}

#chat1 .form-outline .form-control ~.form-notch .form-notch-leading {
	left: 0;
	top: 0;
	height: 100%;
	border-right: none;
	border-radius: .65rem 0 0 .65rem;
}

#chat1 .form-outline .form-control ~.form-notch .form-notch-middle {
	flex: 0 0 auto;
	max-width: calc(100% - 1rem);
	height: 100%;
	border-right: none;
	border-left: none;
}

#chat1 .form-outline .form-control ~.form-notch .form-notch-trailing {
	flex-grow: 1;
	height: 100%;
	border-left: none;
	border-radius: 0 .65rem .65rem 0;
}

#chat1 .form-outline .form-control:focus ~.form-notch .form-notch-leading
	{
	border-top: 0.125rem solid #39c0ed;
	border-bottom: 0.125rem solid #39c0ed;
	border-left: 0.125rem solid #39c0ed;
}

#chat1 .form-outline .form-control:focus ~.form-notch .form-notch-leading,
	#chat1 .form-outline .form-control.active ~.form-notch .form-notch-leading
	{
	border-right: none;
	transition: all 0.2s linear;
}

#chat1 .form-outline .form-control:focus ~.form-notch .form-notch-middle
	{
	border-bottom: 0.125rem solid;
	border-color: #39c0ed;
}

#chat1 .form-outline .form-control:focus ~.form-notch .form-notch-middle,
	#chat1 .form-outline .form-control.active ~.form-notch .form-notch-middle
	{
	border-top: none;
	border-right: none;
	border-left: none;
	transition: all 0.2s linear;
}

#chat1 .form-outline .form-control:focus ~.form-notch .form-notch-trailing
	{
	border-top: 0.125rem solid #39c0ed;
	border-bottom: 0.125rem solid #39c0ed;
	border-right: 0.125rem solid #39c0ed;
}

#chat1 .form-outline .form-control:focus ~.form-notch .form-notch-trailing,
	#chat1 .form-outline .form-control.active ~.form-notch .form-notch-trailing
	{
	border-left: none;
	transition: all 0.2s linear;
}

#chat1 .form-outline .form-control:focus ~.form-label {
	color: #39c0ed;
}

#chat1 .form-outline .form-control ~.form-label {
	color: #bfbfbf;
}
</style>
<section style="background-color: #eee;">
	<div class="container py-5">

		<div class="row d-flex justify-content-center">
			<div class="col-md-12 col-lg-12 col-xl-12">

				<div class="card" id="chat1" style="border-radius: 15px;">
					<div
						class="card-header d-flex justify-content-between align-items-center p-3 bg-info text-white border-bottom-0"
						style="border-top-left-radius: 15px; border-top-right-radius: 15px;">
						<i class="fas fa-angle-left"></i>
						<p class="mb-0 fw-bold">Discussion</p>
						<i class="fas fa-times"></i>
					</div>
					<div class="card-body">
						<c:forEach var="chat" items="${sessionScope.chatList}">
							<div class="d-flex flex-row justify-content-start mb-4">
								<img
									src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp"
									alt="avatar 1" style="width: 45px; height: 100%;">
								<div class="p-3 ms-3"
									style="border-radius: 15px; background-color: rgba(57, 192, 237, .2);">
									<p class="small mb-0">${chat.from.name} - ${chat.date}</p>
									<b>${chat.msg}</b>
								</div>
							</div>

						</c:forEach>
						<form
							action='<spring:url value="/Student/saveMessage"></spring:url>'
							method="post">
							<!-- <div class="form-outline">
								<textarea class="form-control" id="msg" name="msg" rows="4"></textarea>
								<label class="form-label" for="textAreaExample">Type
									your message</label>
							</div> -->
							<!-- <button class="btn btn-primary" style="margin-left: 40%;">Send</button> -->
					</div>
				</div>
				</form>
			</div>
		</div>

	</div>
</section>