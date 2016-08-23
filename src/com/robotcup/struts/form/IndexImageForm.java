/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.robotcup.struts.form;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

/** 
 * MyEclipse Struts
 * Creation date: 05-04-2014
 * 
 * XDoclet definition:
 * @struts.form name="indexImageForm"
 */
public class IndexImageForm extends ActionForm {
	/*
	 * Generated fields
	 */
	private Integer pid;
	
	private Integer adid;

	/** title property */
	private String title;

	/** path property */
	private FormFile path;

	/** relname property */
	private String relname;

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
	 * Returns the title.
	 * @return String
	 */
	public String getTitle() {
		return title;
	}

	/** 
	 * Set the title.
	 * @param title The title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/** 
	 * Returns the path.
	 * @return File
	 */
	public FormFile getPath() {
		return path;
	}

	/** 
	 * Set the path.
	 * @param path The path to set
	 */
	public void setPath(FormFile path) {
		this.path = path;
	}

	/** 
	 * Returns the relname.
	 * @return String
	 */
	public String getRelname() {
		return relname;
	}

	/** 
	 * Set the relname.
	 * @param relname The relname to set
	 */
	public void setRelname(String relname) {
		this.relname = relname;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getAdid() {
		return adid;
	}

	public void setAdid(Integer adid) {
		this.adid = adid;
	}
}