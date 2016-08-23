package com.robotcup.service.inter;

import java.util.List;

import com.robotcup.domain.ItemsType;
import com.robotcup.domain.TeamAdmin;
import com.robotcup.domain.TeamArea;
import com.robotcup.domain.TeamItems;
import com.robotcup.domain.TeamUnversity;

public interface TeamAdminServiceInter {

	// 获取管理员密码
	public String getAdminPassword(int adid);

	// 修改管理员密码
	public void changeAdminPassword(int adid, String pwd);

	// 根据管理员名称检查是否已经存在该管理员，避免重名
	public boolean isAdminRepeat(String adname);

	// 添加管理员
	public void addAdmin(TeamAdmin teamAdmin);

	// 删除管理
	public void delAdminByAdid(TeamAdmin ta);

	// 避免赛区重名
	public boolean isAreaRepeat(String aname);

	// 添加赛区
	public void addArea(TeamArea teamArea);

	// 删除赛区
	public void delAreaByAid(TeamArea ta);

	// 避免学校重名
	public boolean isUnversityRepeat(String sname);

	// 添加学校
	public void addUnversity(TeamUnversity teamUnversity);

	// 删除学校
	public void delObject(Object obj);

	// 避免分类重名
	public boolean isTypeRepeat(String tyname);

	// 添加分类
	public void addType(ItemsType itemsType);

	// 删除分类
	public void delTypeByTyid(ItemsType it);

	// 避免项目重名
	public boolean isItemRepeat(String itname);

	// 添加项目
	public void addItem(TeamItems teamItem);

	// 删除项目
	public void delItemByItid(int itid);

	// 2015-09-22增加，关闭/打开项目
	public void setItemVisibleByItid(int itid, int state);

	// 根据分类id获取项目分类
	public ItemsType getItemsTypeByTyid(int tyid);

	// 获取项目
	public TeamItems getTeamItemByItid(int itid);

	// 根据赛区id获取赛区
	public TeamArea getTeamAreaByAid(int aid);

	// 获取全部的管理员
	public TeamAdmin getTeamAdminByAdid(int adid);

	// 获取全部的管理员
	public List<TeamAdmin> getTeamAdmin();

	// 修改管理员信息
	public void updateAdminInfo(TeamAdmin ta);

	// 根据管理员用户名获取管理员
	public TeamAdmin getTeamAdminByAdname(String adname);

	// 修改报名入口
	public void changeEntrance(char c);

	// 获取当前报名入口状态
	public boolean getEntrance();
}
