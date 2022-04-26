package kh.semi.thduo.review.model.vo;

import java.sql.Timestamp;

public class ReviewVo {
	private int t_r_no;
	private String t_no;
	private String t_r_content;
	private Timestamp t_r_date; 
	private int t_r_score;
	private String t_r_writer;
	private String m_id;
	
	public ReviewVo() {
		
	}

	@Override
	public String toString() {
		return "ReviewVo [t_r_no=" + t_r_no + ", t_no=" + t_no + ", t_r_content=" + t_r_content + ", t_r_date="
				+ t_r_date + ", t_r_score=" + t_r_score + ", t_r_writer=" + t_r_writer + ", m_id=" + m_id + "]";
	}

	public int getT_r_no() {
		return t_r_no;
	}

	public void setT_r_no(int t_r_no) {
		this.t_r_no = t_r_no;
	}

	public String getT_no() {
		return t_no;
	}

	public void setT_no(String t_no) {
		this.t_no = t_no;
	}

	public String getT_r_content() {
		return t_r_content;
	}

	public void setT_r_content(String t_r_content) {
		this.t_r_content = t_r_content;
	}

	public Timestamp getT_r_date() {
		return t_r_date;
	}

	public void setT_r_date(Timestamp t_r_date) {
		this.t_r_date = t_r_date;
	}

	public int getT_r_score() {
		return t_r_score;
	}

	public void setT_r_score(int t_r_score) {
		this.t_r_score = t_r_score;
	}

	public String getT_r_writer() {
		return t_r_writer;
	}

	public void setT_r_writer(String t_r_writer) {
		this.t_r_writer = t_r_writer;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
}