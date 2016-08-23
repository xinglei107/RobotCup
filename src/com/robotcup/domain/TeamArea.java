package com.robotcup.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * @����
 * ����
 * @����
 * ��Ӧ���ݿ�������<br>
 * ������в���������Ϣ
 * @����
 * <li>aid�����</li>
 * <li>aname��������</li>
 * 
 */

public class TeamArea implements java.io.Serializable {

	// Fields

	private Integer aid;
	private String aname;
	private Set teamUnversities = new HashSet(0);
	private Set teamAdmins = new HashSet(0);

	// Constructors

	/** default constructor */
	public TeamArea() {
	}

	/** minimal constructor */
	public TeamArea(String aname) {
		this.aname = aname;
	}

	/** full constructor */
	public TeamArea(String aname, Set teamUnversities, Set teamAdmins) {
		this.aname = aname;
		this.teamUnversities = teamUnversities;
		this.teamAdmins = teamAdmins;
	}

	// Property accessors

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public Set getTeamUnversities() {
		return this.teamUnversities;
	}

	public void setTeamUnversities(Set teamUnversities) {
		this.teamUnversities = teamUnversities;
	}

	public Set getTeamAdmins() {
		return this.teamAdmins;
	}

	public void setTeamAdmins(Set teamAdmins) {
		this.teamAdmins = teamAdmins;
	}

}