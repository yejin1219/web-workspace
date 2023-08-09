package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;
import servlet.model.vo.MemberVO;

@WebServlet(urlPatterns="/front.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청이 어디에서 들어오는 요청인지...command 값 받는다.
		String command = request.getParameter("command");
		String path = "index.jsp"; //경로지정
	     
		try {
			if(command.equals("register")) {
				path = register(request,response);
			}else if(command.equals("login")) {
				path= login(request,response);
			}else if(command.equals("search")) {
				path= findMember(request,response);
			}else if(command.equals("allmember")) {
				path = allMember(request,response);
			}else if(command.equals("update")) {
				path = update(request,response);
			}else if(command.equals("logout")) {
				path = logout(request,response);
			}
	
			
		}catch (SQLException e) {}
			
		// 네비게이션
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	protected String register(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException{

		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO vo = new MemberVO(id,password,name,address);
		
		MemberDAO.getInstance().registerMember(vo);
        return "index.jsp";
		
	}
	
      protected String login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException{

    	 HttpSession session = request.getSession();
  		String id = request.getParameter("id");
  		String password = request.getParameter("password");
  		
  		
  		MemberVO vo = new MemberVO();

  		
  			vo = MemberDAO.getInstance().login(id, password);
  			
  			if(vo!=null) {
  				session.setAttribute("vo", vo);
//  			로그인처럼 상태를 무조건 유지해야하는 경우만 session에 저장
  			// 한번만 호출 할 경우에는 request씀
  			}
  			
  			
  		
  		  return "views/login_result.jsp";
	}
	
      protected String findMember(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException{
    	  String id = request.getParameter("id");
          MemberVO vo = MemberDAO.getInstance().findByIdMember(id);
  			
  			if(vo!=null) {
  				request.setAttribute("vo", vo);
  				return "views/find_ok.jsp";
  			}else {
  				return "views/find_fail.jsp";
  			}
  	
      }
      
      protected String allMember(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException{
    	  ArrayList<MemberVO> list = MemberDAO.getInstance().showAllMember();
    	  
    		  request.setAttribute("list", list);
    		  return "views/allShow.jsp";
  
      }
      
      protected String update(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException, SQLException{
    	  HttpSession session = request.getSession();
  		
  		
  		String id = request.getParameter("id");
  		String password = request.getParameter("password");
  		String name = request.getParameter("name");
  		String address = request.getParameter("address");
  		
  		MemberVO vo = new MemberVO();
  		vo.setId(id);
  		vo.setPassword(password);
  		vo.setName(name);
  		vo.setAddress(address);
  		
  		
  		
  		  
  			MemberDAO.getInstance().updateMember(vo);
  			if(session.getAttribute("vo")!=null) {
  				session.setAttribute("vo", vo);

//  			session에 담았기 때문에 redirect로 보내도 됨
  		
  			}
  			return "views/update_result.jsp";
      }
      
      protected String logout(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException, SQLException{
    	 HttpSession session = request.getSession();
    	 
    	 if(session.getAttribute("vo")!=null) {
    		 session.invalidate();
    		 return "views/logout.jsp";
    	 }
    	  
    	  return "index.jsp"; 
      }
     
}
