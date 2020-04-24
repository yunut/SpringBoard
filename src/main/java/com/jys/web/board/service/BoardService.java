package com.jys.web.board.service;

import java.util.List;
import java.util.Map;

import com.jys.common.Pagination;
import com.jys.web.board.model.BoardVO;

public interface BoardService {
	//�Խ��� ����Ʈ
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception;
	
	//�۾��� ��
	public void insertBoard(BoardVO boardVO) throws Exception;
	
	//�� �� ����
	public BoardVO getBoardContent(int bid) throws Exception;
	
	//�۾��� ������Ʈ
	public void updateBoard(BoardVO boardVO) throws Exception;
	
	//�Խñ� ����
	public void deleteBoard(int bid) throws Exception;
	
	//�� �Խñ� ���� Ȯ��
	public int getBoardListCnt() throws Exception;
	
}
