package com.robotcup.domain;

import java.math.BigDecimal;

/**
 * @类名
 * 参赛队成员
 * @描述
 * 对应数据库成员表<br>
 * 存放成员的各种信息
 * @参数
 * <li>mid：编号</li>
 * <li>teamUser：所属参赛队</li>
 * <li>mname：姓名</li>
 * <li>mgender：性别</li>
 * <li>mphone：电话</li>
 * <li>memail：邮箱</li>
 * <li>mtype：类型（教师或学生）</li>
 * <li>mleader：领队（1表示领队）</li>
 * <li>mremark：预留字段</li>
 */

public class TeamMembers implements java.io.Serializable {

	// Fields

	private Integer mid;
	private TeamUser teamUser;
	private String mname;
	private String mgender;
	private String mphone;
	private String memail;
	private String mtype;
	private Integer mleader;
	private String mremark;

	// Constructors

	/** default constructor */
	public TeamMembers() {
	}

	/** minimal constructor */
	public TeamMembers(String mname, String mgender, String mphone) {
		this.mname = mname;
		this.mgender = mgender;
		this.mphone = mphone;
	}

	/** full constructor */
	public TeamMembers(TeamUser teamUser, String mname, String mgender,
			String mphone, String memail, String mtype, Integer mleader,
			String mremark) {
		this.teamUser = teamUser;
		this.mname = mname;
		this.mgender = mgender;
		this.mphone = mphone;
		this.memail = memail;
		this.mtype = mtype;
		this.mleader = mleader;
		this.mremark = mremark;
	}

	// Property accessors

	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public TeamUser getTeamUser() {
		return this.teamUser;
	}

	public void setTeamUser(TeamUser teamUser) {
		this.teamUser = teamUser;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMgender() {
		return this.mgender;
	}

	public void setMgender(String mgender) {
		this.mgender = mgender;
	}

	public String getMphone() {
		return this.mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getMemail() {
		return this.memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMtype() {
		return this.mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	public Integer getMleader() {
		return this.mleader;
	}

	public void setMleader(Integer mleader) {
		this.mleader = mleader;
	}

	public String getMremark() {
		return this.mremark;
	}

	public void setMremark(String mremark) {
		this.mremark = mremark;
	}

}