<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="changeQuizName.do" method="post">
<input type="text" name="name" placeholder="Enter a new name">
Change the name of the quiz
<button type="submit"> Submit </button>

</form>
<h1>${newQuizName} </h1>
</body>
</html>