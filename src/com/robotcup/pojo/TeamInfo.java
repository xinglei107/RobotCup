package com.robotcup.pojo;

import java.io.Serializable;
/**
 * 
 * @类名
 * 参赛队详细信息
 * @描述
 * 报名统计时用于显示参赛队的详细信息
 * @参数
 * <li>tname：参赛队名</li>
 * <li>mname：领队姓名</li>
 * <li>mgender：领队性别</li>
 * <li>mtype：领队类型（学生或教师）</li>
 * <li>mphone：领队电话</li>
 * <li>memail：参赛队邮箱（找回密码的那个邮箱）</li>
 * <li>sname：所属学校名称</li>
 * <li>aname：所属赛区名称</li>
 * <li>members：参赛队全部成员，拼字符串</li>
 * <li>teachers：参赛队指导老师，拼字符串</li>
 * 
 *
 */
public class TeamInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//用于统计表中显示一个参赛队的基本信息
	private String tname;
	private String mname;
	private String mgender;
	private String mtype;
	private String mphone;
	private String memail;
	private String sname;
	private String aname;
	private String members;
	private String teachers;
	public TeamInfo(){
		
	}
	public TeamInfo(String tname,String mname,String mgender,String mtype,String mphone,
			String memail,String sname,	String aname)
	{
		this.tname=tname;
		this.mname=mname;
		this.mgender=mgender;
		this.mtype=mtype;
		this.mphone=mphone;
		this.memail=memail;
		this.sname=sname;
		this.aname=aname;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMgender() {
		return mgender;
	}
	public void setMgender(String mgender) {
		this.mgender = mgender;
	}
	public String getMtype() {
		return mtype;
	}
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getMembers() {
		return members;
	}
	public void setMembers(String members) {
		this.members = members;
	}
	public String getTeachers() {
		return teachers;
	}
	public void setTeachers(String teachers) {
		this.teachers = teachers;
	}
}
