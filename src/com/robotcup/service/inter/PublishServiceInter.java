package com.robotcup.service.inter;

import java.util.List;

import com.robotcup.domain.RobotAttachment;
import com.robotcup.domain.RobotLetter;
import com.robotcup.domain.RobotNews;
import com.robotcup.pojo.Attachment;
import com.robotcup.pojo.NewsImp;

public interface PublishServiceInter {

	//添加文章
	public void addNews(RobotNews news);
	
	//添加站内公告
	public void addLetter(RobotLetter rl);
	
	//更新文章
	public void updateNews(RobotNews news);
	
	//根据模块编号查找前十篇文章，用于首页的列表显示
	public List<RobotNews> getTenNewsByAtid(int atid);
	
	//根据模块编号分页查找文章，用于显示列表，不需要全部的news信息，所以不使用RobotNews返回类型
	public List<NewsImp> getNewsByAtid(int atid,int pageNum,int pageSize);
	
	//根据模块返回新闻总页数
	public int getPageSumByAtid(int atid,int pageSize);
		
	//根据文章编号查找文章
	public RobotNews getNewsByNid(int nid);
	
	//根据模块编号返回模块
	public RobotAttachment getRoboAttachmentByAtid(int atid);
	
	//返回附件列表
	public List<Attachment> getAttachments(int pageNum,int pageSize);
	
	//返回全部的消息列表
	public List<NewsImp> getAllRobotNews(int pageNum,int pageSize);
	
	//删除消息
	public void delRobotNewsByNid(int nid);
}
