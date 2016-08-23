package com.robotcup.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.robotcup.domain.ItemsType;
import com.robotcup.domain.RobotAttachment;
import com.robotcup.domain.RobotLetter;
import com.robotcup.domain.TeamArea;
import com.robotcup.domain.TeamItems;
import com.robotcup.domain.TeamUnversity;
import com.robotcup.pojo.TeamApp;
import com.robotcup.pojo.TeamInfo;
import com.robotcup.service.inter.ExecuteQueryInter;
import com.robotcup.util.HibernateHelper;

@Controller
public class ExecuteQueryImp implements ExecuteQueryInter {

	@Resource
	private HibernateHelper hibernateHelper;

	public HibernateHelper getHibernateHelper() {
		return hibernateHelper;
	}

	public void setHibernateHelper(HibernateHelper hibernateHelper) {
		this.hibernateHelper = hibernateHelper;
	}

	/**
	 * ��ȡȫ����ѧУ��Ϣ
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TeamUnversity> getUniversity() {
		// TODO Auto-generated method stub
		String hql = "from TeamUnversity order by teamArea.aname,sname";
		return hibernateHelper.executeQuery(hql);
	}

	/**
	 * ��ȡĳ�����µ�ȫ��ѧУ
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TeamUnversity> getUniversityByAid(int aid) {
		// TODO Auto-generated method stub
		String hql = "from TeamUnversity where teamArea.aid=" + aid;
		return hibernateHelper.executeQuery(hql);
	}

	/**
	 * �޸�ѧУ����
	 */
	@Override
	public void setUniversity(String yname, String nname) {
		// TODO Auto-generated method stub
		String hql = "update TeamUnversity set sname=? where sname=?";
		hibernateHelper.updateQuery(hql, new String[] { nname, yname });
	}

	/**
	 * ��ȡȫ������
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TeamArea> getArea() {
		// TODO Auto-generated method stub
		// 0�����������������������߹���Ա�ģ�����������ʾ
		String hql = "from TeamArea where aid!=0";
		return hibernateHelper.executeQuery(hql);
	}

	/**
	 * ����ѧУ��Ż�ȡѧУ
	 */
	@Override
	public TeamUnversity getUniversityBySid(int sid) {
		// TODO Auto-generated method stub
		String hql = "from TeamUnversity where sid=" + sid;
		List list = hibernateHelper.executeQuery(hql);
		if (list.size() > 0)
			return (TeamUnversity) list.get(0);
		return null;
	}

