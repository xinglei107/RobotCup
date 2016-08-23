package com.robotcup.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.robotcup.domain.ItemsType;
import com.robotcup.domain.TeamAdmin;
import com.robotcup.domain.TeamArea;
import com.robotcup.domain.TeamItems;
import com.robotcup.domain.TeamUnversity;
import com.robotcup.service.inter.TeamAdminServiceInter;
import com.robotcup.util.HibernateHelper;

@Controller
public class TeamAdminServiceImp implements TeamAdminServiceInter {

	@Resource
	private HibernateHelper hibernateHelper;

	public HibernateHelper getHibernateHelper() {
		return hibernateHelper;
	}

	public void setHibernateHelper(HibernateHelper hibernateHelper) {
		this.hibernateHelper = hibernateHelper;
	}

	@Override
	public String getAdminPassword(int adid) {
		// TODO Auto-generated method stub
		String hql = "select adpwd from TeamAdmin where adid=?";
		Object pwd = (Object) hibernateHelper.executeQuery(hql,
				new String[] { adid + "" }).get(0);
		String res = pwd.toString();
		return res;
	}

	@Override
	public void changeAdminPassword(int adid, String pwd) {
		// TODO Auto-generated method stub
		String hql = "update TeamAdmin set adpwd=? where adid=?";
		hibernateHelper.updateQuery(hql, new String[] { pwd, adid + "" });
	}

	@Override
	public void addAdmin(TeamAdmin teamAdmin) {
		// TODO Auto-generated method stub
		hibernateHelper.save(teamAdmin);
	}

	@Override
	public void delAdminByAdid(TeamAdmin ta) {
		// TODO Auto-generated method stub
		hibernateHelper.deleteQuery(ta);
	}

	@Override
	public void addArea(TeamArea teamArea) {
		// TODO Auto-generated method stub
		hibernateHelper.save(teamArea);
	}

	@Override
	public void delAreaByAid(TeamArea ta) {
		// TODO Auto-generated method stub
		hibernateHelper.deleteQuery(ta);
	}

	@Override
	public void addUnversity(TeamUnversity teamUnversity) {
		// TODO Auto-generated method stub
		hibernateHelper.save(teamUnversity);
	}

	@Override
	public void delObject(Object obj) {
		// TODO Auto-generated method stub
		hibernateHelper.deleteQuery(obj);
	}

	@Override
	public void addType(ItemsType itemsType) {
		// TODO Auto-generated method stub
		hibernateHelper.save(itemsType);
	}

	@Override
	public void delTypeByTyid(ItemsType it) {
		// TODO Auto-generated method stub
		hibernateHelper.deleteQuery(it);
	}

	@Override
	public void addItem(TeamItems teamItem) {
		// TODO Auto-generated method stub
		hibernateHelper.save(teamItem);
	}

	@Override
	public void delItemByItid(int itid) {
		// TODO Auto-generated method stub
		String hql = "delete from TeamItems where itid=?";
		hibernateHelper.updateQuery(hql, new String[] { itid + "" });
	}

	/**
	 * 2016-03-26允许修改项目的参赛人数上限和下限
	 * @param item
	 */
	public void updateItemByItid(TeamItems item) {
		// TODO Auto-generated method stub
		String hql = "update TeamItems set itremark=?,itlimit=?,ittealim=?,itteacap=? where itid=?";
		hibernateHelper.updateQuery(
				hql,
				new String[] { item.getItremark(), item.getItlimit() + "",
						item.getIttealim() + "", item.getItteacap() + "",
						item.getItid() + "" });
	}

	@Override
	public ItemsType getItemsTypeByTyid(int tyid) {
		// TODO Auto-generated method stub
		String hql = "from ItemsType where tyid=?";
		List list = hibernateHelper.executeQuery(hql,
				new String[] { tyid + "" });
		if (list.size() > 0)
			return (ItemsType) list.get(0);
		return null;
	}

