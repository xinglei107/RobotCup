package com.robotcup.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @����
 * ����
 * @����
 * ������ʾ�����б�<br>
 * �����Ǵ���������ȡ�����Ķ�����ʾ�����б�ʱ����Ҫ���ŵ������ֶ���Ϣ����������һ������ڲ�ѯ��ʾ
 * @����
 * <li>name������·����ʵ��ΪMD5���ܺ���ļ�����</li>
 * <li>relname��������ʵ�ļ���</li>
 * <li>top���Ƿ��ö���1��ʾ�ö���</li>
 * <li>date������ʱ��</li>
 *
 */
public class Attachment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String relname;
	private int top;
	private Date date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRelname() {
		return relname;
	}
	public void setRelname(String relname) {
		this.relname = relname;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
