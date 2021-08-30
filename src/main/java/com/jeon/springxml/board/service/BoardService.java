package com.jeon.springxml.board.service;

import java.util.List;

import com.jeon.springxml.board.dto.BoardDTO;

public interface BoardService {
    
    public List<BoardDTO> boardList() throws Exception;

    public void insertBoard(BoardDTO board) throws Exception;

    public void updateBoard(BoardDTO board) throws Exception;
    
    public void deleteBoard(BoardDTO board) throws Exception;
}
