package testcases.account_center;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.account_center.account_center_navi_bar_page;
import pages.login.login_page;
import data.com_data.comdata;
import model.csv_reader;
import data.com_data.assert_text;
public class test_case_010_account_center_mondify_passwd {
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
    public void test_account_center_modify_passwd() throws Exception{
    	login_page loginp=new login_page(dr);
    	comdata comd=new comdata();
    	account_center_navi_bar_page acenternbp=new account_center_navi_bar_page(dr);
    	csv_reader csvr=new csv_reader("D:\\java files\\tuqiangol_test1\\src\\data\\account_center\\user_to_modify_passwd.csv");
    	assert_text assertt=new assert_text();
    	List<List<String>> csvList = csvr.readCSVFile();
    	loginp.open_login_page();
		Thread.sleep(2000);
    	loginp.user_login(comd.base_user()[0], comd.base_user()[1]);
    	acenternbp.mondify_user_passwd(csvList.get(0).get(0),csvList.get(0).get(1),csvList.get(0).get(2));
    	Assert.assertEquals(acenternbp.get_title_mondify_user_passwd(),assertt.account_center_page_modify_passwd_title()[0],"修改密码页面跳转失败");
    	Assert.assertFalse(acenternbp.cancle_mondify_user_passwd(),"取消修改密码错误");
    	acenternbp.mondify_user_passwd(csvList.get(0).get(0),csvList.get(0).get(1),csvList.get(0).get(2));
    	Assert.assertFalse(acenternbp.close_mondify_user_passwd(),"取消修改密码错误");
    	acenternbp.mondify_user_passwd(csvList.get(0).get(0),csvList.get(0).get(1),csvList.get(0).get(2));
    	acenternbp.click_confim_mondify_user_passwd();
    	Assert.assertEquals(acenternbp.mondify_user_passwd_content(), assertt.account_center_page_modify_passwd_content(),"修改密码失败");
    	acenternbp.click_mondify_user_passwded();
    	Assert.assertEquals(dr.getCurrentUrl()+"/", comd.base_url(),"修改成功后页面跳转错误");
    	Thread.sleep(2000);
    	loginp.user_login(comd.base_user()[0], csvList.get(0).get(1));
    	acenternbp.mondify_user_passwd(csvList.get(1).get(0),csvList.get(1).get(1),csvList.get(1).get(2));
    	
    	
    	
    	
    }

}
