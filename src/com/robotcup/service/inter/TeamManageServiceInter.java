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
	// 插入参赛队
	public void addTeam(TeamUser teamUser);

	// 判断是否重名
	public boolean isTeamRepeat(String tname);

	// 登录验证
	public TeamUser login(String tname, String tpwd);

	// 管理员登陆验证
	public TeamAdmin adminLogin(String adname, String adpwd);

	// 返回参赛队所有成员
	public List<TeamMembers> getTeamMembersByTid(int tid);

	// 返回参赛队所报项目
	public List<TeamApplication> getItemsByTid(int tid, String year);

	// 返回项目类型
	public List<ItemsType> getItemsType();

	// 根据项目类型返回项目
	public List<TeamItems> getItemsByTyid(int tyid);

	// 根据项目编号返回项目
	public TeamItems getIteamByItid(int itid);

	// 更改报名项目审核状态
	public void changeAppState(int appid, int state);

	// 获取项目的人数上限
	public int getItlimitByItid(int itid);

	// //更改出场顺序
	// public void changeAppNum(int appid);
	//
	// //更改项目总分
	// public void changeAppSum(int appid);

	// 插入报名项目
	public void addTeamApplication(TeamApplication teamApplication);

	// 判断用户是否已选择某项目
	public boolean hasTeamApplication(int tid, int itid, String year);

	// 删除用户报名的项目
	public void deleteTeamApplication(int appid);

	// 根据编号返回参赛队
	public TeamUser getTeamUserByTid(int tid);

	// 获取参赛队密码
	public String getTeamPassword(int tid);

	// 修改参赛队密码
	public void changeTeamPassword(int tid, String pwd);

	// 检查队名是否重复
	public boolean isRepeat(String tname, int tid);

	// 修改参赛队基本信息
	public void changeTeamInfo(int tid, TeamUserForm tuf);

	// 获取队员
	public TeamMembers getTeamMemberByMid(int mid);

	// 插入队员
	public void addTeamMember(TeamMembers tm);

	// 修改成员信息
	public void changeTeamMember(TeamMembers tm);

	// 删除队员
	public void delTeamMemberByMid(int mid);

	// 根据管理员编号返回管理员
	public TeamAdmin getTeamAdminByAdid(int adid);

	// 根据队名获取邮箱，找回密码
	public String getEmailByTname(String tname);

	// 根据用户名查找用户，用于通过用户名找回密码
	public TeamUser getTeamUserByTname(String tname);

	// 判断是否已经有领队
	public int existLeader(int tid);

	// 更改参赛队的所属年份
	public void changeTeamYear(int tid, String year);

}