	@Override
	public TeamArea getTeamAreaByAid(int aid) {
		// TODO Auto-generated method stub
		String hql = "from TeamArea where aid=?";
		List list = hibernateHelper
				.executeQuery(hql, new String[] { aid + "" });
		if (list.size() > 0)
			return (TeamArea) list.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isAdminRepeat(String adname) {
		// TODO Auto-generated method stub
		String hql = "from TeamAdmin where adname=?";
		List<Object> r = hibernateHelper.executeQuery(hql,
				new String[] { adname });
		if (r.size() <= 0)
			return false;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isAreaRepeat(String aname) {
		// TODO Auto-generated method stub
		String hql = "from TeamArea where aname=?";
		List<Object> r = hibernateHelper.executeQuery(hql,
				new String[] { aname });
		if (r.size() <= 0)
			return false;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isUnversityRepeat(String sname) {
		// TODO Auto-generated method stub
		String hql = "from TeamUnversity where sname=?";
		List<Object> r = hibernateHelper.executeQuery(hql,
				new String[] { sname });
		if (r.size() <= 0)
			return false;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isTypeRepeat(String tyname) {
		// TODO Auto-generated method stub
		String hql = "from ItemsType where tyname=?";
		List<Object> r = hibernateHelper.executeQuery(hql,
				new String[] { tyname });
		if (r.size() <= 0)
			return false;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isItemRepeat(String itname) {
		// TODO Auto-generated method stub
		String hql = "from TeamItems where itname=?";
		List<Object> r = hibernateHelper.executeQuery(hql,
				new String[] { itname });
		if (r.size() <= 0)
			return false;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TeamAdmin> getTeamAdmin() {
		// TODO Auto-generated method stub
		// 不获取超级管理员
		String hql = "from TeamAdmin where teamArea.aid!=0 order by teamArea.aname";
		return hibernateHelper.executeQuery(hql);
	}

	@Override
	public TeamAdmin getTeamAdminByAdid(int adid) {
		// TODO Auto-generated method stub
		String hql = "from TeamAdmin where adid=?";
		List l = hibernateHelper.executeQuery(hql, new String[] { adid + "" });
		if (l.size() > 0)
			return (TeamAdmin) l.get(0);
		return null;
	}

	@Override
	public void updateAdminInfo(TeamAdmin ta) {
		// TODO Auto-generated method stub
		String hql = "update TeamAdmin set adname=?,ademail=? where adid=?";
		String[] parameters = new String[] { ta.getAdname(), ta.getAdemail(),
				ta.getAdid() + "" };
		hibernateHelper.updateQuery(hql, parameters);
	}

	@Override
	public TeamAdmin getTeamAdminByAdname(String adname) {
		// TODO Auto-generated method stub
		String hql = "from TeamAdmin where adname=?";
		List l = hibernateHelper.executeQuery(hql, new String[] { adname });
		if (l.size() > 0)
			return (TeamAdmin) l.get(0);
		return null;
	}

	@Override
	public TeamItems getTeamItemByItid(int itid) {
		// TODO Auto-generated method stub
		String hql = "from TeamItems where itid=?";
		List l = hibernateHelper.executeQuery(hql, new String[] { itid + "" });
		if (l.size() > 0)
			return (TeamItems) l.get(0);
		return null;
	}

	@Override
	public void changeEntrance(char c) {
		// TODO Auto-generated method stub
		String hql = "update TeamAdmin set entrance=?";
		hibernateHelper.updateQuery(hql, new String[] { c + "" });
	}

	@Override
	public boolean getEntrance() {
		// TODO Auto-generated method stub
		String hql = "from TeamAdmin where entrance is not null";
		List l = hibernateHelper.executeQuery(hql);
		if (l.size() > 0) {
			TeamAdmin t = (TeamAdmin) l.get(0);
			if (t.getEntrance().equals("1"))
				return true;
		}
		return false;
	}

	/**
	 * 2015-09-22增加 关闭项目，替代删除
	 */
	@Override
	public void setItemVisibleByItid(int itid, int state) {
		// TODO Auto-generated method stub
		String hql = "update TeamItems set visible=? where itid=?";
		hibernateHelper
				.updateQuery(hql, new String[] { state + "", itid + "" });
		// 关闭项目时，将已经选择该项目的删除
		if (state == 0) {

		}
	}
}
