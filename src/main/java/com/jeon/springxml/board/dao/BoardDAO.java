package com.jeon.springxml.board.dao;

import java.util.List;

import com.jeon.springxml.board.dto.BoardDTO;

public interface BoardDAO {
    
    public List<BoardDTO> getList() throws Exception;

    public void insert(BoardDTO board) throws Exception;

    public void update(BoardDTO board) throws Exception;

    public void delete(BoardDTO board) throws Exception;
}
