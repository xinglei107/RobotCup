package com.robotcup.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @类名
 * 新闻
 * @描述
 * 对应数据库中新闻表<br>
 * 存放管理发布的新闻动态、比赛日程、参赛队风采等等文章
 * @参数
 * <li>nid:消息编号</li>
 * <li>robotAttachment：消息所属模块：</li>
 * <li>teamAdmin：发布者</li>
 * <li>mtitle：标题</li>
 * <li>mdate：发布时间</li>
 * <li>mcontent：内容（Oracle数据库中使用CLOB类型）</li>
 * <li>mattachment：附件地址（实际存放的是md5加密后的文件名）</li>
 * <li>matname：附件真实文件名（加密的文件名不可逆）</li>
 * <li>mtop：是否置顶 （1表示置顶）</li>
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
	private String matname;//附件的真实文件名
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