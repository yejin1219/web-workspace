package member.controller.component;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.dao.MemberDAO;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class AllmemberController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<MemberVO> list = new MemberService().showAllMember();
		
		String path = "index.jsp";
		if(list !=null) {
			request.setAttribute("list", list);
			path = "views/allShow.jsp";
		}
		
		return new ModelAndView(path);
	}

}
