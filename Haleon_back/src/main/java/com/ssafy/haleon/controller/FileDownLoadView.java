package com.ssafy.haleon.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component
public class FileDownLoadView extends AbstractView {

	public FileDownLoadView() {
		setContentType("apllication/download; charset=UTF-8");
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ServletContext ctx = getServletContext();
		String realPath = ctx.getRealPath("/file");
		
        
        String fileuri = (String) model.get("fileuri");    // 파일 경로
        String filename = (String) model.get("filename");
        File file = new File(fileuri);
		
        response.setContentType(getContentType());
        response.setContentLength((int) file.length());
        
        String header = request.getHeader("User-Agent");
        boolean isIE = header.indexOf("MSIE") > -1 || header.indexOf("Trident") > -1;
        String fileName = null;
        // IE는 다르게 처리
        if (isIE) {
        	fileName = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
        } else {
            fileName = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
        }
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        OutputStream out = response.getOutputStream();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            FileCopyUtils.copy(fis, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fis != null) {
                try { 
                    fis.close(); 
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        out.flush();
    }
}
