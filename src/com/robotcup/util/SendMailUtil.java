package com.robotcup.util;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailUtil {

	  protected javax.mail.Session session = null;
	     
	//�ʼ��û���
	     String mailUser = "523194607@163.com"; //��ͨ���ĸ��ʺŷ����ʼ�
	     String host = "smtp.163.com";     //��ͨ���ĸ����������ʼ�
	     String pwd = "yanghao@#!163";   //����Ҫͨ�����ʺŵ������Ƕ��٣�Ҳ����mailUser������
	     
	     String sender = "523194607@163.com" ;     //�ʼ������﷢�ͺ�mailUser��һ������
	     String getter = "" ;       //˭�����ʼ�
	     
	     public SendMailUtil() {
	         Properties props = new Properties();          //������һ�������ļ��Ա�洢��Ϣ
	         props.put("mail.transport.protocol", "smtp"); //����˵���ʼ��Ĵ���Э��
	         props.put("mail.smtp.host", host);            //˵�������ʼ���������ַ
	         props.put("mail.smtp.auth", "true");          //˵�������ʼ��Ƿ���Ҫ��֤����ʾ�Լ���������������Ҫ��֤��
	         props.put("mail.smpt.port", "25");            //˵���ʼ����͵Ķ˿ں�
	   
	         //session��֤ getInstance()
	         session = javax.mail.Session.getInstance(props,new Authenticator(){
	       public PasswordAuthentication getPasswordAuthentication() {
	           return new PasswordAuthentication(mailUser,pwd);
	       }
	         });
	         //����Ǹ��ٺ�̨��Ϣ����ӡ�ڿ���̨
	         session.setDebug(true);
	     }
	     public void send(String from,String content) {
	         try { 
	          this.getter = from;
	          Message msg = new MimeMessage(session);
	          //���÷�����
	             msg.setFrom(new InternetAddress(sender)); 
	             //���ý�����
	             msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(getter));
	             //���÷���ʱ��
	             msg.setSentDate(new Date()); 
	             //�������ݵĻ������ƣ������
	             String htmltext=content; 
	             msg.setContent(htmltext, "text/html;charset=GBK"); 
	             //���÷�������
	             msg.setSubject("�һ������ʼ�");
	             //�����ʼ�����
	    //         msg.setText(htmltext); //�����html�ĸ�ʽ�����ʼ���ô�ʼ���������Ҫͨ��setContent�����ò��Ҳ�����setText
	             Transport transport = session.getTransport("smtp"); //�õ�����Э��
	             transport.connect(host, mailUser, pwd);//�뷢���ߵ���������
	             transport.send(msg); //������Ϣ
	             
	         } catch (Exception ee) {
	             ee.printStackTrace();
	         }
	     }

}
