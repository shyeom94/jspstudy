package com.gdu.prj.service;

import java.util.List;
import java.util.Optional;

import com.gdu.prj.common.ActionForward;
import com.gdu.prj.dao.BoardDao;
import com.gdu.prj.dao.BoardDaoImpl;
import com.gdu.prj.dto.BoardDto;

import jakarta.servlet.http.HttpServletRequest;

/*
 * view - controller - service - dao - db
 */

public class BoardServiceImpl implements BoardService {

  // service 는 dao 를 호출한다.
  private BoardDao boardDao = BoardDaoImpl.getInstance(); // 싱글톤 객체를 가져다가 사용할 수 있도록 변경.

  @Override
  public ActionForward addBoard(HttpServletRequest request) { // title, contents parameter
    String title = request.getParameter("title"); 
    String contents = request.getParameter("contents"); 
    BoardDto board = BoardDto.builder()
                             .title(title)
                             .contents(contents)
                             .build();
    int insertCount = boardDao.insertBoard(board);
    // redirect 경로는 URLMapping 으로 작성한다. 
    String view = null;
    // 실패 -> index.jsp, 성공 -> 목록보기
    if (insertCount == 1) { // 성공 
      view = request.getContextPath() + "/board/list.brd";
    } else if (insertCount == 0){ //실패 
      view = request.getContextPath() + "/main.brd";
    }
    // INSERT 이후 이동은 redirect 
    return new ActionForward(view, true); // redirect 여부 -> true
  }

  @Override
  public ActionForward getBoardList(HttpServletRequest request) {
    int boardCount = boardDao.getBoardCount();
    List<BoardDto> boardList = boardDao.selectBoardList(null); // db 에서 가져온 목록이 저장된다.
    request.setAttribute("boardCount", boardCount); // request 에 최종 저장하고 전달하는 forward 작업을 하면 전달된다.
    request.setAttribute("boardList", boardList);
    return new ActionForward("/board/list.jsp", false); // 폴더이름/파일이름 , true 면 redirect // false 면 forward 된다.
  }

  @Override
  public ActionForward getBoardByNo(HttpServletRequest request) {
    Optional<String> opt = Optional.ofNullable(request.getParameter("board_no"));
    int board_no = Integer.parseInt(opt.orElse("0"));
    BoardDto board = boardDao.selectBoardByNo(board_no);
    String view = null;
    if (board != null) {
      view = "/board/detail.jsp";
      request.setAttribute("board", board);
    } else {
      view = "/index.jsp";
    }
    return new ActionForward(view, false); // forward 로 이동, request 에 data 저장 후 jsp 이름으로 이동! 
  }

  @Override
  public ActionForward editBoard(HttpServletRequest request) {
    return null;
  }

  @Override
  public ActionForward modifyBoard(HttpServletRequest request) {
    return null;
  }

  @Override
  public ActionForward removeBoard(HttpServletRequest request) {
    return null;
  }

}
