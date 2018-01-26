package cn.edu.saif.ccm.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.saif.ccm.service.FtpService;
import cn.edu.saif.shared.common.Constants;
import cn.edu.saif.shared.ftp.MyFtpClient;

@Service
public class FtpServiceImpl implements FtpService{

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	@Autowired
	MyFtpClient ftpClient;
	
	@Override
	public void download() {
		try {
			ftpClient.init();
			int reply = ftpClient.getReplyCode(); 
            if (!FTPReply.isPositiveCompletion(reply)) { 
                ftpClient.disconnect();
                return; 
            }
            iterateDown(ftpClient,"",Constants.FTP_HOME_PATH+sdf.format(new Date()));
            ftpClient.logout(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
            if (ftpClient.isConnected()) { 
                try { 
                    ftpClient.disconnect(); 
                } catch (IOException ioe) { 
                } 
            } 
        }
	}
	
	public static void iterateDown(FTPClient ftpClient,String dir,String downloadPath) throws IOException{  
        File filedown = new File(downloadPath);  
        if(!filedown.exists()){  
            filedown.mkdirs();
        }
		FTPFile[] files = ftpClient.listFiles(dir);  
        for(int i=0;i<files.length;i++){
        	FTPFile f=files[i];
        	if(f.getName().startsWith("."))
        		continue;
            String localPath = downloadPath+File.separator+f.getName();  
            File file = new File(localPath);  
            
            if(f.isFile()){
                FileOutputStream fos = null;  
                fos = new FileOutputStream(localPath);  
                String path = dir+File.separator+f.getName();  
                ftpClient.retrieveFile(path, fos);  
                System.out.println("Downloaded :"+f.toString());
                IOUtils.closeQuietly(fos);  
            }else if(f.isDirectory()){  
            	System.out.println("Make local dirs :"+localPath);
                file.mkdirs();
                iterateDown(ftpClient,dir+File.separator+f.getName(),localPath);  
            }  
        }  
    } 
}
