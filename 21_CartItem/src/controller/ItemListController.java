package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ItemDAO;

public class ItemListController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList list = new ArrayList<>();
		list = ItemDAO.getInstance().getAllItem();
		String path = "index.jsp";
		if(list != null) {
			request.setAttribute("list", list);
			path = "itemList.jsp";
		}
		return new ModelAndView(path);
	}

}
