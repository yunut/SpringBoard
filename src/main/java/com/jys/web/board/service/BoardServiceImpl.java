package com.jys.web.board.service;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.jys.web.board.dao.BoardDAO;
import com.jys.web.board.model.BoardVO;



@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO boardDAO;

	@Override
	public List<BoardVO> getBoardList() throws Exception {
		return boardDAO.getBoardList();
	}
	
	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		boardDAO.insertBoard(boardVO);
	}
	
	@Override
	public BoardVO getBoardContent(int bid) throws Exception{
		boardDAO.updateViewCnt(bid);
		return boardDAO.getBoardContent(bid);
	}



}