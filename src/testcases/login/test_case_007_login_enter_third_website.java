package testcases.login;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.com_data.assert_text;
import data.com_data.comdata;
//import junit.framework.Assert;
import model.csv_reader;
import pages.login.login_page;

public class test_case_007_login_enter_third_website {
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
    public void test_third_website() throws Exception{
    	csv_reader csvr=new csv_reader("D:\\java files\\tuqiangol_test1\\src\\data\\login\\login_enter_third_party_website.csv");
    	login_page loginp=new login_page(dr);
    	assert_text assertt=new assert_text();
    	List<List<String>> csvList = csvr.readCSVFile();
    	comdata comd=new comdata();
    	loginp.open_login_page();
		Thread.sleep(2000);
		String tuqiang_handle=dr.getWindowHandle();
		for(int i=0;i<csvList.get(0).size();i++){
			
			String actual_link=loginp.enter_third_party_website(csvList.get(0).get(i));
			String expect_link=assertt.log_in_page_third_party_website()[i];
			Thread.sleep(2000);
			Assert.assertEquals(actual_link, expect_link, "当前第三方链接跳转错误");
			dr.close();
			dr.switchTo().window(tuqiang_handle);
			Assert.assertEquals(comd.base_url()+"/", dr.getCurrentUrl(), "回到原窗口失败");
			
		}
    }

}
