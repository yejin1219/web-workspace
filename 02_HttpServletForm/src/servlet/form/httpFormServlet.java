package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class httpFormServlet
 */
public class httpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		/*
		 * 한글 처리는 양방향을 다 해줘야함!(request, response)
		 * 
		 * */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		String id = request.getParameter("userId");
//		Parameter 안에 들어가는 것 : key (=name)
		String password = request.getParameter("userPwd");
		
		
		PrintWriter out = response.getWriter();
		String gender = request.getParameter("gender");
		out.println("<h2>정보 출력,,</h2>");
		out.println("<p>당신의 아이디는 : " + id + "</p>");
		out.println("<p>당신의 비밀번호는 : " + password + "</p>");
	
		// 당신의 성별을 --> form.html 라디오 사용!		
		out.println("<p>당신의 성별은 "+(gender.charAt(0)=='M' ? "남자" : "여자") +"</p>");
				
		
		out.println("<ul>");
		String[] menulist = request.getParameterValues("menu");
		for(String menu : menulist) {
			out.println("<li> " + menu + "<li>");
		}
		out.println("</ul>");
		
		
		
		
		out.close();
		
	}

}
