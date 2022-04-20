package kh.semi.thduo.alarm.model.vo;

import java.sql.Timestamp;

public class AlarmVo {
	private int alarmNo;
	private String alarmContent;
	private Timestamp alarmDate;
	private String alarmSendId;
	private String alarmReceiveId;
	private String mId;
	
	
	public AlarmVo(int alarmNo, String alarmContent, Timestamp alarmDate, String alarmSendId, String alarmReceiveId,
			String mId) {
		super();
		this.alarmNo = alarmNo;
		this.alarmContent = alarmContent;
		this.alarmDate = alarmDate;
		this.alarmSendId = alarmSendId;
		this.alarmReceiveId = alarmReceiveId;
		this.mId = mId;
	}


	@Override
	public String toString() {
		return "AlarmVo [alarmNo=" + alarmNo + ", alarmContent=" + alarmContent + ", alarmDate=" + alarmDate
				+ ", alarmSendId=" + alarmSendId + ", alarmReceiveId=" + alarmReceiveId + ", mId=" + mId + "]";
	}


	public int getAlarmNo() {
		return alarmNo;
	}


	public void setAlarmNo(int alarmNo) {
		this.alarmNo = alarmNo;
	}


	public String getAlarmContent() {
		return alarmContent;
	}


	public void setAlarmContent(String alarmContent) {
		this.alarmContent = alarmContent;
	}


	public Timestamp getAlarmDate() {
		return alarmDate;
	}


	public void setAlarmDate(Timestamp alarmDate) {
		this.alarmDate = alarmDate;
	}


	public String getAlarmSendId() {
		return alarmSendId;
	}


	public void setAlarmSendId(String alarmSendId) {
		this.alarmSendId = alarmSendId;
	}


	public String getAlarmReceiveId() {
		return alarmReceiveId;
	}


	public void setAlarmReceiveId(String alarmReceiveId) {
		this.alarmReceiveId = alarmReceiveId;
	}


	public String getmId() {
		return mId;
	}


	public void setmId(String mId) {
		this.mId = mId;
	}
	
	
}
