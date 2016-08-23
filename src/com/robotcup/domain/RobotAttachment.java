package com.robotcup.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * @类名
 * 网站模块
 * @描述
 * 对应数据库中模块表<br>
 * 存放网站的模块，显示在网站首页，包含下面几个内容
 * @内容
 * 	<li>新闻动态</li>
 * 	<li>参赛队风采</li>
 * 	<li>竞赛规则</li>
 *	<li>比赛日程</li>
 *	<li>组织结构</li>
 *	<li>历届回顾</li>
 *	<li>大赛介绍</li>
 *	<li>联系我们</li>
 *	<li>附件下载（此模块不是单独的模块，是从各模块有附件的新闻中提取的，不对应新闻表中的新闻）</li>
 *@参数
 *	<li>atid:模块编号</li>
 *	<li>atname:模块名</li>
 */

public class RobotAttachment implements java.io.Serializable {

	// Fields

	private Integer atid;
	private String atname;
	private Set robotNewses = new HashSet(0);

	// Constructors

	/** default constructor */
	public RobotAttachment() {
	}

	/** minimal constructor */
	public RobotAttachment(String atname) {
		this.atname = atname;
	}

	/** full constructor */
	public RobotAttachment(String atname, Set robotNewses) {
		this.atname = atname;
		this.robotNewses = robotNewses;
	}

	// Property accessors

	public Integer getAtid() {
		return this.atid;
	}

	public void setAtid(Integer atid) {
		this.atid = atid;
	}

	public String getAtname() {
		return this.atname;
	}

	public void setAtname(String atname) {
		this.atname = atname;
	}

	public Set getRobotNewses() {
		return this.robotNewses;
	}

	public void setRobotNewses(Set robotNewses) {
		this.robotNewses = robotNewses;
	}

}