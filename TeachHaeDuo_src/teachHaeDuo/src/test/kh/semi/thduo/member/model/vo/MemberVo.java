package test.kh.semi.thduo.member.model.vo;

public class MemberVo {
//	M_ID       NOT NULL VARCHAR2(20)  
//	M_NICKNAME NOT NULL VARCHAR2(60)  
//	EMAIL      NOT NULL VARCHAR2(100) 
//	PHONE               VARCHAR2(20)  
//	PASSWORD   NOT NULL VARCHAR2(20)  
	
	private String mId;
	private String mNickname;
	private String email;
	private String phone;
	private String password;

	public MemberVo() {
		
	}

	public MemberVo(String mId, String password) {
		this.mId = mId;
		this.password = password;
	}

	public MemberVo(String mId, String mNickname, String email, String phone, String password) {
		this.mId = mId;
		this.mNickname = mNickname;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	@Override
	public String toString() {
		return "MemberVo [mId=" + mId + ", mNickname=" + mNickname + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + "]";
	}

	public MemberVo(String mId, String mNickname, String email, String phone) {
		super();
		this.mId = mId;
		this.mNickname = mNickname;
		this.email = email;
		this.phone = phone;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmNickname() {
		return mNickname;
	}

	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}

