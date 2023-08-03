package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;


public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletContext context;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		request.setCharacterEncoding("utf-8");		
		response.setContentType("text/html;charset=utf-8");

		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String addr = request.getParameter("addr");
		*/
		
		
		/*
		 * 1. Attribute에 바인딩된 데이터를 받아와서
		 * 2. 웹브라우저로 출력하는 로직을 작성 
		 * */
		
		
		// 1. Attribute에 바인딩된 데이터를 받아와서
		context = getServletContext();
		
		 MemberVO vo = (MemberVO) context.getAttribute("vo");
		     
		     
		// 2. 웹브라우저로 출력하는 로직을 작성 
//	    PrintWriter out = response.getWriter();
//	    out.println("<h2>회원님의 정보를 출력합니다</h2>");
//	    out.println("이름은 : " + vo.getName()+"<br>"+"나이는 : "+vo.getAge()+"<br>"+"주소는 : " +vo.getAddr() );
//		 --> result.jsp로 이동
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
