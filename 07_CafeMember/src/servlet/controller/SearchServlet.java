package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAO;
import servlet.model.MemberVO;


public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SearchServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.폼 데이터 받아오기
		String name = request.getParameter("name");
		MemberDAO dao =  new MemberDAO();
		MemberVO vo = null;
		try {
			//2. DAO 리턴 받아서
			 vo =dao.findByNameMember(name);
			//3. 멤버 정보 1개 바인딩 
			 request.setAttribute("vo", vo);
	
		} catch (SQLException e) {
		
			
		}
		
		 
		//4. 네비게이션 -> view.jsp
		 request.getRequestDispatcher("view.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
