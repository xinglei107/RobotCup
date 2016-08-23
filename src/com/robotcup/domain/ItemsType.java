package com.robotcup.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @����
 * ��Ŀ����
 * @����
 * ��Ӧ���ݿ�����Ŀ�����<br>
 * ��Ų�����Ŀ�ķ���
 * @����
 * <li>tyid��������</li>
 * <li>tyname��������</li>
 * 
 */


public class ItemsType implements java.io.Serializable {

	// Fields
	private Integer tyid;
	private String tyname;
	private Integer tyorder;
	private Set teamItems = new HashSet(0);

	// Constructors

	/** Ĭ�ϵĹ��캯�� */
	public ItemsType() {
	}

	/** ȫ���캯�� */
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