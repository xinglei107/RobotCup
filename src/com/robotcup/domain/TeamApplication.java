package com.robotcup.domain;

import java.math.BigDecimal;

/**
 * @类名 报名信息
 * @描述 对应数据库报名信息报表<br>
 *     存放各参赛队的报名项目信息
 * @参数 <li>appid：编号</li> <li>teamUser：对应的参赛队</li> <li>teamItems：所报项目</li> <li>
 *     appsum：总分</li> <li>appnum：出场顺序</li> <li>appstate：审核状态</li>
 */

public class TeamApplication implements java.io.Serializable {

	// Fields

	private Integer appid;
	private TeamUser teamUser;
	private TeamItems teamItems;
	private Integer appsum;
	private Integer appnum;
	private Integer appstate;

	/**
	 * 增加年份
	 */
	private String appyear;

	// Constructors

	/** default constructor */
	public TeamApplication() {
	}

	/** full constructor */
	public TeamApplication(TeamUser teamUser, TeamItems teamItems,
			Integer appsum, Integer appnum, Integer appstate, String appyear) {
		this.teamUser = teamUser;
		this.teamItems = teamItems;
		this.appsum = appsum;
		this.appnum = appnum;
		this.appstate = appstate;
		this.appyear = appyear;
	}

	// Property accessors

	public String getAppyear() {
		return appyear;
	}

	public void setAppyear(String appyear) {
		this.appyear = appyear;
	}

	public Integer getAppid() {
		return this.appid;
	}

	public void setAppid(Integer appid) {
		this.appid = appid;
	}

	public TeamUser getTeamUser() {
		return this.teamUser;
	}

	public void setTeamUser(TeamUser teamUser) {
		this.teamUser = teamUser;
	}

	public TeamItems getTeamItems() {
		return this.teamItems;
	}

	public void setTeamItems(TeamItems teamItems) {
		this.teamItems = teamItems;
	}

	public Integer getAppsum() {
		return this.appsum;
	}

	public void setAppsum(Integer appsum) {
		this.appsum = appsum;
	}

	public Integer getAppnum() {
		return this.appnum;
	}

	public void setAppnum(Integer appnum) {
		this.appnum = appnum;
	}

	public Integer getAppstate() {
		return this.appstate;
	}

	public void setAppstate(Integer appstate) {
		this.appstate = appstate;
	}

}