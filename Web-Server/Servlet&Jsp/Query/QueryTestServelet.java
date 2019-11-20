package core;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/querytest")
public class QueryTestServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String[] hobby = request.getParameterValues("hobby");

		String[] food = request.getParameterValues("food");
	
		out.print("<h2>전달된 내용</h2>");
		out.print("<hr>");
		out.print("<ul><li>이름 :"+request.getParameter("stname")+"</li>");
		out.print("<li>암호 :"+request.getParameter("pswd")+"</li>");
		out.print("<li>나이 :"+request.getParameter("age")+"</li>");
		out.print("<li>성별 :"+request.getParameter("gender")+"</li>");
		out.print("<li>취미 :");
		if(hobby==null )
			out.print("없음");
		else {
			for(int i=0; i<hobby.length;i++)
					out.print(" "+hobby[i]);
		}
		out.print("</li>");
		out.print("<li>좋아하는 색 :"+request.getParameter("color")+"</li>");
		out.print("<li>좋아하는 음식 :");
		if(food==null )
			out.print("없음");
		else {
			for(int i=0; i<food.length;i++) 
					out.print(" "+food[i]);
		}
		out.print("</li>");
		out.print("의견 :"+request.getParameter("opinion"));
		out.print("<hr>");
		out.print("<a href='" + request.getHeader("referer") + "'>입력화면으로</a>");
		out.close();

	}

}
