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
	 * ���һ��������
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
	 * �û���¼�����ص�½����û�
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
	 * ��ȡĳһ�������е�ȫ����Ա
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
	 * ��ȡĳһ������������ȫ����Ŀ 2015-09-22�޸ģ������Ŀ�ѱ��رգ�����ʾ
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
	 * ��ȡȫ������Ŀ����
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
	 * ��ȡĳһ�����µ�ȫ����Ŀ
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
	 * ���һ��������Ϣ
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
	 * ������Ŀ��Ż�ȡ��Ŀ��Ϣ
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
	 * �����������ӱ�Ż�ȡ��������Ϣ
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
	 * �ж�ĳ�������Ƿ��Ѿ�����ĳ��Ŀ
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
	 * ���ݱ������ɾ��������Ŀ
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
	 * ����Ա��¼�����ص�¼��Ĺ���Ա��Ϣ
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
	 * ��ȡ����������
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
	 * �޸Ĳ���������
	 */
	@Override
	public void changeTeamPassword(int tid, String pwd) {
		// TODO Auto-generated method stub
		String hql = "update TeamUser set tpwd=? where tid=?";
		hibernateHelper.updateQuery(hql, new String[] { pwd, tid + "" });
	}

	/**
	 * �޸Ĳ�������Ϣ
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
	 * �ж϶����Ƿ��ѱ�ע��
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
	 * ���ݳ�Ա��Ż�ȡ��Ա��Ϣ
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
	 * ��Ӳ����ӳ�Ա
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
	 * �޸ĳ�Ա��Ϣ
	 */
	@Override
	public void changeTeamMember(TeamMembers tm) {
		// TODO Auto-generated method stub
		hibernateHelper.updateQuery(tm);
	}

	/**
	 * ���ݹ���Ա��Ż�ȡ����Ա
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
	 * ���ı�����Ŀ״̬
	 */
	@Override
	public void changeAppState(int appid, int state) {
		// TODO Auto-generated method stub
		String hql = "update TeamApplication set appstate=? where appid=?";
		String[] parameters = new String[] { state + "", appid + "" };
		hibernateHelper.updateQuery(hql, parameters);
	}

	/**
	 * ���ݶ����ж��Ƿ����ظ� ���޸���Ϣʱ���õ��жϷ���isRepeat������ͬ
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
	 * ������ӵı��
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
	 * 2016-04-01��ȡָ��ѧУ���걨��ĳһ��Ŀ�Ĳ�������Ŀ�������ȡbistu���걨���赸�Ķ���
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
