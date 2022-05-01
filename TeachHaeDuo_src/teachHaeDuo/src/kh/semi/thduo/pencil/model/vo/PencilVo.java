package kh.semi.thduo.pencil.model.vo;

import java.sql.Timestamp;

public class PencilVo {
	private int cpNo;
	private String cpContent;
	private int cpCash;
	private Timestamp cpDate;
	private String mId;
	
	
	public PencilVo() {
		super();
	}





	@Override
	public String toString() {
		return "PencilVo [cpNo=" + cpNo + ", cpContent=" + cpContent + ", cpCash=" + cpCash + ", cpDate=" + cpDate
				+ ", mId=" + mId + "]";
	}


	public int getCpNo() {
		return cpNo;
	}


	public void setCpNo(int cpNo) {
		this.cpNo = cpNo;
	}


	public String getCpContent() {
		return cpContent;
	}


	public int getCpCash() {
		return cpCash;
	}





	public void setCpCash(int cpCash) {
		this.cpCash = cpCash;
	}





	public void setCpContent(String cpContent) {
		this.cpContent = cpContent;
	}


	public Timestamp getCpDate() {
		return cpDate;
	}


	public void setCpDate(Timestamp cpDate) {
		this.cpDate = cpDate;
	}


	public String getmId() {
		return mId;
	}


	public void setmId(String mId) {
		this.mId = mId;
	}

	
	
	
}
