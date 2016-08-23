package com.robotcup.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @类名
 * 新闻列表
 * @描述
 * 用户首页和列表信息中显示新闻列表，与RobotNews中的属性有所不同，
 * imageUrl用于存放从新闻内容中提取的图片，用于首页要闻中显示图片预览，
 * preContent用于存放正文的预览文字。
 * @参数
 * <li>nid：编号</li>
 * <li>title：标题</li>
 * <li>imageUrl：图片相对路径</li>
 * <li>preContent：内容预览</li>
 * <li>mdate：发布时间</li>
 * <li>author：发布者</li>
 * <li>attachment：所属模块</li>
 * <li>mtop：是否置顶（1表示置顶）</li>
 *
 */
public class NewsImp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//显示要闻中的标题，图片和预览内容
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
