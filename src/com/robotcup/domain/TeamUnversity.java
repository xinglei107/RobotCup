package com.robotcup.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * @类名
 * 学校信息
 * @描述
 * 对应数据库学校信息表<br>
 * 存放可以参赛的学校信息
 * @参数
 * <li>sid：编号</li>
 * <li>teamArea：所属赛区</li>
 * <li>sname：学校名称</li>
 */

public class TeamUnversity implements java.io.Serializable {

	// Fields

	private Integer sid;
	private TeamArea teamArea;
	private String sname;
	private Set teamUsers = new HashSet(0);

	// Constructors

	/** default constructor */
	public TeamUnversity() {
	}

	/** minimal constructor */
	public TeamUnversity(String sname) {
		this.sname = sname;
	}

	/** full constructor */
	public TeamUnversity(TeamArea teamArea, String sname, Set teamUsers) {
		this.teamArea = teamArea;
		this.sname = sname;
		this.teamUsers = teamUsers;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public TeamArea getTeamArea() {
		return this.teamArea;
	}

	public void setTeamArea(TeamArea teamArea) {
		this.teamArea = teamArea;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Set getTeamUsers() {
		return this.teamUsers;
	}

	public void setTeamUsers(Set teamUsers) {
		this.teamUsers = teamUsers;
	}

}