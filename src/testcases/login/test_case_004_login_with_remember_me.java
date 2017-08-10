package testcases.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.com_data.comdata;
import pages.account_center.account_center_navi_bar_page;
import pages.login.login_page;

public class test_case_004_login_with_remember_me {
	WebDriver dr;
	@BeforeMethod
	public void setUp() throws Exception{
		dr=new FirefoxDriver();
		dr.manage().window().maximize();
		dr.manage().deleteAllCookies();
	}
     @AfterMethod
	public void tearDown() throws Exception{
		dr.quit();
	}
     
    @Test 
    public void test_login_with_remember_me() throws InterruptedException{
    	login_page loginp=new login_page(dr);
    	comdata comd=new comdata();
    	account_center_navi_bar_page acenternbp=new account_center_navi_bar_page(dr);
    	loginp.open_login_page();
    	Thread.sleep(2000);
    	String actual_url=dr.getCurrentUrl();
		String expect_url = comd.base_url() + "/customer/toAccountCenter";
		Assert.assertEquals(actual_url, expect_url, "��½ҳ����ת����");
		acenternbp.usr_logout();
		Assert.assertEquals(dr.getCurrentUrl(), comd.base_url()+"/", "�˳�ϵͳʧ��");
		Assert.assertEquals(loginp.check_remeber_me(), true, "��ס����ʧ��");
		loginp.login_button_click();
		Assert.assertEquals(acenternbp.usr_info_account(), comd.base_user()[0], "��ס����ʧ�ܵ�½����");
    }

}
