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
 * Creation date: 05-04-2014
 * 
 * XDoclet definition:
 * @struts.form name="letterForm"
 */
public class LetterForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** adid property */
	private Integer adid;

	/** lcontent property */
	private String lcontent;

	/** ltitle property */
	private String ltitle;

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
	 * Returns the adid.
	 * @return Integer
	 */
	public Integer getAdid() {
		return adid;
	}

	/** 
	 * Set the adid.
	 * @param adid The adid to set
	 */
	public void setAdid(Integer adid) {
		this.adid = adid;
	}

	/** 
	 * Returns the lcontent.
	 * @return String
	 */
	public String getLcontent() {
		return lcontent;
	}

	/** 
	 * Set the lcontent.
	 * @param lcontent The lcontent to set
	 */
	public void setLcontent(String lcontent) {
		this.lcontent = lcontent;
	}

	/** 
	 * Returns the ltitle.
	 * @return String
	 */
	public String getLtitle() {
		return ltitle;
	}

	/** 
	 * Set the ltitle.
	 * @param ltitle The ltitle to set
	 */
	public void setLtitle(String ltitle) {
		this.ltitle = ltitle;
	}
}