package cn.edu.saif.shared.manager;

import org.springframework.stereotype.Component;

/**
 * @author Xiao GuangLei
 *
 */

@Component
public class LdapManager extends AbstractManager{

	private String url;

	public String getUrl() {
		return "url:"+url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
