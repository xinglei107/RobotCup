package com.robotcup.pojo;

import java.io.Serializable;

/**
 * 
 * @ClassName ItemInfo
 * @Description
 * 
 * @date 2015-9-22 增加 项目关闭状态
 * @author xinglei
 */
public class ItemInfo implements Serializable {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private String itname;
	private int students;
	private int teachers;
	private int sum_s_t;
	private int visible;

	public String getItname() {
		return itname;
	}

	public void setItname(String itname) {
		this.itname = itname;
	}

	public int getStudents() {
		return students;
	}

	public void setStudents(int students) {
		this.students = students;
	}

	public int getTeachers() {
		return teachers;
	}

	public void setTeachers(int teachers) {
		this.teachers = teachers;
	}

	public int getSum_s_t() {
		return sum_s_t;
	}

	public void setSum_s_t(int sum_s_t) {
		this.sum_s_t = sum_s_t;
	}

	public int getVisible() {
		return visible;
	}

	public void setVisible(int visible) {
		this.visible = visible;
	}
}
