package com.personal.demo.tool;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FTPUtil {

    private static Logger log = LoggerFactory.getLogger(FTPUtil.class);
    /** 
     * Description: 向FTP服务器上传文件 
     * @Version1.0 
     * @param url FTP服务器hostname 
     * @param port FTP服务器端口 
     * @param username FTP登录账号 
     * @param password FTP登录密码 
     * @param path FTP服务器保存目录 
     * @param filename 上传到FTP服务器上的文件名 
     * @param input 输入流 
     * @return 成功返回true，否则返回false 
     */  
    public static boolean uploadFile(String server,String path,String filename,InputStream input) {
	boolean success = false;  
	FTPClient ftp = new FTPClient();
	try {  
	    ftp.setConnectTimeout(1000);
	    ftp.setDataTimeout(1000);
	    ftp.connect("192.168.9.38",21);
	    ftp.login("ftpuser", "lijiahao"); 
	    String route="upload/"+path;
	    if(!ftp.changeWorkingDirectory(route)) {
		ftp.makeDirectory(route);
		ftp.changeWorkingDirectory(route);
	    } 
	    log.info(ftp.getReplyString());
	    ftp.listNames();
	    log.info(ftp.getReplyString());
	    ftp.setFileType(FTP.BINARY_FILE_TYPE);
	    //ftp.enterLocalPassiveMode();
	    ftp.storeFile(filename, input);
	    log.info(ftp.getReplyString());
	    input.close();  
	    ftp.logout(); 
	    return true;
	} catch (IOException e) {  
	    e.printStackTrace();  
	} finally {  
	    if (ftp.isConnected()) {  
		try {  
		    ftp.disconnect();  
		} catch (IOException ioe) {  
		}  
	    }  
	}  
	return success;
    }

    public static boolean uploadPicture(String fileName,InputStream input) {
	return uploadFile("192.168.9.38","pic",fileName,input);
    }
}