	/**
	 * ����ͳ��ʱ��ȡ�����ӵ���ϸ��Ϣ
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TeamInfo> getTeamInfoByAid(int aid, int pageNum, int pageSize,
			String year) {
		// TODO Auto-generated method stub
		List<TeamInfo> list = new ArrayList<TeamInfo>();
		String hql = null;
		List<Object[]> temp = new ArrayList<Object[]>();
		if (aid == 0)// ����ȫ������
		{
			hql = "select tm.teamUser.tname,tm.mname,tm.mgender,tm.mtype,tm.mphone"
					+ ",tm.memail,tm.teamUser.teamUnversity.sname,tm.teamUser.teamUnversity.teamArea.aname"
					+ " from TeamMembers as tm where tm.mleader=1 and tm.teamUser.tyear=? order by tm.teamUser.teamUnversity.teamArea.aname,"
					+ "tm.teamUser.teamUnversity.sname,tm.teamUser.tname";
			if (pageSize > 0)// ���շ�ҳ��ȡ
				temp = hibernateHelper.executeQuery(hql, new String[] { year },
						pageNum, pageSize);
			else
				// ��ȡȫ��
				temp = hibernateHelper.executeQuery(hql, new String[] { year });
		} else {
			hql = "select tm.teamUser.tname,tm.mname,tm.mgender,tm.mtype,tm.mphone"
					+ ",tm.memail,tm.teamUser.teamUnversity.sname,tm.teamUser.teamUnversity.teamArea.aname"
					+ " from TeamMembers as tm where tm.mleader=1 and tm.teamUser.teamUnversity.teamArea.aid=? and tm.teamUser.tyear=? order by tm.teamUser.teamUnversity.teamArea.aname,"
					+ "tm.teamUser.teamUnversity.sname,tm.teamUser.tname";
			if (pageSize > 0)
				temp = hibernateHelper.executeQuery(hql, new String[] {
						aid + "", year }, pageNum, pageSize);
			else
				temp = hibernateHelper.executeQuery(hql, new String[] {
						aid + "", year });
		}
		for (int i = 0; i < temp.size(); i++) {
			TeamInfo info = new TeamInfo();
			info.setTname(temp.get(i)[0].toString());
			info.setMname(temp.get(i)[1].toString());
			info.setMgender(temp.get(i)[2].toString());
			info.setMtype(temp.get(i)[3].toString());
			info.setMphone(temp.get(i)[4].toString());
			info.setMemail(temp.get(i)[5].toString());
			info.setSname(temp.get(i)[6].toString());
			info.setAname(temp.get(i)[7].toString());
			// ���Ҳ������µĳ�Ա��ָ����ʦ
			info.setMembers(getTeamMemberByTname(info.getTname()));
			info.setTeachers(getTeamTeacherByTname(info.getTname()));
			if (hasApp(info.getTname()))
				list.add(info);
		}
		return list;
	}

	private boolean hasApp(String tname) {
		String hql = "from TeamApplication where teamUser.tname=?";
		List list = hibernateHelper.executeQuery(hql, new String[] { tname });
		if (list.size() > 0)
			return true;
		return false;
	}

	/**
	 * ��ȡȫ����ģ��
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RobotAttachment> getAllAttachment() {
		// TODO Auto-generated method stub
		String hql = "from RobotAttachment";
		return hibernateHelper.executeQuery(hql);
	}

	/**
	 * ����������Ż�ȡ�μӸ���Ŀ�Ĳ�������Ϣ��0��ʾ��ȡȫ�������ı�����Ϣ <br>
	 * 2015-09-22�޸ģ������Ŀ�ѱ��رգ�����Ҫ���
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TeamApp> getTeamApp(int aid, int pageNum, int pageSize,
			String year) {
		// TODO Auto-generated method stub
		String hql = null;
		List<Object[]> list = null;
		if (aid == 0) {
			hql = "select ta.appid,ta.teamUser.tname,ta.teamUser.teamUnversity.sname,tm.mname,"
					+ "ta.teamItems.itname,ta.appnum,ta.teamItems.itlimit,ta.appstate,ta.teamItems.itremark"
					+ " from TeamApplication ta,TeamMembers tm where ta.teamUser.tid=tm.teamUser.tid"
					+ " and tm.mleader=1 and ta.appyear=? and ta.teamItems.visible=1 order by ta.teamItems.itname,ta.appnum ";

			if (pageSize > 0)
				list = hibernateHelper.executeQuery(hql, new String[] { year },
						pageNum, pageSize);
			else
				list = hibernateHelper.executeQuery(hql, new String[] { year });
		} else {
			hql = "select ta.appid,ta.teamUser.tname,ta.teamUser.teamUnversity.sname,tm.mname,"
					+ "ta.teamItems.itname,ta.appnum,ta.teamItems.itlimit,ta.appstate,ta.teamItems.itremark"
					+ " from TeamApplication ta,TeamMembers tm where ta.teamUser.tid=tm.teamUser.tid"
					+ " and tm.mleader=1 and ta.teamUser.teamUnversity.teamArea.aid=? and ta.appyear=? and ta.teamItems.visible=1"
					+ " order by ta.teamItems.itname,ta.appnum ";
			if (pageSize > 0)
				list = hibernateHelper.executeQuery(hql, new String[] {
						aid + "", year }, pageNum, pageSize);
			else
				list = hibernateHelper.executeQuery(hql, new String[] {
						aid + "", year });
		}
		List<TeamApp> res = new ArrayList<TeamApp>();
		for (int i = 0; i < list.size(); ++i) {
			TeamApp ta = new TeamApp();
			ta.setAppid(Integer.parseInt(list.get(i)[0].toString()));
			ta.setTname(list.get(i)[1].toString());
			ta.setSname(list.get(i)[2].toString());
			ta.setMname(list.get(i)[3].toString());
			ta.setItname(list.get(i)[4].toString());
			if (list.get(i)[5] != null)
				ta.setAppnum(Integer.parseInt(list.get(i)[5].toString()));
			if (list.get(i)[6] != null)
				ta.setApplimit(Integer.parseInt(list.get(i)[6].toString()));
			if (list.get(i)[7] != null) {
				if (Integer.parseInt(list.get(i)[7].toString()) == 1)
					ta.setAppstates("ͨ��");
				else if (Integer.parseInt(list.get(i)[7].toString()) == -1)
					ta.setAppstates("δͨ��");
				else
					ta.setAppstates("�����");
			}
			// ��������
			ta.setAppremark(Integer.parseInt(list.get(i)[8].toString()));
			// ��ѯ��Ա
			String mem = getTeamMemberByTname(ta.getTname());
			ta.setMembers(mem);
			String[] mems = mem.split("��");
			int memnum = mems.length;// ��Ա����
			if (mem.trim().length() < 1)
				memnum = 0;
			if (memnum >= ta.getAppremark() && memnum <= ta.getApplimit())
				res.add(ta);
			// ��ѯָ����ʦ
			String teas = getTeamTeacherByTname(ta.getTname());
			ta.setTeacherName(teas);
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TeamItems> getAllItems() {
		// TODO Auto-generated method stub
		String hql = "from TeamItems order by visible desc,itemsType.tyorder desc,itorder desc";
		List<TeamItems> res = hibernateHelper.executeQuery(hql);
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemsType> getAllItemsType() {
		// TODO Auto-generated method stub
		String hql = "from ItemsType order by tyorder desc";
		List<ItemsType> res = hibernateHelper.executeQuery(hql);
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public RobotLetter getRobotLetter() {
		// TODO Auto-generated method stub
		String hql = "from RobotLetter order by ldate desc";
		List<Object> res = hibernateHelper.executeQuery(hql);
		if (res.size() <= 0)
			return null;
		return (RobotLetter) res.get(0);
	}

	/**
	 * 2016-03-26��ѯҳ��ʱ�޳�û����ӡ���Ŀ�ѹرյı�����
	 */
	@Override
	public int getTeamAppPageSum(int aid, int pageSize, String year) {
		// TODO Auto-generated method stub
		String hql = null;
		Long count = null;
		int sum = 1;
		if (aid != 0)// ����������ѯ
		{
			hql = "select count(*) from TeamApplication ta,TeamMembers tm where ta.teamUser.tid=tm.teamUser.tid"
					+ " and tm.mleader=1 and ta.teamUser.teamUnversity.teamArea.aid=? and ta.appyear=? and ta.teamItems.visible=1";
			count = (Long) hibernateHelper.executeQuery(hql,
					new String[] { aid + "", year }).get(0);
		} else if (aid == 0)// ��ѯȫ������
		{
			hql = "select count(*) from TeamApplication ta,TeamMembers tm where ta.teamUser.tid=tm.teamUser.tid"
					+ " and tm.mleader=1 and ta.appyear=? and ta.teamItems.visible=1";
			count = (Long) hibernateHelper.executeQuery(hql,
					new String[] { year }).get(0);
		}
		if (count != null)
			sum = Integer.parseInt(count.toString());
		int pageSum = 1;
		pageSum = sum % pageSize == 0 ? sum / pageSize : sum / pageSize + 1;
		return pageSum;
	}

