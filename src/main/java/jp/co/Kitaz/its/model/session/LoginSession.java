package jp.co.Kitaz.its.model.session;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
//ログイン機能保持予定
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LoginSession {
	
	private int userId;
	private int tmpId;
	private String userName;
	private String password;
	private boolean isLogined;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTmpId() {
		return tmpId;
	}
	public void setTmpId(int tmpId) {
		this.tmpId = tmpId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLogined() {
		return isLogined;
	}
	public void setLogined(boolean isLogined) {
		this.isLogined = isLogined;
	}

}
