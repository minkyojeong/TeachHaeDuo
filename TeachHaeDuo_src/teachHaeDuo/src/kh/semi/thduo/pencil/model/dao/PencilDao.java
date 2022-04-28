package kh.semi.thduo.pencil.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.thduo.pencil.model.vo.PencilVo;

public class PencilDao {
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	public int plusPencil(Connection conn, PencilVo vo) {
		int result = 0;
		String sql ="";
		
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
		
	}
	public int minusPencil(Connection conn, PencilVo vo) {
		int result = 0;
		
		return result;
		
	}
	public ArrayList<PencilVo> listPencil(Connection conn, String mId) {
		ArrayList<PencilVo> result = null;
		
		return result;
		
	}
}
