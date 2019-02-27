package com.cal.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cal.dto.CalDto;

public class CalDao {

	public List<CalDto> getCalList(String id,String yyyyMMdd){
		
		Connection con=getConnection();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		List<CalDto> list=new ArrayList<CalDto>();
		
		String sql=" SELECT * FROM CALBOARD WHERE ID=? AND SUBSTR(MDATE,1,8)=? ";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, yyyyMMdd);
			
			
			System.out.println("03. query 준비 : " + sql);
			
			rs=pstm.executeQuery();
			System.out.println("03.query 실행 및 리턴");
			
			while(rs.next()) {
				CalDto dto=new CalDto();
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setMdate(rs.getString(5));
				dto.setRegdate(rs.getDate(6));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("3/4 단계 오류");
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
			close(con);
		}
		return list;
	}
	
	public int insertCalBoard(CalDto dto) {
		
		Connection con=getConnection();
		PreparedStatement pstm=null;
		int res=0;
		
		String sql=" INSERT INTO CALBOARD "+ " VALUES(CALBOARDSEQ.NEXTVAL,?,?,?,?,SYSDATE) ";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1,dto.getId());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			pstm.setString(4,dto.getMdate());
			
			System.out.println("03.query 준비 : "+sql);
			
			res=pstm.executeUpdate();
			System.out.println("03. query 실행 및 리턴");
			
			if(res>0) {
				commit(con);
			}	
		} catch (SQLException e) {
			System.out.println("3/4 단계 에러");
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		return res;
	}
}


























