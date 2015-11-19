<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Begin Quiz</title>
</head>
<body>
	<h1>${quiz.name}</h1>
	<form action="checkAnswer.do" method="POST">
		<c:forEach var="question" items="${quiz.questions}">
			<h3>
				<c:out value="${question.text}" />
			</h3>
			<c:forEach var="answer" items="${question.answers}">
				<p>
					<input type="radio" name="${question.id}" value="${answer.id }" />
					<c:out value="${answer.text }" />

				</p>
			</c:forEach>
		</c:forEach>
		<h4>
		<input type=submit value="Submit Answers" />
		</h4>
	</form>

</body>
</html>