package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
// jsp3 프로젝트를 시작할 때는 url에 http://localhost:8082/jsp3 직접 입력 또는
// 프로젝트 우클릭 > Run as > Run on Server로 실행!
// 서블릿 : http 프로토콜 요청과 응답을 처리하는 클래스

@WebServlet("/first.dev")		// 요청 url : first.dev 요청을 처리하는 클래스, HttpServlet 상속받음!
public class FirstServlet extends HttpServlet {
	// 서블릿에서는 jsp 내장 객체를 직접 선언해서 사용한다.
	// 그 중에서 request, response는 메소드 인자로 전달받는다.
	private static final long serialVersionUID = 1L;
       
    public FirstServlet() {
    }

    // method 방식 중 GET을 처리한다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메소드");
		
		String temp = request.getParameter("temp");
		System.out.println("temp 파라미터 : " + temp);
		
		// 자바스크립트 또는 html 태그 요소 출력할 때 필요한 설정이 있다.
		// * out 선언 전에 해야 함!
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
			
		// out.print("<br>");의 out 객체 선언
		// 응답을 보내기 위해 만들어지는 객체이다.
		PrintWriter out = response.getWriter();
		
		// session 객체는 로그인에 활용! 선언하기
		// request 객체로 생성한다. (요청이 만들어지는 객체)
		HttpSession session = request.getSession();
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		out.print("<script>");
		out.print("alert('테스트 중입니다.');");
		out.print("</script>");
		// 코딩을 오래할 때는 서버를 중단해놓고 코딩을 하는 것이 좋다. 서버 재시작이 계속 되니까!
	}
	
	
	// method 방식 중 POST를 처리한다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doGet(request, response);
		// doPost로 doGet 메소드를 호출할 수 있다!
	}
	
	// method가 GET, POST 둘 다 처리하는 메소드 : service가 재정의되었을 때, doGet과 doPost는 실행되지 않는다.
/*
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service 메소드");
	}
*/
}
