package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		
		MemberDTO dto = new MemberDTO();
//		MemberDAO dao = new MemberDAO();
		try {
			dto = MemberDAO.getInstance().login(id, password);
			session.setAttribute("dto", dto);
//			로그인처럼 상태를 무조건 유지해야하는 경우만 session에 저장
			// 한번만 호출 할 경우에는 request씀
			
		} catch (SQLException e) {
			
		}
		response.sendRedirect("views/login_result.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
