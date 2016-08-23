package com.robotcup.service.inter;

import java.util.List;

import com.robotcup.domain.ItemsType;
import com.robotcup.domain.TeamAdmin;
import com.robotcup.domain.TeamApplication;
import com.robotcup.domain.TeamItems;
import com.robotcup.domain.TeamMembers;
import com.robotcup.domain.TeamUser;
import com.robotcup.struts.form.TeamUserForm;

public interface TeamManageServiceInter {
	// ���������
	public void addTeam(TeamUser teamUser);

	// �ж��Ƿ�����
	public boolean isTeamRepeat(String tname);

	// ��¼��֤
	public TeamUser login(String tname, String tpwd);

	// ����Ա��½��֤
	public TeamAdmin adminLogin(String adname, String adpwd);

	// ���ز��������г�Ա
	public List<TeamMembers> getTeamMembersByTid(int tid);

	// ���ز�����������Ŀ
	public List<TeamApplication> getItemsByTid(int tid, String year);

	// ������Ŀ����
	public List<ItemsType> getItemsType();

	// ������Ŀ���ͷ�����Ŀ
	public List<TeamItems> getItemsByTyid(int tyid);

	// ������Ŀ��ŷ�����Ŀ
	public TeamItems getIteamByItid(int itid);

	// ���ı�����Ŀ���״̬
	public void changeAppState(int appid, int state);

	// ��ȡ��Ŀ����������
	public int getItlimitByItid(int itid);

	// //���ĳ���˳��
	// public void changeAppNum(int appid);
	//
	// //������Ŀ�ܷ�
	// public void changeAppSum(int appid);

	// ���뱨����Ŀ
	public void addTeamApplication(TeamApplication teamApplication);

	// �ж��û��Ƿ���ѡ��ĳ��Ŀ
	public boolean hasTeamApplication(int tid, int itid, String year);

	// ɾ���û���������Ŀ
	public void deleteTeamApplication(int appid);

	// ���ݱ�ŷ��ز�����
	public TeamUser getTeamUserByTid(int tid);

	// ��ȡ����������
	public String getTeamPassword(int tid);

	// �޸Ĳ���������
	public void changeTeamPassword(int tid, String pwd);

	// �������Ƿ��ظ�
	public boolean isRepeat(String tname, int tid);

	// �޸Ĳ����ӻ�����Ϣ
	public void changeTeamInfo(int tid, TeamUserForm tuf);

	// ��ȡ��Ա
	public TeamMembers getTeamMemberByMid(int mid);

	// �����Ա
	public void addTeamMember(TeamMembers tm);

	// �޸ĳ�Ա��Ϣ
	public void changeTeamMember(TeamMembers tm);

	// ɾ����Ա
	public void delTeamMemberByMid(int mid);

	// ���ݹ���Ա��ŷ��ع���Ա
	public TeamAdmin getTeamAdminByAdid(int adid);

	// ���ݶ�����ȡ���䣬�һ�����
	public String getEmailByTname(String tname);

	// �����û��������û�������ͨ���û����һ�����
	public TeamUser getTeamUserByTname(String tname);

	// �ж��Ƿ��Ѿ������
	public int existLeader(int tid);

	// ���Ĳ����ӵ��������
	public void changeTeamYear(int tid, String year);

}
