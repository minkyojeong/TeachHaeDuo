package kh.semi.thduo.board.vo;

import java.sql.Timestamp;
import java.util.ArrayList;



public class BoardVo {
	private String bNo;
	private String bCategory;
	private String bTitle;
	private String bContent;
	private String bWriter;
	private String bWriteDate;
	private String bCnt;
	private String mId;
	private ArrayList<BoardReCommentVo> reCommentList;
	
	@Override
	public String toString() {
		return "BoardVo [bNo=" + bNo + ", bCategory=" + bCategory + ", bTitle=" + bTitle + ", bContent=" + bContent
				+ ", bWriter=" + bWriter + ", bWriteDate=" + bWriteDate + ", bCnt=" + bCnt + ", mId=" + mId + "]";
	}
	public String getbNo() {
		return bNo;
	}
	public void setbNo(String bNo) {
		this.bNo = bNo;
	}
	public String getbCategory() {
		return bCategory;
	}
	public void setbCategory(String bCategory) {
		this.bCategory = bCategory;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getbWriter() {
		return bWriter;
	}
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}
	public String getbWriteDate() {
		return bWriteDate;
	}
	public void setbWriteDate(String bWriteDate) {
		this.bWriteDate = bWriteDate;
	}
	public String getbCnt() {
		return bCnt;
	}
	public void setbCnt(String bCnt) {
		this.bCnt = bCnt;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public ArrayList<BoardReCommentVo> getReCommentList() {
		return reCommentList;
	}
	public void setReCommentList(ArrayList<BoardReCommentVo> reCommentList) {
		this.reCommentList = reCommentList;
	}
	
}