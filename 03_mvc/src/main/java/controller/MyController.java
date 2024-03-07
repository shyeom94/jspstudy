package controller;

import java.io.IOException;

import common.ActionForward;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MyInterface;
import model.MyInterfaceImpl;

public class MyController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    /* 요청 UTF-8 인코딩 */
    request.setCharacterEncoding("UTF-8");

    /* 어떤 요청인지 확인 (URLMapping 확인) */
    String requestURI = request.getRequestURI(); /* http://localhost:8080/mvc/getDate.do */
    String contextPath = request.getContextPath(); /* /mvc */
    String urlMapping = requestURI.substring(requestURI.indexOf(contextPath) + contextPath.length());

    // System.out.println(urlMapping);

    /* MyInterface 타입의 MyInterfaceImpl 객체 생성 */
    MyInterface myInterface = new MyInterfaceImpl();

    /* 메소드 호출 결과(view 경로 + forward/redirect 이동방식)를 저장할 ActionForward 객체 선언 */
    // String path = null; // 변수
    ActionForward actionForward = null;

    /* 요청에 따른 메소드 호출 */
    switch (urlMapping) {
    case "/getDate.do":
      actionForward = myInterface.getDate(request); // 호출
      System.out.println(request.getAttribute("date")); // 확인
      break;
    case "/getTime.do":
      actionForward = myInterface.getTime(request);
      System.out.println(request.getAttribute("time"));
      break;
    case "/getDateTime.do":
      actionForward = myInterface.getDateTime(request);
      System.out.println(request.getAttribute("datetime"));
      break;
    }

    // System.out.println(path); // 확인 코드

    /* 어디로 어떻게 이동할 것인지 결정 */
    if (actionForward != null) {
      if (actionForward.isRedirect()) {
        response.sendRedirect(actionForward.getView());
      } else {
        request.getRequestDispatcher(actionForward.getView()).forward(request, response);
      }
    }

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
