package com.jys.web.board.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jys.web.board.model.BoardVO;
import com.jys.web.board.service.BoardService;



@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Inject
	private BoardService boardService;

	@RequestMapping(value = "/getBoardList", method = RequestMethod.GET)
	public String getBoardList(Model model) throws Exception {
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/index";
	}
	
	@RequestMapping("/boardForm")
	public String boardForm() {
		return "board/boardFrom";
	}
	
	//ModelAttribute �ֳ����̼� : ȭ�鿡�� �Ѱ��ִ� ���� BoardVO�� ��Ī�� �����͸� �޾ƿ�
	//RedirectAttributes ���� : �۾����� ���ư� ������
	@RequestMapping(value = "/saveBoard", method = RequestMethod.POST)
	public String saveBoard(@ModelAttribute("BoardVO") BoardVO boardVO 
			, RedirectAttributes rttr) throws Exception {
		boardService.insertBoard(boardVO);
		return "redirect:/board/getBoardList";
	}
	
	//Service���� return���� ������ ȭ�鿡 ����
	@RequestMapping(value = "/getBoardContent", method = RequestMethod.GET)
	public String getBoardContent(Model model, @RequestParam("bid") int bid) throws Exception {
		model.addAttribute("boardContent", boardService.getBoardContent(bid));
		return "board/boardContent";
	}


}	
