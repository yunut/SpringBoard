package com.jys.web.board.dao;

import java.util.List;

import com.jys.common.Pagination;
import com.jys.web.board.model.BoardVO;


//DAO 구현을 위한 인터페이스
public interface BoardDAO {
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception;
	public BoardVO getBoardContent(int bid) throws Exception;
	public int insertBoard(BoardVO boardVO) throws Exception;
	public int updateBoard(BoardVO boardVO) throws Exception;
	public int deleteBoard(int bid) throws Exception;
	public int updateViewCnt(int bid) throws Exception;
	public int getBoardListCnt() throws Exception;

}

