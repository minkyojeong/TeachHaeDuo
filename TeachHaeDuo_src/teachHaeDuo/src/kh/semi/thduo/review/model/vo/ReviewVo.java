package kh.semi.thduo.review.model.vo;

import java.sql.Timestamp;

public class ReviewVo {
	private int tRNo;
	private String tNo;
	private String tRContent;
	private Timestamp tRDate; 
	private int tRScore;
	
	public ReviewVo() {
		super();
	}

	@Override
	public String toString() {
		return "ReviewVo [tRNo=" + tRNo + ", tNo=" + tNo + ", tRContent=" + tRContent + ", tRDate=" + tRDate
				+ ", tRScore=" + tRScore + "]";
	}

	public int getTRNo() {
		return tRNo;
	}

	public void setTRNo(int tRNo) {
		this.tRNo = tRNo;
	}

	public String getTNo() {
		return tNo;
	}

	public void setTNo(String tNo) {
		this.tNo = tNo;
	}

	public String getTRContent() {
		return tRContent;
	}

	public void setTRContent(String tRContent) {
		this.tRContent = tRContent;
	}

	public Timestamp getTRDate() {
		return tRDate;
	}

	public void setTRDate(Timestamp tRDate) {
		this.tRDate = tRDate;
	}

	public int getTRScore() {
		return tRScore;
	}

	public void setTRScore(int tRScore) {
		this.tRScore = tRScore;
	}
}
