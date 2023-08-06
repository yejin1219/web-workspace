package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAO;
import servlet.model.MemberVO;

/**
 * Servlet implementation class ViewMemberServlet2
 */
public class ViewMemberServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. DAO 리턴 받기	
		MemberDAO dao =  new MemberDAO();
		ArrayList<MemberVO> list = null;
		try {
			
//					dao.showALLMember();
			
			//2. 바인딩
			list=dao.showALLMember();
			
			request.setAttribute("list",list);
		} catch (SQLException e) {
			
		}
		
		//3. 네비게이션 --> result.jsp
		 request.getRequestDispatcher("result.jsp").forward(request, response);
		 
		 //response.sendRedirect: 클라이언트 측에서 새로운 URL로 이동하도록 요청합니다.
		// request.getRequestDispatcher("").forward(request, response): 서버 내에서 다른 서블릿 또는 JSP로 요청과 응답을 전달하여 서버 내에서 페이지를 전환합니다.
	}

	

}
