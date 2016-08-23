package com.robotcup.domain;

import java.math.BigDecimal;

/**
 * @����
 * ����������
 * @����
 * ��Ӧ���������ű�<br>
 * �������ô˱����Ƿ��Ѷ�����Ա������վ����
 * @����
 * <li>leid�����</li>
 * <li>teamUser��������</li>
 * <li>robotLetter����Ӧ��һ��վ����</li>
 * <li>lestate��״̬��1��ʾ�Ѷ���</li>
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