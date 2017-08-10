package pages.login;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import automate_driver.automateDriver;
import data.com_data.comdata;

public class login_page extends automateDriver {
	public login_page(WebDriver dr){
		super(dr);
	}
	public void open_login_page(){
		comdata comd=new comdata();
		super.navigate(comd.base_url(),"/");
	}
	//账号输入框
	public void account_input(String account){
		super.operate_input_element("account", account);
	}
	//密码输入框
	public void password_input(String password){
		super.operate_input_element("password", password);
	}
	//登陆按钮点击操作
	public void login_button_click(){
		super.click_element("logins");
	}
	//登陆时记住我勾选框
	public void remember_me(){
		super.click_element("checkbox");
	}
	//检查记住我勾选状态
	public boolean check_remeber_me(){
		boolean box_status=super.get_element("checkbox").isSelected();
		return box_status;
	}
	//忘记密码点击操作
	public void forget_password(){
		super.click_element("x,html/body/div[1]/div/div[3]/span[1]/a[1]");
	}
	//忘记密码输入账号
	public void forget_passwd_account(String forgetPasswdAccount){
		super.operate_input_element("x,//*[@id='validmessage-form']/div[1]/div/input", forgetPasswdAccount);
	}
	public void forget_passwd_phone(String forgetPasswdPhone){
		super.operate_input_element("x,//*[@id='validmessage-form']/div[2]/div/input", forgetPasswdPhone);
	}
	//获取点击找回密码后的文本内容
	public String get_text_after_forget_password(){
		String text= super.get_text("x,//*[@id='RetrievePasswordModal']/div/div/div[1]/h4");
		return text;
		}
	//取消忘记密码
	public void dis_forget_password(){
		super.click_element("x,//*[@id='RetrievePasswordModal']/div/div/div[3]/button[3]");
		}
	//获取登陆按钮的文本内容
	public String login_button_text(){
		String login_button_text=super.get_text("logins");
		return login_button_text;
	}
	//封装登陆操作
	public void user_login(String account,String password) throws InterruptedException{
		this.account_input(account);
		this.password_input(password);
		this.login_button_click();
		Thread.sleep(2000);
	}
	public String change_language(String language) throws InterruptedException{
		if(language.equals("zh")){
			super.click_element("x,html/body/footer/div[1]/ul/li[1]/a");
			Thread.sleep(3000);
			String login_button_text=this.login_button_text();
			return login_button_text;
		}else if(language.equals("English")){
			super.click_element("x,html/body/footer/div[1]/ul/li[2]/a");
			Thread.sleep(3000);
			String login_button_text=this.login_button_text();
			return login_button_text;
		}else if(language.equals("Espana")){
			super.click_element("x,html/body/footer/div[1]/ul/li[3]/a");
			Thread.sleep(3000);
			String login_button_text=this.login_button_text();
			return login_button_text;
		}else if(language.equals("Portugal")){
			super.click_element("x,html/body/footer/div[1]/ul/li[4]/a");
			Thread.sleep(3000);
			String login_button_text=this.login_button_text();
			return login_button_text;
		}else if(language.equals("Polska")){
			super.click_element("x,html/body/footer/div[1]/ul/li[5]/a");
			Thread.sleep(3000);
			String login_button_text=this.login_button_text();
			return login_button_text;
		}else if(language.equals("Deutschland")){
			super.click_element("x,html/body/footer/div[1]/ul/li[6]/a");
			Thread.sleep(3000);
			String login_button_text=this.login_button_text();
			return login_button_text;
		}else{
			return null;
		}
	}
	public String enter_third_party_website(String web_name){
		if(web_name.equals("trustWeb")){
			super.click_element("x,/html/body/footer/div[3]/a[1]");
			String tuqiang_handle=super.get_current_window_handle();
			Set<String> handles=new HashSet<String>();
			handles=super.get_all_window_handles();
			for(String handle:handles){
				if(!handle.equals(tuqiang_handle)){
					super.switch_to_window(handle);
				}
			}
			return super.get_current_url();
		}else if(web_name.equals("cybercop")){
			super.click_element("x,/html/body/footer/div[3]/a[2]");
			String tuqiang_handle=super.get_current_window_handle();
			Set<String> handles=new HashSet<String>();
			handles=super.get_all_window_handles();
			for(String handle:handles){
				if(!handle.equals(tuqiang_handle)){
					super.switch_to_window(handle);
				}
			}
			return super.get_current_url();
		}else if(web_name.equals("safeMonitor")){
			super.click_element("x,/html/body/footer/div[3]/a[3]");
			String tuqiang_handle=super.get_current_window_handle();
			Set<String> handles=new HashSet<String>();
			handles=super.get_all_window_handles();
			for(String handle:handles){
				if(!handle.equals(tuqiang_handle)){
					super.switch_to_window(handle);
				}
			}
			return super.get_current_url();
		}else if(web_name.equals("badInfo")){
			super.click_element("x,/html/body/footer/div[3]/a[4]");
			String tuqiang_handle=super.get_current_window_handle();
			Set<String> handles=new HashSet<String>();
			handles=super.get_all_window_handles();
			for(String handle:handles){
				if(!handle.equals(tuqiang_handle)){
					super.switch_to_window(handle);
				}
			}
			return super.get_current_url();
		}
		
		else{
			return null;
		}
		
	}
	
}
