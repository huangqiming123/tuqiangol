package testcases.login;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.login.login_page;
import model.csv_reader;
import data.com_data.assert_text;

public class test_case_005_login_forget_passwd  {
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
	public void test_login_forget_passwd() throws Exception{
    	login_page loginp=new login_page(dr);
    	csv_reader csvr=new csv_reader("D:\\java files\\tuqiangol_test1\\src\\data\\login\\login_forget_pwd.csv");
    	List<List<String>> csvList = csvr.readCSVFile();
    	assert_text assertt=new assert_text();
		loginp.open_login_page();
		Thread.sleep(2000);
		loginp.forget_password();
		Assert.assertEquals(loginp.get_text_after_forget_password(), assertt.log_in_page_find_password_text());
		for(int i=0;i<csvList.size();i++){
		loginp.forget_passwd_account(csvList.get(i).get(0));
		loginp.forget_passwd_phone(csvList.get(i).get(1));
		loginp.dis_forget_password();
		Assert.assertEquals(loginp.login_button_text(), assertt.log_in_page_log_in_text());
		}
		
	}

}
