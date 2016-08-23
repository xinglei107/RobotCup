package com.robotcup.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * @���� ��Ŀ��Ϣ
 * @���� ��Ӧ���ݿ���Ŀ��<br>
 *     ������еĿɱ���Ŀ
 * @���� <li>itid�����</li> <li>itemsType����������</li> <li>itname����Ŀ����</li> <li>
 *     itlimit��ѧ������</li> <li>itremark��ѧ������</li> <li>ittealim����ʦ����</li> <li>
 *     itteacap����ʦ����</li>
 * 
 *     2015-09-22�����Ƿ�ɼ��ֶ�
 *     
 *     2016-05-20���������ֶ�
 */

public class TeamItems implements java.io.Serializable {

	// Fields

	private Integer itid;
	private ItemsType itemsType;
	private String itname;
	private Integer itlimit;
	private String itremark;
	private Integer ittealim;
	private Integer itteacap;
	private Integer itorder;
	private Set teamApplications = new HashSet(0);

	// �Ƿ�ɼ�
	private Integer visible;

	// Constructors

	/** default constructor */
	public TeamItems() {
	}

	/** minimal constructor */
	public TeamItems(String itname) {
		this.itname = itname;
	}

	/** full constructor */
	public TeamItems(ItemsType itemsType, String itname, Integer itlimit,
			String itremark, Set teamApplications) {
		this.itemsType = itemsType;
		this.itname = itname;
		this.itlimit = itlimit;
		this.itremark = itremark;
		this.teamApplications = teamApplications;
	}

	// Property accessors

	public Integer getItid() {
		return this.itid;
	}

	public void setItid(Integer itid) {
		this.itid = itid;
	}

	public ItemsType getItemsType() {
		return this.itemsType;
	}

	public void setItemsType(ItemsType itemsType) {
		this.itemsType = itemsType;
	}

	public String getItname() {
		return this.itname;
	}

	public void setItname(String itname) {
		this.itname = itname;
	}

	public Integer getItlimit() {
		return this.itlimit;
	}

	public void setItlimit(Integer itlimit) {
		this.itlimit = itlimit;
	}

	public String getItremark() {
		return this.itremark;
	}

	public void setItremark(String itremark) {
		this.itremark = itremark;
	}

	public Set getTeamApplications() {
		return this.teamApplications;
	}

	public void setTeamApplications(Set teamApplications) {
		this.teamApplications = teamApplications;
	}

	public Integer getIttealim() {
		return ittealim;
	}

	public void setIttealim(Integer ittealim) {
		this.ittealim = ittealim;
	}

	public Integer getItteacap() {
		return itteacap;
	}

	public void setItteacap(Integer itteacap) {
		this.itteacap = itteacap;
	}

	public Integer getVisible() {
		return visible;
	}

	public void setVisible(Integer visible) {
		this.visible = visible;
	}

	public Integer getItorder() {
		return itorder;
	}

	public void setItorder(Integer itorder) {
		this.itorder = itorder;
	}

}