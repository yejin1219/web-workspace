package servlet.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class idCheckController implements Controller{

	
@Override
public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
	 String id = request.getParameter("id");
	 PrintWriter out = response.getWriter();
	 
	 MemberVO vo = new MemberVO();
	 vo = MemberDAO.getInstance().findByIdMember(id);
				
	 if(vo!=null) {
		 out.print("이 ID는 사용 불가한 아이디입니다.");
	 }else {
		 out.print("이 ID는 사용 가능한 아이디입니다.");
	 }
	return new ModelAndView();
}}
