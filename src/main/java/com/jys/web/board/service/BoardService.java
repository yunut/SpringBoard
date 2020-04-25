package com.jys.web.board.service;

import java.util.List;
import java.util.Map;

import com.jys.common.Pagination;
import com.jys.common.Search;
import com.jys.web.board.model.BoardVO;
import com.jys.web.board.model.ReplyVO;

public interface BoardService {
	//게시판 리스트
	public List<BoardVO> getBoardList(Search search) throws Exception;
	
	//글쓰기 폼
	public void insertBoard(BoardVO boardVO) throws Exception;
	
	//글 상세 내용
	public BoardVO getBoardContent(int bid) throws Exception;
	
	//글쓰기 업데이트
	public void updateBoard(BoardVO boardVO) throws Exception;
	
	//게시글 삭제
	public void deleteBoard(int bid) throws Exception;
	
	//총 게시글 개수 확인
	public int getBoardListCnt(Search search) throws Exception;
	
	
	// 댓글 리스트
	public List<ReplyVO> getReplyList(int bid) throws Exception;
	public int saveReply(ReplyVO replyVO) throws Exception;
	public int updateReply(ReplyVO replyVO) throws Exception;
	public int deleteReply(int rid) throws Exception;

}
