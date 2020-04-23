package com.jys.web.board.service;

import java.util.List;
import java.util.Map;


import com.jys.web.board.model.BoardVO;

public interface BoardService {
	//게시판 리스트
	public List<BoardVO> getBoardList() throws Exception;
	
	//글쓰기 폼
	public void insertBoard(BoardVO boardVO) throws Exception;
	
	//글 상세 내용
	public BoardVO getBoardContent(int bid) throws Exception;
}
