package kh.semi.thduo.board.vo;

public class BoardReportVo {
	public String bRNo;
	public String bNo;
	public String bRWriter;
	public String bRCategory;
	public String bRWriteDate;
	
	
	public String getbRNo() {
		return bRNo;
	}
	public void setbRNo(String bRNo) {
		this.bRNo = bRNo;
	}
	public String getbNo() {
		return bNo;
	}
	public void setbNo(String bNo) {
		this.bNo = bNo;
	}
	public String getbRWriter() {
		return bRWriter;
	}
	public void setbRWriter(String bRWriter) {
		this.bRWriter = bRWriter;
	}
	public String getbRCategory() {
		return bRCategory;
	}
	public void setbRCategory(String bRCategory) {
		this.bRCategory = bRCategory;
	}
	public String getbRWriteDate() {
		return bRWriteDate;
	}
	public void setbRWriteDate(String bRWriteDate) {
		this.bRWriteDate = bRWriteDate;
	}
	@Override
	public String toString() {
		return "BoardReportVo [bRNo=" + bRNo + ", bNo=" + bNo + ", bRWriter=" + bRWriter + ", bRCategory=" + bRCategory
				+ ", bRWriteDate=" + bRWriteDate + "]";
	}
	
}
