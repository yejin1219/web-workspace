package pattern.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pattern.controller.Controller;
import pattern.model.NoteBook;
import pattern.model.NoteBookDAO;

public class FindController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 비즈니스 로직 짜기
		
		// 폼값 받아오기
		String model = request.getParameter("model");
		NoteBook notebook = NoteBookDAO.getInstance().findNoteBook(model);
		
		String path = "find_fail.jsp";
		
		if(notebook != null) {
			request.setAttribute("notebook", notebook);
			path = "find_result.jsp";
		}
		return path;
	}

}
