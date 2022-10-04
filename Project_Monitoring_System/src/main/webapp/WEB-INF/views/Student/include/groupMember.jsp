
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
			Project Group Members
			<c:forEach var="member" items="${sessionScope.groupMembers}">
				<h3>${member.prn} - ${member.name} - ${member.sMobile}</h3>
			</c:forEach>
		</div>