package com.robotcup.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * @����
 * ������
 * @����
 * ��Ӧ���ݿ�����ӱ�<br>
 * ��Ų����ӵĻ�����Ϣ
 * @����
 * <li>tid�����</li>
 * <li>teamUnversity��������ѧ</li>
 * <li>tname������</li>
 * <li>tpwd������</li>
 * <li>temail�����䣨�����һ����룩</li>
 * <li>tremark����ע</li>
 */

public class TeamUser implements java.io.Serializable {

	// Fields

	private Integer tid;
	private TeamUnversity teamUnversity;
	private String tname;
	private String tpwd;
	private String temail;
	private String tremark;
	private Set teamApplications = new HashSet(0);
	private Set teamLetters = new HashSet(0);
	private Set teamMemberses = new HashSet(0);
	/**
	 * 2015-4-19�������
	 */
	private String tyear;

	// Constructors

	/** default constructor */
	public TeamUser() {
	}

	/** minimal constructor */
	public TeamUser(String tname, String tpwd) {
		this.tname = tname;
		this.tpwd = tpwd;
	}

	/** full constructor */
	public TeamUser(TeamUnversity teamUnversity, String tname, String tpwd,
			String temail, String tremark, Set teamApplications,
			Set teamLetters, Set teamMemberses) {
		this.teamUnversity = teamUnversity;
		this.tname = tname;
		this.tpwd = tpwd;
		this.temail = temail;
		this.tremark = tremark;
		this.teamApplications = teamApplications;
		this.teamLetters = teamLetters;
		this.teamMemberses = teamMemberses;
	}

	// Property accessors

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public TeamUnversity getTeamUnversity() {
		return this.teamUnversity;
	}

	public void setTeamUnversity(TeamUnversity teamUnversity) {
		this.teamUnversity = teamUnversity;
	}

	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTpwd() {
		return this.tpwd;
	}

	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
	}

	public String getTemail() {
		return this.temail;
	}

	public void setTemail(String temail) {
		this.temail = temail;
	}

	public String getTremark() {
		return this.tremark;
	}

	public void setTremark(String tremark) {
		this.tremark = tremark;
	}

	public Set getTeamApplications() {
		return this.teamApplications;
	}

	public void setTeamApplications(Set teamApplications) {
		this.teamApplications = teamApplications;
	}

	public Set getTeamLetters() {
		return this.teamLetters;
	}

	public void setTeamLetters(Set teamLetters) {
		this.teamLetters = teamLetters;
	}

	public Set getTeamMemberses() {
		return this.teamMemberses;
	}

	public void setTeamMemberses(Set teamMemberses) {
		this.teamMemberses = teamMemberses;
	}

	public String getTyear() {
		return tyear;
	}

	public void setTyear(String tyear) {
		this.tyear = tyear;
	}

}