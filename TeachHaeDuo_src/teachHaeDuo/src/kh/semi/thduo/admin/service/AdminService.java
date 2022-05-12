package kh.semi.thduo.admin.service;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.getConnection;

import java.sql.Connection;

import kh.semi.thduo.admin.dao.AdminDao;
import kh.semi.thduo.admin.vo.AdminVo;



public class AdminService {
	
	private AdminDao dao = new AdminDao(); 
	
	// 회원 로그인 ok
			public AdminVo login(String adminId, String adminPw) {
				AdminVo retVo = null;
				Connection conn = getConnection();
				retVo = dao.login(conn, adminId, adminPw);
				close(conn);
				return retVo;
			}

}
