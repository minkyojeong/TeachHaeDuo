package kh.semi.thduo.student.vo;

import java.sql.Timestamp;

public class StudentVo {

	private String mId;
	private String sNo;

	public String getsNo() {
		return sNo;
	}

	public void setsNo(String sNo) {
		this.sNo = sNo;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	@Override
	public String toString() {
		return "StudentVo [mId=" + mId + ", sNo=" + sNo + "]";
	}

}
