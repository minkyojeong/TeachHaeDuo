package kh.semi.thduo.report.model.vo;

import java.sql.Timestamp;

public class ReportVo {
	private int m_r_no;
	private String m_r_sendid;
	private String m_r_sendName;
	private String m_r_receiveid;
	private String m_r_receiveName;
	private String m_r_category;
	private String m_r_content;
	private Timestamp t_r_date;
	private String m_id;
	private String t_no;
	private String m_r_receiveNickname;
	
	

	public ReportVo() {
		super();
	}

	@Override
	public String toString() {
		return "ReportVo [m_r_no=" + m_r_no + ", m_r_sendid=" + m_r_sendid + ", m_r_sendName=" + m_r_sendName
				+ ", m_r_receiveid=" + m_r_receiveid + ", m_r_receiveName=" + m_r_receiveName + ", m_r_category="
				+ m_r_category + ", m_r_content=" + m_r_content + ", t_r_date=" + t_r_date + ", m_id=" + m_id
				+ ", t_no=" + t_no + ", m_r_receiveNickname=" + m_r_receiveNickname + "]";
	}
	public String getM_r_receiveNickname() {
		return m_r_receiveNickname;
	}

	public void setM_r_receiveNickname(String m_r_receiveNickname) {
		this.m_r_receiveNickname = m_r_receiveNickname;
	}
	public String getT_no() {
		return t_no;
	}

	public void setT_no(String t_no) {
		this.t_no = t_no;
	}

	public String getM_r_sendName() {
		return m_r_sendName;
	}

	public void setM_r_sendName(String m_r_sendName) {
		this.m_r_sendName = m_r_sendName;
	}

	public String getM_r_receiveName() {
		return m_r_receiveName;
	}

	public void setM_r_receiveName(String m_r_receiveName) {
		this.m_r_receiveName = m_r_receiveName;
	}

	public int getM_r_no() {
		return m_r_no;
	}

	public void setM_r_no(int m_r_no) {
		this.m_r_no = m_r_no;
	}

	public String getM_r_sendid() {
		return m_r_sendid;
	}

	public void setM_r_sendid(String m_r_sendid) {
		this.m_r_sendid = m_r_sendid;
	}

	public String getM_r_receiveid() {
		return m_r_receiveid;
	}

	public void setM_r_receiveid(String m_r_receiveid) {
		this.m_r_receiveid = m_r_receiveid;
	}

	public String getM_r_category() {
		return m_r_category;
	}

	public void setM_r_category(String m_r_category) {
		this.m_r_category = m_r_category;
	}

	public String getM_r_content() {
		return m_r_content;
	}

	public void setM_r_content(String m_r_content) {
		this.m_r_content = m_r_content;
	}

	public Timestamp getT_r_date() {
		return t_r_date;
	}

	public void setT_r_date(Timestamp t_r_date) {
		this.t_r_date = t_r_date;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
}
