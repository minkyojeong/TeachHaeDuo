package kh.semi.thduo.pencil.model.vo;

import java.sql.Timestamp;

public class PencilVo {
	private int cmNo;
	private String cmContent;
	private int cmPencil;
	private Timestamp cmDate;
	private String mId;
	
	
	public PencilVo(int cmNo, String cmContent, int cmPencil, Timestamp cmDate, String mId) {
		super();
		this.cmNo = cmNo;
		this.cmContent = cmContent;
		this.cmPencil = cmPencil;
		this.cmDate = cmDate;
		this.mId = mId;
	}

	@Override
	public String toString() {
		return "PencilVo [cmNo=" + cmNo + ", cmContent=" + cmContent + ", cmPencil=" + cmPencil + ", cmDate=" + cmDate
				+ ", mId=" + mId + "]";
	}

	public int getCmNo() {
		return cmNo;
	}

	public void setCmNo(int cmNo) {
		this.cmNo = cmNo;
	}

	public String getCmContent() {
		return cmContent;
	}

	public void setCmContent(String cmContent) {
		this.cmContent = cmContent;
	}

	public int getCmPencil() {
		return cmPencil;
	}

	public void setCmPencil(int cmPencil) {
		this.cmPencil = cmPencil;
	}

	public Timestamp getCmDate() {
		return cmDate;
	}

	public void setCmDate(Timestamp cmDate) {
		this.cmDate = cmDate;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}
	
	
}
