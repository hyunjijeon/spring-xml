package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MariadbClientTest {

    private static String DRIVER = "org.mariadb.jdbc.Driver";
    private static String DB_URL = "jdbc:mysql://192.168.15.118:3306/USER01_DB";
    private static String USERNAME = "user01";
    private static String PASSWORD = "user01";

    @Test
    public void test() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("\n- MySQL Connection");
            insert(conn, 12, "1222");
            selectAll(conn);
            delete(conn, 12);
            selectAll(conn);
            conn.close();
        } catch (SQLException se1) {
            se1.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public void selectAll(Connection con) throws Exception {
        String query = "SELECT * FROM SPRING_BOARD";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            System.out.println(">> Execute query: " + query);
            while(rs.next()) {
                System.out.println("bNo: " + rs.getInt("bNo") + " title: " + rs.getString("title"));
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public int insert(Connection con, int bNo, String title) throws Exception {
        String query = "INSERT INTO SPRING_BOARD (bNo, title) VALUES (?, ?);";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, bNo);
            pstmt.setString(2, title);
            int cnt = pstmt.executeUpdate();
            System.out.println(">> Execute query: " + query);
            System.out.println("   row count: " + cnt);
            pstmt.close();
            return cnt;
        } catch (Exception e) {
            throw e;
        }
    }

    public int delete(Connection con, int bNo) throws Exception {
        String query = "DELETE FROM SPRING_BOARD WHERE bNo = ?;";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, bNo);
            int cnt = pstmt.executeUpdate();
            System.out.println(">> Execute query: " + query);
            System.out.println("   row count: " + cnt);
            pstmt.close();
            return cnt;
        } catch (Exception e) {
            throw e;
        }
    }
}
