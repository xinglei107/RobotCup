/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.robotcup.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 05-01-2014
 * 
 * XDoclet definition:
 * @struts.form name="teamUnversityForm"
 */
public class TeamUnversityForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** sid property */
	private Integer sid;

	/** aid property */
	private Integer aid;

	/** sname property */
	private String sname;

	/*
	 * Generated Methods
	 */

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

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
	 * Returns the aid.
	 * @return Integer
	 */
	public Integer getAid() {
		return aid;
	}

	/** 
	 * Set the aid.
	 * @param aid The aid to set
	 */
	public void setAid(Integer aid) {
		this.aid = aid;
	}

	/** 
	 * Returns the sname.
	 * @return String
	 */
	public String getSname() {
		return sname;
	}

	/** 
	 * Set the sname.
	 * @param sname The sname to set
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}
}