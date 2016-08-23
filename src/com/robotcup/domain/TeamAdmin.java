package com.robotcup.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * @类名
 * 管理员
 * @描述
 * 对应数据库管理员表<br>
 * 存放管理员信息
 * @参数
 * <li>adid：管理员编号</li>
 * <li>teamArea：所属赛区</li>
 * <li>adname：用户名</li>
 * <li>adpwd：密码</li>
 * <li>ademail：邮箱（用于找回密码）</li>
 */

public class TeamAdmin implements java.io.Serializable {

	// Fields

	private Integer adid;
	private TeamArea teamArea;
	private String adname;
	private String adpwd;
	private String ademail;
	private Set robotNewses = new HashSet(0);
	private Set robotLetters = new HashSet(0);
/**
 * 增加入口控制
 */
	private String entrance;
	// Constructors

	/** default constructor */
	public TeamAdmin() {
	}

	/** minimal constructor */
	public TeamAdmin(String adname, String adpwd) {
		this.adname = adname;
		this.adpwd = adpwd;
	}

	/** full constructor */
	public TeamAdmin(TeamArea teamArea, String adname, String adpwd,
			String ademail, Set robotNewses, Set robotLetters) {
		this.teamArea = teamArea;
		this.adname = adname;
		this.adpwd = adpwd;
		this.ademail = ademail;
		this.robotNewses = robotNewses;
		this.robotLetters = robotLetters;
	}

	// Property accessors

	public Integer getAdid() {
		return this.adid;
	}

	public void setAdid(Integer adid) {
		this.adid = adid;
	}

	public TeamArea getTeamArea() {
		return this.teamArea;
	}

	public void setTeamArea(TeamArea teamArea) {
		this.teamArea = teamArea;
	}

	public String getAdname() {
		return this.adname;
	}

	public void setAdname(String adname) {
		this.adname = adname;
	}

	public String getAdpwd() {
		return this.adpwd;
	}

	public void setAdpwd(String adpwd) {
		this.adpwd = adpwd;
	}

	public String getAdemail() {
		return this.ademail;
	}

	public void setAdemail(String ademail) {
		this.ademail = ademail;
	}

	public Set getRobotNewses() {
		return this.robotNewses;
	}

	public void setRobotNewses(Set robotNewses) {
		this.robotNewses = robotNewses;
	}

	public Set getRobotLetters() {
		return this.robotLetters;
	}

	public void setRobotLetters(Set robotLetters) {
		this.robotLetters = robotLetters;
	}

	public String getEntrance() {
		return entrance;
	}

	public void setEntrance(String entrance) {
		this.entrance = entrance;
	}

}