package pattern.controller;

import pattern.controller.component.FindController;

public class ControllerFactory {

	//싱글톤 패턴
	private static ControllerFactory factory = new ControllerFactory();
	
	private ControllerFactory() { //빈 생성자, 다른곳에서 생성 하지 못하도록  private
		System.out.println("ControllerFactory Creating..");
	}
	
	public static ControllerFactory getInstance() { // 다른곳에서 호출할 수 있도록 public
		return factory;
	}
	
	// createController 
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("findModel")) {
			controller = new FindController();
		}
		
		return controller;
	}
	
}
