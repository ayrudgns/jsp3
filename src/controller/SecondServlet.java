package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/second.dev")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SecondServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 모든 Controller에서는 아래 3개의 동작 중 하나로 끝난다. 
		// 1. ** pageContext.forward("second.jsp");		// ~view.jsp 역할을 한다.
		// 2. response.sendRedirect("first.dev");		// 요청 url		-> ThirdServlet 참고
		// 3. 자바스크립트 alert, location.href 실행하기		// 요청 url은 location.href	-> FirstServlet 참고
		
		request.setAttribute("data", "!!! 연습중 !!!");
		request.setAttribute("number", 999);
		request.setAttribute("now", "현재 날짜 시간");
		HttpSession session = request.getSession();
		session.setAttribute("now", LocalDate.now());
		
		
		// 1. ** pageContext.forward("second.jsp");		// ~view.jsp 역할을 한다.		
		// RequestDispatcher 객체는 request, response를 view 페이지에 전달한다.
		RequestDispatcher rd = request.getRequestDispatcher("second.jsp");		// view
		rd.forward(request, response);		// 요청과 응답 전달
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
