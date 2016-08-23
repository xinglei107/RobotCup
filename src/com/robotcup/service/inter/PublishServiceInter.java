package com.robotcup.service.inter;

import java.util.List;

import com.robotcup.domain.RobotAttachment;
import com.robotcup.domain.RobotLetter;
import com.robotcup.domain.RobotNews;
import com.robotcup.pojo.Attachment;
import com.robotcup.pojo.NewsImp;

public interface PublishServiceInter {

	//�������
	public void addNews(RobotNews news);
	
	//���վ�ڹ���
	public void addLetter(RobotLetter rl);
	
	//��������
	public void updateNews(RobotNews news);
	
	//����ģ���Ų���ǰʮƪ���£�������ҳ���б���ʾ
	public List<RobotNews> getTenNewsByAtid(int atid);
	
	//����ģ���ŷ�ҳ�������£�������ʾ�б�����Ҫȫ����news��Ϣ�����Բ�ʹ��RobotNews��������
	public List<NewsImp> getNewsByAtid(int atid,int pageNum,int pageSize);
	
	//����ģ�鷵��������ҳ��
	public int getPageSumByAtid(int atid,int pageSize);
		
	//�������±�Ų�������
	public RobotNews getNewsByNid(int nid);
	
	//����ģ���ŷ���ģ��
	public RobotAttachment getRoboAttachmentByAtid(int atid);
	
	//���ظ����б�
	public List<Attachment> getAttachments(int pageNum,int pageSize);
	
	//����ȫ������Ϣ�б�
	public List<NewsImp> getAllRobotNews(int pageNum,int pageSize);
	
	//ɾ����Ϣ
	public void delRobotNewsByNid(int nid);
}
