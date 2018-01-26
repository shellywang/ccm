package cn.edu.saif.shared.ftp;


import org.apache.commons.net.ftp.FTPClient;
import cn.edu.saif.shared.common.BaseException;

public class MyFtpClient extends FTPClient {
	
	private static String hostname;
	private static int port;
	private static String username;
	private static String password;
	
	public void init() throws BaseException{
		if(hostname==null)
			throw new BaseException("hostname is null");
		if(username==null || password==null)
			throw new BaseException("username or password is null");
		try {
			if(this.isConnected()){
				this.disconnect();
			}
			this.connect(hostname, port);
			this.login(username, password);
		} catch (Exception e) {
			throw new BaseException(e.getMessage());
		}
	}

	public static String getHostname() {
		return hostname;
	}

	public static void setHostname(String hostname) {
		MyFtpClient.hostname = hostname;
	}

	public static int getPort() {
		return port;
	}

	public static void setPort(int port) {
		MyFtpClient.port = port;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		MyFtpClient.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		MyFtpClient.password = password;
	}
	
}
