<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Quiz</title>
</head>
<body>
	<center>
		<h1>Edit a Quiz</h1>
	</center>
	<form action="addQuiz.do" method="post">
		<p>
			Select a Quiz <select name="quizzes">
		</p>
		<option value="states">States and Capitals</option>
		</select> <br />

		<p>
			Question: <input name="question" type="text">

		</p>
		<p>
			Answer Option1: <input name="answer1" type="text"> <input
				name="response1" type="text"> Correct Answer Y/N ?

		</p>
		<p>
			Answer Option3: <input name="answer2" type="text"> <input
				name="response2" type="text"> Correct Answer Y/N ?
		</p>
		<p>
			Answer Option3: <input name="answer3" type="text"> <input
				name="response3" type="text"> Correct Answer Y/N ?
		</p>
		<p>
			Answer Option4: <input name="answer4" type="text"> <input
				name="response4" type="text"> Correct Answer Y/N ?
		</p>
		<button type=submit>Submit Question</button>
	</form>
	<c:if test="${!empty newQuestion }">
		<p>
			You added the following Question<br /> ${newQuestion.text}<br />
			<c:forEach var="answers" items="${newQuestion.answers}">
				<p>
					<c:out value="${answers.text }" />
				</p>
			</c:forEach>
	</c:if>

</body>
</html>