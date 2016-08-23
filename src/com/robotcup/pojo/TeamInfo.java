package com.robotcup.pojo;

import java.io.Serializable;
/**
 * 
 * @����
 * ��������ϸ��Ϣ
 * @����
 * ����ͳ��ʱ������ʾ�����ӵ���ϸ��Ϣ
 * @����
 * <li>tname����������</li>
 * <li>mname���������</li>
 * <li>mgender������Ա�</li>
 * <li>mtype��������ͣ�ѧ�����ʦ��</li>
 * <li>mphone����ӵ绰</li>
 * <li>memail�����������䣨�һ�������Ǹ����䣩</li>
 * <li>sname������ѧУ����</li>
 * <li>aname��������������</li>
 * <li>members��������ȫ����Ա��ƴ�ַ���</li>
 * <li>teachers��������ָ����ʦ��ƴ�ַ���</li>
 * 
 *
 */
public class TeamInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//����ͳ�Ʊ�����ʾһ�������ӵĻ�����Ϣ
	private String tname;
	private String mname;
	private String mgender;
	private String mtype;
	private String mphone;
	private String memail;
	private String sname;
	private String aname;
	private String members;
	private String teachers;
	public TeamInfo(){
		
	}
	public TeamInfo(String tname,String mname,String mgender,String mtype,String mphone,
			String memail,String sname,	String aname)
	{
		this.tname=tname;
		this.mname=mname;
		this.mgender=mgender;
		this.mtype=mtype;
		this.mphone=mphone;
		this.memail=memail;
		this.sname=sname;
		this.aname=aname;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMgender() {
		return mgender;
	}
	public void setMgender(String mgender) {
		this.mgender = mgender;
	}
	public String getMtype() {
		return mtype;
	}
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getMembers() {
		return members;
	}
	public void setMembers(String members) {
		this.members = members;
	}
	public String getTeachers() {
		return teachers;
	}
	public void setTeachers(String teachers) {
		this.teachers = teachers;
	}
}
