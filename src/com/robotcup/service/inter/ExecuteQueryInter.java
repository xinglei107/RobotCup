package com.robotcup.service.inter;

import java.util.List;

import com.robotcup.domain.ItemsType;
import com.robotcup.domain.RobotAttachment;
import com.robotcup.domain.RobotLetter;
import com.robotcup.domain.TeamArea;
import com.robotcup.domain.TeamItems;
import com.robotcup.domain.TeamUnversity;
import com.robotcup.pojo.TeamApp;
import com.robotcup.pojo.TeamInfo;

public interface ExecuteQueryInter {

	// ����ȫ��ѧУ
	public List<TeamUnversity> getUniversity();

	// ����ָ��ѧУ
	public TeamUnversity getUniversityBySid(int sid);
	//�޸�У��
	public void setUniversity(String yname,String nname);
	// ��������ѧУ
	public List<TeamUnversity> getUniversityByAid(int aid);

	// ����ȫ������
	public List<TeamArea> getArea();

	// �����������ز����Ӽ������Ϣ
	public List<TeamInfo> getTeamInfoByAid(int aid, int pageNum, int pageSize,
			String year);

	// ���ݶ����������ж�Ա
	public  String getTeamMemberByTname(String tname);

	// ���ݶ�������ָ����ʦ
	public String getTeamTeacherByTname(String tname);

	// �����������ز�������ҳ��
	public int getTeamPageSum(int aid, int pageSize, String year);

	// ���ر�����ҳ��
	public int getTeamAppPageSum(int aid, int pageSize, String year);

	// ���ز����ӱ�����Ϣ
	/**
	 * ���������
	 * 
	 * @param aid
	 * @param pageNum
	 * @param pageSize
	 * @param year
	 * @return
	 */
	public List<TeamApp> getTeamApp(int aid, int pageNum, int pageSize,
			String year);

	// ������վģ��
	public List<RobotAttachment> getAllAttachment();

	// ����ȫ����Ŀ
	public List<TeamItems> getAllItems();

	// ����ȫ����Ŀ����
	public List<ItemsType> getAllItemsType();

	// ����վ�ڹ���
	public RobotLetter getRobotLetter();

	// ���������鿴��Ŀ�ı���ͳ����Ϣ
	/**
	 * ���
	 * 
	 * @param type
	 * @param itname
	 * @param aid
	 * @param year
	 * @return
	 */
	public int getItemInfo(String type, String itname, int aid, String year);

	// ��ѯ�ж���ѧУ����
	public int getSchoolCount(int aid, String year);
	
	//20160521
	public int getDistinctStuCount(String year);
	//20160521
	public int getDistinctTeaCount(String year);
	//20160521
	public int getDistinctSchCount(String year);
	//20160521
	public int getDistinctTeamCount(String year);
}
