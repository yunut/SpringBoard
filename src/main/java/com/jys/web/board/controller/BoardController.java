package com.jys.web.board.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jys.common.Pagination;
import com.jys.web.board.model.BoardVO;
import com.jys.web.board.service.BoardService;



@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Inject
	private BoardService boardService;

	@RequestMapping(value = "/getBoardList", method = RequestMethod.GET)
	public String getBoardList(Model model
			,@RequestParam(required = false, defaultValue = "1") int page
			,@RequestParam(required = false, defaultValue = "1") int range
			) throws Exception {
		
		
			//전체 게시글 개수
			int listCnt = boardService.getBoardListCnt();
		    //Pagination 객체생성
			Pagination pagination = new Pagination();
			pagination.pageInfo(page, range, listCnt);
			model.addAttribute("pagination", pagination);
			model.addAttribute("boardList", boardService.getBoardList(pagination));
		return "board/index";
	}
	
	@RequestMapping("/boardForm")
	public String boardForm(@ModelAttribute("boardVO") BoardVO vo, Model model) {
		return "board/boardForm";
	}
	
	//ModelAttribute 애노테이션 : 화면에서 넘겨주는 값을 BoardVO와 매칭해 데이터를 받아옴
	//RedirectAttributes 인자 : 글쓰기후 돌아갈 페이지
	@RequestMapping(value = "/saveBoard", method = RequestMethod.POST)
	public String saveBoard(@ModelAttribute("BoardVO") BoardVO boardVO 
			, @RequestParam("mode") String mode
			, RedirectAttributes rttr) throws Exception {
		if (mode.equals("edit")) {
			boardService.updateBoard(boardVO);
		} else {
			boardService.insertBoard(boardVO);
		}

		return "redirect:/board/getBoardList";
	}
	
	//Service에서 return받은 내역을 화면에 전달
	@RequestMapping(value = "/getBoardContent", method = RequestMethod.GET)
	public String getBoardContent(Model model, @RequestParam("bid") int bid) throws Exception {
		model.addAttribute("boardContent", boardService.getBoardContent(bid));
		return "board/boardContent";
	}
	
	//게시물 수정
	@RequestMapping(value = "/editForm", method = RequestMethod.GET)
	public String editForm(@RequestParam("bid") int bid
			, @RequestParam("mode") String mode, Model model) throws Exception {
		model.addAttribute("boardContent", boardService.getBoardContent(bid));
		model.addAttribute("mode", mode);
		model.addAttribute("boardVO", new BoardVO());
		return "board/boardForm";
	}

	//게시물 삭제
	@RequestMapping(value = "/deleteBoard", method = RequestMethod.GET)
	public String deleteBoard(RedirectAttributes rttr, @RequestParam("bid") int bid) throws Exception {
		boardService.deleteBoard(bid);;
		return "redirect:/board/getBoardList";
	}
	
	/*
	//예외처리
	@ExceptionHandler(RuntimeException.class)
	public String exceptionHandler(Model model, Exception e){
		logger.info("exception : " + e.getMessage());
		model.addAttribute("exception", e);
		return "error/exception";
	}
	*/
	

}	
