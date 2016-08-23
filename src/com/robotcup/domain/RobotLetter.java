package com.robotcup.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @类名
 * 站内信
 * @描述
 * 对应数据库中站内信表<br>
 * 用来存放管理员发布的站内信
 * @参数
 * <li>lid：信编号</li>
 * <li>teamAdmin：发布者</li>
 * <li>ltitle：标题</li>
 * <li>lcontent：内容</li>
 * <li>ldate：发布时间</li>
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