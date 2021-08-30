package com.jeon.springxml.board.controller;

import java.util.List;

import com.jeon.springxml.board.dto.BoardDTO;
import com.jeon.springxml.board.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board/*")
public class BoardController {
    
    @Autowired
    BoardService boardService;

    @RequestMapping("/")
    public String root(Model model) throws Exception {
        List<BoardDTO> list = boardService.boardList();
        model.addAttribute("list", list);
        return "board/board_list";
    }

    @RequestMapping("list")
    public String getBoardList(Model model) throws Exception {
        List<BoardDTO> list = boardService.boardList();
        model.addAttribute("list", list);
        return "board/board_list";
    }

    @RequestMapping(value="insert", method=RequestMethod.POST)
    public String insertBoard(BoardDTO board) throws Exception {
        boardService.insertBoard(board);
        return "redirect:list";
    }

    @RequestMapping(value="update", method=RequestMethod.POST)
    public String updateBoard(BoardDTO board) throws Exception {
        boardService.updateBoard(board);
        return "redirect:list";
    }

    @RequestMapping(value="delete", method=RequestMethod.POST)
    public String deleteBoard(BoardDTO board) throws Exception {
        boardService.deleteBoard(board);
        return "redirect:list";
    }
    
}
