package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberVO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 서버에 요청하는 순간 무조건 만들어지기 때문에 request로 가져오면 된다.
		// 로그인 했을 때 회원 정보를 계속 가지고 있는 경우 - sesstion, cookie
		// 쿠키는 String으로 문자열로만 저장됨 Session은 객체로 저장할 수 잇음(보안성도 더 좋음)
		
		// 1. 세션을 하나 받아온다. request.getSession()
		HttpSession session = request.getSession();
		
		//2. 폼에 입력된 값을 가지고 객체 생성..MemberVO()
		String id = request.getParameter("id");
		String password = request.getParameter("password");	
		MemberVO vo = new MemberVO(id,password,"김예진","서울");
		//-- DAO 생략..
		
		//3. 세션에 바인딩(쿠키와 달리 객체로 넘길 수 있다.)
		session.setAttribute("vo", vo);
		
		//4. 네비게이션
		PrintWriter out = response.getWriter();
		out.println("<a href=ProductServlet>ProductServlet..</a>");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
