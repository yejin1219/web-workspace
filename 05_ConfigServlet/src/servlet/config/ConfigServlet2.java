package servlet.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ConfigServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int count = 0;
    private String path ="d:\\test2\\config.txt";;
	
	public void init(ServletConfig config) throws ServletException {
		// 1. ServletConfing 의 기능을 사용해서 path에 연결된 값을 받아온다.
		path = config.getInitParameter("path");
		

		
		try {
			//2. BufferedReader, FileReader 를 사용해서 파일을 읽어들인다.
			BufferedReader br = new BufferedReader(new FileReader(path));
			String str = br.readLine();
			
			//3. count값으로 필드 초기화	
			count = Integer.parseInt(str);
			br.close();
			
		} catch (IOException e) {

			System.out.println("파일 읽어오기 실패");
		}
	}

	public void destroy() {
		//4. PrintWriter, FileWriter를 사용해서 count값 지정
		
		File file = new File(path);
		file.getParentFile().mkdirs(); //mkdirs() :디렉토리 강제 생성
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file));
			pw.println(count);
			pw.close();
			System.out.println(path + "count 값 ::" + count + "파일에 영구적으로 저장");
			
			
		} catch (IOException e) {
			
			System.out.println(" 스트림 생성 실패 ");
		}
		
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//5. 폼에 입력된 값을 받아서 
		//  ~~~ 아무개 님은 ~~몇번째 입장하신 고객입니다.
		// 를 브라우저로 출력(이때 출력은 config2.jsp에서)
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("userName");
		PrintWriter out = response.getWriter();
		out.println("<a href=config2.jsp?count=" + ++count + "&userName="+name +">config2.jsp로 이동</a>");
                                  //		링크에 키값들을 넣어야 jsp파일에서 읽어 올 수 있음 
		out.close();
		
	}

}
