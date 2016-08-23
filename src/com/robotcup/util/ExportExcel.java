package com.robotcup.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.interceptor.ServletResponseAware;

public class ExportExcel implements ServletResponseAware {


	private HttpServletResponse response; 
	private String fileName; 
	private String[][] data;
	private String[] colnames;
	
	public ExportExcel(HttpServletResponse response,String fileName,String [] colnames,String[][] data)
	{
		this.response=response;
		this.fileName=fileName+".xls";
		this.colnames=colnames;
		this.data=data;
	}
	
	public void export()
	{
		try{
			setResponseHeader(); 
			exportExcel(response.getOutputStream()); 
			response.getOutputStream().flush(); 
			response.getOutputStream().close(); 
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	 /**设置响应头*/ 
	 private void setResponseHeader() { 
		 response.setContentType("application/octet-stream;charset=iso-8859-1"); 
		 try { 
		 response.setHeader("Content-Disposition", "attachment;filename=" 
		 + java.net.URLEncoder.encode(this.fileName, "UTF-8")); 
		 // 客户端不缓存 
		 response.addHeader("Pragma", "no-cache"); 
		 response.addHeader("Cache-Control", "no-cache"); 
		 } catch (UnsupportedEncodingException e) { 
		 // TODO Auto-generated catch block 
		 e.printStackTrace(); 
		 } 

	 } 
	 
	 /**导出数据*/ 
	 private void exportExcel(OutputStream os) { 
		 Workbook workbook = null;
		 workbook = new HSSFWorkbook(); 
		 //workbook = new XSSFWorkbook(); 导出xlsx
		 Sheet sheet = workbook.createSheet(fileName); 
		 Row row = sheet.createRow(0); 
		 for(int i=0;i<colnames.length;++i)
		 {
			 row.createCell(i).setCellValue(colnames[i]); 
		 }
		 for (int i = 0; i < data.length; ++i) 
		 {
			 row = sheet.createRow(i+1); 
			 for(int j=0;j<colnames.length;++j)
				 row.createCell(j).setCellValue(data[i][j]); 
		 } 
		 try { 
		 workbook.write(os); 
		 } catch (IOException e) { 
		 e.printStackTrace(); 
		 } 
	 }
	
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response=arg0;
	}

}
