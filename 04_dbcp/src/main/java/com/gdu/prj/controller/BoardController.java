package com.gdu.prj.controller;

import java.io.IOException;

import com.gdu.prj.common.ActionForward;
import com.gdu.prj.service.BoardService;
import com.gdu.prj.service.BoardServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * view - controller - service - dao - db
 */
public class BoardController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  // controller 는 service 를 호출한다.
  private BoardService boardService = new BoardServiceImpl();

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // 요청 UTF-8 인코딩
    request.setCharacterEncoding("UTF-8");

    // 요청 주소 확인
    String requestURI = request.getRequestURI(); /* http://localhost:8080/dbcp/board/list.brd */
    String contextPath = request.getContextPath(); /* /dbcp */
    String urlMappping = requestURI.substring(requestURI.indexOf(contextPath) + contextPath.length());

    // 서비스 메소드의 호출 결과를 저장할 ActionForward 객체 선언
    ActionForward actionForward = null; // 선언

    // 요청 주소에 따른 서비스 메소드 호출
    switch (urlMappping) {
    case "/board/list.brd":
      actionForward = boardService.getBoardList(request);
      break;
    }

    // 어디로 갈 것인가 주소 , 어떻게 갈 것인가. redirect or forward
    // 결정.
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
