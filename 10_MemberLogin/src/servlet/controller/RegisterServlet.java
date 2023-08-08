package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPassword(password);
		dto.setName(name);
		dto.setAddress(address);
		
//		MemberDAO dao = new MemberDAO();
		try { //회원가입 성공
			MemberDAO.getInstance().registerMember(dto);
			session.setAttribute("dto", dto);
			response.sendRedirect("AllMemberServlet");
		} catch (SQLException e) {
			//회원가입 실패 한 경우
			System.out.println("회원가입 실패");
			response.sendRedirect("index.jsp");
			
		}
		
		
		

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
