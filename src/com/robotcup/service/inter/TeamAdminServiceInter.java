package com.robotcup.service.inter;

import java.util.List;

import com.robotcup.domain.ItemsType;
import com.robotcup.domain.TeamAdmin;
import com.robotcup.domain.TeamArea;
import com.robotcup.domain.TeamItems;
import com.robotcup.domain.TeamUnversity;

public interface TeamAdminServiceInter {

	// ��ȡ����Ա����
	public String getAdminPassword(int adid);

	// �޸Ĺ���Ա����
	public void changeAdminPassword(int adid, String pwd);

	// ���ݹ���Ա���Ƽ���Ƿ��Ѿ����ڸù���Ա����������
	public boolean isAdminRepeat(String adname);

	// ��ӹ���Ա
	public void addAdmin(TeamAdmin teamAdmin);

	// ɾ������
	public void delAdminByAdid(TeamAdmin ta);

	// ������������
	public boolean isAreaRepeat(String aname);

	// �������
	public void addArea(TeamArea teamArea);

	// ɾ������
	public void delAreaByAid(TeamArea ta);

	// ����ѧУ����
	public boolean isUnversityRepeat(String sname);

	// ���ѧУ
	public void addUnversity(TeamUnversity teamUnversity);

	// ɾ��ѧУ
	public void delObject(Object obj);

	// �����������
	public boolean isTypeRepeat(String tyname);

	// ��ӷ���
	public void addType(ItemsType itemsType);

	// ɾ������
	public void delTypeByTyid(ItemsType it);

	// ������Ŀ����
	public boolean isItemRepeat(String itname);

	// �����Ŀ
	public void addItem(TeamItems teamItem);

	// ɾ����Ŀ
	public void delItemByItid(int itid);

	// 2015-09-22���ӣ��ر�/����Ŀ
	public void setItemVisibleByItid(int itid, int state);

	// ���ݷ���id��ȡ��Ŀ����
	public ItemsType getItemsTypeByTyid(int tyid);

	// ��ȡ��Ŀ
	public TeamItems getTeamItemByItid(int itid);

	// ��������id��ȡ����
	public TeamArea getTeamAreaByAid(int aid);

	// ��ȡȫ���Ĺ���Ա
	public TeamAdmin getTeamAdminByAdid(int adid);

	// ��ȡȫ���Ĺ���Ա
	public List<TeamAdmin> getTeamAdmin();

	// �޸Ĺ���Ա��Ϣ
	public void updateAdminInfo(TeamAdmin ta);

	// ���ݹ���Ա�û�����ȡ����Ա
	public TeamAdmin getTeamAdminByAdname(String adname);

	// �޸ı������
	public void changeEntrance(char c);

	// ��ȡ��ǰ�������״̬
	public boolean getEntrance();
}
