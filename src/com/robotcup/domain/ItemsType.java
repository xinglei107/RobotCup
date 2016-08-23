package com.robotcup.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @类名
 * 项目分类
 * @描述
 * 对应数据库中项目分类表<br>
 * 存放参赛项目的分类
 * @参数
 * <li>tyid：分类编号</li>
 * <li>tyname：分类名</li>
 * 
 */


public class ItemsType implements java.io.Serializable {

	// Fields
	private Integer tyid;
	private String tyname;
	private Integer tyorder;
	private Set teamItems = new HashSet(0);

	// Constructors

	/** 默认的构造函数 */
	public ItemsType() {
	}

	/** 全构造函数 */
	public ItemsType(String tyname,Set teamItems) {
		this.tyname = tyname;
		this.setTeamItems(teamItems);
	}

	// Property accessors

	public Integer getTyid() {
		return this.tyid;
	}

	public void setTyid(Integer tyid) {
		this.tyid = tyid;
	}

	public String getTyname() {
		return this.tyname;
	}

	public void setTyname(String tyname) {
		this.tyname = tyname;
	}

	public Set getTeamItems() {
		return teamItems;
	}

	public void setTeamItems(Set teamItems) {
		this.teamItems = teamItems;
	}

	public Integer getTyorder() {
		return tyorder;
	}

	public void setTyorder(Integer tyorder) {
		this.tyorder = tyorder;
	}

}