package com.jys.web.board.service;

import java.util.List;
import java.util.Map;

import com.jys.common.Pagination;
import com.jys.common.Search;
import com.jys.web.board.model.BoardVO;
import com.jys.web.board.model.ReplyVO;

public interface BoardService {
	//�Խ��� ����Ʈ
	public List<BoardVO> getBoardList(Search search) throws Exception;
	
	//�۾��� ��
	public void insertBoard(BoardVO boardVO) throws Exception;
	
	//�� �� ����
	public BoardVO getBoardContent(int bid) throws Exception;
	
	//�۾��� ������Ʈ
	public void updateBoard(BoardVO boardVO) throws Exception;
	
	//�Խñ� ����
	public void deleteBoard(int bid) throws Exception;
	
	//�� �Խñ� ���� Ȯ��
	public int getBoardListCnt(Search search) throws Exception;
	
	
	// ��� ����Ʈ
	public List<ReplyVO> getReplyList(int bid) throws Exception;
	public int saveReply(ReplyVO replyVO) throws Exception;
	public int updateReply(ReplyVO replyVO) throws Exception;
	public int deleteReply(int rid) throws Exception;

}
