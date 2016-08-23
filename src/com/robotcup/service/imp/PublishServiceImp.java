package com.robotcup.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.robotcup.domain.RobotAttachment;
import com.robotcup.domain.RobotLetter;
import com.robotcup.domain.RobotNews;
import com.robotcup.pojo.Attachment;
import com.robotcup.pojo.NewsImp;
import com.robotcup.service.inter.PublishServiceInter;
import com.robotcup.util.HibernateHelper;
@Controller
public class PublishServiceImp implements PublishServiceInter {

	@Resource
	private HibernateHelper hibernateHelper;
	public HibernateHelper getHibernateHelper() {
		return hibernateHelper;
	}
	public void setHibernateHelper(HibernateHelper hibernateHelper) {
		this.hibernateHelper = hibernateHelper;
	}
	/**
	 * ���һ������
	 */
	@Override
	public void addNews(RobotNews news) {
		// TODO Auto-generated method stub
		hibernateHelper.save(news);
	}
	/**
	 * ��ȡĳһģ���µ�ȫ������
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RobotNews> getTenNewsByAtid(int atid) {
		// TODO Auto-generated method stub
		String hql="from RobotNews where robotAttachment.atid=? order by mtop asc,mdate desc";
		return hibernateHelper.executeQuery(hql, new String[]{atid+""});
	}
	/**
	 * �������ű�Ż�ȡ����
	 */
	@Override
	public RobotNews getNewsByNid(int nid) {
		// TODO Auto-generated method stub
		String hql="from RobotNews where nid=?";
		List list= hibernateHelper.executeQuery(hql, new String[]{nid+""});
		if(list.size()>0)
			return (RobotNews)list.get(0);
		return null;
	}
	/**
	 * ����ģ���Ż�ȡģ��
	 */
	@Override
	public RobotAttachment getRoboAttachmentByAtid(int atid) {
		// TODO Auto-generated method stub
		String hql="from RobotAttachment where atid=?";
		List list=hibernateHelper.executeQuery(hql,new String[]{atid+""});
		if(list.size()>0)
			return (RobotAttachment) list.get(0);
		return null;
	}
	/**
	 * ����ҳ�Ļ�ȡ������Ϣ
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Attachment> getAttachments(int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		//����ȡ��ҳչʾ�еĸ���ͼƬ
		String hql="select mattachment,matname,mtop,mdate from RobotNews where atid!=10 and mattachment is not null order by mtop,mdate desc";
		List<Object[]> olist=hibernateHelper.executeQuery(hql,null,pageNum,pageSize);
		List<Attachment> res=new ArrayList<Attachment>();
		for(int i=0;i<olist.size();++i)
		{
			Attachment a=new Attachment();
			a.setName(olist.get(i)[0].toString());
			a.setRelname(olist.get(i)[1].toString());
			if(olist.get(i)[2]!=null)
				a.setTop(Integer.parseInt(olist.get(i)[2].toString()));
			a.setDate((Date)olist.get(i)[3]);
			res.add(a);
		}
		return res;
	}
	/**
	 * ����ҳ�Ļ�ȡĳһģ���µ������б�
	 */
	@SuppressWarnings({ "unchecked"})
	@Override
	public List<NewsImp> getNewsByAtid(int atid,int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		String hql="select nid,mtop,mtitle,mdate from RobotNews where robotAttachment.atid=? order by mtop asc,mdate desc";
		String parameters[]=new String[]{atid+""};
		List<Object[]> list=hibernateHelper.executeQuery(hql, parameters,pageNum,pageSize);
		List<NewsImp> res=new ArrayList<NewsImp>();
		for(int i=0;i<list.size();++i){
			NewsImp ni=new NewsImp();
			ni.setNid(Integer.parseInt(list.get(i)[0].toString()));
			if(list.get(i)[1]!=null)
				ni.setMtop(Integer.parseInt(list.get(i)[1].toString()));
			ni.setTitle(list.get(i)[2].toString());
			ni.setMdate((Date)list.get(i)[3]);
			res.add(ni);
		}
		return res;
	}
	/**
	 * ��ȡĳһģ���µ���������
	 * atid=9��ʾ��ȡ������Ŀ
	 * atid=0��ʾ��ȡȫ��ģ���������Ŀ
	 */
	@Override
	public int getPageSumByAtid(int atid, int pageSize) {
		// TODO Auto-generated method stub
		//���ڸ������ǵ�����ģ�飬Ҫ��������
		String hql=null;
		Long o=null;
		if(atid!=9&&atid!=0)
		{
			hql="select count(*) from RobotNews where atid=?";
			o=(Long) hibernateHelper.executeQuery(hql,new String[]{atid+""}).get(0);
		}
		else if(atid==9)
		{
			hql="select count(*) from RobotNews where mattachment is not null and atid!=10";
			o=(Long) hibernateHelper.executeQuery(hql).get(0);
		}
		else if(atid==0)
		{
			hql="select count(*) from RobotNews where atid!=10";
			o=(Long) hibernateHelper.executeQuery(hql).get(0);
		}
		int pageSum=1;
		if(o!=null)
		{
			int count=Integer.parseInt(o.toString());
			pageSum=count%pageSize==0?count/pageSize:(count/pageSize+1);
		}
		return pageSum;
	}
	/**
	 * ����ȫ������Ϣ
	 * ��������ҳչʾ��ͼƬ
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NewsImp> getAllRobotNews(int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		String hql="select nid,mtop,mtitle,mdate,robotAttachment.atname,teamAdmin.adname from RobotNews where robotAttachment.atid!=10 order by mtop asc,robotAttachment.atname,teamAdmin.adname,mdate desc";
		List<Object[]> list=hibernateHelper.executeQuery(hql,null,pageNum,pageSize);
		List<NewsImp> res=new ArrayList<NewsImp>();
		for(int i=0;i<list.size();++i)
		{
			NewsImp ni=new NewsImp();
			ni.setNid(Integer.parseInt(list.get(i)[0].toString()));
			if(list.get(i)[1]!=null)
				ni.setMtop(Integer.parseInt(list.get(i)[1].toString()));
			ni.setTitle(list.get(i)[2].toString());
			ni.setMdate((Date) list.get(i)[3]);
			ni.setAttachment(list.get(i)[4].toString());
			ni.setAuthor(list.get(i)[5].toString());
			res.add(ni);
		}
		return res;
	}
	@Override
	public void delRobotNewsByNid(int nid) {
		// TODO Auto-generated method stub
		String hql="delete from RobotNews where nid=?";
		hibernateHelper.updateQuery(hql,new String[]{nid+""});
	}
	@Override
	public void updateNews(RobotNews news) {
		// TODO Auto-generated method stub
		hibernateHelper.updateQuery(news);
	}
	@Override
	public void addLetter(RobotLetter rl) {
		// TODO Auto-generated method stub
		hibernateHelper.save(rl);
	}
}