	@Override
	public int getTeamPageSum(int aid, int pageSize, String year) {
		// TODO Auto-generated method stub
		String hql = null;
		Long count = null;
		int sum = 1;
		if (aid != 0)// ����������ѯ����ӵĲ�������Ŀ��û����ӵĲ�����ʾ
		{
			hql = "select count(*) from TeamMembers where teamUser.teamUnversity.teamArea.aid=? and mleader=1 and teamUser.tyear=?";
			count = (Long) hibernateHelper.executeQuery(hql,
					new String[] { aid + "", year }).get(0);
		} else if (aid == 0)// ��ѯȫ������
		{
			hql = "select count(*) from TeamMembers where mleader=1 and teamUser.tyear=?";
			count = (Long) hibernateHelper.executeQuery(hql,
					new String[] { year }).get(0);
		}
		if (count != null)
			sum = Integer.parseInt(count.toString());
		int pageSum = 1;
		pageSum = sum % pageSize == 0 ? sum / pageSize : sum / pageSize + 1;
		return pageSum;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getTeamMemberByTname(String tname) {
		// TODO Auto-generated method stub
		String hql = "select mname from TeamMembers where teamUser.tname=? and mtype=?";
		List<Object> l = hibernateHelper.executeQuery(hql, new String[] {
				tname, "ѧ��" });
		String members = "";
		if (l.size() > 0) {
			for (int i = 0; i < l.size(); ++i)
				members += l.get(i).toString() + "��";
			if (members.length() > 0)
				members = members.substring(0, members.length() - 1);
		}
		return members;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getTeamTeacherByTname(String tname) {
		// TODO Auto-generated method stub
		String hql = "select mname from TeamMembers where teamUser.tname=? and mtype=?";
		List<Object> l = hibernateHelper.executeQuery(hql, new String[] {
				tname, "��ʦ" });
		String teachers = "";
		if (l.size() > 0) {
			for (int i = 0; i < l.size(); ++i)
				teachers += l.get(i).toString() + "��";
			if (teachers.length() > 0)
				teachers = teachers.substring(0, teachers.length() - 1);
		}
		return teachers;
	}

	/**
	 * ���ݶ�Ա�����ͣ���ʦ��ѧ������������ѯÿ����Ŀ�ı������
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int getItemInfo(String type, String itname, int aid, String year) {
		// TODO Auto-generated method stub
		if (aid != 0) {
			String hql = "select count(*) from TeamMembers a,TeamItems b,"
					+ "TeamApplication c where a.teamUser.tid=c.teamUser.tid and b.itid=c.teamItems.itid and c.appyear=? "
					+ "and a.mtype=? and a.teamUser.teamUnversity.teamArea.aid=? and b.itname=?"
					+ " group by b.itname";
			List list = hibernateHelper.executeQuery(hql, new String[] { year,
					type, aid + "", itname });
			if (list.size() < 1)
				return 0;
			int res = Integer.parseInt(list.get(0).toString());
			return res;
		} else {
			String hql = "select count(*) from TeamMembers a,TeamItems b,"
					+ "TeamApplication c where a.teamUser.tid=c.teamUser.tid and b.itid=c.teamItems.itid and c.appyear=?"
					+ "and a.mtype=? and b.itname=?" + " group by b.itname";
			List list = hibernateHelper.executeQuery(hql, new String[] { year,
					type, itname });
			if (list.size() < 1)
				return 0;
			int res = Integer.parseInt(list.get(0).toString());
			return res;
		}
	}

	/**
	 * ��ȡÿ����������ѧУ��������aid=0��ʾ��ȡȫ������
	 */
	@Override
	public int getSchoolCount(int aid, String year) {
		// TODO Auto-generated method stub
		// ��ѯȫ����ѧУ��Ŀ
		if (aid != 0) {
			String hql = " select distinct teamUser.teamUnversity.sid from TeamApplication where teamUser.teamUnversity.teamArea.aid=? and appyear=?";
			List list = hibernateHelper.executeQuery(hql, new String[] {
					aid + "", year });
			int res = list.size();
			return res;
		}
		String hql = " select distinct teamUser.teamUnversity.sid from TeamApplication where appyear=?";
		List list = hibernateHelper.executeQuery(hql, new String[] { year });
		int res = list.size();
		return res;
	}

	@Override
	public int getDistinctStuCount(String year) {
		// TODO Auto-generated method stub
		String hql = "select distinct teamUser.tname from TeamApplication where appyear=?";
		List list = hibernateHelper.executeQuery(hql, new String[] { year });

		int memberCount = 0;
		for (int i = 0; i < list.size(); ++i) {
			String tname = list.get(i).toString();
			String members = getTeamMemberByTname(tname);

			String[] mems = members.split("��");
			int mc = mems.length;// ��Ա����
			if (members.trim().length() < 1)
				mc = 0;
			memberCount += mc;
		}
		return memberCount;
	}

	@Override
	public int getDistinctTeaCount(String year) {
		// TODO Auto-generated method stub
		String hql = "select distinct teamUser.tname from TeamApplication where appyear=?";
		List list = hibernateHelper.executeQuery(hql, new String[] { year });

		int teaCount = 0;
		for (int i = 0; i < list.size(); ++i) {
			String tname = list.get(i).toString();
			String teachers = getTeamTeacherByTname(tname);

			String[] teas = teachers.split("��");
			int tc = teas.length;// ��ʦ����
			if (teachers.trim().length() < 1)
				tc = 0;
			teaCount += tc;
		}
		return teaCount;
	}

	@Override
	public int getDistinctSchCount(String year) {
		// TODO Auto-generated method stub
		String hql = "select distinct teamUser.teamUnversity.sname from TeamApplication where appyear=?";
		List list = hibernateHelper.executeQuery(hql, new String[] { year });
		return list.size();
	}

	@Override
	public int getDistinctTeamCount(String year) {
		// TODO Auto-generated method stub
		String hql = "select distinct teamUser.tname from TeamApplication where appyear=?";
		List list = hibernateHelper.executeQuery(hql, new String[] { year });
		return list.size();
	}

}
