package kh.semi.thduo.teacher.model.vo;

import java.util.ArrayList;

import kh.semi.thduo.like.model.vo.LikeVo;
import kh.semi.thduo.review.model.vo.ReviewVo;

public class TeacherVo {
	private String t_no;
	private String t_major;
	private String online_yna;
	private String t_tcnt;
	private String t_tprice;
	private String t_wantstud;
	private String t_career;
	private String t_language;
	private String t_special;
	private String t_approval;
	private String t_permit_yn;
	private String t_picture;
	private String t_intro;
	private String t_recruit_yn;
	private String object_list;
	private String area_list;
	private double avg_rscore;
	private String m_id;
	private int t_age;
	private String m_name;
	private String m_nickname;
	private String gender_fm;
	private String m_address;
	private ArrayList<ReviewVo> t_review;
	private LikeVo like;
	
	public TeacherVo() {
		super();
	}

	@Override
	public String toString() {
		return "TeacherVo [t_no=" + t_no + ", t_major=" + t_major + ", online_yna=" + online_yna + ", t_tcnt=" + t_tcnt
				+ ", t_tprice=" + t_tprice + ", t_wantstud=" + t_wantstud + ", t_career=" + t_career + ", t_language="
				+ t_language + ", t_special=" + t_special + ", t_approval=" + t_approval + ", t_permit_yn="
				+ t_permit_yn + ", t_picture=" + t_picture + ", t_intro=" + t_intro + ", t_recruit_yn=" + t_recruit_yn
				+ ", object_list=" + object_list + ", area_list=" + area_list + ", avg_rscore=" + avg_rscore + ", m_id="
				+ m_id + ", t_age=" + t_age + ", m_name=" + m_name + ", m_nickname=" + m_nickname + ", gender_fm="
				+ gender_fm + ", m_address=" + m_address + ", t_review=" + t_review + ", like=" + like + "]";
	}

	public String getT_no() {
		return t_no;
	}

	public void setT_no(String t_no) {
		this.t_no = t_no;
	}

	public String getT_major() {
		return t_major;
	}

	public void setT_major(String t_major) {
		this.t_major = t_major;
	}

	public String getOnline_yna() {
		return online_yna;
	}

	public void setOnline_yna(String online_yna) {
		this.online_yna = online_yna;
	}

	public String getT_tcnt() {
		return t_tcnt;
	}

	public void setT_tcnt(String t_tcnt) {
		this.t_tcnt = t_tcnt;
	}

	public String getT_tprice() {
		return t_tprice;
	}

	public void setT_tprice(String t_tprice) {
		this.t_tprice = t_tprice;
	}

	public String getT_wantstud() {
		return t_wantstud;
	}

	public void setT_wantstud(String t_wantstud) {
		this.t_wantstud = t_wantstud;
	}

	public String getT_career() {
		return t_career;
	}

	public void setT_career(String t_career) {
		this.t_career = t_career;
	}

	public String getT_language() {
		return t_language;
	}

	public void setT_language(String t_language) {
		this.t_language = t_language;
	}

	public String getT_special() {
		return t_special;
	}

	public void setT_special(String t_special) {
		this.t_special = t_special;
	}

	public String getT_approval() {
		return t_approval;
	}

	public void setT_approval(String t_approval) {
		this.t_approval = t_approval;
	}

	public String getT_permit_yn() {
		return t_permit_yn;
	}

	public void setT_permit_yn(String t_permit_yn) {
		this.t_permit_yn = t_permit_yn;
	}

	public String getT_picture() {
		return t_picture;
	}

	public void setT_picture(String t_picture) {
		this.t_picture = t_picture;
	}

	public String getT_intro() {
		return t_intro;
	}

	public void setT_intro(String t_intro) {
		this.t_intro = t_intro;
	}

	public String getT_recruit_yn() {
		return t_recruit_yn;
	}

	public void setT_recruit_yn(String t_recruit_yn) {
		this.t_recruit_yn = t_recruit_yn;
	}

	public String getObject_list() {
		return object_list;
	}

	public void setObject_list(String object_list) {
		this.object_list = object_list;
	}

	public String getArea_list() {
		return area_list;
	}

	public void setArea_list(String area_list) {
		this.area_list = area_list;
	}

	public double getAvg_rscore() {
		return avg_rscore;
	}

	public void setAvg_rscore(double avg_rscore) {
		this.avg_rscore = avg_rscore;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public int getT_age() {
		return t_age;
	}

	public void setT_age(int t_age) {
		this.t_age = t_age;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_nickname() {
		return m_nickname;
	}

	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}

	public String getGender_fm() {
		return gender_fm;
	}

	public void setGender_fm(String gender_fm) {
		this.gender_fm = gender_fm;
	}

	public String getM_address() {
		return m_address;
	}

	public void setM_address(String m_address) {
		this.m_address = m_address;
	}

	public ArrayList<ReviewVo> getT_review() {
		return t_review;
	}

	public void setT_review(ArrayList<ReviewVo> t_review) {
		this.t_review = t_review;
	}

	public LikeVo getLike() {
		return like;
	}

	public void setLike(LikeVo like) {
		this.like = like;
	}
}
