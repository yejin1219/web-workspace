package servlet.controller;

import servlet.controller.component.AllmemberController;
import servlet.controller.component.FindController;
import servlet.controller.component.LoginController;
import servlet.controller.component.LogoutController;
import servlet.controller.component.RegisterController;
import servlet.controller.component.UpdateController;

// ControllerFactory 랑 하는 역할 같음 이름만 바뀜
public class HandlerMapping {

	// 1. HandlerMapping 객체 생성 
	private static HandlerMapping handler = new HandlerMapping();
	
	// 2. 빈 생성자 
	private HandlerMapping() {}
	
	//3. handler 반환하는 getInstance() 메소드 
	public static HandlerMapping getInstance() {
		return handler;
	}
	//4. controller 만들어 내는 메소드 
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("find.do")) {
			controller = new FindController();
		}else if(command.equals("login.do")) {
			controller= new LoginController();
		}else if(command.equals("register.do")) {
			controller= new RegisterController();
		}else if(command.equals("update.do")) {
			controller = new UpdateController();
		}else if(command.equals("allmember.do")) {
			controller = new AllmemberController();
		}else if(command.equals("logout.do")) {
			controller = new LogoutController();
		}
		
		return controller;
		
	}
}
