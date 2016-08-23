package com.robotcup.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @����
 * �����б�
 * @����
 * �û���ҳ���б���Ϣ����ʾ�����б���RobotNews�е�����������ͬ��
 * imageUrl���ڴ�Ŵ�������������ȡ��ͼƬ��������ҳҪ������ʾͼƬԤ����
 * preContent���ڴ�����ĵ�Ԥ�����֡�
 * @����
 * <li>nid�����</li>
 * <li>title������</li>
 * <li>imageUrl��ͼƬ���·��</li>
 * <li>preContent������Ԥ��</li>
 * <li>mdate������ʱ��</li>
 * <li>author��������</li>
 * <li>attachment������ģ��</li>
 * <li>mtop���Ƿ��ö���1��ʾ�ö���</li>
 *
 */
public class NewsImp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//��ʾҪ���еı��⣬ͼƬ��Ԥ������
	private int nid;
	private String title;
	private String imageUrl;
	private String preContent;
	private Date mdate;
	private String author;
	private String attachment;
	private int mtop;
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getPreContent() {
		return preContent;
	}
	public void setPreContent(String preContent) {
		this.preContent = preContent;
	}
	public Date getMdate() {
		return mdate;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	public int getMtop() {
		return mtop;
	}
	public void setMtop(int mtop) {
		this.mtop = mtop;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
}
