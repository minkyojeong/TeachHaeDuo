package kh.semi.thduo.board.vo;

public class BoardReCommentVo {
	private String rNo;
	private String rContent;
	private String rWriter;
	private String rWriteDate;
	private String bNo;
	
	@Override
	public String toString() {
		return "BoardReCommentVo [rNo=" + rNo + ", rContent=" + rContent + ", rWriter=" + rWriter + ", rWriteDate="
				+ rWriteDate + ", bNo=" + bNo + "]";
	}
	public String getrNo() {
		return rNo;
	}
	public void setrNo(String rNo) {
		this.rNo = rNo;
	}
	public String getrContent() {
		return rContent;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	public String getrWriter() {
		return rWriter;
	}
	public void setrWriter(String rWriter) {
		this.rWriter = rWriter;
	}
	public String getrWriteDate() {
		return rWriteDate;
	}
	public void setrWriteDate(String rWriteDate) {
		this.rWriteDate = rWriteDate;
	}
	public String getbNo() {
		return bNo;
	}
	public void setbNo(String bNo) {
		this.bNo = bNo;
	}
}
