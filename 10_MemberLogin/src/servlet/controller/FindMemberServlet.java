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


public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
	    String id = request.getParameter("id");
		
		
//		MemberDAO dao = new MemberDAO();
//		MemberDTO dto = new MemberDTO();
		try {
			MemberDTO dto = MemberDAO.getInstance().findByIdMember(id);
			
			if(dto!=null) {
				request.setAttribute("dto", dto);
				request.getRequestDispatcher("views/find_ok.jsp").forward(request, response);
			}else {
				response.sendRedirect("views/find_fail.jsp");
			}
	
		} catch (SQLException e) {
	
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
