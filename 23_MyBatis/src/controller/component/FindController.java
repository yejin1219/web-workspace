package controller.component;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.service.StudentService;
import model.vo.StudentVO;

public class FindController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String word = request.getParameter("word");
		List<StudentVO> list = new StudentService().showStudent(word);
		String path = "";
		if(list!=null) {
			request.setAttribute("list",list);
			path = "views/index.jsp";
		}
		return new ModelAndView(path);
	}

}
