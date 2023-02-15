package com.JungHoon.home.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.jsp.jstl.sql.Result;
import javax.sql.DataSource;

import com.JungHoon.home.dto.BDto;

public class BDao {
	
	DataSource dataSource;
	
	public BDao() {
		super();
		// TODO Auto-generated constructor stub
		  try {
		         Context context = new InitialContext();
		         dataSource = (DataSource) context.lookup("java:comp/env/env/jdbc/Oracle11g");
		         
		      }catch(Exception e){
		         
		         
		         e.printStackTrace();
		         
		      }
		      
		   }
	

	
	
	public ArrayList<BDto> list(){
		
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		
		Connection conn = null;//DB 연결 생성
		PreparedStatement pstmt = null; //sql 실행
		ResultSet rs = null; //select 일때 결과 받아주는 객체
		try {
			conn = dataSource.getConnection(); //dataSource 에서 Connection 생성
			
			String sql = "select * from mvc_board ORDER BY bid DESC";// 모든글 가져오기
			// 게시글 번호의 내림차순 정렬로 모든 글 목록 가져오기)최근글이 가장 위에 오도록 함)
			
			pstmt = conn.prepareStatement(sql);
			pstmt.executeQuery();
			
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcotent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bitn");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				
				System.out.println("btitle");
				
				BDto dto = new BDto(bid, bname,	bcotent, btitle, bdate, bhit, bgroup, bstep, bindent);
				dtos.add(dto);
				
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
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
 		
		return dtos;
		
	}

}
