/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.robotcup.struts.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.springframework.stereotype.Controller;

import com.robotcup.domain.RobotNews;
import com.robotcup.pojo.Attachment;
import com.robotcup.service.imp.PublishServiceImp;
import com.robotcup.service.imp.TeamManageServiceImp;
import com.robotcup.struts.form.IndexImageForm;
import com.robotcup.util.MyTools;

/** 
 * MyEclipse Struts
 * Creation date: 05-04-2014
 * 
 * XDoclet definition:
 * @struts.action path="/indexImage" name="indexImageForm" scope="request" validate="true"
 */
@Controller
public class IndexImageAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */

	@Resource
	private PublishServiceImp publishServiceImp;
	public PublishServiceImp getPublishServiceImp() {
		return publishServiceImp;
	}
	public void setPublishServiceImp(PublishServiceImp publishServiceImp) {
		this.publishServiceImp = publishServiceImp;
	}
	@Resource
	private TeamManageServiceImp teamManageServiceImp;
	public TeamManageServiceImp getTeamManageServiceImp() {
		return teamManageServiceImp;
	}
	public void setTeamManageServiceImp(TeamManageServiceImp teamManageServiceImp) {
		this.teamManageServiceImp = teamManageServiceImp;
	}
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		IndexImageForm indexImageForm = (IndexImageForm) form;// TODO Auto-generated method stub
		RobotNews rnews=new RobotNews();
		rnews.setMtitle(indexImageForm.getTitle());
		rnews.setTeamAdmin(teamManageServiceImp.getTeamAdminByAdid(indexImageForm.getAdid()));
		rnews.setMdate(new Date());
		rnews.setMcontent(" ");//不能为空，放一个空格
		rnews.setRobotAttachment(publishServiceImp.getRoboAttachmentByAtid(10));//首页展示模块
		FormFile ff=indexImageForm.getPath();
		String fileName=ff.getFileName();//获取文件全名

		int end=fileName.lastIndexOf(".");
		String type=fileName.substring(end);
		if(!(type.toLowerCase().equals(".jpg")||type.toLowerCase().equals(".png")||type.toLowerCase().equals(".gif")))
		{
			//文件名不合法
			request.setAttribute("res", 0);
		}
		else{
			//下面将文件流保存到服务器
			if(fileName!=null && fileName.length()>0){
				InputStream is=null;
				OutputStream os=null;
				try {
					//得到输入流
					is=ff.getInputStream();
					//得到要输出文件的tomcat下的路径				
					String filepath= request.getSession().getServletContext().getRealPath("/index");
					String lastName=fileName.substring(fileName.lastIndexOf('.'));//获取文件的后缀名
					String firstName=fileName.substring(0, fileName.lastIndexOf('.'));//获取文件名
					String newName=MyTools.MD5(firstName);//利用md5重命名文件，防止出现重名文件相互覆盖
					os=new FileOutputStream(filepath+"\\"+newName+lastName);
					rnews.setMatname(fileName);//保存文件的真实文件名
					rnews.setMattachment(newName+lastName);//保存文件的存储文件名
					//System.out.println(fileName+";"+filepath+"\\"+newName+lastName);
					int len=0;
					byte[] bytes=new byte[1024];
					while((len=is.read(bytes))>0){
						 //读取文件向服务器中写  读一点写一点
						os.write(bytes,0,len);//表示每次写bytes个字节，从0开始读写 到 len结束					
					 }
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					try {
					if(is!=null)is.close();
					if(os!=null)os.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			publishServiceImp.addNews(rnews);
			//插入成功
			request.setAttribute("res", 1);
		}
		
		List<RobotNews> imglist=publishServiceImp.getTenNewsByAtid(10);//获取首页展示的图片
		request.getSession().setAttribute("imglist", imglist);
		return mapping.findForward("ok");
	}
}