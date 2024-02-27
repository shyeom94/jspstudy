package pkg02_request.pkg02_request;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
// ctrl + shift + o -> 불필요한 import 정리
public class MyRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyRequest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  // 1. 요청 UTF-8 인코딩 
	  request.setCharacterEncoding("UTF-8");
	  
	  // 2. 요청 파라미터 -> 보내주는 데이터가 있는가? 
	  // 모든 파라미터는 문자열 String 이다.
	  String strNumber = request.getParameter("number");
	  int number = Integer.parseInt(strNumber);
	  System.out.println(number);
	  
	  String strNumber2 = request.getParameter("number2");
	  double number2 = Double.parseDouble(strNumber2);
    System.out.println(number2);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
