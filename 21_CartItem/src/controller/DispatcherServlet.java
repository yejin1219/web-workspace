package controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.HandlerMapping;
import controller.ModelAndView;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		System.out.println("RequestURI :: " +requestURI);
		
		String [] requestURILIST = requestURI.split("/");
		System.out.println("RequestURILIST ::" + Arrays.toString(requestURILIST) );
		
		String command = requestURILIST[requestURILIST.length-1];
		System.out.println("Command::" + command);
		
		
		
	
		Controller controller = HandlerMapping.getInstance().createController(command);
		try {
			//  3. 해당 컨트롤러의 handle메소드 호출 -> new ModelAndView(path,[true]) 반환
			ModelAndView mv = controller.handle(request, response);
			
			if(mv!=null) { //4. mv 안에  객체가 존재한다면 
				if(mv.isRedirect()) { //4-1. isRedirect 가 true면 네비게이션 sendRedirect 사용
				  response.sendRedirect(mv.getPath());	
				}else {//4-2. false면 네비게이션 getRequestDispatcher 사용
					request.getRequestDispatcher(mv.getPath()).forward(request, response);
				}
			}
		} catch (Exception e) {

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
