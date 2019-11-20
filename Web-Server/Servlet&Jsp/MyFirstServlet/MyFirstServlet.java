package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myfirst")
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_WEEK);
		String korDay="";
		switch(day) {
		case 1 : korDay = "일"; break;
		case 2 : korDay = "월"; break;
		case 3 : korDay = "화"; break;
		case 4 : korDay = "수"; break;
		case 5 : korDay = "목"; break;
		case 6 : korDay = "금"; break;
		case 7 : korDay = "토"; break;
		}
		response.setContentType("text/html;charset = utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h2>"+name+"님 반가워요.. 오늘은 "+korDay+"요일 입니다.</h2>");
	}

}
