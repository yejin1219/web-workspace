package ServletLife;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LifecycleServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public int count = 0;
   
    public LifecycleServlet1() {
       System.out.println("1. LifecycleServlet 생성자...");
        
    }

	public void init(ServletConfig config) throws ServletException {
//		딱 한번만 실행가능
		System.out.println("2. init..호출...");
	}


	public void destroy() {
//		서버가 종료되는 순간 나타나는 메소드
		System.out.println("4. destory..호출..");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. service.. 호출..");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h>LifeCycle CallBack Method...</h>");
		out.println("<p>Count :: " + ++count + "</p>");
	}

}
