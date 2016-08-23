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

	// 返回全部学校
	public List<TeamUnversity> getUniversity();

	// 返回指定学校
	public TeamUnversity getUniversityBySid(int sid);
	//修改校名
	public void setUniversity(String yname,String nname);
	// 返回赛区学校
	public List<TeamUnversity> getUniversityByAid(int aid);

	// 返回全部赛区
	public List<TeamArea> getArea();

	// 根据赛区返回参赛队及相关信息
	public List<TeamInfo> getTeamInfoByAid(int aid, int pageNum, int pageSize,
			String year);

	// 根据队名返回所有队员
	public  String getTeamMemberByTname(String tname);

	// 根据队名返回指导老师
	public String getTeamTeacherByTname(String tname);

	// 根据赛区返回参赛队总页数
	public int getTeamPageSum(int aid, int pageSize, String year);

	// 返回报名总页数
	public int getTeamAppPageSum(int aid, int pageSize, String year);

	// 返回参赛队报名信息
	/**
	 * 增加了年份
	 * 
	 * @param aid
	 * @param pageNum
	 * @param pageSize
	 * @param year
	 * @return
	 */
	public List<TeamApp> getTeamApp(int aid, int pageNum, int pageSize,
			String year);

	// 返回网站模块
	public List<RobotAttachment> getAllAttachment();

	// 返回全部项目
	public List<TeamItems> getAllItems();

	// 返回全部项目类型
	public List<ItemsType> getAllItemsType();

	// 查找站内公告
	public RobotLetter getRobotLetter();

	// 根据赛区查看项目的报名统计信息
	/**
	 * 年份
	 * 
	 * @param type
	 * @param itname
	 * @param aid
	 * @param year
	 * @return
	 */
	public int getItemInfo(String type, String itname, int aid, String year);

	// 查询有多少学校参赛
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
