package kh.semi.thduo.like.model.vo;

public class LikeVo {
	private String s_no;
	private String t_no;
	private String m_id;
	
	@Override
	public String toString() {
		return "LikeVo [s_no=" + s_no + ", t_no=" + t_no + ", m_id=" + m_id + "]";
	}

	public String getS_no() {
		return s_no;
	}

	public void setS_no(String s_no) {
		this.s_no = s_no;
	}

	public String getT_no() {
		return t_no;
	}

	public void setT_no(String t_no) {
		this.t_no = t_no;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
}
