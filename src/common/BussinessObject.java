package common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.upload.FormFile;

import model.bean.HinhAnhBean;
import model.bean.PageBean;
import model.dao.HinhAnhDAO;

/**
 * BussinessObject
 *
 * Version 1.0
 *
 * Date: 7-3-2017
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 7-3-2017         DonNA            Create
 */
public abstract class BussinessObject
{
	//phan trang
	public ArrayList<PageBean> paginate(int size, int show, int index)
	{
		ArrayList<PageBean> pages = new ArrayList<PageBean>();
		if(index > show + 1) pages.add(new PageBean("first", "«", false));
		int i = index - show > 0 ? index - show : 1;
		size = (index + show <= size ? index + show : size) + 1;
		while(i < size)
		{
			pages.add(new PageBean(String.valueOf(i), String.valueOf(i), i == index));
			i++;
		}
		if(index + show < size) pages.add(new PageBean("last", "»", false));
		
		return pages;
	}
	//luu file > tra ve duong dan
	public static String saveFile(String path, FormFile file,String sttfile, ActionServlet action) throws IOException
	{
		String filePath = action.getServletContext().getRealPath(path);
	    //System.out.println(filePath);
		File folder = new File(filePath);
	    //dat ten lai theo thoi gian hien tai
	    SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
		String currentSec=df.format(new Date());
	    if(!folder.exists()) folder.mkdir();
	    String[] doiFile = file.getFileName().split("\\.");
	    String fileName = currentSec +"_"+sttfile+ '.' + doiFile[doiFile.length - 1];
        File newFile = new File(filePath, fileName);

        if(!newFile.exists())
        {
        	FileOutputStream fos = new FileOutputStream(newFile);
        	fos.write(file.getFileData());
        	fos.flush();
        	fos.close();
	        return fileName;
        }
	    return null;
	}
	//luu nhieu file > tra ve list duong dan
	public static String[] saveMultiFile(String path, ArrayList<FormFile> fileHinhAnh, ActionServlet action) throws IOException
	{
		String[] lshinhanh=new String[ fileHinhAnh.size() ];
		for(int i = 0; i < fileHinhAnh.size(); i++) {
			FormFile file=fileHinhAnh.get(i);
			lshinhanh[i]=(saveFile(path, file,Integer.toString(i), action));
		}
		return lshinhanh;
	}
	public static void deleteFile(String path, ActionServlet action) {
		try{
			String filePath = action.getServletContext().getRealPath(path);
		    File file = new File(filePath);
		    if(file.delete()){
				System.out.println(file.getName() + " is deleted!");
			}else{
				System.out.println("Delete operation is failed.");
			}
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		
	}
	public static void deleteMultiFile(String[] hinhXoa, ActionServlet action) {
		int hinhXoalen=hinhXoa.length;
		for (int i=0;i<hinhXoalen;i++){
			deleteFile(HinhAnhDAO.getAnhByMa(hinhXoa[i]),action);
			HinhAnhDAO.deleteAnhByMa(hinhXoa[i]);
		}
	}
}