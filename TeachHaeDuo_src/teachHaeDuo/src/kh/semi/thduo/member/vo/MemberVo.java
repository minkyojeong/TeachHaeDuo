package kh.semi.thduo.member.vo;

import java.sql.Timestamp;

public class MemberVo {
	
	private String 			mId;			
	private String 			mPw; 	
	private String 			mName;	
	private String 			mNickname;	
	private String 			mBirth;		
	private String 			mAddress;	
	private String 			mPhone;		
	private String 			mEmail;		
	private String 			genderFm;	
	private String 			roleSt;		
	private Timestamp 		mDate;	
	private String 			mCertificate;
	private String 			mAlarmYn;
	private String          tNo;
	private String			tRecruitYn;
	private String 			sNo;
	private Timestamp 		cpDate;
	private String 			cpCash;
	
	
	
	public Timestamp getCpDate() {
		return cpDate;
	}
	public void setCpDate(Timestamp cpDate) {
		this.cpDate = cpDate;
	}
	public String getCpCash() {
		return cpCash;
	}
	public void setCpCash(String cpCash) {
		this.cpCash = cpCash;
	}
	public String getsNo() {
		return sNo;
	}
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	public String gettRecruitYn() {
		return tRecruitYn;
	}
	public void settRecruitYn(String tRecruitYn) {
		this.tRecruitYn = tRecruitYn;
	}
	public String gettNo() {
		return tNo;
	}
	public void settNo(String tNo) {
		this.tNo = tNo;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPw() {
		return mPw;
	}
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmNickname() {
		return mNickname;
	}
	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
	}
	public String getmBirth() {
		return mBirth;
	}
	public void setmBirth(String mBirth) {
		this.mBirth = mBirth;
	}
	public String getmAddress() {
		return mAddress;
	}
	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}
	public String getmPhone() {
		return mPhone;
	}
	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public String getGenderFm() {
		return genderFm;
	}
	public void setGenderFm(String genderFm) {
		this.genderFm = genderFm;
	}
	public String getRoleSt() {
		return roleSt;
	}
	public void setRoleSt(String roleSt) {
		this.roleSt = roleSt;
	}
	public Timestamp getmDate() {
		return mDate;
	}
	public void setmDate(Timestamp mDate) {
		this.mDate = mDate;
	}
	public String getmCertificate() {
		return mCertificate;
	}
	public void setmCertificate(String mCertificate) {
		this.mCertificate = mCertificate;
	}
	public String getmAlarmYn() {
		return mAlarmYn;
	}
	public void setmAlarmYn(String mAlarmYn) {
		this.mAlarmYn = mAlarmYn;
	}
	@Override
	public String toString() {
		return "MemberVo [mId=" + mId + ", mPw=" + mPw + ", mName=" + mName + ", mNickname=" + mNickname + ", mBirth="
				+ mBirth + ", mAddress=" + mAddress + ", mPhone=" + mPhone + ", mEmail=" + mEmail + ", genderFm="
				+ genderFm + ", roleSt=" + roleSt + ", mDate=" + mDate + ", mCertificate=" + mCertificate
				+ ", mAlarmYn=" + mAlarmYn + ", tNo=" + tNo + ", tRecruitYn=" + tRecruitYn + ", sNo=" + sNo
				+ ", cpDate=" + cpDate + ", cpCash=" + cpCash + "]";
	}
	
}
	
	

