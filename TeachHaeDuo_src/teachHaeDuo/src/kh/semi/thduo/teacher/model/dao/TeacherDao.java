package kh.semi.thduo.teacher.model.dao;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.commit;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.getConnection;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.thduo.like.model.vo.LikeVo;
import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.review.model.vo.ReviewVo;
import kh.semi.thduo.teacher.model.vo.TeacherSearchSettingVo;
import kh.semi.thduo.teacher.model.vo.TeacherVo;

public class TeacherDao {
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 회원가입 시, 선생님 정보 초기 삽입
	public int insertTeacherInit(Connection conn, String mId) {
		int result = 0;
		String sql = "INSERT INTO t_profile VALUES((SELECT 'T' || (SELECT MAX(TO_NUMBER(SUBSTR(t_no, 2))) + 1 FROM t_profile) FROM dual), default, default, default, default, default, default, default, default, default, default, default, ?, default, default)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	// 모든 선생님 정보 읽기
	public ArrayList<TeacherVo> readAllTeacher(Connection conn, int startRnum, int endRnum) {
		ArrayList<TeacherVo> retVolist = null;
		String sql = "SELECT pro.t_no, pro.t_major, pro.t_picture, m.m_nickname, round(rscore.avg_rscore, 2) avg_rscore, olist.object_list, alist.area_list"
				+ " FROM t_profile pro JOIN member m" 
				+ "                    ON pro.m_id = m.m_id"
				+ "                    JOIN view_teacher_rscroe_avg rscore"
				+ "                    ON rscore.m_nickname = m.m_nickname"
				+ "                    JOIN view_teacher_object olist"
				+ "                    ON olist.m_nickname = m.m_nickname"
				+ "                    JOIN view_teacher_area alist"
				+ "                    ON alist.m_nickname = m.m_nickname"
				+ " ORDER BY TO_NUMBER(SUBSTR(t_no, 2)) desc";
		System.out.println("sql: " + sql);
		sql = "select * from (select ROWNUM rnum, tall.* from ("+sql+") tall) tall2  where rnum>=? and rnum<=?";
		System.out.println("sql: " + sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);
			pstmt.setInt(2, endRnum);
			rs = pstmt.executeQuery();
			retVolist = new ArrayList<TeacherVo>();
			while (rs.next()) {
				TeacherVo vo = new TeacherVo();
				vo.setT_no(rs.getString("t_no"));
				vo.setT_major(rs.getString("t_major"));
				vo.setT_picture(rs.getString("t_picture"));
				vo.setM_nickname(rs.getString("m_nickname"));
				vo.setAvg_rscore(rs.getDouble("avg_rscore"));
				vo.setObject_list(rs.getString("object_list"));
				vo.setArea_list(rs.getString("area_list"));

				retVolist.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("dao retVolist 1:" + retVolist);
		
		return retVolist;
	}
		
	// 모든선생님 세기
	public int countReadAllTeacher(Connection conn) {
		int result = 0;
		String sql = "SELECT COUNT(*)"
				+ " FROM t_profile pro JOIN member m" 
				+ "                    ON pro.m_id = m.m_id"
				+ "                    JOIN view_teacher_rscroe_avg rscore"
				+ "                    ON rscore.m_nickname = m.m_nickname"
				+ "                    JOIN view_teacher_object olist"
				+ "                    ON olist.m_nickname = m.m_nickname"
				+ "                    JOIN view_teacher_area alist"
				+ "                    ON alist.m_nickname = m.m_nickname";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("dao count result :" + result);
		
		return result;
	}
	
	// 검색한 과목에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readTeacher(Connection conn, String object, int startRnum, int endRnum) {
		ArrayList<TeacherVo> retVolist = null;
		String sql = "SELECT pro.t_no, pro.t_major, pro.t_picture, m.m_nickname, round(rscore.avg_rscore, 2) avg_rscore, olist.object_list, alist.area_list"
				+ " FROM t_profile pro JOIN member m" 
				+ "                    ON pro.m_id = m.m_id"
				+ "                    JOIN view_teacher_rscroe_avg rscore"
				+ "                    ON rscore.m_nickname = m.m_nickname"
				+ "                    JOIN view_teacher_object olist"
				+ "                    ON olist.m_nickname = m.m_nickname"
				+ "                    JOIN view_teacher_area alist"
				+ "                    ON alist.m_nickname = m.m_nickname" 
				+ " WHERE olist.object_list LIKE ?"
				+ " ORDER BY TO_NUMBER(SUBSTR(t_no, 2)) desc";
		System.out.println("sql: " + sql);
		sql = "select * from (select ROWNUM rnum, tall.* from ("+sql+") tall) tall2  where rnum>=? and rnum<=?";
		System.out.println("sql: " + sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + object + "%");
			pstmt.setInt(2, startRnum);
			pstmt.setInt(3, endRnum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				retVolist = new ArrayList<TeacherVo>();
				do {
					TeacherVo vo = new TeacherVo();

					vo.setT_no(rs.getString("t_no"));
					vo.setT_major(rs.getString("t_major"));
					vo.setT_picture(rs.getString("t_picture"));
					vo.setM_nickname(rs.getString("m_nickname"));
					vo.setAvg_rscore(rs.getDouble("avg_rscore"));
					vo.setObject_list(rs.getString("object_list"));
					vo.setArea_list(rs.getString("area_list"));

					retVolist.add(vo);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return retVolist;
	}
	
	// 검색한 과목에 맞는 선생님 정보 개수 읽기
	public int countReadTeacher(Connection conn, String object) {
		int result  = 0;
		String sql = "SELECT count(*) "
				+ " FROM t_profile pro JOIN member m" 
				+ "                    ON pro.m_id = m.m_id"
				+ "                    JOIN view_teacher_rscroe_avg rscore"
				+ "                    ON rscore.m_nickname = m.m_nickname"
				+ "                    JOIN view_teacher_object olist"
				+ "                    ON olist.m_nickname = m.m_nickname"
				+ "                    JOIN view_teacher_area alist"
				+ "                    ON alist.m_nickname = m.m_nickname" 
				+ " WHERE olist.object_list LIKE ?"
				+ " ORDER BY TO_NUMBER(SUBSTR(t_no, 2)) desc";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + object + "%");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	// 성별과 활동지역 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readAreaGenderTeacher(Connection conn, String genderFm, String area) {
		ArrayList<TeacherVo> retVolist = null;
		String a = "%" + area + "%";

		String sql = "SELECT pro.t_no, pro.t_major, pro.t_picture, m.m_nickname, round(rscore.avg_rscore, 2) avg_rscore, olist.object_list, alist.area_list"
				+ " FROM t_profile pro JOIN member m" // 띄어쓰기 꼭하기
				+ "                    ON pro.m_id = m.m_id" 
				+ "                    JOIN view_teacher_rscroe_avg rscore"
				+ "                    ON rscore.m_nickname = m.m_nickname"
				+ "                    JOIN view_teacher_object olist"
				+ "                    ON olist.m_nickname = m.m_nickname"
				+ "                    JOIN view_teacher_area alist"
				+ "                    ON alist.m_nickname = m.m_nickname" 
				+ "                    WHERE  1=1 ";
		if (!area.equals("init") && !area.equals("")) {
			sql += "					  and alist.area_list like '" + a + "'";
		}
		if (!genderFm.equals("init") && !genderFm.equals("")) {
			genderFm = genderFm.toUpperCase();
			sql += "                    and m.GENDER_FM = '" + genderFm + "'"; // "랑 ; 잘보기
		}

		try {
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, a);
//			pstmt.setString(2, genderFm);
			rs = pstmt.executeQuery();
			retVolist = new ArrayList<TeacherVo>();

			while (rs.next()) {
				TeacherVo vo = new TeacherVo();
				vo.setT_no(rs.getString("t_no"));
				vo.setT_major(rs.getString("t_major"));
				vo.setT_picture(rs.getString("t_picture"));
				vo.setM_nickname(rs.getString("m_nickname"));
				vo.setAvg_rscore(rs.getDouble("avg_rscore"));
				vo.setObject_list(rs.getString("object_list"));
				vo.setArea_list(rs.getString("area_list"));
				retVolist.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("dao retVolist 1:" + retVolist);
		
		return retVolist;
	}

	// 찜 여부 체크
	public LikeVo checkLike(Connection conn, String m_id, String t_no) {
		LikeVo retVo = null;
		String sql = "SELECT * FROM dibs JOIN member_student USING(s_no) WHERE m_id = ? AND t_no = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.setString(2, t_no);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				retVo = new LikeVo();
				retVo.setS_no(rs.getString("s_no"));
				retVo.setT_no(rs.getString("t_no"));
				retVo.setM_id(rs.getString("m_id"));
			}
		} catch (SQLException e) {

		} finally {
			close(rs);
			close(pstmt);
		}

		return retVo;
	}

	// 선생님 통합 검색
	public ArrayList<TeacherVo> searchTeacher(Connection conn, TeacherSearchSettingVo setVo,int startRnum,int entRnum) {
		ArrayList<TeacherVo> retVolist = null;
		String sql = "SELECT pro.*, m_nickname, gender_fm, round(rscore.avg_rscore, 2) avg_rscore, olist.object_list, alist.area_list"
				+ "    FROM t_profile pro JOIN member m ON  pro.m_id=m.m_id"
				+ "    JOIN view_teacher_rscroe_avg rscore USING (m_nickname)"
				+ "    JOIN view_teacher_object olist USING (m_nickname)"
				+ "    JOIN view_teacher_area alist USING (m_nickname)" 
				+ "    WHERE  1=1 ";
//		if(setVo.getT_profile_yn() != null && !setVo.getT_permit_yn().equals("")) {
//			sql+= "    AND pro.t_permit_yn = '"+setVo.getT_permit_yn()+"'";  // 통화허용
//		}
		if (setVo.getArea_list() != null && !setVo.getArea_list().equals("")) {
			sql += "    AND alist.area_list like '%" + setVo.getArea_list() + "%'"; // 지역 %%
		}
		if (setVo.getGender_fm() != null && !setVo.getGender_fm().equals("")) {
			sql += "    AND m.gender_fm = '" + setVo.getGender_fm() + "'"; // 성별
		}
		if (setVo.getObject_list() != null && !setVo.getObject_list().equals("")) {
			sql += "    AND olist.object_list like '%" + setVo.getObject_list() + "%'"; // 과목 %%
		}
		if (setVo.getT_recruit_yn() != null && !setVo.getT_recruit_yn().equals("")) {
			sql += "    AND pro.t_recruit_yn = '" + setVo.getT_recruit_yn() + "'";// 모집중 모집중Y, 모집중아니면N"
		}
		if (setVo.getOnline_yna() != null && !setVo.getOnline_yna().equals("") && setVo.getOnline_yna().equals("N")) {
			sql += "    AND pro.online_yna = 'N'";
		}
		if (setVo.getOnline_yna() != null && !setVo.getOnline_yna().equals("") && setVo.getOnline_yna().equals("Y")) {
			sql += "    AND (pro.online_yna = 'Y' OR pro.online_yna = 'A')";
		}
		if (setVo.getLiked().equals("Y") && setVo.getsNo() != null && !setVo.getsNo().equals("")) {
			sql += "    AND pro.t_no IN (select t_no from dibs where s_no ='" + setVo.getsNo() + "')"; // 찜
		}
		sql += " ORDER BY TO_NUMBER(SUBSTR(t_no, 2)) desc"; // 선생님 최신순으로 정렬
		System.out.println("sql: " + sql);
		sql = "select * from (select ROWNUM rnum, tall.* from ("+sql+") tall) tall2  where rnum>=? and rnum<=?";
		System.out.println("sql: " + sql);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);
			pstmt.setInt(2, entRnum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				retVolist = new ArrayList<TeacherVo>();
				do {
					TeacherVo vo = new TeacherVo();
					
					vo.setT_no(rs.getString("t_no"));
					vo.setT_major(rs.getString("t_major"));
					vo.setT_picture(rs.getString("t_picture"));
					vo.setM_nickname(rs.getString("m_nickname"));
					vo.setAvg_rscore(rs.getDouble("avg_rscore"));
					vo.setObject_list(rs.getString("object_list"));
					vo.setArea_list(rs.getString("area_list"));
					
					System.out.println("5" + vo);
					retVolist.add(vo);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("DAO searchTeacher:" + retVolist);

		return retVolist;
	}
	
	//선생님 세기
	public int countTeacher(Connection conn, TeacherSearchSettingVo setVo) {
		int result = 0;
		String sql = "SELECT count(*) "
				+ "    FROM t_profile pro JOIN member m ON  pro.m_id=m.m_id"
				+ "    JOIN view_teacher_rscroe_avg rscore USING (m_nickname)"
				+ "    JOIN view_teacher_object olist USING (m_nickname)"
				+ "    JOIN view_teacher_area alist USING (m_nickname)" 
				+ "    WHERE  1=1 ";
//		if(setVo.getT_profile_yn() != null && !setVo.getT_permit_yn().equals("")) {
//			sql+= "    AND pro.t_permit_yn = '"+setVo.getT_permit_yn()+"'";  // 통화허용
//		}
		if (setVo.getArea_list() != null && !setVo.getArea_list().equals("")) {
			sql += "    AND alist.area_list like '%" + setVo.getArea_list() + "%'"; // 지역 %%
		}
		if (setVo.getGender_fm() != null && !setVo.getGender_fm().equals("")) {
			sql += "    AND m.gender_fm = '" + setVo.getGender_fm() + "'"; // 성별
		}
		if (setVo.getObject_list() != null && !setVo.getObject_list().equals("")) {
			sql += "    AND olist.object_list like '%" + setVo.getObject_list() + "%'"; // 과목 %%
		}
		if (setVo.getT_recruit_yn() != null && !setVo.getT_recruit_yn().equals("")) {
			sql += "    AND pro.t_recruit_yn = '" + setVo.getT_recruit_yn() + "'";// 모집중 모집중Y, 모집중아니면N"
		}
		if (setVo.getOnline_yna() != null && !setVo.getOnline_yna().equals("") && setVo.getOnline_yna().equals("N")) {
			sql += "    AND pro.online_yna = 'N'";
		}
		if (setVo.getOnline_yna() != null && !setVo.getOnline_yna().equals("") && setVo.getOnline_yna().equals("Y")) {
			sql += "    AND (pro.online_yna = 'Y' OR pro.online_yna = 'A')";
		}
		if (setVo.getLiked().equals("Y") && setVo.getsNo() != null && !setVo.getsNo().equals("")) {
			sql += "    AND pro.t_no IN (select t_no from dibs where s_no ='" + setVo.getsNo() + "')"; // 찜
		}

		System.out.println("sql: " + sql);
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("DAO countTeacher:" + result);

		return result;
	}
	
	// 선생님 상세정보 읽기
	public TeacherVo readTeacherInfo(Connection conn, String tNo) {
		TeacherVo retVo = null;
		String sql = "SELECT pro.*, olist.object_list, alist.area_list, round(rscore.avg_rscore, 2) avg_rscore, SUBSTR(m.m_name,1,1) || LPAD('*',LENGTH(m.m_name)-1, '*') m_name, TRUNC(MONTHS_BETWEEN(TRUNC(SYSDATE,'YEAR'), m.m_birth)/12)+2 t_age, m.m_nickname, m.gender_fm, m.m_address "
				+ "FROM t_profile pro JOIN member m ON pro.m_id = m.m_id "
				+ "JOIN view_teacher_rscroe_avg rscore ON rscore.m_nickname = m.m_nickname "
				+ "JOIN view_teacher_object olist ON olist.m_nickname = m.m_nickname "
				+ "JOIN view_teacher_area alist ON alist.m_nickname = m.m_nickname " 
				+ "WHERE t_no = ?";
		String sql2 = "SELECT t_r_no, t_r_writer, m_id, t_no, t_r_content, TO_CHAR(t_r_date, 'YYYY-MM-DD HH24:MI:SS') t_r_date, t_r_score "
				+ "FROM t_review WHERE t_no = ? ORDER BY t_r_date DESC";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				retVo = new TeacherVo();

				retVo.setT_no(rs.getString("t_no"));
				retVo.setT_major(rs.getString("t_major"));
				retVo.setOnline_yna(rs.getString("online_yna"));
				retVo.setT_tcnt(rs.getString("t_tcnt"));
				retVo.setT_tprice(rs.getString("t_tprice"));
				retVo.setT_wantstud(rs.getString("t_wantstud"));
				retVo.setT_career(rs.getString("t_career"));
				retVo.setT_language(rs.getString("t_language"));
				retVo.setT_special(rs.getString("t_special"));
				retVo.setT_approval(rs.getString("t_approval"));
				retVo.setT_profile_yn(rs.getString("t_profile_yn"));
				retVo.setT_picture(rs.getString("t_picture"));
				retVo.setT_intro(rs.getString("t_intro"));
				retVo.setT_recruit_yn(rs.getString("t_recruit_yn"));
				retVo.setObject_list(rs.getString("object_list"));
				retVo.setArea_list(rs.getString("area_List"));
				retVo.setAvg_rscore(rs.getDouble("avg_rscore"));
				retVo.setM_id(rs.getString("m_id"));
				retVo.setT_age(rs.getInt("t_age"));
				retVo.setM_name(rs.getString("m_name"));
				retVo.setM_nickname(rs.getString("m_nickname"));
				retVo.setGender_fm(rs.getString("gender_fm"));
				retVo.setM_address(rs.getString("m_address"));

				close(rs);
				close(pstmt);

				// 리뷰 읽어오기
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, tNo);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					ArrayList<ReviewVo> reviewList = new ArrayList<ReviewVo>();
					do {
						ReviewVo rvo = new ReviewVo();
						rvo.setT_r_no(rs.getInt("t_r_no"));
						rvo.setT_no(rs.getString("t_no"));
						rvo.setT_r_content(rs.getString("t_r_content"));
						rvo.setT_r_date(rs.getTimestamp("t_r_date"));
						rvo.setT_r_score(rs.getInt("t_r_score"));
						rvo.setT_r_writer(rs.getString("t_r_writer"));
						rvo.setM_id(rs.getString("m_id"));
						
						reviewList.add(rvo);
					} while (rs.next());
					retVo.setT_review(reviewList);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return retVo;
	}

	// 선생님 교습정보 수정
	public int updateTeacher(Connection conn, TeacherVo tVo) {
		int result = 0;
		String sql = "update t_profile set t_major=? , online_yna=? , " 
				+ "t_tcnt=? , t_tprice=? , t_wantstud=? , "
				+ "t_career=? , t_language=? , t_special=? , t_profile_yn='Y' , " 
				+ "t_intro=? where t_no=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tVo.getT_major());
			pstmt.setString(2, tVo.getOnline_yna());
			pstmt.setString(3, tVo.getT_tcnt());
			pstmt.setString(4, tVo.getT_tprice());
			pstmt.setString(5, tVo.getT_wantstud());
			pstmt.setString(6, tVo.getT_career());
			pstmt.setString(7, tVo.getT_language());
			pstmt.setString(8, tVo.getT_special());
			pstmt.setString(9, tVo.getT_intro());
			pstmt.setString(10, tVo.getT_no());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	// 선생님 승인여부 체크
	public String checkApproval(Connection conn, String tNo) {
		String result = null;
		String sql = "select T_APPROVAL from t_profile where t_no=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getString("T_APPROVAL");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	// 선생님 교습정보 등록 여부 확인
	public String checkProfile(Connection conn, String tNo) {
		String result = null;
		String sql = "select T_PROFILE_YN from t_profile where t_no=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getString("T_PROFILE_YN");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	// 선생님 담당 과목 넣기
	public int insertObject(Connection conn, String object, String tNo) {
		int result = 0;
		String sql = "insert into TEACH_OBJECT (ob_code, t_no) values( (select ob_code from object where ob_name=?) , ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, tNo);
			pstmt.setString(1, object);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	// 선생님 담당 과목 삭제
	public int deleteObject(Connection conn, String tNo) {
		int result = 0;
		String sql = "delete from teach_object where t_no=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 선생님 활동지역 넣기
	public int insertActiveArea(Connection conn, String activeArea, String tNo) {
		int result = 0;
		String sql = "insert into ACTI_AREA (t_no, area_code) values(?, (select area_code from area where area_name=?) )";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tNo);
			pstmt.setString(2, activeArea);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	// 선생님 활동지역 삭제
	public int deleteActiveArea(Connection conn, String tNo) {
		int result = 0;
		String sql = "delete from acti_area where t_no=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	// 선생님 프로필 사진 등록/변경
	public int updateProfilePicture(Connection conn, TeacherVo tVo) {
		int result = 0;
		String sql = "update t_profile set  T_PICTURE = ? where t_no = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tVo.getT_picture());
			pstmt.setString(2, tVo.getT_no());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	
	// 비승인 선생님 정보 읽기
	public ArrayList<MemberVo> readTeacherApprovalList(Connection conn){
		ArrayList<MemberVo> voList = null;
		String sql = "select m_id, m_name, m_nickname, m_birth, m_phone, m_email, gender_fm, m_date, m_certificate, t_no from member m join t_profile t USING(M_ID) where T_APPROVAL='N'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs != null) {
				voList = new ArrayList<MemberVo>();
				while(rs.next()) {
					MemberVo vo = new MemberVo();
					vo.setmId(rs.getString("m_id"));
					vo.setmName(rs.getString("m_name"));
					vo.setmNickname(rs.getString("m_nickname"));
					vo.setmBirth(rs.getString("m_birth"));
					vo.setmPhone(rs.getString("m_phone"));
					vo.setmEmail(rs.getString("m_email"));
					vo.setGenderFm(rs.getString("gender_fm"));
					vo.setmDate(rs.getTimestamp("m_date"));
					vo.setmCertificate(rs.getString("m_certificate"));
					vo.settNo(rs.getString("t_no"));
					voList.add(vo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return voList;
	}
	
	// 성별에 맞는 선생님 정보 읽기
//	public ArrayList<TeacherVo> readGenderTeacher(Connection conn, String genderFm) {
//		ArrayList<TeacherVo> retVolist = null;
//
//		return retVolist;
//	}

	// 활동지역에 맞는 선생님 정보 읽기
//	public ArrayList<TeacherVo> readAreaTeacher(Connection conn, String area) {
//		ArrayList<TeacherVo> retVolist = null;
//
//		return retVolist;
//	}

	// 온-오프 여부에 맞는 선생님 정보 읽기 (온라인)
//	public ArrayList<TeacherVo> readOnlineTeacher(Connection conn, String onlineYna) {
//		ArrayList<TeacherVo> retVolist = null;
//
//		String sql = " SELECT pro.t_no, pro.t_major, pro.t_picture, m.m_nickname, round(rscore.avg_rscore, 2) avg_rscore, olist.object_list, alist.area_list"
//				+ " FROM t_profile pro JOIN member m" + "				                    ON pro.m_id = m.m_id"
//				+ "				                   JOIN view_teacher_rscroe_avg rscore"
//				+ "				                   ON rscore.m_nickname = m.m_nickname"
//				+ "				                    JOIN view_teacher_object olist"
//				+ "			                    ON olist.m_nickname = m.m_nickname"
//				+ "		                    JOIN view_teacher_area alist"
//				+ "				                   ON alist.m_nickname = m.m_nickname"
//				+ "			                  WHERE  ONLINE_YNA ='Y'";
//		String sql2 = " SELECT pro.t_no, pro.t_major, pro.t_picture, m.m_nickname, round(rscore.avg_rscore, 2) avg_rscore, olist.object_list, alist.area_list"
//				+ " FROM t_profile pro JOIN member m" + "				                    ON pro.m_id = m.m_id"
//				+ "				                   JOIN view_teacher_rscroe_avg rscore"
//				+ "				                   ON rscore.m_nickname = m.m_nickname"
//				+ "				                    JOIN view_teacher_object olist"
//				+ "			                    ON olist.m_nickname = m.m_nickname"
//				+ "		                    JOIN view_teacher_area alist"
//				+ "				                   ON alist.m_nickname = m.m_nickname"
//				+ "			                  WHERE  ONLINE_YNA ='N'";
//		try {
//			pstmt = conn.prepareStatement(sql);
//
//			rs = pstmt.executeQuery();
//			retVolist = new ArrayList<TeacherVo>();
//
//			while (rs.next()) {
//				TeacherVo vo = new TeacherVo();
//				vo.setT_no(rs.getString("t_no"));
//				vo.setT_major(rs.getString("t_major"));
//				vo.setT_picture(rs.getString("t_picture"));
//				vo.setM_nickname(rs.getString("m_nickname"));
//				vo.setAvg_rscore(rs.getDouble("avg_rscore"));
//				vo.setObject_list(rs.getString("object_list"));
//				vo.setArea_list(rs.getString("area_list"));
//				retVolist.add(vo);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rs);
//			close(pstmt);
//		}
//		System.out.println("dao retVolist 1:" + retVolist);
//		return retVolist;
//	}



//	 모집 여부에 맞는 선생님 정보 읽기
//	public ArrayList<TeacherVo> readRecruitTeacher(Connection conn, String tRecruitYn) {
//		ArrayList<TeacherVo> retVolist = null;
//
//		return retVolist;
//	}
//
//	// 찜 여부에 맞는 선생님 정보 읽기
//	public ArrayList<TeacherVo> readLikeTeacher(Connection conn, String sNo) {
//		ArrayList<TeacherVo> retVolist = null;
//
//		return retVolist;
//	}
	// 선생님 통화허용 여부 변경
//	public int updateTeacherPermit(Connection conn, String tNo) {
//		int retsult = 0;
//
//		return retsult;
//	}
//


}
