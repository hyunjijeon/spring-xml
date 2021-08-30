package com.jeon.springxml.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.jeon.springxml.board.dto.BoardDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("plainJdbcBoardDAO")
public class PlainJdbcBoardDAO implements BoardDAO {

    @Autowired
    private DataSource datasource;

    private static final String INSERT_SQL = "INSERT INTO SPRING_BOARD (bNo, title) VALUES (?, ?)";
    private static final String SELECT_SQL = "SELECT * FROM SPRING_BOARD";
    private static final String UPDATE_SQL = "UPDATE SPRING_BOARD SET title=? WHERE bNo=?";
    private static final String DELETE_SQL = "DELETE FROM SPRING_BOARD WHERE bNo=?";

    @Override
    public List<BoardDTO> getList() throws Exception {
        try (Connection conn = datasource.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SELECT_SQL);
            try (ResultSet rs = ps.executeQuery()) {
                List<BoardDTO> list = new ArrayList<BoardDTO>();
                while(rs.next()) {
                    BoardDTO dto = new BoardDTO();
                    dto.setbNo(rs.getInt(1));
                    dto.setTitle(rs.getString(2));
                    list.add(dto);
                }
                return list;
            } catch (Exception e) {
                //TODO: handle exception
                throw e;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void insert(BoardDTO board) throws Exception {
        try (Connection conn = datasource.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(INSERT_SQL);
            ps.setInt(1, board.getbNo());
            ps.setString(2, board.getTitle());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void update(BoardDTO board) throws Exception {
        try (Connection conn = datasource.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(UPDATE_SQL);
            ps.setString(1, board.getTitle());
            ps.setInt(2, board.getbNo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }        
    }

    @Override
    public void delete(BoardDTO board) throws Exception {
        try (Connection conn = datasource.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(DELETE_SQL);
            ps.setInt(1, board.getbNo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }                
    }
    
}
