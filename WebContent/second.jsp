<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Second</title>
</head>

<body>
<h3>서블릿에서 저장된 애트리뷰트</h3>
<hr>
<div>애트리뷰트 값을 찾아오는 순서는 pageContext(pageScope) -> requestScope -> sessionScope -> applicationScope</div>
					<!-- 순서대로 찾아봤는데, 없네? => null 출력 -->
data : ${data}<br>
number : ${number}<br>
now : ${ now }<br>
now : ${ sessionScope.now }<br>		<!-- 서블릿에 저장된 애트리뷰트를 찾아올 때, 정확하게 지정해주고 싶은 경우에는 이렇게 써준다! -->
user : ${ user }<br>	<!-- 없는 애트리뷰트 값 출력(null이 아닌 empty), el(표현 언어)로 캐스팅하면서 빈 문자열이 됨. -->
user : <%= session.getAttribute("user") %>		<!-- null 출력 -->
</body>
</html>