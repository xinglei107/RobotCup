package com.robotcup.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.robotcup.domain.ItemsType;
import com.robotcup.domain.TeamAdmin;
import com.robotcup.domain.TeamApplication;
import com.robotcup.domain.TeamItems;
import com.robotcup.domain.TeamMembers;
import com.robotcup.domain.TeamUser;
import com.robotcup.service.inter.TeamManageServiceInter;
import com.robotcup.struts.form.TeamUserForm;
import com.robotcup.util.HibernateHelper;

@Controller
public class TeamManageServiceImp implements TeamManageServiceInter {

	@Resource
	private HibernateHelper hibernateHelper;

	public HibernateHelper getHibernateHelper() {
		return hibernateHelper;
	}

	public void setHibernateHelper(HibernateHelper hibernateHelper) {
		this.hibernateHelper = hibernateHelper;
	}

	/**
	 * 添加一个参赛队
	 */
	@Override
	public void addTeam(TeamUser teamUser) {
		// TODO Auto-generated method stub
		try {
			hibernateHelper.save(teamUser);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		}
	}

	/**
	 * 用户登录，返回登陆后的用户
	 */
	@SuppressWarnings("unchecked")
	@Override
	public TeamUser login(String tname, String tpwd) {
		// TODO Auto-generated method stub
		String hql = "from TeamUser where tname=? and tpwd=?";
		List<TeamUser> list = hibernateHelper.executeQuery(hql, new String[] {
				tname, tpwd });
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	/**
	 * 获取某一参赛队中的全部成员
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TeamMembers> getTeamMembersByTid(int tid) {
		// TODO Auto-generated method stub
		String hql = "from TeamMembers where tid=?";
		String parameters[] = { tid + "" };
		List<TeamMembers> members = null;
		try {
			members = hibernateHelper.executeQuery(hql, parameters);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		}
		return members;
	}

	/**
	 * 获取某一参赛队所报的全部项目 2015-09-22修改，如果项目已被关闭，则不显示
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TeamApplication> getItemsByTid(int tid, String year) {
		// TODO Auto-generated method stub
		String hql = "from TeamApplication where teamUser.tid=? and appyear=? and teamItems.visible=1";
		String parameters[] = { tid + "", year };
		List<TeamApplication> items = null;
		try {
			items = hibernateHelper.executeQuery(hql, parameters);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		}
		return items;
	}

	/**
	 * 获取全部的项目分类
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ItemsType> getItemsType() {
		// TODO Auto-generated method stub
		String hql = "from ItemsType order by tyorder desc";
		List<ItemsType> type = null;
		try {
			type = hibernateHelper.executeQuery(hql);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		}
		return type;
	}

	/**
	 * 获取某一分类下的全部项目
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TeamItems> getItemsByTyid(int tyid) {
		// TODO Auto-generated method stub
		String hql = "from TeamItems where itemsType.tyid=? and visible=1";
		List<TeamItems> type = null;
		try {
			type = hibernateHelper
					.executeQuery(hql, new String[] { tyid + "" });
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		}
		return type;
	}

	/**
	 * 添加一条报名信息
	 */
	@Override
	public void addTeamApplication(TeamApplication teamApplication) {
		// TODO Auto-generated method stub
		try {
			hibernateHelper.save(teamApplication);
			changeTeamYear(teamApplication.getTeamUser().getTid(),
					teamApplication.getAppyear());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		}
	}

	/**
	 * 根据项目编号获取项目信息
	 */
	@Override
	public TeamItems getIteamByItid(int itid) {
		// TODO Auto-generated method stub
		String hql = "from TeamItems where itid=?";
		TeamItems type = null;
		try {
			type = (TeamItems) hibernateHelper.executeQuery(hql,
					new String[] { itid + "" }).get(0);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		}
		return type;
	}

	/**
	 * 根据赛参赛队编号获取参赛队信息
	 */
	@Override
	public TeamUser getTeamUserByTid(int tid) {
		// TODO Auto-generated method stub
		String hql = "from TeamUser where tid=?";
		TeamUser user = null;
		try {
			user = (TeamUser) hibernateHelper.executeQuery(hql,
					new String[] { tid + "" }).get(0);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		}
		return user;
	}

	/**
	 * 判读某参赛队是否已经报名某项目
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean hasTeamApplication(int tid, int itid, String year) {
		// TODO Auto-generated method stub
		String hql = "from TeamApplication where teamUser.tid=? and teamItems.itid=? and appyear=?";
		TeamApplication app = null;
		List<TeamApplication> applist = null;
		try {
			applist = hibernateHelper.executeQuery(hql, new String[] {
					tid + "", itid + "", year });
			if (applist.size() > 0)
				app = (TeamApplication) applist.get(0);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		}
		return app == null ? false : true;
	}

	/**
	 * 根据报名编号删除报名项目
	 */
	@Override
	public void deleteTeamApplication(int appid) {
		// TODO Auto-generated method stub
		String hql = "delete from TeamApplication where appid=?";
		try {
			hibernateHelper.updateQuery(hql, new String[] { appid + "" });
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		}
	}

	/**
	 * 管理员登录，返回登录后的管理员信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public TeamAdmin adminLogin(String adname, String adpwd) {
		// TODO Auto-generated method stub
		String hql = "from TeamAdmin where adname=? and adpwd=?";
		List<TeamAdmin> list = hibernateHelper.executeQuery(hql, new String[] {
				adname, adpwd });
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	/**
	 * 获取参赛队密码
	 */
	@Override
	public String getTeamPassword(int tid) {
		// TODO Auto-generated method stub
		String hql = "select tpwd from TeamUser where tid=?";
		String res = (String) hibernateHelper.executeQuery(hql,
				new String[] { tid + "" }).get(0);
		return res;
	}

	/**
	 * 修改参赛队密码
	 */
	@Override
	public void changeTeamPassword(int tid, String pwd) {
		// TODO Auto-generated method stub
		String hql = "update TeamUser set tpwd=? where tid=?";
		hibernateHelper.updateQuery(hql, new String[] { pwd, tid + "" });
	}

	/**
	 * 修改参赛队信息
	 */
	@Override
	public void changeTeamInfo(int tid, TeamUserForm tuf) {
		// TODO Auto-generated method stub
		String hql = "update TeamUser set tname=?,temail=?,teamUnversity.sid=?,tremark=? where tid=?";
		String parameters[] = new String[] { tuf.getTname(), tuf.getTemail(),
				tuf.getSid() + "", tuf.getTremark(), tid + "" };
		hibernateHelper.updateQuery(hql, parameters);
	}

	/**
	 * 判断队名是否已被注册
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean isRepeat(String tname, int tid) {
		// TODO Auto-generated method stub
		String hql = "from TeamUser where tname=? and tid!=?";
		List<Object> list = hibernateHelper.executeQuery(hql, new String[] {
				tname, tid + "" });
		if (list.size() == 0)
			return false;
		return true;
	}

	/**
	 * 根据成员编号获取成员信息
	 */
	@Override
	public TeamMembers getTeamMemberByMid(int mid) {
		// TODO Auto-generated method stub
		String hql = "from TeamMembers where mid=?";
		List list = hibernateHelper
				.executeQuery(hql, new String[] { mid + "" });
		if (list.size() > 0)
			return (TeamMembers) list.get(0);
		return null;
	}

	/**
	 * 添加参赛队成员
	 */
	@Override
	public void addTeamMember(TeamMembers tm) {
		// TODO Auto-generated method stub
		try {
			hibernateHelper.save(tm);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		}
	}

	/**
	 * 修改成员信息
	 */
	@Override
	public void changeTeamMember(TeamMembers tm) {
		// TODO Auto-generated method stub
		hibernateHelper.updateQuery(tm);
	}

	/**
	 * 根据管理员编号获取管理员
	 */
	@Override
	public TeamAdmin getTeamAdminByAdid(int adid) {
		// TODO Auto-generated method stub
		String hql = "from TeamAdmin where adid=?";
		List list = hibernateHelper.executeQuery(hql,
				new String[] { adid + "" });
		if (list.size() > 0)
			return (TeamAdmin) list.get(0);
		return null;
	}

	/**
	 * 更改报名项目状态
	 */
	@Override
	public void changeAppState(int appid, int state) {
		// TODO Auto-generated method stub
		String hql = "update TeamApplication set appstate=? where appid=?";
		String[] parameters = new String[] { state + "", appid + "" };
		hibernateHelper.updateQuery(hql, parameters);
	}

	/**
	 * 根据队名判断是否有重复 与修改信息时所用的判断方法isRepeat有所不同
	 */
	@Override
	public boolean isTeamRepeat(String tname) {
		// TODO Auto-generated method stub
		String hql = "from TeamUser where tname=?";
		@SuppressWarnings("unchecked")
		List<Object> res = hibernateHelper.executeQuery(hql,
				new String[] { tname });
		if (res.size() <= 0)
			return false;
		return true;
	}

	@Override
	public int getItlimitByItid(int itid) {
		// TODO Auto-generated method stub
		int num = 0;
		String hql = "select itlimit from TeamItems where itid=?";
		Object o = hibernateHelper
				.executeQuery(hql, new String[] { itid + "" });
		if (o != null)
			num = Integer.parseInt(o.toString());
		return num;
	}

	@Override
	public void delTeamMemberByMid(int mid) {
		// TODO Auto-generated method stub
		String hql = "delete from TeamMembers where mid=?";
		hibernateHelper.updateQuery(hql, new String[] { mid + "" });
	}

	@Override
	public String getEmailByTname(String tname) {
		// TODO Auto-generated method stub
		String hql = "select temail from TeamUser where tname=?";
		Object o = null;
		List l = hibernateHelper.executeQuery(hql, new String[] { tname });
		if (l.size() > 0)
			o = l.get(0);
		if (o != null)
			return o.toString();
		return null;
	}

	@Override
	public TeamUser getTeamUserByTname(String tname) {
		// TODO Auto-generated method stub
		String hql = "from TeamUser where tname=?";
		List l = hibernateHelper.executeQuery(hql, new String[] { tname });
		if (l.size() > 0)
			return (TeamUser) l.get(0);
		return null;
	}

	/**
	 * 返回领队的编号
	 */
	@Override
	public int existLeader(int tid) {
		// TODO Auto-generated method stub
		String hql = "from TeamMembers where mleader=1 and tid=?";
		List l = hibernateHelper.executeQuery(hql, new String[] { tid + "" });
		if (l.size() > 0)
			return ((TeamMembers) l.get(0)).getMid();
		return -1;
	}

	@Override
	public void changeTeamYear(int tid, String year) {
		// TODO Auto-generated method stub
		String hql = "update TeamUser set tyear=? where tid=?";
		String[] parameters = new String[] { year, tid + "" };
		hibernateHelper.updateQuery(hql, parameters);
	}

	/**
	 * 2016-04-01获取指定学校今年报名某一项目的参赛队数目，比如获取bistu今年报名舞蹈的对数
	 * 
	 * @param sname
	 * @param itname
	 * @param tyear
	 * @return
	 */
	public int getAppCountByUnIt(String sname, String itname, String tyear) {
		String hql = "select count(*) from TeamApplication ap, TeamItems it, TeamUnversity un, TeamUser ue where ap.teamItems.itid=it.itid and ap.teamUser.tid=ue.tid and ue.teamUnversity.sid=un.sid and ap.appyear=? and un.sname=? and it.itname=? group by it.itname,un.sname,ap.appyear";
		List<Long> o = hibernateHelper.executeQuery(hql, new String[] { tyear,
				sname, itname });
		Long num = 0L;
		if (o.size()==1)
			num = o.get(0);
		return num.intValue();
	}
}
