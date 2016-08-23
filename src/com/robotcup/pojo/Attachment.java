package com.robotcup.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @类名
 * 附件
 * @描述
 * 用于显示附件列表<br>
 * 附件是从新闻中提取出来的对象，显示附件列表时不需要新闻的其他字段信息，单独做成一个类便于查询显示
 * @参数
 * <li>name：附件路径（实际为MD5加密后的文件名）</li>
 * <li>relname：附件真实文件名</li>
 * <li>top：是否置顶（1表示置顶）</li>
 * <li>date：发布时间</li>
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
