<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Answers</title>
</head>
<body background="http://thumbs.dreamstime.com/x/gold-trophy-congratulations-4824479.jpg">
<h3> You answered ${correctAnswers} out of ${numOfQuestions}
</h3>
<h2>Score: ${percent} %
</h2>
<c:forEach var="question" items="${quiz.questions}">
			<h3>
				<c:out value="${question.text}" />
			</h3>
			<c:forEach var="answer" items="${question.answers}">
				<p>
					<input type="radio" disabled="disabled" name="${question.id}" value="${answer.id }" />
					<c:out value="${answer.text }" />
					<c:if test="${answer.isCorrect eq 'Y' .charAt(0) }">
					(Correct)
					</c:if>
							</p>
			</c:forEach>
		</c:forEach>
</body>
</html>