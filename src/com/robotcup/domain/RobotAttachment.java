package com.robotcup.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * @����
 * ��վģ��
 * @����
 * ��Ӧ���ݿ���ģ���<br>
 * �����վ��ģ�飬��ʾ����վ��ҳ���������漸������
 * @����
 * 	<li>���Ŷ�̬</li>
 * 	<li>�����ӷ��</li>
 * 	<li>��������</li>
 *	<li>�����ճ�</li>
 *	<li>��֯�ṹ</li>
 *	<li>����ع�</li>
 *	<li>��������</li>
 *	<li>��ϵ����</li>
 *	<li>�������أ���ģ�鲻�ǵ�����ģ�飬�ǴӸ�ģ���и�������������ȡ�ģ�����Ӧ���ű��е����ţ�</li>
 *@����
 *	<li>atid:ģ����</li>
 *	<li>atname:ģ����</li>
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