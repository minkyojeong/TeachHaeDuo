package kh.semi.thduo.pencil.model.vo;

import java.sql.Timestamp;

public class PencilVo {
	private int cpNo;
	private String cpContent;
	private int cpPencil;
	private Timestamp cpDate;
	private String mId;
	
	
	public PencilVo() {
		super();
	}


	public PencilVo(int cpNo, String cpContent, int cpPencil, Timestamp cpDate, String mId) {
		super();
		this.cpNo = cpNo;
		this.cpContent = cpContent;
		this.cpPencil = cpPencil;
		this.cpDate = cpDate;
		this.mId = mId;
	}


	@Override
	public String toString() {
		return "PencilVo [cpNo=" + cpNo + ", cpContent=" + cpContent + ", cpPencil=" + cpPencil + ", cpDate=" + cpDate
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


	public void setCpContent(String cpContent) {
		this.cpContent = cpContent;
	}


	public int getCpPencil() {
		return cpPencil;
	}


	public void setCpPencil(int cpPencil) {
		this.cpPencil = cpPencil;
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
