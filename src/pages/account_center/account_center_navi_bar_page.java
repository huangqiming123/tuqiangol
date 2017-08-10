package pages.account_center;

import org.openqa.selenium.WebDriver;

import automate_driver.automateDriver;

public class account_center_navi_bar_page extends automateDriver {

	public account_center_navi_bar_page(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}
	//招呼栏用户栏
	public String hello_user_account(){
		String hello_user=super.get_element("c,user-name").getText();
		return hello_user;
	}
	// 账户总览左下方用户信息
    // --用户名
    public String usr_info_name(){
        String usr_name = super.get_element("userName").getText();
        return usr_name;
    }

    // --账号
    public String usr_info_account(){
        String usr_account = super.get_element("userAccount").getText();
        return usr_account;
    }

    // --客户类型
    public String usr_info_type(){
        String usr_type = super.get_element("userType").getText();
        return usr_type;
    }

    // --电话
    public String usr_info_phone(){
        String usr_phone = super.get_element("userPhone").getText();
        return usr_phone;
    }
    	
    //账户总览下方“我的服务商”信息

    //销售/代理商账户--服务商
    public String sales_usr_service_provider(){
        String service_provider_all = super.get_element(
            "x,/html/body/div[1]/div[5]/div/div/div[2]/div[1]/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/ul/li[1]").getText();
        String service_provider=service_provider_all.split("：")[1];
        return service_provider;
    }

    //销售/代理商户账户--联系人
    public String sales_usr_service_provider_connect(){
        String service_provider_connect_all = super.get_element(
            "x,/html/body/div[1]/div[5]/div/div/div[2]/div[1]/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/ul/li[2]").getText();
        String service_provider_connect=service_provider_connect_all.split("：")[1];
        return service_provider_connect;
    }

    //销售/代理商账户--电话
    public String sales_usr_service_provider_phone(){
        String service_provider_phone_all = super.get_element(
            "x,/html/body/div[1]/div[5]/div/div/div[2]/div[1]/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/ul/li[3]").getText();
        String service_provider_phone=service_provider_phone_all.split("：")[1];
        return service_provider_phone;
    }

    //普通用户账户--服务商
    public String ordinary_usr_service_provider(){
        String service_provider = super.get_element(
            "x,/html/body/div[1]/div[4]/div/div[2]/div[1]/div/div/div[1]/div[2]/ul/li[1]").getText();
        return service_provider;
    }

    //普通用户账户--联系人
    public String ordinary_usr_service_provider_connect(){
        String service_provider_connect = super.get_element(
            "x,/html/body/div[1]/div[4]/div/div[2]/div[1]/div/div/div[1]/div[2]/ul/li[2]").getText();
        return service_provider_connect;
    }

    //普通用户账户--电话
    public String ordinary_usr_service_provider_phone(){
        String service_provider_phone = super.get_element(
            "x,/html/body/div[1]/div[4]/div/div[2]/div[1]/div/div/div[1]/div[2]/ul/li[3]").getText();
        return service_provider_phone;
    }
    public void usr_logout() throws InterruptedException{
    	super.float_element("x,/html/body/div[1]/header/div/div[2]/div[2]/div[2]/span/a");
    	Thread.sleep(2000);
    	super.click_element("p,退出系统");
    	Thread.sleep(1000);
    	String logout_text=super.get_text("c,layui-layer-content");
    	System.out.println(logout_text);
    	super.click_element("c,layui-layer-btn0");
    	Thread.sleep(1000);
    	
    }
    //招呼栏退出系统-取消
    public void usr_logout_dismiss() throws InterruptedException{
    	super.float_element("x,/html/body/div[1]/header/div/div[2]/div[2]/div[2]/span/a");
    	Thread.sleep(2000);
    	super.click_element("p,退出系统");
    	Thread.sleep(1000);
    	super.click_element("c,layui-layer-btn1");
    }
    public String per_data_account(){
    	return super.get_text("edit-modal-account");
    }
    public String per_data_username(){
    	return super.get_text("edit-modal-nickName");
    }
    public String per_data_phone(){
    	return super.get_text("edit-modal-phone");
    }
    public String per_data_email(){
    	return super.get_text("edit-modal-email");
    }
    public void float_to_setting() throws InterruptedException{
    	super.float_element("x,/html/body/div[1]/header/div/div[2]/div[2]/div[2]/span/a");
    	Thread.sleep(2000);
    }
    public void click_mondify_info(){
    	super.click_element("p,修改资料");
    }
    public void click_mondify_password(){
    	super.click_element("p,修改密码");
    }
    public String modify_usr_info(String user_name,String phone,String email) throws InterruptedException{
    	super.float_element("x,/html/body/div[1]/header/div/div[2]/div[2]/div[2]/span/a");
    	Thread.sleep(2000);
    	super.click_element("p,修改资料");
    	Thread.sleep(1000);
    	super.operate_input_element("edit-modal-nickName", user_name);
    	Thread.sleep(1000);
    	super.operate_input_element("edit-modal-phone", phone);
    	Thread.sleep(1000);
    	super.operate_input_element("edit-modal-email", email);
    	Thread.sleep(1000);
    	super.click_element("c,layui-layer-btn0");
    	Thread.sleep(2000);
    	String save_status=super.get_text("c,layui-layer-content");
    	return save_status;
    }
    //修改密码
    public void mondify_user_passwd(String oldPwd,String newPwd,String renewPwd) throws InterruptedException{
    	super.float_element("x,/html/body/div[1]/header/div/div[2]/div[2]/div[2]/span/a");
    	Thread.sleep(2000);
    	super.click_element("p,修改密码");
    	super.operate_input_element("oldPwd", oldPwd);
    	super.operate_input_element("newPwd", newPwd);
    	super.operate_input_element("renewPwd", renewPwd);
    	
    }
    //得到修改密码页面title
    public String get_title_mondify_user_passwd(){
    	return super.get_text("x,.//*[@id='layui-layer1']/div[1]");
    }
    public boolean close_mondify_user_passwd(){
    	super.click_element("c,layui-layer-ico.layui-layer-close.layui-layer-close1");
    	return super.is_element_exist("x,.//*[@id='layui-layer1']/div[1]");
    }
    public boolean cancle_mondify_user_passwd(){
    	super.click_element("c,layui-layer-btn1");
    	return super.is_element_exist("x,.//*[@id='layui-layer1']/div[1]");
    }
    public void click_confim_mondify_user_passwd(){
    	super.click_element("c,layui-layer-btn0");
    }
    public String mondify_user_passwd_content(){
    	return super.get_text("c,layui-layer-content");
    }
    public void click_mondify_user_passwded(){
    	super.click_element("x,.//*[@id='layui-layer10']/div[3]/a");
    }
   

        		
}



