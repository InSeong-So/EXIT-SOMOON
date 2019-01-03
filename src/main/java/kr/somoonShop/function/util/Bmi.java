package kr.somoonShop.function.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Bmi extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		action(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		action(request, response);
	}

	protected void action(HttpServletRequest request, HttpServletResponse response) {

		try {
			String a = request.getParameter("a");
			String b = request.getParameter("b");
			System.out.println("a : " + a + ", b : " + b);

			BMIMain bm = new BMIMain();
			int result = 0;

			result = bm.bmi(Integer.parseInt(a), Integer.parseInt(b));

			System.out.println("result : " + result);

			response.setContentType("text/html; charset=UTF-8");

			String html = "<h1>결과값 : " + result + "</h1>";
			html += "<a href='index.html'>계산기로 이동</a>";

			response.getWriter().append(html);

			// 서블렛 자바 메소드 속에서 사용하는 것, Mokito를 이용해서 사용하면 안됨
//			if(check) {
//				request.setAttribute("result", result);		
//				RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
//				rd.forward(request, response);
//			} else {
//				//forward와 다르게 sendRedirect는 a태그와 같은 역할을 한다.
//				response.sendRedirect("index.html");
//			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("종료");
		}

	}
}
