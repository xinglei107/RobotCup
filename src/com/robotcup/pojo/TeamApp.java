package com.robotcup.pojo;

import java.io.Serializable;

public class TeamApp implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int appid;
	private String tname;
	private String sname;
	private String mname;
	private String itname;
	private String appstates;
	private int appnum;
	private int applimit;
	private int appremark;//обоч
	private String members;
	private String teacherName;
	public int getAppid() {
		return appid;
	}
	public void setAppid(int appid) {
		this.appid = appid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getItname() {
		return itname;
	}
	public void setItname(String itname) {
		this.itname = itname;
	}
	public int getAppnum() {
		return appnum;
	}
	public void setAppnum(int appnum) {
		this.appnum = appnum;
	}
	public String getAppstates() {
		return appstates;
	}
	public void setAppstates(String appstates) {
		this.appstates = appstates;
	}
	public String getMembers() {
		return members;
	}
	public void setMembers(String members) {
		this.members = members;
	}
	public int getApplimit() {
		return applimit;
	}
	public void setApplimit(int applimit) {
		this.applimit = applimit;
	}
	public int getAppremark() {
		return appremark;
	}
	public void setAppremark(int appremark) {
		this.appremark = appremark;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
}
