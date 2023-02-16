package com.JungHoon.home.dao;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.JungHoon.home.dto.BDto;

public class BDao {
   
   DataSource dataSource;
   
   public BDao() {
      super();
      // TODO Auto-generated constructor stub
      
      try {
         Context context = new InitialContext();
         dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
         
      } catch(Exception e) {
         e.printStackTrace();
      }
      
   }
   
   public ArrayList<BDto> list() {
      ArrayList<BDto> dtos = new ArrayList<BDto>();
      Connection conn = null; //DB 연결 생성
      PreparedStatement pstmt = null; //sql 실행
      ResultSet rs = null; // select 일 때 결과 받아주는 객체
      
      try {
         conn = dataSource.getConnection(); //dataSource에서 connection 생성
         
         String sql = "select * from mvc_board ORDER BY bid DESC"; 
         //게시글 번호의 내림차순 정렬로 모든 글 목록 가져오기(최근글이 가장 위에 오도록 함)
         
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         
         while(rs.next()) {
            int bid = rs.getInt("bid");
            String bname = rs.getString("bname");
            String btitle = rs.getString("btitle");
            String bcontent = rs.getString("bcontent");
               Timestamp bdate = rs.getTimestamp("bdate");
            int bhit = rs.getInt("bhit");
            int bgroup = rs.getInt("bgroup");
            int bstep = rs.getInt("bstep");
            int bindent = rs.getInt("bindent");
            
            BDto dto = new BDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
            dtos.add(dto);
         }
         
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if(rs != null) {
               rs.close();
            }
            if(pstmt != null) {
               pstmt.close();
            }
            if(conn != null) {
               conn.close();
            }
            
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      
      
      
      return dtos;
      
   }
   
   public BDto contentView(String cid) {
      
	   BDto dto = null;
	   
      Connection conn = null; //DB 연결 생성
      PreparedStatement pstmt = null; //sql 실행
      ResultSet rs = null;
      try {
         conn = dataSource.getConnection(); //dataSource에서 connection 생성
         String sql = "select * from mvc_board where bid=?";
         //게시글 번호의 내림차순 정렬로 모든 글 목록 가져오기(최근글이 가장 위에 오도록 함)
         
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, cid);
         
         rs = pstmt.executeQuery();
         
         if(rs.next()) {
        	 int bid = rs.getInt("bid");
             String bname = rs.getString("bname");
             String btitle = rs.getString("btitle");
             String bcontent = rs.getString("bcontent");
             Timestamp bdate = rs.getTimestamp("bdate");
             int bhit = rs.getInt("bhit");
             int bgroup = rs.getInt("bgroup");
             int bstep = rs.getInt("bstep");
             int bindent = rs.getInt("bindent");
             
             dto = new BDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
         }
         
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if(pstmt != null) {
               pstmt.close();
            }
            if(conn != null) {
               conn.close();
            }
            
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      return dto;
   }

public void write(String bname, String btitle, String bcontent) {
	// TODO Auto-generated method stub
	
}
}