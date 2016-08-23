package com.robotcup.domain;

import java.math.BigDecimal;

/**
 * @����
 * �����ӳ�Ա
 * @����
 * ��Ӧ���ݿ��Ա��<br>
 * ��ų�Ա�ĸ�����Ϣ
 * @����
 * <li>mid�����</li>
 * <li>teamUser������������</li>
 * <li>mname������</li>
 * <li>mgender���Ա�</li>
 * <li>mphone���绰</li>
 * <li>memail������</li>
 * <li>mtype�����ͣ���ʦ��ѧ����</li>
 * <li>mleader����ӣ�1��ʾ��ӣ�</li>
 * <li>mremark��Ԥ���ֶ�</li>
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