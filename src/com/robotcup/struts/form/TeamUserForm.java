/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.robotcup.struts.form;

import org.apache.struts.action.ActionForm;

/** 
 * MyEclipse Struts
 * Creation date: 03-30-2014
 * 
 * XDoclet definition:
 * @struts.form name="teamUserForm"
 */
public class TeamUserForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** sid property */
	private Integer sid;

	/** tmail property */
	private String temail;

	/** tpwd property */
	private String tpwd;

	/** tname property */
	private String tname;
	
	private String tremark;
	
	private Integer lrole;
	

	/*
	 * Generated Methods
	 */

	/** 
	 * Returns the sid.
	 * @return Integer
	 */
	public Integer getSid() {
		return sid;
	}

	/** 
	 * Set the sid.
	 * @param sid The sid to set
	 */
	public void setSid(Integer sid) {
		this.sid = sid;
	}

	/** 
	 * Returns the tmail.
	 * @return String
	 */
	public String getTemail() {
		return temail;
	}

	/** 
	 * Set the tmail.
	 * @param tmail The tmail to set
	 */
	public void setTemail(String temail) {
		this.temail = temail;
	}

	/** 
	 * Returns the tpwd.
	 * @return String
	 */
	public String getTpwd() {
		return tpwd;
	}

	/** 
	 * Set the tpwd.
	 * @param tpwd The tpwd to set
	 */
	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
	}

	/** 
	 * Returns the tname.
	 * @return String
	 */
	public String getTname() {
		return tname;
	}

	/** 
	 * Set the tname.
	 * @param tname The tname to set
	 */
	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTremark() {
		return tremark;
	}

	public void setTremark(String tremark) {
		this.tremark = tremark;
	}

	public Integer getLrole() {
		return lrole;
	}

	public void setLrole(Integer lrole) {
		this.lrole = lrole;
	}

}