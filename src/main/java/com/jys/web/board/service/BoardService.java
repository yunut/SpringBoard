package com.jys.web.board.service;

import java.util.List;
import java.util.Map;


import com.jys.web.board.model.BoardVO;

public interface BoardService {
	//�Խ��� ����Ʈ
	public List<BoardVO> getBoardList() throws Exception;
	
	//�۾��� ��
	public void insertBoard(BoardVO boardVO) throws Exception;
	
	//�� �� ����
	public BoardVO getBoardContent(int bid) throws Exception;
}
