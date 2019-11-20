package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset = utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("pid");
		out.print("<h2>선택한상품:"+id+"</h2><br>");
		out.print("<a href='" + request.getHeader("referer") + "'>입력화면으로</a>");
	}

}