package servlet.controller.component;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class FindController implements Controller{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String id = request.getParameter("id");
		
		MemberVO vo = MemberDAO.getInstance().findByIdMember(id);
		String path = "find.jsp";
		
		if(vo!=null) {
			request.setAttribute("vo", vo);
			path = "find_ok.jsp";
		}else {
			path = "find_fail.jsp";
		}
		
		return path;
	}

	
	
}
