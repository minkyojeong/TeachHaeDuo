package kh.semi.thduo.teacher.model.vo;

import java.util.ArrayList;

import kh.semi.thduo.like.model.vo.LikeVo;
import kh.semi.thduo.review.model.vo.ReviewVo;

public class TeacherSearchSettingVo {
	private String online_yna;  // Y, N, A, ""null 전체보기
	private String t_permit_yn;  // Y, ""null 전체보기
	private String t_recruit_yn;  // Y, ""null 전체보기
	private String object_list;  // '국어', ""null 전체보기
	private String area_list;  // '강남', ""null 전체보기
	private String gender_fm;  // 'M','F', ""null 전체보기
	private String liked;   // 'Y', 'N' 전체보기
	private String sNo;   // liked 'Y'일때 로그인한 sNo
	

	@Override
	public String toString() {
		return "TeacherSearchSettingVo [online_yna=" + online_yna + ", t_permit_yn=" + t_permit_yn + ", t_recruit_yn="
				+ t_recruit_yn + ", object_list=" + object_list + ", area_list=" + area_list + ", gender_fm="
				+ gender_fm + ", liked=" + liked + ", sNo=" + sNo + "]";
	}
	public String getLiked() {
		return liked;
	}
	public void setLiked(String liked) {
		this.liked = liked;
	}
	public String getOnline_yna() {
		return online_yna;
	}
	public void setOnline_yna(String online_yna) {
		this.online_yna = online_yna;
	}
	public String getT_permit_yn() {
		return t_permit_yn;
	}
	public void setT_permit_yn(String t_permit_yn) {
		this.t_permit_yn = t_permit_yn;
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
	public String getGender_fm() {
		return gender_fm;
	}
	public void setGender_fm(String gender_fm) {
		this.gender_fm = gender_fm;
	}

	public String getsNo() {
		return sNo;
	}
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	
	
	
}
