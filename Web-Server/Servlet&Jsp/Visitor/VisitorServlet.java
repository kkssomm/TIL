package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visitor")
public class VisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset = utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String text1 = request.getParameter("name");
		String text2 = request.getParameter("opinion");
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DATE);
		out.print("<h2>" + text1 + "님이 " + year + "년 " + month + "월" + date + "일에 남긴 글입니다.</h2>");
		out.print("<hr>");
		out.print(text2);
		out.print("<br>");
		out.print("<a href='" + request.getHeader("referer") + "'>입력화면으로</a>");
		out.close();
	}

}
