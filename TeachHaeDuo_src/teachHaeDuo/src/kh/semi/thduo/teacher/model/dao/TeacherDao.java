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
import kh.semi.thduo.review.model.vo.ReviewVo;
import kh.semi.thduo.teacher.model.vo.TeacherSearchSettingVo;
import kh.semi.thduo.teacher.model.vo.TeacherVo;

public class TeacherDao {
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 선생님 교습정보 삽입
	public int insertTeacher(Connection conn, TeacherVo vo) {
		int result = 0;
		String sql = "";

		return result;
	}

	// 모든 선생님 정보 읽기
	public ArrayList<TeacherVo> readAllTeacher(Connection conn) {
		ArrayList<TeacherVo> retVolist = null;
		String sql = "SELECT pro.t_no, pro.t_major, pro.t_picture, m.m_nickname, round(rscore.avg_rscore, 2) avg_rscore, olist.object_list, alist.area_list"
				+ " FROM t_profile pro JOIN member m" + "                    ON pro.m_id = m.m_id"
				+ "                    JOIN view_teacher_rscroe_avg rscore"
				+ "                    ON rscore.m_nickname = m.m_nickname"
				+ "                    JOIN view_teacher_object olist"
				+ "                    ON olist.m_nickname = m.m_nickname"
				+ "                    JOIN view_teacher_area alist"
				+ "                    ON alist.m_nickname = m.m_nickname"
				+ " ORDER BY TO_NUMBER(SUBSTR(t_no, 2)) desc";
		try {
			pstmt = conn.prepareStatement(sql);
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

	// 검색한 과목에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readTeacher(Connection conn, String object) {
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

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + object + "%");
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
				} while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return retVolist;
	}

	// 성별에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readGenderTeacher(Connection conn, String genderFm) {
		ArrayList<TeacherVo> retVolist = null;

		return retVolist;
	}

	// 활동지역에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readAreaTeacher(Connection conn, String area) {
		ArrayList<TeacherVo> retVolist = null;

		return retVolist;
	}

	// 성별과 활동지역 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readAreaGenderTeacher(Connection conn, String genderFm, String area) {
		ArrayList<TeacherVo> retVolist = null;
		String a = "%" + area + "%";

		String sql = "SELECT pro.t_no, pro.t_major, pro.t_picture, m.m_nickname, round(rscore.avg_rscore, 2) avg_rscore, olist.object_list, alist.area_list"
				+ " FROM t_profile pro JOIN member m" // 띄어쓰기 꼭하기
				+ "                    ON pro.m_id = m.m_id" + "                    JOIN view_teacher_rscroe_avg rscore"
				+ "                    ON rscore.m_nickname = m.m_nickname"
				+ "                    JOIN view_teacher_object olist"
				+ "                    ON olist.m_nickname = m.m_nickname"
				+ "                    JOIN view_teacher_area alist"
				+ "                    ON alist.m_nickname = m.m_nickname" + "                    WHERE  1=1 ";
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
//				vo.setT_picture(rs.getString("t_picture"));
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

	// 온-오프 여부에 맞는 선생님 정보 읽기 (온라인)
	public ArrayList<TeacherVo> readOnlineTeacher(Connection conn, String onlineYna) {
		ArrayList<TeacherVo> retVolist = null;

		String sql = " SELECT pro.t_no, pro.t_major, pro.t_picture, m.m_nickname, round(rscore.avg_rscore, 2) avg_rscore, olist.object_list, alist.area_list"
				+ " FROM t_profile pro JOIN member m" + "				                    ON pro.m_id = m.m_id"
				+ "				                   JOIN view_teacher_rscroe_avg rscore"
				+ "				                   ON rscore.m_nickname = m.m_nickname"
				+ "				                    JOIN view_teacher_object olist"
				+ "			                    ON olist.m_nickname = m.m_nickname"
				+ "		                    JOIN view_teacher_area alist"
				+ "				                   ON alist.m_nickname = m.m_nickname"
				+ "			                  WHERE  ONLINE_YNA ='Y'";
		String sql2 = " SELECT pro.t_no, pro.t_major, pro.t_picture, m.m_nickname, round(rscore.avg_rscore, 2) avg_rscore, olist.object_list, alist.area_list"
				+ " FROM t_profile pro JOIN member m" + "				                    ON pro.m_id = m.m_id"
				+ "				                   JOIN view_teacher_rscroe_avg rscore"
				+ "				                   ON rscore.m_nickname = m.m_nickname"
				+ "				                    JOIN view_teacher_object olist"
				+ "			                    ON olist.m_nickname = m.m_nickname"
				+ "		                    JOIN view_teacher_area alist"
				+ "				                   ON alist.m_nickname = m.m_nickname"
				+ "			                  WHERE  ONLINE_YNA ='N'";
		try {
			pstmt = conn.prepareStatement(sql);

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

	// 통화허용 여부에 맞는 선생님 정보 읽기
//	public ArrayList<TeacherVo> readCallTeacher(Connection conn, String tPermitYn){
//		ArrayList<TeacherVo> retVolist = null;
//		String sql =" SELECT pro.t_no, pro.t_major, pro.t_picture, m.m_nickname, round(rscore.avg_rscore, 2) avg_rscore, olist.object_list, alist.area_list"
//				+ " FROM t_profile pro JOIN member m"
//				+ "				                    ON pro.m_id = m.m_id"
//				+ "				                   JOIN view_teacher_rscroe_avg rscore"
//				+ "				                   ON rscore.m_nickname = m.m_nickname"
//				+ "				                    JOIN view_teacher_object olist"
//				+ "			                    ON olist.m_nickname = m.m_nickname"
//				+ "		                    JOIN view_teacher_area alist"
//				+ "				                   ON alist.m_nickname = m.m_nickname"
//				+ "			                  WHERE  t_profile_yn ='Y'";
//		String sql2= " SELECT pro.t_no, pro.t_major, pro.t_picture, m.m_nickname, round(rscore.avg_rscore, 2) avg_rscore, olist.object_list, alist.area_list"
//				+ " FROM t_profile pro JOIN member m"
//				+ "				                    ON pro.m_id = m.m_id"
//				+ "				                   JOIN view_teacher_rscroe_avg rscore"
//				+ "				                   ON rscore.m_nickname = m.m_nickname"
//				+ "				                    JOIN view_teacher_object olist"
//				+ "			                    ON olist.m_nickname = m.m_nickname"
//				+ "		                    JOIN view_teacher_area alist"
//				+ "				                   ON alist.m_nickname = m.m_nickname"
//				+ "			                  WHERE  t_profile_yn ='N'";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			retVolist = new ArrayList<TeacherVo>();
//			
//			while(rs.next()) {
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

	// 모집 여부에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readRecruitTeacher(Connection conn, String tRecruitYn) {
		ArrayList<TeacherVo> retVolist = null;

		return retVolist;
	}

	// 찜 여부에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readLikeTeacher(Connection conn, String sNo) {
		ArrayList<TeacherVo> retVolist = null;

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
	public ArrayList<TeacherVo> searchTeacher(Connection conn, TeacherSearchSettingVo setVo) {
		ArrayList<TeacherVo> retVolist = null;
		String sql = "SELECT pro.*, m_nickname, gender_fm, round(rscore.avg_rscore, 2) avg_rscore, olist.object_list, alist.area_list"
				+ "    FROM t_profile pro JOIN member m ON  pro.m_id=m.m_id"
				+ "    JOIN view_teacher_rscroe_avg rscore USING (m_nickname)"
				+ "    JOIN view_teacher_object olist USING (m_nickname)"
				+ "    JOIN view_teacher_area alist USING (m_nickname)" + "    WHERE  1=1 ";
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

	// 선생님 상세정보 읽기
	public TeacherVo readTeacherInfo(Connection conn, String tNo) {
		TeacherVo retVo = null;
		String sql = "SELECT pro.*, olist.object_list, alist.area_list, round(rscore.avg_rscore, 2) avg_rscore, SUBSTR(m.m_name,1,1) || LPAD('*',LENGTH(m.m_name)-1, '*') m_name, TRUNC(MONTHS_BETWEEN(TRUNC(SYSDATE,'YEAR'), m.m_birth)/12)+2 t_age, m.m_nickname, m.gender_fm, m.m_address "
				+ "FROM t_profile pro JOIN member m ON pro.m_id = m.m_id "
				+ "JOIN view_teacher_rscroe_avg rscore ON rscore.m_nickname = m.m_nickname "
				+ "JOIN view_teacher_object olist ON olist.m_nickname = m.m_nickname "
				+ "JOIN view_teacher_area alist ON alist.m_nickname = m.m_nickname " + "WHERE t_no = ?";
		String sql2 = "SELECT t_r_no, t_r_writer, m_id, t_no, t_r_content, TO_CHAR(t_r_date, 'YYYY-MM-DD HH24:MI:SS') t_r_date, t_r_score "
				+ "FROM t_review WHERE t_no = ? ORDER BY t_r_date DESC";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tNo);
			rs = pstmt.executeQuery();
//			private ArrayList<ReviewVo> tReview;

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
		String sql = "update t_profile set t_major=? , online_yna=? , " + "t_tcnt=? , t_tprice=? , t_wantstud=? , "
				+ "t_career=? , t_language=? , t_special=? , t_profile_yn='Y' , " + "t_intro=? where t_no=?";

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

	// 선생님 통화허용 여부 변경
	public int updateTeacherPermit(Connection conn, String tNo) {
		int retsult = 0;

		return retsult;
	}

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
	public int insertObject(Connection conn, String[] object, String tNo) {
		int result = 0;
		String sql = "insert into TEACH_OBJECT (ob_code, t_no) values( (select ob_code from object where ob_name=?) , ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, tNo);
			for (int i = 0; i < object.length; i++) {
				pstmt.setString(1, object[i]);
				result = pstmt.executeUpdate();
				if (result == 0) {
					break;
				} else {
					continue;
				}
			}

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
	public int insertActiveArea(Connection conn, String[] activeArea, String tNo) {
		int result = 0;
		String sql = "insert into ACTI_AREA (t_no, area_code) values(?, (select area_code from area where area_name=?) )";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tNo);
			for (int i = 0; i < activeArea.length; i++) {
				pstmt.setString(2, activeArea[i]);
				result = pstmt.executeUpdate();
				System.out.println("dao result" + i + ":" + result);
				if (result == 0) {
					break;
				} else {
					continue;
				}
			}

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
}
