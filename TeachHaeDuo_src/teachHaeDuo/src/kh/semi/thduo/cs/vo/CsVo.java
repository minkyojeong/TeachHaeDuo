package kh.semi.thduo.cs.vo;

public class CsVo {
	private String faqNo;
	private String faqQuestion;
	private String faqAnswer;
	private String faqCnt;
	private String adminId;
	private String noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private String noticeCnt;
	private String noticeWriteDate;
	
	public String getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(String noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getNoticeCnt() {
		return noticeCnt;
	}
	public void setNoticeCnt(String noticeCnt) {
		this.noticeCnt = noticeCnt;
	}
	public String getNoticeWriteDate() {
		return noticeWriteDate;
	}
	public void setNoticeWriteDate(String noticeWriteDate) {
		this.noticeWriteDate = noticeWriteDate;
	}
	public String getFaqNo() {
		return faqNo;
	}
	public void setFaqNo(String faqNo) {
		this.faqNo = faqNo;
	}
	public String getFaqQuestion() {
		return faqQuestion;
	}
	public void setFaqQuestion(String faqQuestion) {
		this.faqQuestion = faqQuestion;
	}
	public String getFaqAnswer() {
		return faqAnswer;
	}
	public void setFaqAnswer(String faqAnswer) {
		this.faqAnswer = faqAnswer;
	}
	public String getFaqCnt() {
		return faqCnt;
	}
	public void setFaqCnt(String faqCnt) {
		this.faqCnt = faqCnt;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	@Override
	public String toString() {
		return "CsVo [faqNo=" + faqNo + ", faqQuestion=" + faqQuestion + ", faqAnswer=" + faqAnswer + ", faqCnt="
				+ faqCnt + ", adminId=" + adminId + ", noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle
				+ ", noticeContent=" + noticeContent + ", noticeCnt=" + noticeCnt + ", noticeWriteDate="
				+ noticeWriteDate + "]";
	}
	
}
