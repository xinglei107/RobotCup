package com.robotcup.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @����
 * ����
 * @����
 * ��Ӧ���ݿ������ű�<br>
 * ��Ź����������Ŷ�̬�������ճ̡������ӷ�ɵȵ�����
 * @����
 * <li>nid:��Ϣ���</li>
 * <li>robotAttachment����Ϣ����ģ�飺</li>
 * <li>teamAdmin��������</li>
 * <li>mtitle������</li>
 * <li>mdate������ʱ��</li>
 * <li>mcontent�����ݣ�Oracle���ݿ���ʹ��CLOB���ͣ�</li>
 * <li>mattachment��������ַ��ʵ�ʴ�ŵ���md5���ܺ���ļ�����</li>
 * <li>matname��������ʵ�ļ��������ܵ��ļ��������棩</li>
 * <li>mtop���Ƿ��ö� ��1��ʾ�ö���</li>
 */

public class RobotNews implements java.io.Serializable {

	// Fields

	private Integer nid;
	private RobotAttachment robotAttachment;
	private TeamAdmin teamAdmin;
	private String mtitle;
	private Date mdate;
	private String mcontent;
	private String mattachment;
	private String matname;//��������ʵ�ļ���
	private Integer mtop;

	// Constructors

	/** default constructor */
	public RobotNews() {
	}

	/** minimal constructor */
	public RobotNews(String mtitle, Date mdate, String mcontent) {
		this.mtitle = mtitle;
		this.mdate = mdate;
		this.mcontent = mcontent;
	}

	/** full constructor */
	public RobotNews(RobotAttachment robotAttachment, TeamAdmin teamAdmin,
			String mtitle, Date mdate, String mcontent, String mattachment,
			Integer mtop,String matname) {
		this.robotAttachment = robotAttachment;
		this.teamAdmin = teamAdmin;
		this.mtitle = mtitle;
		this.mdate = mdate;
		this.mcontent = mcontent;
		this.mattachment = mattachment;
		this.mtop = mtop;
		this.matname=matname;
	}

	// Property accessors

	public Integer getNid() {
		return this.nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public RobotAttachment getRobotAttachment() {
		return this.robotAttachment;
	}

	public void setRobotAttachment(RobotAttachment robotAttachment) {
		this.robotAttachment = robotAttachment;
	}

	public TeamAdmin getTeamAdmin() {
		return this.teamAdmin;
	}

	public void setTeamAdmin(TeamAdmin teamAdmin) {
		this.teamAdmin = teamAdmin;
	}

	public String getMtitle() {
		return this.mtitle;
	}

	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}

	public Date getMdate() {
		return this.mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}

	public String getMcontent() {
		return this.mcontent;
	}

	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}

	public String getMattachment() {
		return this.mattachment;
	}

	public void setMattachment(String mattachment) {
		this.mattachment = mattachment;
	}

	public Integer getMtop() {
		return this.mtop;
	}

	public void setMtop(Integer mtop) {
		this.mtop = mtop;
	}

	public String getMatname() {
		return matname;
	}

	public void setMatname(String mattname) {
		this.matname = mattname;
	}

}