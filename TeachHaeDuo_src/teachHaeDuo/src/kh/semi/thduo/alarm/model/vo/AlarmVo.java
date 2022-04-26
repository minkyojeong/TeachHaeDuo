package kh.semi.thduo.alarm.model.vo;

import java.sql.Timestamp;

public class AlarmVo {

	private int alarm_no;
	private String alarm_content;
	private Timestamp alarm_date;
	private String alarm_sendid;
	private String alarm_receiveid;
	private String m_id;
	
	public AlarmVo() {
		super();
	}

	@Override
	public String toString() {
		return "AlarmVo [alarm_no=" + alarm_no + ", alarm_content=" + alarm_content + ", alarm_date=" + alarm_date
				+ ", alarm_sendid=" + alarm_sendid + ", alarm_receiveid=" + alarm_receiveid + ", m_id=" + m_id + "]";
	}
	
	public int getAlarm_no() {
		return alarm_no;
	}
	public void setAlarm_no(int alarm_no) {
		this.alarm_no = alarm_no;
	}
	public String getAlarm_content() {
		return alarm_content;
	}
	public void setAlarm_content(String alarm_content) {
		this.alarm_content = alarm_content;
	}
	public Timestamp getAlarm_date() {
		return alarm_date;
	}
	public void setAlarm_date(Timestamp alarm_date) {
		this.alarm_date = alarm_date;
	}
	public String getAlarm_sendid() {
		return alarm_sendid;
	}
	public void setAlarm_sendid(String alarm_sendid) {
		this.alarm_sendid = alarm_sendid;
	}
	public String getAlarm_receiveid() {
		return alarm_receiveid;
	}
	public void setAlarm_receiveid(String alarm_receiveid) {
		this.alarm_receiveid = alarm_receiveid;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
}
