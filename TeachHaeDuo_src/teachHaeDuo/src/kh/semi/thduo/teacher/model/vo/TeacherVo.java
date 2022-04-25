package kh.semi.thduo.teacher.model.vo;

import java.util.ArrayList;

import kh.semi.thduo.review.model.vo.ReviewVo;

public class TeacherVo {
	private String tNo;
	private String tMajor;
	private String onlineYna;
	private String tTcnt;
	private String tTprice;
	private String tWantstud;
	private String tCareer;
	private String tLanguage;
	private String tSpecial;
	private String tApproval;
	private String tPermitYn;
	private String tPicture;
	private String tIntro;
	private String tRecruitYn;
	private String objectList;
	private String areaList;
	private double avgRscore;
	private String mId;
	private int tAge;
	private String mName;
	private String mNickname;
	private String genderFm;
	private String mAddress;
	private ArrayList<ReviewVo> tReview;
	
	public TeacherVo() {
		super();
	}

	@Override
	public String toString() {
		return "TeacherVo [tNo=" + tNo + ", tMajor=" + tMajor + ", onlineYna=" + onlineYna + ", tTcnt=" + tTcnt
				+ ", tTprice=" + tTprice + ", tWantstud=" + tWantstud + ", tCareer=" + tCareer + ", tLanguage="
				+ tLanguage + ", tSpecial=" + tSpecial + ", tApproval=" + tApproval + ", tPermitYn=" + tPermitYn
				+ ", tPicture=" + tPicture + ", tIntro=" + tIntro + ", tRecruitYn=" + tRecruitYn + ", objectList="
				+ objectList + ", areaList=" + areaList + ", avgRscore=" + avgRscore + ", mId=" + mId + ", tAge=" + tAge
				+ ", mName=" + mName + ", mNickname=" + mNickname + ", genderFm=" + genderFm + ", mAddress=" + mAddress
				+ ", tReview=" + tReview + "]";
	}

	public String getTNo() {
		return tNo;
	}

	public void setTNo(String tNo) {
		this.tNo = tNo;
	}

	public String getTMajor() {
		return tMajor;
	}

	public void setTMajor(String tMajor) {
		this.tMajor = tMajor;
	}

	public String getOnlineYna() {
		return onlineYna;
	}

	public void setOnlineYna(String onlineYna) {
		this.onlineYna = onlineYna;
	}

	public String getTTcnt() {
		return tTcnt;
	}

	public void setTTcnt(String tTcnt) {
		this.tTcnt = tTcnt;
	}

	public String getTTprice() {
		return tTprice;
	}

	public void setTTprice(String tTprice) {
		this.tTprice = tTprice;
	}

	public String getTWantstud() {
		return tWantstud;
	}

	public void setTWantstud(String tWantstud) {
		this.tWantstud = tWantstud;
	}

	public String getTCareer() {
		return tCareer;
	}

	public void setTCareer(String tCareer) {
		this.tCareer = tCareer;
	}

	public String getTLanguage() {
		return tLanguage;
	}

	public void setTLanguage(String tLanguage) {
		this.tLanguage = tLanguage;
	}

	public String getTSpecial() {
		return tSpecial;
	}

	public void setTSpecial(String tSpecial) {
		this.tSpecial = tSpecial;
	}

	public String getTApproval() {
		return tApproval;
	}

	public void setTApproval(String tApproval) {
		this.tApproval = tApproval;
	}

	public String getTPermitYn() {
		return tPermitYn;
	}

	public void setTPermitYn(String tPermitYn) {
		this.tPermitYn = tPermitYn;
	}

	public String getTPicture() {
		return tPicture;
	}

	public void setTPicture(String tPicture) {
		this.tPicture = tPicture;
	}

	public String getTIntro() {
		return tIntro;
	}

	public void setTIntro(String tIntro) {
		this.tIntro = tIntro;
	}

	public String getTRecruitYn() {
		return tRecruitYn;
	}

	public void setTRecruitYn(String tRecruitYn) {
		this.tRecruitYn = tRecruitYn;
	}

	public String getObjectList() {
		return objectList;
	}

	public void setObjectList(String objectList) {
		this.objectList = objectList;
	}

	public String getAreaList() {
		return areaList;
	}

	public void setAreaList(String areaList) {
		this.areaList = areaList;
	}

	public double getAvgRscore() {
		return avgRscore;
	}

	public void setAvgRscore(double avgRscore) {
		this.avgRscore = avgRscore;
	}

	public String getMId() {
		return mId;
	}

	public void setMId(String mId) {
		this.mId = mId;
	}

	public int getTAge() {
		return tAge;
	}

	public void setTAge(int tAge) {
		this.tAge = tAge;
	}

	public String getMName() {
		return mName;
	}

	public void setMName(String mName) {
		this.mName = mName;
	}

	public String getMNickname() {
		return mNickname;
	}

	public void setMNickname(String mNickname) {
		this.mNickname = mNickname;
	}

	public String getGenderFm() {
		return genderFm;
	}

	public void setGenderFm(String genderFm) {
		this.genderFm = genderFm;
	}

	public String getMAddress() {
		return mAddress;
	}

	public void setMAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	public ArrayList<ReviewVo> getTReview() {
		return tReview;
	}

	public void setTReview(ArrayList<ReviewVo> tReview) {
		this.tReview = tReview;
	}
}
