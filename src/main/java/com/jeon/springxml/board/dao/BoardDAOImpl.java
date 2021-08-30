package com.jeon.springxml.board.dao;

import java.util.ArrayList;
import java.util.List;

import com.jeon.springxml.board.dto.BoardDTO;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	private List<BoardDTO> list = new ArrayList<BoardDTO>();

	public BoardDAOImpl() {
		super();
		list.add(new BoardDTO(1, "hi"));
        list.add(new BoardDTO(2, "~~~~"));
        list.add(new BoardDTO(3, "bye"));
	}

	@Override
	public List<BoardDTO> getList() throws Exception {
		return list;
	}

	@Override
	public void insert(BoardDTO board) throws Exception {
		list.add(board);
	}

	@Override
	public void update(BoardDTO board) throws Exception {
		if (list.contains(board)) {
			int idx = list.indexOf(board);
			list.set(idx, board);
		}
	}

	@Override
	public void delete(BoardDTO board) throws Exception {
		if (list.contains(board)) {
			list.remove(board);
		}
	}

	

    
}
