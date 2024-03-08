package com.gdu.prj.service;

import java.util.List;

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
  public ActionForward addBoard(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
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
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ActionForward editBoard(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ActionForward modifyBoard(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ActionForward removeBoard(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

}
