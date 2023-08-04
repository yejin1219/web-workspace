package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAO;
import servlet.model.MemberVO;

/*
 * 회원 가입하면,, 정보를 바탕으로
 * MemberVO를 생성 ..ArrayList에 추가
 * ArrayList를 통째로 ServletContext에 바인딩
 * 출력 결과는 viewMember.jsp 페이지에서 
 * */
public class EntranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private ServletContext context;
//	List<MemberVO> list = Collections.synchronizedList(new ArrayList<MemberVO>());

	/*
	public void init(ServletConfig config) throws ServletException {
		
		context = config.getServletContext();   //config 명시해줘야 함
		context.setAttribute("list", list); 
	}
*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setAttribute("list", list);
		
		
		String name = request.getParameter("name");
		int age = request.getParameter("age")!=null ? Integer.parseInt(request.getParameter("age")) : 0;
		String addr = request.getParameter("addr");
		
		
		MemberVO vo = new MemberVO(name, age, addr);
		System.out.println("2. vo생성");
//		list.add(vo);
		
		
		// 3.DAO로 데이터 전송(DAO연결)
        MemberDAO dao =  new MemberDAO();
        try {
			dao.insertMember(vo);
		} catch (SQLException e) {
			
		}
		
		
		//4. 내비게이션 --> viewMemberServlet으로 
//		RequestDispatcher rdp = request.getRequestDispatcher("result.jsp");
//		rdp.forward(request, response); // 이때 위에서 설정한 페이지로 이동 
//       RequestDispatcher rdp = request.getRequestDispatcher("ViewMemberServlet");
//		rdp.forward(request, response); --> forward : 응답을 계속 다음으로 넘기는 것
		response.sendRedirect("view2"); // --> 바로 내가 응답처리할게 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
