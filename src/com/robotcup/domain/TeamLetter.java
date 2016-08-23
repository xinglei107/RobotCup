package com.robotcup.domain;

import java.math.BigDecimal;

/**
 * @类名
 * 参赛队收信
 * @描述
 * 对应数据中收信表<br>
 * 参赛队用此表标记是否已读管理员发布的站内信
 * @参数
 * <li>leid：编号</li>
 * <li>teamUser：发布者</li>
 * <li>robotLetter：对应哪一条站内信</li>
 * <li>lestate：状态（1表示已读）</li>
 */

public class TeamLetter implements java.io.Serializable {

	// Fields

	private Integer leid;
	private TeamUser teamUser;
	private RobotLetter robotLetter;
	private Integer lestate;

	// Constructors

	/** default constructor */
	public TeamLetter() {
	}

	/** minimal constructor */
	public TeamLetter(Integer lestate) {
		this.lestate = lestate;
	}

	/** full constructor */
	public TeamLetter(TeamUser teamUser, RobotLetter robotLetter,
			Integer lestate) {
		this.teamUser = teamUser;
		this.robotLetter = robotLetter;
		this.lestate = lestate;
	}

	// Property accessors

	public Integer getLeid() {
		return this.leid;
	}

	public void setLeid(Integer leid) {
		this.leid = leid;
	}

	public TeamUser getTeamUser() {
		return this.teamUser;
	}

	public void setTeamUser(TeamUser teamUser) {
		this.teamUser = teamUser;
	}

	public RobotLetter getRobotLetter() {
		return this.robotLetter;
	}

	public void setRobotLetter(RobotLetter robotLetter) {
		this.robotLetter = robotLetter;
	}

	public Integer getLestate() {
		return this.lestate;
	}

	public void setLestate(Integer lestate) {
		this.lestate = lestate;
	}

}