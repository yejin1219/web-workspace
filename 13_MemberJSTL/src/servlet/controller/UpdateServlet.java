package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
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
		
		
		
		  try {
			MemberDAO.getInstance().updateMember(dto);
			if(session.getAttribute("dto")!=null) {
				session.setAttribute("dto", dto);
			}
			
			request.getRequestDispatcher("views/update_result.jsp").forward(request, response);
//			session에 담았기 때문에 redirect로 보내도 됨
		} catch (SQLException e) {}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
