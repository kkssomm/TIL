package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/move")
public class MoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String text = request.getParameter("action");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(text);
		if(text==null) {
			out.print("<h2>추출된 쿼리 문자열이 없어서 MoveServlet이 직접 응답합니다</h2><br>");
		}
		else {
			System.out.println("RedirectServlet 수행");
			if(text.equals("naver")) {
				response.sendRedirect("http://www.naver.com/");
			}
			if(text.equals("daum")) response.sendRedirect("http://www.daum.net/");
			if(text.equals("google")) response.sendRedirect("http://www.google.com/");
		}
	}

}
