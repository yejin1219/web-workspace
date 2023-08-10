package servlet.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//hidden 값으로 들어온 요청을 받지 않고, 들어온 요청의 주소를 직접 인식시킨다.
		String requestURI = request.getRequestURI();
		System.out.println("RequestURI :: " +requestURI);
		
		String [] requestURILIST = requestURI.split("/");
		System.out.println("RequestURILIST ::" + Arrays.toString(requestURILIST) );
		
		String command = requestURILIST[requestURILIST.length-1];
		System.out.println("Command::" + command);
		
		Controller controller = HandlerMapping.getInstance().createController(command);
		try {
			ModelAndView mv = controller.handle(request, response);
			if(mv!=null) {
				if(mv.isRedirect()) {
				  response.sendRedirect(mv.getPath());	
				}else {
					request.getRequestDispatcher(mv.getPath()).forward(request, response);
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
