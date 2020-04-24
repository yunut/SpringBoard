package com.jys.web.board.service;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jys.common.Pagination;
import com.jys.web.board.dao.BoardDAO;
import com.jys.web.board.model.BoardVO;



@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO boardDAO;

	@Override
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception {
		return boardDAO.getBoardList(pagination);
	}
	
	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		boardDAO.insertBoard(boardVO);
	}
	
	@Transactional
	@Override
	public BoardVO getBoardContent(int bid) throws Exception{
		boardDAO.updateViewCnt(bid);
		return boardDAO.getBoardContent(bid);
	}
	
	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		boardDAO.updateBoard(boardVO);
	}
	
	@Override
	public void deleteBoard(int bid) throws Exception {
		 boardDAO.deleteBoard(bid);
	}
	
	//총 게시글 개수 확인
	@Override
	public int getBoardListCnt() throws Exception {
		return boardDAO.getBoardListCnt();
	}


}