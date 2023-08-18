package member.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.dao.MemberDAO;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class RegisterController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		
		MemberVO vo = new MemberVO(id,password,name,address);
		  new MemberService().registerMember(vo); // 이때, setAttribute안하는 이유 : 회원가입만 하고 로그인은 따로 하겟다. 
		                                              // 회원가입하는 순간 바로 로그인되는 경우에는 session.setAttribute 로 바인딩 하면됨
		  String path = "index.jsp"; 
		  
		  //데이터 바인딩 - request, session, context
		  // 공통점 :  setAttribute로 바인딩
		  // 차이점
		  //request < -- 요청이 들어오면 응답하는 순간까지에만 사용함 : 범위가 가장 좁음
		  //session < -- 로그인 ~ 로그아웃(invalidate()) 하는 동안까지 사용 
		  //context < -- 서버가 열리는 순간부터 끝날때까지 , 잘안씀 : 범위가 가장 넓음
		   
		return new ModelAndView(path,true);
	}

}
