package com.jeon.springxml.board.service;

import java.util.List;

import com.jeon.springxml.board.dao.BoardDAO;
import com.jeon.springxml.board.dto.BoardDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
	@Qualifier("plainJdbcBoardDAO")
    BoardDAO boardDao;

	@Override
	public List<BoardDTO> boardList() throws Exception {
		return boardDao.getList();
	}

	@Override
	public void insertBoard(BoardDTO board) throws Exception {
		boardDao.insert(board);
	}

	@Override
	public void updateBoard(BoardDTO board) throws Exception {
		boardDao.update(board);
	}

	@Override
	public void deleteBoard(BoardDTO board) throws Exception {
		boardDao.delete(board);
	}
    
}
