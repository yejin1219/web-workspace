package pattern.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
  
	// 실행하는 메소드 딱 하나만 있으면 됨
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	// 비즈니스 로직 작성할 때 request 사용해야 하기 때문에 ↑
}
