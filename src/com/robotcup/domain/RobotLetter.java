package com.robotcup.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @����
 * վ����
 * @����
 * ��Ӧ���ݿ���վ���ű�<br>
 * ������Ź���Ա������վ����
 * @����
 * <li>lid���ű��</li>
 * <li>teamAdmin��������</li>
 * <li>ltitle������</li>
 * <li>lcontent������</li>
 * <li>ldate������ʱ��</li>
 */

public class RobotLetter implements java.io.Serializable {

	// Fields

	private Integer lid;
	private TeamAdmin teamAdmin;
	private String ltitle;
	private String lcontent;
	private Date ldate;
	private Set teamLetters = new HashSet(0);

	// Constructors

	/** default constructor */
	public RobotLetter() {
	}

	/** minimal constructor */
	public RobotLetter(String ltitle, String lcontent, Date ldate) {
		this.ltitle = ltitle;
		this.lcontent = lcontent;
		this.ldate = ldate;
	}

	/** full constructor */
	public RobotLetter(TeamAdmin teamAdmin, String ltitle, String lcontent,
			Date ldate, Set teamLetters) {
		this.teamAdmin = teamAdmin;
		this.ltitle = ltitle;
		this.lcontent = lcontent;
		this.ldate = ldate;
		this.teamLetters = teamLetters;
	}

	// Property accessors

	public Integer getLid() {
		return this.lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public TeamAdmin getTeamAdmin() {
		return this.teamAdmin;
	}

	public void setTeamAdmin(TeamAdmin teamAdmin) {
		this.teamAdmin = teamAdmin;
	}

	public String getLtitle() {
		return this.ltitle;
	}

	public void setLtitle(String ltitle) {
		this.ltitle = ltitle;
	}

	public String getLcontent() {
		return this.lcontent;
	}

	public void setLcontent(String lcontent) {
		this.lcontent = lcontent;
	}

	public Date getLdate() {
		return this.ldate;
	}

	public void setLdate(Date ldate) {
		this.ldate = ldate;
	}

	public Set getTeamLetters() {
		return this.teamLetters;
	}

	public void setTeamLetters(Set teamLetters) {
		this.teamLetters = teamLetters;
	}

}